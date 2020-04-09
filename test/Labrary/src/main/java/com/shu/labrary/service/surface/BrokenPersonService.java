package com.shu.labrary.service.surface;


import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.request.AddBrokenPersonInfo;
import com.shu.labrary.tools.TableModel;

import java.util.List;

public interface BrokenPersonService {
    public TableModel searchBrokenPersonInformation(Integer curr, Integer nums) throws AllException;

    public TableModel deleteSomeBrokenPerson(List<Integer> data) throws AllException;

    public TableModel addDishonestPerson(AddBrokenPersonInfo data) throws AllException;
}
