package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowUserEmailAndPhoneVO
 * description: 存储用户的邮箱和密码
 * author: pongshy
 * create: 2020-3-13
 */
@Data
public class ShowUserEmailAndPhoneVO {
    private String email;

    private String phone;
}
