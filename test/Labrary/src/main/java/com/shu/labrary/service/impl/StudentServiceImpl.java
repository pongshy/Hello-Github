package com.shu.labrary.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.AdminMapper;
import com.shu.labrary.mapper.ApplybodyMapper;
import com.shu.labrary.pojo.Admin;
import com.shu.labrary.pojo.AdminExample;
import com.shu.labrary.pojo.Applybody;
import com.shu.labrary.pojo.ApplybodyExample;
import com.shu.labrary.pojo.response.StudentInformationVO;
import com.shu.labrary.service.surface.StudentService;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: StudentSerivceImpl
 * @description: 关于学生的操作
 * @author: pongshy
 * @create: 2020-1-1
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private ApplybodyMapper applybodyMapper;
    /**
     * @Description: 获取学生信息
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @Override
    public TableModel searchStudentInformation(Integer curr, Integer nums) throws AllException {
        TableModel tableModel = new TableModel();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminidIsNotNull();
        PageHelper.startPage(curr, nums);
        try {
            List<Admin> adminlist = adminMapper.selectByExample(adminExample);
            PageInfo pageInfo = new PageInfo(adminlist, 5);
            if (adminlist.isEmpty()) {
                tableModel.setCode(0);
                tableModel.setCount(0);
                tableModel.setData(null);
                tableModel.setMsg("暂无学生");
                return tableModel;
            }
            List<StudentInformationVO> voList = new ArrayList<>();
            for (Admin temp_admin : adminlist) {
                StudentInformationVO studentInformationVO = new StudentInformationVO();
                BeanUtils.copyProperties(temp_admin, studentInformationVO);
                voList.add(studentInformationVO);
            }
            int total = (int) pageInfo.getTotal();
            tableModel.setCount(total);
            tableModel.setData(voList);
            tableModel.setCode(0);

            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }


    /**
     * @Description: 删除学生
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @Override
    public TableModel deleteSomeStudent(List<Integer> requestId) throws AllException {
        AdminExample adminExampl = new AdminExample();
        try {
            for (Integer num : requestId) {
                //先检查是否存在预约
                ApplybodyExample applybodyExample=new ApplybodyExample();
                applybodyExample.createCriteria().andTeacheridEqualTo(num);
                List<Applybody> applybodies = applybodyMapper.selectByExample(applybodyExample);
                for (Applybody applybody : applybodies) {
                    if (applybody.getBegintime().after(new Date()))
                    {
                        return TableModel.error("删除失败");
                    }
                }

                int number = adminMapper.countByExample(adminExampl);
                if (number == 0) {
                    adminExampl.clear();
                    continue;
                }
                adminMapper.deleteByPrimaryKey(num);
                adminExampl.clear();
                //删除用户表里面的信息
                Admin admin = adminMapper.selectByPrimaryKey(num);
                if (admin!=null)
                {
                    adminMapper.deleteByPrimaryKey(num);
                }
            }

            return TableModel.success("删除成功!");

        }catch (Exception e)
        {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }
    @Override
    public TableModel searchStudentById(String userId) {
        TableModel tableModel = new TableModel();
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminidEqualTo(Integer.parseInt(userId));
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        tableModel.setData(admins);
        return tableModel;
    }
}
