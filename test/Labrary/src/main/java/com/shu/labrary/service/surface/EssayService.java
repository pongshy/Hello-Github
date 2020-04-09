package com.shu.labrary.service.surface;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.tools.TableModel;

import java.text.ParseException;
import java.util.List;

public interface EssayService {
    public TableModel searchEssayonapplying(Integer curr,Integer nums,Integer isupdate) throws AllException;

    public TableModel deleteessays(List<Integer> deleteids) throws AllException;

    public TableModel searchEssays(Object essayid) throws AllException;
}
