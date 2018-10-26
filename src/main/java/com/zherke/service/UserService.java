package com.zherke.service;

import com.zherke.bean.BaseResponseVo;

import java.io.FileNotFoundException;

/**
 * @author lwb
 * @create 2018-07-11 9:51
 * @desc 用户service
 **/
public interface UserService {

    /**
     * 使用通用Mapper查询列表
     * @param userId
     * @return
     */
    BaseResponseVo findUserList(Integer userId);

    /**
     * 使用sql查询列表
     * @return
     */
    BaseResponseVo findUserByMapper();

    /**
     * 使用sql查询
     * @param userId
     * @return
     */
    BaseResponseVo findUserById(Integer userId);

    /**
     * 使用easyExcel输出Excel
     * @param userId
     * @return
     * @throws FileNotFoundException
     */
    BaseResponseVo writeExcel(Integer userId) throws FileNotFoundException;
}
