package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * @Description: 用于存储问卷Id和对应的预约订单号
 * @Param: []
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-20
 */
@Data
public class QuestionIdAndRequestIdVO {
    private Integer questionId;

    private Integer requestId;

    private Integer identity;

}
