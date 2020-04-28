# 基于SpringBoot的基础项目架构(未进行性能调优，待完善版本)
## 自主学习 尝试写一些小插件或小功能
### 项目参考 [ lihengming/spring-boot-api-project-seed ](https://github.com/lihengming/spring-boot-api-project-seed "lihengming/spring-boot-api-project-seed")
### 开发工具推荐 IntelliJ IDEA 。[参考文档](http://wiki.jikexueyuan.com/project/intellij-idea-tutorial/ "IntelliJ IDEA")
### 一、当前架构
#### 1.SpringBoot + mybatis + 通用Mapper + Project Lombok + cors 
### 二、插件介绍
#### 1）Project Lombok
通过注释帮助我们生成常用的代码 例如set/get，log等。减少重复性工作。<br/>
更多详情 [ Project Lombok ](https://projectlombok.org/ "lombok插件")
后期准备逐渐去掉此语法糖。出于对Java封装特性的保护。
#### 2）cors
解决跨域问题。
#### 3）mybatis & 通用Mapper
持久层选择使用常用的mybatis，同样使用通用Mapper提供单表操作的基础方法。减少开发人员工作量。<br/>
更多详情[mybatis/mybatis-3](https://github.com/mybatis/mybatis-3 "mybatis/mybatis-3")
#### 4）alibaba/easyexcel
快速、简单避免OOM的java处理Excel工具<br/>
更多详情 [alibaba/easyexcel](https://github.com/alibaba/easyexcel)
#### 5) 配置中心 Apollo
实现配置的动态加载与推送<br/>
官方开源文档 [Apollo](https://github.com/ctripcorp/apollo/wiki/)<br/>
apollo配置采用SPI方式自定义meta-server获取类<br/>
详细使用方式如下：<br/>
需本地搭建Apollo配置中心 搭建方法参考官方文档。<br/>
打开POM文件中xxx.apollo.client包引用。并且打开ApolloConfig配置文件注释。<br/>
注：此工程仅限于本地测试 <br/>
若需要生产定制。参考Apollo官方文档 自行实现生产环境需要的jar 通过SPI方式注入即可
###  三、项目启动方法
#### 1）修改application-dev.properties
修改application-dev.properties配置文件中数据库地址。<br/>
注：后期会将properties文件修改为yml文件。
#### 2）使用generator生成实体
修改resource/generator下generatorConfig.xml文件。<br/>
执行generator插件生成pojo。
#### 3)Maven配置文件添加私人仓库 
https://repo.rdc.aliyun.com/repository/129414-release-em30Ph<br/>
username：dk4eMd<br/>
password：XR7Ufeh2ga<br/>


