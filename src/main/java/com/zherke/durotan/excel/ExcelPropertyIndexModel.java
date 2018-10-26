package com.zherke.durotan.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @author lwb
 * @create 下午5:04 2018-07-19
 * @desc
 **/
@Data
public class ExcelPropertyIndexModel extends BaseRowModel {

    @ExcelProperty(value = { "序号"}, index = 0)
    private String index;

    @ExcelProperty(value = { "姓名"}, index = 1)
    private String userName;

    @ExcelProperty(value = { "年龄"}, index = 2)
    private String userAge;

    @ExcelProperty(value = { "性别"}, index = 3)
    private String userGender;

    @ExcelProperty(value = { "手机号"}, index = 4)
    private String userPhoneNo;

    @ExcelProperty(value = { "邮件"}, index = 5)
    private String userEmail;
}
