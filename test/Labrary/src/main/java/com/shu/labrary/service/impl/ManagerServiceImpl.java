package com.shu.labrary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.*;
import com.shu.labrary.pojo.*;
import com.shu.labrary.pojo.request.AddFamousPic;
import com.shu.labrary.pojo.request.FamousTeacherInfo;
import com.shu.labrary.pojo.request.ManagerAddVo;
import com.shu.labrary.pojo.request.StTeacherInfo;
import com.shu.labrary.service.surface.ManagerService;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    ApplybodyMapper applybodyMapper;

    @Autowired
    BrokenpersonMapper brokenpersonMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    FileMapper fileMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    FamousteacherMapper famousteacherMapper;

    @Autowired
    NewsMapper newsMapper;

    @Autowired
    StteacherMapper stteacherMapper;

    @Autowired
    AppointmenttimeMapper appointmenttimeMapper;

    @Override
    public TableModel searchManager(Integer curr, Integer nums) throws AllException {
        TableModel tableModel = new TableModel();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAuthEqualTo("ROLE_Monitor");
        PageHelper.startPage(curr, 8);
        try {
            List<Admin> admins = adminMapper.selectByExample(adminExample);
            PageInfo pageInfo = new PageInfo(admins, 5);
            tableModel.setData(admins);
            tableModel.setMsg("200");
            tableModel.setCount((int) pageInfo.getTotal());
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel deleteMangers(List<Integer> list) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            for (Integer integer : list) {
                adminMapper.deleteByPrimaryKey(integer);
            }
            tableModel.setMsg("200");
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel addMangers(ManagerAddVo addTeamodel) throws AllException {
        TableModel tableModel = new TableModel();
        Admin admin = new Admin();
        try {
            admin.setAdminid(Integer.parseInt(addTeamodel.getTeacherID()));
            admin.setName(addTeamodel.getTeachername());
            //先查询部门，设置组织名称
            Department department = departmentMapper.selectByPrimaryKey(Integer.parseInt(addTeamodel.getDepId()));
            if (department != null) {
                //查询admin里面是否已经存在用户
                Admin admin1 = adminMapper.selectByPrimaryKey(Integer.parseInt(addTeamodel.getTeacherID()));
                //如果用户已经存在则更新用户
                if (admin1 != null) {
                    admin1.setAuth("ROLE_Monitor");
                    admin1.setDuty("管理员");
                    admin1.setPhone(addTeamodel.getPhone());
                    admin.setOrganization(department.getDepartmentname());
                    admin.setBrokenrecord(0);
                    admin.setOnline(true);
                    adminMapper.updateByPrimaryKeySelective(admin1);
                } else {
                    admin.setPhone(addTeamodel.getPhone());
                    admin.setAuth("ROLE_Monitor");
                    admin.setDuty("管理员");
                    admin.setOrganization(department.getDepartmentname());
                    admin.setBrokenrecord(0);
                    admin.setOnline(true);
                    adminMapper.insert(admin);
                }
            }
            tableModel.setMsg("200");
            return tableModel;

        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    //查询当前预约数 历史总预约数 辅导教师人数  违约人数
    @Override
    public TableModel searchCircle() throws AllException {
        TableModel tableModel = new TableModel();
        ApplybodyExample applybodyExample = new ApplybodyExample();
        try {
            ApplybodyExample.Criteria criteria = applybodyExample.createCriteria();
            criteria.andBegintimeGreaterThanOrEqualTo(new Date(System.currentTimeMillis()));
            int NowApplybodynumber = applybodyMapper.countByExample(applybodyExample);
            int allApplybodynumber = applybodyMapper.countByExample(null);
            int teacherNumber = teacherMapper.countByExample(null);
            int brokenPersonNumber = brokenpersonMapper.countByExample(null);
            List<Integer> list = new ArrayList<>();
            list.add(NowApplybodynumber);
            list.add(allApplybodynumber);
            list.add(teacherNumber);
            list.add(brokenPersonNumber);
            tableModel.setData(list);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel searchPictureSrc() throws AllException {
        TableModel tableModel = new TableModel();
        try {
            List<File> files = fileMapper.selectByExample(null);
            tableModel.setData(files);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel insert(News news) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            newsMapper.insert(news);
            tableModel.setMsg("200");
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }


    @Override
    public TableModel searchNews(Integer newsId) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            NewsExample newsExample = new NewsExample();
            NewsExample.Criteria criteria = newsExample.createCriteria().andNewsidEqualTo(newsId);
            List<News> news = newsMapper.selectByExampleWithBLOBs(newsExample);
            tableModel.setData(news);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel searchNewsForLatest() throws AllException {
        TableModel tableModel = new TableModel();
        try {
            List<Map> news = newsMapper.selectNewsLatest();
            List<Map> Managernews = newsMapper.selectManagerNews();
            List alllist = new ArrayList();
            alllist.add(news);
            alllist.add(Managernews);
            tableModel.setData(alllist);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel searchNewsManager(Integer curr) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            PageHelper.startPage(curr, 8);
            List<News> news = newsMapper.selectByExample(null);
            PageInfo pageInfo = new PageInfo(news, 5);
            int all = (int) pageInfo.getTotal();
            tableModel.setCount(all);
            tableModel.setData(news);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel selectNewsByDate(String inputstartdate, String inputenddate, Integer curr) throws ParseException, AllException {
        TableModel tableModel = new TableModel();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date newstartdate = formatter.parse(inputstartdate);
            Date newenddate = formatter.parse(inputenddate);
            PageHelper.startPage(curr, 8);
            List<Map> newsList = newsMapper.selectNewsByDate(newstartdate, newenddate);
            PageInfo pageInfo = new PageInfo(newsList, 5);
            tableModel.setCount((int) pageInfo.getTotal());
            tableModel.setData(newsList);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }


    @Override
    public TableModel deleteNews(List<Integer> deleteids) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            if (deleteids != null) {
                for (Integer deleteid : deleteids) {
                    newsMapper.deleteByPrimaryKey(deleteid);
                }
            }
            tableModel.setMsg("200");
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel selectTeacherInFamous(int parseInt) throws AllException {
        TableModel tableModel = new TableModel();
        try {

            TeacherExample teacherExample = new TeacherExample();
            TeacherExample.Criteria criteria = teacherExample.createCriteria().andDepartment1idEqualTo(parseInt);
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            tableModel.setData(teachers);
            return tableModel;

        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel uploadFamouTeacher(FamousTeacherInfo famousTeacherInfo) throws AllException {
        TableModel tableModel = new TableModel();
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeachernameEqualTo(famousTeacherInfo.getTeacherName());
        try {
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            if (teachers != null) {

                //先检查数据库是否有名师
                FamousteacherExample famousteacherExample = new FamousteacherExample();
                famousteacherExample.createCriteria().andTeacheridEqualTo(teachers.get(0).getTeacherid());
                List<Famousteacher> famousteachers = famousteacherMapper.selectByExample(famousteacherExample);
                Famousteacher famousteacher = new Famousteacher();
                if (famousteachers.isEmpty() || famousteachers.size() == 0) {

                    famousteacher.setTeacherid(teachers.get(0).getTeacherid());
                    famousteacher.setIntroductions(famousTeacherInfo.getHtml());
                    famousteacherMapper.insertSelective(famousteacher);
                } else {
                    famousteacher.setTeacherid(teachers.get(0).getTeacherid());
                    famousteacher.setIntroductions(famousTeacherInfo.getHtml());
                    famousteacherMapper.updateByPrimaryKeySelective(famousteacher);
                }
            }
            tableModel.setCode(200);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel deleteFamouTeacher(String teacherName) {
        TableModel tableModel = new TableModel();
        //先查询名师id
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTeachernameEqualTo(teacherName);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);

        if (teachers.size() != 0 || teachers != null) {
            FamousteacherExample famousteacherExample = new FamousteacherExample();
            famousteacherExample.createCriteria().andTeacheridEqualTo(teachers.get(0).getTeacherid());
            famousteacherMapper.deleteByExample(famousteacherExample);
        }
        tableModel.setCode(200);
        return tableModel;
    }


    @Override
    public TableModel searchNewsName() throws AllException {
        TableModel tableModel = new TableModel();
        NewsExample newsExample = new NewsExample();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -3);
        Date time = calendar.getTime();
        newsExample.createCriteria().andNewstimeGreaterThanOrEqualTo(time);
        try {
            List<News> news = newsMapper.selectByExample(newsExample);
            tableModel.setData(news);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel uploadFamPic(AddFamousPic addFamousPic) throws AllException {
        TableModel tableModel = new TableModel();
        File file = new File();
        //先查询新闻号
        NewsExample newsExample = new NewsExample();
        try {
            if (addFamousPic != null) {
                newsExample.createCriteria().andNewsnameEqualTo(addFamousPic.getNewsName());
                List<News> news = newsMapper.selectByExample(newsExample);

                if (news != null) {

                    //先将之前的news状态置为0
                    File oldFile = fileMapper.selectByPrimaryKey(Integer.parseInt(addFamousPic.getPicNum()));
                    News oldNew = newsMapper.selectByPrimaryKey(oldFile.getNewsid());
                    oldNew.setHavepicture(0);
                    newsMapper.updateByPrimaryKeySelective(oldNew);

                    //将新的新闻标识置1
                    NewsExample updateNews = new NewsExample();
                    updateNews.createCriteria().andNewsnameEqualTo(addFamousPic.getNewsName());
                    List<News> news1 = newsMapper.selectByExample(updateNews);
                    news1.get(0).setHavepicture(1);
                    newsMapper.updateByPrimaryKeySelective(news1.get(0));

                    file.setFileid(Integer.parseInt(addFamousPic.getPicNum()));
                    file.setFilesrc(addFamousPic.getPicsrc());
                    file.setFiletype("图片");
                    file.setFilename(addFamousPic.getNewsName());
                    file.setNewsid(news.get(0).getNewsid());
                    fileMapper.updateByPrimaryKeySelective(file);
                    tableModel.setCode(200);
                    return tableModel;

                }
            }
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
        return null;
    }


    @Override
    public TableModel addToStteacher(List<Integer> adminList) throws AllException {
        TableModel tableModel = new TableModel();

        try {
            for (Integer integer : adminList) {

                //先确定学生教师表中没有该学生
                Stteacher stteacher1 = stteacherMapper.selectByPrimaryKey(integer);
                if (stteacher1 != null) {
                    tableModel.setCode(500);
                    return tableModel;
                }
                //先查询出用户的信息
                Admin admin = adminMapper.selectByPrimaryKey(integer);
                if (admin != null) {
                    Stteacher stteacher = new Stteacher();
                    stteacher.setStteacherid(admin.getAdminid());
                    stteacher.setStteachername(admin.getName());
                    stteacher.setDuty(admin.getDuty());
                    stteacher.setDepartmentid(admin.getDepartmentid());
                    stteacher.setOrganization(admin.getOrganization());
                    stteacher.setBuilding("上海大学宝山校区本部图书馆二楼东侧");
                    stteacher.setCampus("宝山校区");
                    stteacher.setSatisfaction("3");
                    stteacherMapper.insertSelective(stteacher);

                    //再将admin表中的duty改为"学生教师"
                    admin.setDuty("学生教师");
                    admin.setAuth("ROLE_Teacher");
                    adminMapper.updateByPrimaryKeySelective(admin);
                    tableModel.setCode(200);
                } else {
                    tableModel.setCode(500);
                }
            }
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel searchStteacher(Integer curr) throws AllException {
        TableModel tableModel = new TableModel();
        try {
            PageHelper.startPage(curr, 8);
            StteacherExample stteacherExample = new StteacherExample();
            List<Stteacher> stteachers = stteacherMapper.selectByExample(stteacherExample);

            PageInfo pageInfo = new PageInfo(stteachers, 5);
            tableModel.setCount((int) pageInfo.getTotal());
            tableModel.setData(stteachers);
            tableModel.setCode(200);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel upDateStTeacher(StTeacherInfo stTeacherInfo) throws AllException {
        TableModel tableModel = new TableModel();
        Stteacher stteacher = new Stteacher();

        BeanUtils.copyProperties(stTeacherInfo, stteacher);
        //查询数据库中有没有该学生教师
        try {
            Stteacher stteacher1 = stteacherMapper.selectByPrimaryKey(stTeacherInfo.getStteacherid());

            if (stteacher1 != null) {
                //查询到学院的名称
                Department department = departmentMapper.selectByPrimaryKey(stTeacherInfo.getDepartmentid());
                stteacher.setOrganization(department.getDepartmentname());

                stteacherMapper.updateByPrimaryKeySelective(stteacher);
            } else {
                tableModel.setCode(500);
                return tableModel;
            }
            tableModel.setCode(200);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel deleteStTeacher(List<Integer> deleteids) throws AllException {
        TableModel tableModel = new TableModel();

        try {
            if (deleteids != null) {
                for (Integer deleteid : deleteids) {
                    //先检查有无预约安排
                    AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
                    appointmenttimeExample.createCriteria().andTeacheridEqualTo(deleteid);
                    List<Appointmenttime> appointmenttimes = appointmenttimeMapper.selectByExample(appointmenttimeExample);

                    ApplybodyExample applybodyExample = new ApplybodyExample();
                    applybodyExample.createCriteria().andTeacheridEqualTo(deleteid);
                    List<Applybody> applybodies = applybodyMapper.selectByExample(applybodyExample);
                    if (appointmenttimes.size() != 0 || applybodies.size() != 0) {
                        tableModel.setCode(500);
                        return tableModel;
                    }

                    stteacherMapper.deleteByPrimaryKey(deleteid);

                    //在删除学生教师同时，删除该用户
                    adminMapper.deleteByPrimaryKey(deleteid);

                }
            }
            tableModel.setCode(200);
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }
}
