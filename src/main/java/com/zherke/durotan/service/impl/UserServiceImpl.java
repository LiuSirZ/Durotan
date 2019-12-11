package com.zherke.durotan.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.zherke.durotan.bean.BaseResponseVo;
import com.zherke.durotan.excel.ExcelPropertyIndexModel;
import com.zherke.durotan.mapper.UsersMapper;
import com.zherke.durotan.pojo.Users;
import com.zherke.durotan.service.UserService;
import com.zherke.durotan.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ClockProvider;
import java.io.*;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lwb
 * @create 2018-07-11 9:52
 * @desc 用户service实现
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public BaseResponseVo findUserList(Integer userId) {

        PageHelper.startPage(0,10);
        List<Users> users = usersMapper.selectAll();
        return ResponseUtil.success(new PageInfo<Users>(users).getList());
    }

    @Override
    public BaseResponseVo findUserByMapper() {
//        List<Users> users = usersMapper.findUserByMapper();
        //lombok 中可使用var代替其他类型 类似 JDK10
        var users = usersMapper.findUserByMapper();
        return ResponseUtil.success(users);
    }

    @Override
    public BaseResponseVo findUserById(Integer userId) {

        Users user = usersMapper.findUserById(1);
        return ResponseUtil.success(user);
    }

    public BaseResponseVo readExcel() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File("2007NoModelMultipleSheet.xlsx"));
        try {
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null,
                    new AnalysisEventListener<List<String>>() {
                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            System.out.println(
                                    "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                            + " data:" + object);
                        }
                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {

                        }
                    });

            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public BaseResponseVo writeExcel(Integer userId) throws FileNotFoundException {
        OutputStream out = new FileOutputStream("/Users/lwb/Documents/资料/78.xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
            Sheet sheet1 = new Sheet(1, 0,ExcelPropertyIndexModel.class);

            short fontSize = 12;
            TableStyle tableStyle = new TableStyle();
            Font font = new Font();
            font.setBold(true);
            font.setFontHeightInPoints(fontSize);
            tableStyle.setTableContentFont(font);
            sheet1.setTableStyle(tableStyle);

            sheet1.setSheetName("sheet1");
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] > pivot) {
                ++i;
            }
            while (arr[j] < pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    /**
     * 冒泡排序
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param arr 需要排序的数组
     */
    public static void bubbleSort(int[] arr){

        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp = 0;
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }

    public static void bubbleSort2(int[] arr){
        if (arr == null || arr.length <= 1) {
            return;
        }
        boolean flag;
        int temp = 0;
        int len = arr.length;
        do{
            flag = false;
            len-=1;
            for(int i =0; i<arr.length;i++){
                if(arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag =true;
                }
            }
        }while (flag);
    }




        public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }
}
