package com.shu.labrary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.AdminMapper;
import com.shu.labrary.mapper.BrokenpersonMapper;
import com.shu.labrary.pojo.Admin;
import com.shu.labrary.pojo.AdminExample;
import com.shu.labrary.pojo.Brokenperson;
import com.shu.labrary.pojo.BrokenpersonExample;
import com.shu.labrary.pojo.request.AddBrokenPersonInfo;
import com.shu.labrary.pojo.response.BrokenPersonInformationVO;
import com.shu.labrary.service.surface.BrokenPersonService;
import com.shu.labrary.tools.DateUtils;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: BrokenPersonServiceImpl
 * @description: 关于失信人员的操作
 * @author: pongshy
 * @create: 2020-1-1
 */
@Transactional
@Service
public class BrokenPersonServiceImpl implements BrokenPersonService {

    @Autowired
    private BrokenpersonMapper brokenpersonMapper;

    @Autowired
    private AdminMapper adminMapper;


    /**
     * @Description: 获取失信人员的信息
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @Override
    public TableModel searchBrokenPersonInformation(Integer curr, Integer nums) throws AllException {
        TableModel tableModel = new TableModel();

        BrokenpersonExample brokenpersonExample = new BrokenpersonExample();
        brokenpersonExample.createCriteria().andIdIsNotNull();

        try {
            PageHelper.startPage(curr, nums);
            List<Brokenperson> brokenpersonList = brokenpersonMapper.selectByExample(brokenpersonExample);

            if (brokenpersonList.isEmpty()) {
                tableModel.setCode(0);
                tableModel.setCount(0);
                tableModel.setData(null);
                tableModel.setMsg("暂无失信人员");

                return tableModel;
            }
            List<BrokenPersonInformationVO> list = new ArrayList<>();
            for (Brokenperson temp_broken : brokenpersonList) {
                BrokenPersonInformationVO temp = new BrokenPersonInformationVO();
                BeanUtils.copyProperties(temp_broken, temp);
                temp.setTime(temp_broken.getTime().toString());

                list.add(temp);
            }

            PageInfo pageInfo = new PageInfo(brokenpersonList, 5);
            int total = (int) pageInfo.getTotal();
            tableModel.setCount(total);
            tableModel.setData(list);
            tableModel.setCode(0);

            return tableModel;
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    /**
     * @Description: 删除失信人员
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @Override
    public TableModel deleteSomeBrokenPerson(List<Integer> data) throws AllException {
        TableModel tableModel = new TableModel();

        BrokenpersonExample brokenpersonExample = new BrokenpersonExample();
        AdminExample adminExample = new AdminExample();
        Admin record = new Admin();
        record.setBrokenrecord(0);

        try {
            for (Integer userId : data) {
                brokenpersonExample.createCriteria().andUseridEqualTo(userId);
                Integer exist = brokenpersonMapper.countByExample(brokenpersonExample);
                if (exist == 0) {
                    brokenpersonExample.clear();
                    adminExample.clear();
                    continue;
                }
                brokenpersonMapper.deleteByExample(brokenpersonExample);

                //将admin表中对应用户的brokenrecord置零
                adminExample.createCriteria().andAdminidEqualTo(userId);
                adminMapper.updateByExampleSelective(record, adminExample);

                brokenpersonExample.clear();
                adminExample.clear();
            }

            tableModel.setCode(0);
            tableModel.setMsg("删除成功!");

            return tableModel;
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    /**
     * @Description: 设置失信人员
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @Override
    public TableModel addDishonestPerson(AddBrokenPersonInfo data) throws AllException {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminidEqualTo(data.getUserId());

        try {
            List<Admin> adminList = adminMapper.selectByExample(adminExample);

            if (adminList.isEmpty()) {
                return TableModel.error("不存在该用户!");
            }

            Admin record = new Admin();
            record.setBrokenrecord(3);
            adminMapper.updateByExampleSelective(record, adminExample);

            Brokenperson brokenperson = new Brokenperson();
            brokenperson.setId(data.getUserId());
            brokenperson.setName(data.getName());
            brokenperson.setReason(data.getDescription());

            brokenperson.setTime(3);

            brokenpersonMapper.insertSelective(brokenperson);

            return TableModel.success("增加成功!");
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

}
