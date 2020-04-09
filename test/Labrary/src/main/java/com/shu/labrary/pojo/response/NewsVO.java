package com.shu.labrary.pojo.response;

import lombok.Data;

/**
 * @Description: 后端向前端发送新闻首页的信息
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-2-13
 */
@Data
public class NewsVO {
    private Integer id;         //用于表示新闻序号，前端需要

    private String newsname;

    private Integer newsid;

    private String newstype;

    private String newsstatus;

    private String newsauth;

    private String newsTime;

    private String newslabel;


}
