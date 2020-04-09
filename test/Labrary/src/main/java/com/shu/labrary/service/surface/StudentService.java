package com.shu.labrary.service.surface;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.tools.TableModel;

import java.util.List;

public interface StudentService {
    public TableModel searchStudentInformation(Integer curr, Integer nums) throws AllException;

    public TableModel deleteSomeStudent(List<Integer> requestId) throws AllException;

    TableModel searchStudentById(String userId);
}
