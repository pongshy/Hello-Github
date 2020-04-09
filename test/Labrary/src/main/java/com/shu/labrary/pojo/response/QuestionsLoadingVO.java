package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: QuestionLoadingVO
 * description: 问卷加载
 * author: pongshy
 * create: 2020-2-7
 */
@Data
public class QuestionsLoadingVO {
    private Integer requestId;

    private String person_name;

    private String startTime;

    private String endTime;

    private String helpintention;

}
