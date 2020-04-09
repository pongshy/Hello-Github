package com.shu.labrary.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.ApplybodyMapper;
import com.shu.labrary.mapper.EssayMapper;

import com.shu.labrary.pojo.Applybody;
import com.shu.labrary.pojo.ApplybodyExample;
import com.shu.labrary.pojo.EssayExample;
import com.shu.labrary.service.surface.EssayService;
import com.shu.labrary.tools.DateUtils;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Transactional
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    EssayMapper essayMapper;

    @Autowired
    ApplybodyMapper applybodyMapper;

    @Override
    public TableModel searchEssayonapplying(Integer curr, Integer nums, Integer isupdate) throws AllException {
        TableModel tableModel = new TableModel();
        EssayExample essayExample = new EssayExample();
        EssayExample.Criteria criteria = essayExample.createCriteria();
        criteria.andOnlinEqualTo(isupdate);
        PageHelper.startPage(curr, nums);

        try {
            if (isupdate == 1) {
                List<Map> list = essayMapper.selecthasupdatedessay(isupdate);
                PageInfo pageInfo = new PageInfo(list, 5);
                int total = (int) pageInfo.getTotal();
                tableModel.setCount(total);
                tableModel.setData(list);
                tableModel.setCode(0);
                return tableModel;
            } else {
                List<Map> list = essayMapper.selectnoupdatedessay(isupdate);
                PageInfo pageInfo = new PageInfo(list, 5);
                int total = (int) pageInfo.getTotal();
                tableModel.setCount(total);
                tableModel.setData(list);
                tableModel.setCode(0);
                return tableModel;

            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel deleteessays(List<Integer> deleteids) throws AllException {
        TableModel tableModel = new TableModel();

        try {
            for (Integer deleteid : deleteids) {
                EssayExample essayExample = new EssayExample();
                //先查询有没有进行中的预约
                ApplybodyExample applybodyExample=new ApplybodyExample();
                applybodyExample.createCriteria().andEssayidEqualTo(deleteid);
                List<Applybody> applybodies = applybodyMapper.selectByExample(applybodyExample);
                if (applybodies.get(0).getBegintime().after(new Date()))
                {
                    tableModel.error("存在进行中的预约，无法删除");
                    return tableModel;
                }

              essayExample.createCriteria().andEssayidEqualTo(deleteid);
                essayMapper.deleteByExample(essayExample);
            }
            tableModel.setCode(200);
            return tableModel;
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel searchEssays(Object object) throws AllException {
        TableModel tableModel = new TableModel();
        Pattern pattern = Pattern.compile("[0-9]*");
        boolean matches = pattern.matcher(object.toString()).matches();
        PageHelper.startPage(1, 10);
        System.out.println(matches);

        try {
            if (matches) {
                List<Map> essays = essayMapper.selectessays(Integer.parseInt(object.toString()));
                PageInfo pageInfo = new PageInfo(essays, 5);
                int total = (int) pageInfo.getTotal();
                tableModel.setCount(total);
                tableModel.setCode(0);
                tableModel.setData(essays);
                return tableModel;
            } else {
                List<Map> essaylist = essayMapper.selectEssaysByName(object.toString());
                PageInfo pageInfo = new PageInfo(essaylist, 5);
                int total = (int) pageInfo.getTotal();
                tableModel.setCount(total);
                tableModel.setCode(0);
                tableModel.setData(essaylist);
                return tableModel;
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }


    public void test()
    {
        EssayExample essayExample=new EssayExample();
        EssayExample.Criteria criteria = essayExample.createCriteria();

    }


}