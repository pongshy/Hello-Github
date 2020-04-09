package com.shu.labrary.service.impl;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.DepartmentMapper;
import com.shu.labrary.pojo.Department;
import com.shu.labrary.service.surface.Departmentservice;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DepartmentserviceImpl implements Departmentservice {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public TableModel serchdepartment() throws AllException {
        try {
          TableModel tableModel=new TableModel();
            List<Department> departmentlist = departmentMapper.selectByExample(null);
            tableModel.setData(departmentlist);
            return tableModel;
        }
        catch(Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }
}
