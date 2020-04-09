package com.shu.labrary.pojo.response;

import lombok.Data;

import java.util.List;

/**
 * @Description: 返回待填写问卷的Id，用户身份信息，以及该问卷对应的订单号
 * @Param: []
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-19
 */
@Data
public class ShowNotFinishedQuestionsVO {
    private String duty;                                        //身份——教职工，学生教师，以及本科生、硕士生、博士生

    private List<QuestionIdAndRequestIdVO> list;                //该用户作为老师时，要填写的问卷


    private List<QuestionIdAndRequestIdVO> educatedList;         //该用户作为被辅导时，要填写的问卷
}
