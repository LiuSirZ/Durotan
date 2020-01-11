package com.zherke.durotan.pojo;

import com.zherke.durotan.annotation.Desensitization;
import com.zherke.durotan.enums.SensitiveTypeEnum;
import lombok.Data;
import java.util.Date;
import javax.persistence.*;

/**
 * @author lwb
 * @date 2018-07-12
 */
@Data
public class Users {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_AGE")
    private String userAge;

    @Column(name = "USER_GENDER")
    private String userGender;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Desensitization(isDesensitization = true,sensitiveType = SensitiveTypeEnum.PASSWORD)
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_NICK_NAME")
    private String userNickName;

    @Desensitization(isDesensitization = true,sensitiveType = SensitiveTypeEnum.EMAIL)
    @Column(name = "USER_EMAIL")
    private String userEmail;
}