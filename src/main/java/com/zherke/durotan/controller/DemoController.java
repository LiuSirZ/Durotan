package com.zherke.durotan.controller;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private static CuratorFramework client;
    private static InterProcessMutex mutex;
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);


    static{
        //创建zookeeper的客户端
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);
        client.start();
        mutex = new InterProcessMutex(client, "/curator/lock");
    }


    /**
     * zookeeper 分布式锁使用
     * 注意：开源框架与Zookeeper版本匹配问题
     * 原理：有序节点
     *      临时节点
     *      事件监听
     * @throws Exception
     */
    public static void zookeeperLock(){

//        try {
//            mutex.acquire();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        executorService.submit(() -> {
            try {
                mutex.acquire();
                    Thread.currentThread().setName("线程1");
                    logger.info("Enter mutex 1--" + Thread.currentThread().getName());
                    //完成业务流程, 释放锁
                mutex.release();
                while (true){
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        executorService.submit(() -> {
            try {

                mutex.acquire();
                Thread.currentThread().setName("线程2");
                logger.info("Enter mutex 2--" + Thread.currentThread().getName());
                //完成业务流程, 释放锁
                mutex.release();
                while (true){
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    public static void main(String[] args){
        zookeeperLock();
    }
}
