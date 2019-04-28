package com.lucky.vo;

import com.lucky.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用于登录的controller 入参实体
 *
 * @author: xiaoran
 * @date: 2019-04-27 21:34
 */
@Data
public class LoginVo {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
