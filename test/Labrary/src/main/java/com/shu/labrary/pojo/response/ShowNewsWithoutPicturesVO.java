package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * program: ShowPictureNewsVO
 * description: 首页加载新闻时，展示无图片的新闻
 * author: pongshy
 * create: 2020-2-13
 */
@Data
public class ShowNewsWithoutPicturesVO {
    private Integer newsId;

    private String newsurl;

    private String newsname;

    private String newstype;

    private String newstime;


}
