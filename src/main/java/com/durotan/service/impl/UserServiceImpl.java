package com.durotan.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.*;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.durotan.bean.BaseResponseVo;
import com.durotan.excel.ExcelPropertyIndexModel;
import com.durotan.mapper.UsersMapper;
import com.durotan.pojo.Users;
import com.durotan.service.UserService;
import com.durotan.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            writer.write(getDate(),sheet1);
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

    private List<? extends BaseRowModel> getDate() {

        List<ExcelPropertyIndexModel> datas = new ArrayList<>();
        ExcelPropertyIndexModel model = new ExcelPropertyIndexModel();
        model.setIndex("0");
        model.setUserAge("18");
        model.setUserEmail("lwb@163.com");
        model.setUserGender("1");
        model.setUserName("测试");
        model.setUserPhoneNo("1821011111");
        datas.add(model);
        return datas;
    }
}
