package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowPictureNewsVO
 * description: 首页加载新闻时，展示有图片的新闻
 * author: pongshy
 * create: 2020-2-13
 */
@Data
public class ShowPictureNewsVO {
    private Integer newId;

    private String newsname;

    private String picturesrc;


}
