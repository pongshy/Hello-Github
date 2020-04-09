package com.shu.labrary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.*;
import com.shu.labrary.pojo.*;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.pojo.response.*;
import com.shu.labrary.service.surface.Teacherservice;
import com.shu.labrary.tools.DateUtils;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@Transactional
@Service
public class TeacherserviceImpl implements Teacherservice {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private AppointmenttimeMapper appoinmenttimeMapper;

    @Autowired
    private ApplybodyMapper applybodyMapper;

    @Autowired
    private StudentqMapper studentqMapper;

    @Autowired
    private TeacherqMapper teacherqMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private FamousteacherMapper famousteacherMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StteacherMapper stteacherMapper;

    @Autowired
    private AppointmenttimeMapper appointmenttimeMapper;

    @Autowired
    private EssayMapper essayMapper;

    @Autowired
    private BrokenpersonMapper brokenpersonMapper;

    @Override
    public TableModel findteacherbydepid(int depid,Integer curr,Integer nums) throws AllException {
        TableModel tableModel=new TableModel();
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andDepartment1idEqualTo(depid);
        PageHelper.startPage(curr,nums);

        try {
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
            PageInfo pageInfo = new PageInfo(teacherList, 5);
            int total = (int) pageInfo.getTotal();
            tableModel.setCode(0);
            tableModel.setData(teacherList);
            tableModel.setCount(total);
            return tableModel;
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    public TableModel findallteacher(Object searchtext) throws AllException {
        TableModel tableModel = new TableModel();
        Pattern pattern = Pattern.compile("[0-9]*");
        boolean matches = pattern.matcher(searchtext.toString()).matches();
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        if (matches) {
            criteria.andTeacheridEqualTo(Integer.parseInt(searchtext.toString()));
        } else {
            criteria.andTeachernameEqualTo(searchtext.toString());
        }

        try {
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
            tableModel.setCount(teachers.size());
            tableModel.setData(teachers);
            tableModel.setCode(0);
            return tableModel;

        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    //增加老师
    @Override
    public TableModel addteacher(AddTeamodel addTeacherModel) throws AllException {
            TableModel tableModel=new TableModel();
            Teacher teacher=new Teacher();

        String departmentName= departmentMapper.selectByPrimaryKey(Integer.parseInt(addTeacherModel
                .getDepartment1id())).getDepartmentname();

            teacher.setTeacherid(Integer.parseInt(addTeacherModel.getTeacherID()));
            teacher.setTeachername(addTeacherModel.getTeachername());
            teacher.setDepartment1id(Integer.parseInt(addTeacherModel.getDepartment1id()));
            teacher.setOrganization(departmentName);
            teacher.setMajor(addTeacherModel.getMajor());
            teacher.setHelpintention(addTeacherModel.getHelpintention());
            teacher.setCampus("宝山校区");
            teacher.setOnline(0);
            teacher.setFree(true);
            teacher.setSatisfaction("3");
            teacher.setBuilding("上海大学宝山校区本部图书馆二楼东侧");
            teacher.setImagesrc(addTeacherModel.getImgurl());
            teacher.setDescription(addTeacherModel.getDescription());

            //再在admin表里面添加用户
            Admin admin=new Admin();
            admin.setAdminid(teacher.getTeacherid());
            admin.setName(teacher.getTeachername());
            admin.setOrganization(teacher.getOrganization());
            admin.setOnline(true);
            admin.setDuty("教职工");
            admin.setAuth("ROLE_Teacher");
            admin.setDepartmentid(teacher.getDepartment1id());

            try {
                if (teacherMapper.selectByPrimaryKey(Integer.parseInt(addTeacherModel.getTeacherID())) != null) {
                    teacherMapper.updateByPrimaryKeySelective(teacher);
                } else {

                    teacherMapper.insert(teacher);
                }

                Admin admin1 = adminMapper.selectByPrimaryKey(admin.getAdminid());
                if (admin1==null)
                {
                    adminMapper.insertSelective(admin);
                }else
                {
                    adminMapper.updateByPrimaryKeySelective(admin);
                }

                tableModel.setCode(200);
                return tableModel;
            }
            catch (Exception e) {
                throw new AllException(EmAllException.DATABASE_ERROR);
            }
    }

    @Override
    public TableModel deleteteacherservice(List<Integer> deletedata) throws IOException {
        try {
            TableModel tableModel = new TableModel();
            for (Integer deletedatum : deletedata) {

                //先查询有无预约
                ApplybodyExample applybodyExample=new ApplybodyExample();
                 applybodyExample.createCriteria().andTeacheridEqualTo(deletedatum);
                List<Applybody> applybodies = applybodyMapper.selectByExample(applybodyExample);

                for (Applybody applybody : applybodies) {
                    if (applybody.getBegintime().after(new Date()))
                    {
                        tableModel.error("教师存在预约，无法删除");
                        return tableModel;
                    }
                }

                teacherMapper.deleteByPrimaryKey(deletedatum);

                //在admin表里面查询，也进行删除
                Admin admin = adminMapper.selectByPrimaryKey(deletedatum);
                if (admin!=null)
                {
                    adminMapper.deleteByPrimaryKey(deletedatum);
                }
            }
            tableModel.setCode(200);
            return tableModel;
        }
        catch (Exception e) {
            e.printStackTrace();
            return TableModel.error("Error");
        }
    }

    @Override
    public TableModel updateTeacherStatus(Integer teacherid, Boolean free) throws AllException {
        TableModel tableModel=new TableModel();
        Teacher teacher=new Teacher();
        teacher.setFree(free);
        teacher.setTeacherid(teacherid);

        try {
            teacherMapper.updateByPrimaryKeySelective(teacher);
            tableModel.setMsg("200");
            return tableModel;
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel searchTeacherInformation(Integer curr, Integer nums) throws AllException {
        return null;
    }



    /**
     * @Description: 教师同意预约
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    @Override
    public TableModel agreeAppointment(AgreeAppointmentInfo data) throws AllException {
        Integer requestId = data.getRequestId();

        ApplybodyExample applybodyExample = new ApplybodyExample();
        applybodyExample.createCriteria().andRequestidEqualTo(requestId);

        Applybody record = new Applybody();
        record.setApplystatus(1);

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(requestId);
            if (applybody.getApplystatus() != 0) {
                return TableModel.error("该预约已被同意或拒绝");
            }
            if (applybodyMapper.updateByExampleSelective(record, applybodyExample) == 1) {
                //自动拒绝该用户对于教师的其他时间预约请求
                applybodyExample.clear();
                applybodyExample.createCriteria().andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andTeacheridEqualTo(Integer.parseInt(applybody.getAdminid()));

                Applybody applybody_temp = new Applybody();
                applybody_temp.setApplystatus(-1);

                TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                Date date = new Date(System.currentTimeMillis());
                applybody_temp.setTimestamp(date);
                applybody_temp.setRefusereason("已有预约被同意");
                applybodyMapper.updateByExampleSelective(applybody_temp, applybodyExample);

                //自动拒绝该用户这个时间段的其他请求
                applybodyExample.clear();
                applybodyExample.createCriteria().andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andBegintimeBetween(applybody.getBegintime(), applybody.getEndtime());

                ApplybodyExample.Criteria criteria = applybodyExample.createCriteria();
                criteria.andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andEndtimeBetween(applybody.getBegintime(), applybody.getEndtime());

                ApplybodyExample.Criteria criteria1 = applybodyExample.createCriteria();
                criteria1.andAdminidEqualTo(applybody.getAdminid()).andApplystatusEqualTo(0).andBegintimeLessThanOrEqualTo(applybody.getBegintime()).andEndtimeGreaterThanOrEqualTo(applybody.getEndtime());

                applybodyExample.or(criteria);
                applybodyExample.or(criteria1);

                Applybody record2 = new Applybody();
                record2.setApplystatus(-1);
                record2.setRefusereason("有时间段重合的预约被同意");

                applybodyMapper.updateByExampleSelective(record2, applybodyExample);

               //teacher那张表中增加历史订单数
                Teacher teacher = teacherMapper.selectByPrimaryKey(applybody.getTeacherid());
                teacher.setOrdernumber(teacher.getOrdernumber() + 1);
                teacherMapper.updateByPrimaryKeySelective(teacher);

                //生成两份问卷
                //教师填写的问卷
                Teacherq teacherq = new Teacherq();
                teacherq.setRequsetid(applybody.getRequestid());
                teacherq.setTeacherid(teacher.getTeacherid());
                if (teacherqMapper.insertSelective(teacherq) != 1) {
                    return TableModel.error("教师问卷生成失败");
                }
                //学生填写的问卷
                Studentq studentq = new Studentq();
                studentq.setRequestid(applybody.getRequestid());
                studentq.setStudentid(Integer.parseInt(applybody.getAdminid()));
                if (studentqMapper.insertSelective(studentq) != 1) {
                    return TableModel.error("学生问卷生成失败");
                }
                //这位教师的这段预约时间被占用
                AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
                appointmenttimeExample.createCriteria().andTeacheridEqualTo(applybody.getTeacherid()).andStarttimeEqualTo(applybody.getBegintime());
                Appointmenttime appointmenttime = new Appointmenttime();
                appointmenttime.setOccupy(1);
                if (appoinmenttimeMapper.updateByExampleSelective(appointmenttime, appointmenttimeExample) != 1) {
                    return TableModel.error("出现错误");
                }

                return TableModel.success("预约成功!");
            }
            else {
                return TableModel.error("预约失败!");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }


    /**
     * @Description: 教师拒绝预约
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    @Override
    public TableModel refuseAppointment(RefuseAppointmentInfo data) throws AllException {
        Integer requestId = data.getRequestId();
        String reason = data.getReason();

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(requestId);

            if (applybody == null) {
                return TableModel.error("不存在该预约!");
            }
            if (applybody.getApplystatus() != 0) {
                return TableModel.error("该预约已同意或是拒绝!");
            }

            applybody.setApplystatus(-1);
            applybody.setRefusereason(reason);

            if (applybodyMapper.updateByPrimaryKeySelective(applybody) > 0) {
                return TableModel.success("拒绝成功!");
            } else {
                return TableModel.error("出错!");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel showInformation() throws AllException {
        try {
            List<Famousteacher> famousteacherList = famousteacherMapper.selectByExampleWithBLOBs(null);
            List<ShowTeacherMessageVO> list = new ArrayList<>();

            AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
            Integer teacherId = 0;
            for (Famousteacher famousteacher : famousteacherList) {
                ShowTeacherMessageVO temp = new ShowTeacherMessageVO();

                teacherId = famousteacher.getTeacherid();
                Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);

                temp.setTeacherId(teacherId);
                BeanUtils.copyProperties(teacher, temp);
                //教师学院信息
                Integer departmentId = teacher.getDepartment1id();
                Department department = departmentMapper.selectByPrimaryKey(departmentId);
                temp.setAcademy(department.getDepartmentname());

                //预约时间
                appointmenttimeExample.createCriteria().andTeacheridEqualTo(teacherId);
                List<Appointmenttime> appointmenttimeList = appoinmenttimeMapper.selectByExample(appointmenttimeExample);
                temp.setAppointmentTimeList(appointmenttimeList);

                //各种奖项，著作，兼职等信息
                temp.setIntroductions(famousteacher.getIntroductions());

                list.add(temp);
                appointmenttimeExample.clear();
            }

            return TableModel.success(list, list.size());

//            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
//
//            if (teacherList.size() == 0) {
//                return TableModel.success(null);
//            }
//
//            DecimalFormat df = new DecimalFormat("0.0");
//
//            AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
//            int i = 0;
//            Integer departmentId = 0;
//
//            for (Teacher temp : teacherList) {
//                if (i > 11) {
//                    break;
//                }
//                ShowTeacherMessageVO showTeacherMessageVO = new ShowTeacherMessageVO();
//                BeanUtils.copyProperties(temp, showTeacherMessageVO);
//                showTeacherMessageVO.setTeacherId(temp.getTeacherid());
//                //满意度，设置小数位数——0.0
//                showTeacherMessageVO.setSatisfaction(df.format(Double.parseDouble(temp.getSatisfaction())));
//
//                //预约时间
//                appointmenttimeExample.createCriteria().andTeacheridEqualTo(temp.getTeacherid());
//                List<Appointmenttime> appointmenttimes = appoinmenttimeMapper.selectByExample(appointmenttimeExample);
//                showTeacherMessageVO.setAppointmentTimeList(appointmenttimes);
//
//                //学院
//                departmentId = temp.getDepartment1id();
//                Department department = departmentMapper.selectByPrimaryKey(departmentId);
//                showTeacherMessageVO.setAcademy(department.getDepartmentname());
//
//                list.add(showTeacherMessageVO);
//                ++i;
//                appointmenttimeExample.clear();
//            }
//
//            return TableModel.success(list, i);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    //在教师编辑页面，查询一个教师的所有时间
    @Override
    public TableModel searchEditTimes(Integer teacherid) {
        TableModel tableModel=new TableModel();
        AppointmenttimeExample appoinmenttimeExample=new AppointmenttimeExample();
        AppointmenttimeExample.Criteria criteria = appoinmenttimeExample.createCriteria();
        criteria.andTeacheridEqualTo(teacherid);
        criteria.andOccupyEqualTo(0);
        List<Appointmenttime> appoinmenttimeList = appoinmenttimeMapper.selectByExample(appoinmenttimeExample);
        List<ManagerTimeVO>list=new ArrayList<>();
        for (Appointmenttime appointmenttime : appoinmenttimeList) {
            ManagerTimeVO managerTimeVO=new ManagerTimeVO();
            managerTimeVO.setTeacherid(teacherid);
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            managerTimeVO.setStarttime(simpleDateFormat.format(appointmenttime.getStarttime()));
            managerTimeVO.setEndtime(simpleDateFormat.format(appointmenttime.getEndtime()));
            managerTimeVO.setOccupy(appointmenttime.getOccupy());
            list.add(managerTimeVO);
        }
        tableModel.setData(list);
        return tableModel;
    }

    @Override
    public TableModel saveTimes( Appointmenttime[] time) throws ParseException {
       TableModel tableModel=new TableModel();
       AppointmenttimeExample appointmenttimeExample=new AppointmenttimeExample();
        AppointmenttimeExample.Criteria criteria = appointmenttimeExample.createCriteria();
        for (Appointmenttime appointmenttime : time) {
                criteria.andTeacheridEqualTo(appointmenttime.getTeacherid());
                appoinmenttimeMapper.deleteByExample(appointmenttimeExample);
        }
        for (Appointmenttime appointmenttime : time) {
                appointmenttime.setId(null);
                appoinmenttimeMapper.insert(appointmenttime);
        }
        tableModel.setMsg("200");
        return tableModel;
    }

    @Override
    public TableModel loadStudentTeacherMsg(NameInfo data) throws AllException{
        String name = data.getName();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        Date date_1 = calendar.getTime();

        StteacherExample stteacherExample = new StteacherExample();
        stteacherExample.createCriteria().andStteachernameLike("%" + name + "%");

        List<Stteacher> stteacherList = stteacherMapper.selectByExample(stteacherExample);
        List<ShowStudentTeacherVO> list = new ArrayList<>();

        AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
        DecimalFormat df = new DecimalFormat("0.0");
        for (Stteacher stteacher : stteacherList) {
            ShowStudentTeacherVO temp = new ShowStudentTeacherVO();

            BeanUtils.copyProperties(stteacher, temp);
            //满意度
            temp.setSatisfaction(df.format(Double.parseDouble(stteacher.getSatisfaction())));
            //学院
            Department department = departmentMapper.selectByPrimaryKey(stteacher.getDepartmentid());
            temp.setAcademy(department.getDepartmentname());
            //预约时间
            AppointmenttimeExample.Criteria criteria = appointmenttimeExample.createCriteria();
            criteria.andTeacheridEqualTo(stteacher.getStteacherid()).andStarttimeGreaterThanOrEqualTo(date_1).andOccupyEqualTo(0);

            List<Appointmenttime> appointmenttimes = appointmenttimeMapper.selectByExample(appointmenttimeExample);
            temp.setAppointmentTimeList(appointmenttimes);

            Admin admin = adminMapper.selectByPrimaryKey(stteacher.getStteacherid());
            temp.setEmail(admin.getEmail());
            temp.setPhone(admin.getPhone());

            list.add(temp);
            appointmenttimeExample.clear();
        }

        return TableModel.success(list);
    }

    @Override
    public TableModel loadDataAcademy(ShowTeacherMsgInfo data) throws AllException {
        String campus = data.getCampsuList();
        String academy = data.getAcademy();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, 1);
        date2 = calendar.getTime();

        List<ShowStudentTeacherVO> list = new ArrayList<>();

        try {
            DepartmentExample departmentExample = new DepartmentExample();
            StteacherExample stteacherExample = new StteacherExample();
            departmentExample.createCriteria().andDepartmentnameEqualTo(academy);

            List<Department> departments = departmentMapper.selectByExample(departmentExample);

            Department department = departments.get(0);
            Integer departmentId = department.getDepartmentid();

            if (campus.equals("全部")) {
                stteacherExample.createCriteria().andDepartmentidEqualTo(departmentId);
            }
            else {
                stteacherExample.createCriteria().andCampusEqualTo(campus).andDepartmentidEqualTo(departmentId);
            }

            PageHelper.startPage(data.getPage(), 12);
            List<Stteacher> stteacherList = stteacherMapper.selectByExample(stteacherExample);

            if (stteacherList.size() == 0) {
                return TableModel.success("暂时没有小教师", 0);
            }
            AppointmenttimeExample appoinmenttimeExample = new AppointmenttimeExample();

            DecimalFormat df = new DecimalFormat("0.0");

            for (Stteacher stteacher : stteacherList) {
                ShowStudentTeacherVO temp = new ShowStudentTeacherVO();
                BeanUtils.copyProperties(stteacher, temp);

                temp.setSatisfaction(df.format(Double.parseDouble(stteacher.getSatisfaction())));

                AppointmenttimeExample.Criteria criteria = appoinmenttimeExample.createCriteria();
                criteria.andTeacheridEqualTo(stteacher.getStteacherid()).andStarttimeGreaterThanOrEqualTo(date2);
                List<Appointmenttime> appointmenttimeList = appointmenttimeMapper.selectByExample(appoinmenttimeExample);

                temp.setAcademy(department.getDepartmentname());
                temp.setAppointmentTimeList(appointmenttimeList);

                Admin admin = adminMapper.selectByPrimaryKey(stteacher.getStteacherid());
                temp.setEmail(admin.getEmail());

                list.add(temp);
                appoinmenttimeExample.clear();
            }
            PageInfo pageInfo = new PageInfo(stteacherList);
            int total = (int)pageInfo.getTotal();
            return TableModel.success(list, total);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel loadDataCampus(ShowTeachersInCampusInfo data) throws AllException {
        Integer page = data.getPage();
        String campus = data.getCampus();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, 1);
        date2 = calendar.getTime();

        StteacherExample stteacherExample = new StteacherExample();
        if (campus.equals("全部")) {
            stteacherExample.createCriteria().andCampusIsNotNull();
        }
        else {
            stteacherExample.createCriteria().andCampusEqualTo(campus);
        }

        PageHelper.startPage(page, 12);
        List<Stteacher> stteacherList = stteacherMapper.selectByExample(stteacherExample);
        if (stteacherList.size() == 0) {
            return TableModel.success("暂时没有教师", 0);
        }

        DecimalFormat df = new DecimalFormat("0.0");

        List<ShowStudentTeacherVO> list = new ArrayList<>();

        AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
        for (Stteacher stteacher : stteacherList) {
            ShowStudentTeacherVO temp = new ShowStudentTeacherVO();

            BeanUtils.copyProperties(stteacher, temp);
            temp.setSatisfaction(df.format(Double.parseDouble(stteacher.getSatisfaction())));

            appointmenttimeExample.createCriteria().andTeacheridEqualTo(stteacher.getStteacherid()).andStarttimeGreaterThanOrEqualTo(date2);
            List<Appointmenttime> appointmenttimes = appointmenttimeMapper.selectByExample(appointmenttimeExample);
            temp.setAppointmentTimeList(appointmenttimes);

            Department department = departmentMapper.selectByPrimaryKey(stteacher.getDepartmentid());
            temp.setAcademy(department.getDepartmentname());

            Admin admin = adminMapper.selectByPrimaryKey(stteacher.getStteacherid());
            temp.setEmail(admin.getEmail());

            list.add(temp);
            appointmenttimeExample.clear();
        }

        PageInfo pageInfo = new PageInfo(stteacherList);
        int total = (int)pageInfo.getTotal();

        return TableModel.success(list, total);
    }

    @Override
    public TableModel showPersonalStteacher(Integer userId) throws AllException {
        Stteacher stteacher = stteacherMapper.selectByPrimaryKey(userId);

        if (stteacher == null) {
            return TableModel.error("暂无此小老师");
        }

        ShowStudentTeacherInformationVO show = new ShowStudentTeacherInformationVO();
        BeanUtils.copyProperties(stteacher, show);

        //学院名
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDepartmentidEqualTo(stteacher.getDepartmentid());

        Department department = departmentMapper.selectByExample(departmentExample).get(0);
        show.setAcademy(department.getDepartmentname());

        //email.phone
        Admin admin = adminMapper.selectByPrimaryKey(userId);
        show.setEmail(admin.getEmail());
        show.setPhone(admin.getPhone());

        //满意度
        DecimalFormat df = new DecimalFormat("0.0");
        show.setSatisfaction(df.format(Double.parseDouble(stteacher.getSatisfaction())));

        //setOnline
        if (admin.getOnline()) {
            show.setOnline(1);
        }
        else {
            show.setOnline(0);
        }

        return TableModel.success(show);
    }

    @Override
    public TableModel changeStteacherInfor(ChangeStTeacherInformationInfo data) throws AllException {
        Stteacher record = new Stteacher();

        BeanUtils.copyProperties(data, record);

//        Stteacher stteacher = stteacherMapper.selectByPrimaryKey(data.getStteacherid());
//        DepartmentExample departmentExample = new DepartmentExample();
//        departmentExample.createCriteria().andDepartmentnameEqualTo(data.getAcademy());
//
//        Department department = departmentMapper.selectByExample(departmentExample).get(0);
//        record.setDepartmentid(department.getDepartmentid());

        if (stteacherMapper.updateByPrimaryKeySelective(record) <= 0) {
            return TableModel.error("修改失败");
        }

        Admin admin = new Admin();

        admin.setAdminid(data.getStteacherid());
        admin.setEmail(data.getEmail());
        admin.setPhone(data.getPhone());

        if (adminMapper.updateByPrimaryKeySelective(admin) > 0) {
            return TableModel.success("修改成功");
        }
        else {
            return TableModel.error("修改失败");
        }

    }

    @Override
    public TableModel stteacherAgreeAppointment(AgreeAppointmentInfo data) throws AllException {
        Integer requestId = data.getRequestId();

        ApplybodyExample applybodyExample = new ApplybodyExample();
        applybodyExample.createCriteria().andRequestidEqualTo(requestId);

        Applybody record = new Applybody();
        record.setApplystatus(1);

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(requestId);
            if (applybody.getApplystatus() != 0) {
                return TableModel.error("该预约已被同意或拒绝");
            }
            if (applybodyMapper.updateByExampleSelective(record, applybodyExample) == 1) {
                //自动拒绝该用户对于教师的其他时间预约请求
                applybodyExample.clear();
                applybodyExample.createCriteria().andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andTeacheridEqualTo(Integer.parseInt(applybody.getAdminid()));

                Applybody applybody_temp = new Applybody();
                applybody_temp.setApplystatus(-1);

                TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                Date date = new Date(System.currentTimeMillis());
                applybody_temp.setTimestamp(date);
                applybody_temp.setRefusereason("已有预约被同意");
                applybodyMapper.updateByExampleSelective(applybody_temp, applybodyExample);

                //自动拒绝该用户这个时间段的其他请求
                applybodyExample.clear();
                applybodyExample.createCriteria().andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andBegintimeBetween(applybody.getBegintime(), applybody.getEndtime());

                ApplybodyExample.Criteria criteria = applybodyExample.createCriteria();
                criteria.andApplystatusEqualTo(0).andAdminidEqualTo(applybody.getAdminid()).andEndtimeBetween(applybody.getBegintime(), applybody.getEndtime());

                ApplybodyExample.Criteria criteria1 = applybodyExample.createCriteria();
                criteria1.andAdminidEqualTo(applybody.getAdminid()).andApplystatusEqualTo(0).andBegintimeLessThanOrEqualTo(applybody.getBegintime()).andEndtimeGreaterThanOrEqualTo(applybody.getEndtime());

                applybodyExample.or(criteria);
                applybodyExample.or(criteria1);

                Applybody record2 = new Applybody();
                record2.setApplystatus(-1);
                record2.setRefusereason("有时间段重合的预约被同意");

                applybodyMapper.updateByExampleSelective(record2, applybodyExample);

                //stteacher那张表中增加历史订单数
                Stteacher stteacher = stteacherMapper.selectByPrimaryKey(applybody.getTeacherid());
                stteacher.setOrdernumber(stteacher.getOrdernumber() + 1);
                stteacherMapper.updateByPrimaryKeySelective(stteacher);

                //生成两份问卷
                //教师填写的问卷
                Teacherq teacherq = new Teacherq();
                teacherq.setRequsetid(applybody.getRequestid());
                teacherq.setTeacherid(stteacher.getStteacherid());
                if (teacherqMapper.insertSelective(teacherq) != 1) {
                    return TableModel.error("教师问卷生成失败");
                }
                //学生填写的问卷
                Studentq studentq = new Studentq();
                studentq.setRequestid(applybody.getRequestid());
                studentq.setStudentid(Integer.parseInt(applybody.getAdminid()));
                if (studentqMapper.insertSelective(studentq) != 1) {
                    return TableModel.error("学生问卷生成失败");
                }
                //这位教师的这段预约时间被占用
                AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
                appointmenttimeExample.createCriteria().andTeacheridEqualTo(applybody.getTeacherid()).andStarttimeEqualTo(applybody.getBegintime());
                Appointmenttime appointmenttime = new Appointmenttime();
                appointmenttime.setOccupy(1);
                if (appoinmenttimeMapper.updateByExampleSelective(appointmenttime, appointmenttimeExample) != 1) {
                    return TableModel.error("出现错误");
                }

                return TableModel.success("预约成功!");
            }
            else {
                return TableModel.error("预约失败!");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel stteacherSeeAppointment(AuditStatusInfo data) throws AllException {
        Integer teacherId = data.getUserId();
        boolean success = data.isSuccess();
        boolean fail = data.isFail();
        boolean checked = data.isCheck();

        if (!success&& !fail && !checked) {
            return TableModel.success("成功", 0);
        }

        try {
            ApplybodyExample applybodyExample = new ApplybodyExample();

            ApplybodyExample.Criteria criteria = applybodyExample.createCriteria();
            ApplybodyExample.Criteria criteria1 = applybodyExample.createCriteria();
            ApplybodyExample.Criteria criteria2 = applybodyExample.createCriteria();

            if (success) {
                criteria.andApplystatusEqualTo(1);
                criteria.andTeacheridEqualTo(teacherId);
            }
            if (checked) {
                criteria1.andApplystatusEqualTo(0);
                criteria1.andTeacheridEqualTo(teacherId);
            }
            if (fail) {
                criteria2.andApplystatusEqualTo(-1);
                criteria2.andTeacheridEqualTo(teacherId);
            }
            applybodyExample.or(criteria1);
            applybodyExample.or(criteria2);

            List<Applybody> applybodyList = applybodyMapper.selectByExample(applybodyExample);

            if (applybodyList.size() == 0) {
                return TableModel.success("成功", 0);
            }

            Stteacher stteacher = stteacherMapper.selectByPrimaryKey(teacherId);
            EssayExample essayExample = new EssayExample();

            List<TeacherSeeAppointmentVO> list = new ArrayList<>();
            for (Applybody applybody : applybodyList) {
                TeacherSeeAppointmentVO temp = new TeacherSeeAppointmentVO();

                Admin user = adminMapper.selectByPrimaryKey(Integer.parseInt(applybody.getAdminid()));
                Department department = departmentMapper.selectByPrimaryKey(user.getDepartmentid());

                essayExample.setOrderByClause("`finishtime` DESC");
                essayExample.createCriteria().andAdminidEqualTo(user.getAdminid()).andTeacheridEqualTo(applybody.getTeacherid());
                List<Essay> essayList = essayMapper.selectByExample(essayExample);

                temp.setEmail(user.getEmail());

                //必须要先上传文章或论文，才可以预约
                if (essayList.size() == 0) {
                    essayExample.clear();
                    continue;
                }
                Essay essay = essayList.get(0);

                temp.setEssayName(essay.getEssayname());
                temp.setEssaysrc(essay.getEssaysrc());
                temp.setStudentName(user.getName());
                temp.setPhoneNumber(user.getPhone());
                temp.setAcademy(department.getDepartmentname());
                temp.setRequestId(applybody.getRequestid());
                temp.setStudentId(applybody.getAdminid());
                temp.setStartTime(DateUtils.DatetoStr(applybody.getBegintime()));
                temp.setEndTime(DateUtils.DatetoStr(applybody.getEndtime()));

                if (applybody.getApplystatus() == -1) {
                    temp.setApplyStatus(3);
                }
                else if (applybody.getApplystatus() == 0) {
                    temp.setApplyStatus(1);
                }
                else if (applybody.getApplystatus() == 1) {
                    temp.setApplyStatus(2);
                }

                BeanUtils.copyProperties(stteacher, temp);

                essayExample.clear();
                list.add(temp);
            }

            return TableModel.success(list);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel  userConfirmStteacher(ConfirmPaperUploadInfo data) throws AllException {
        BrokenpersonExample brokenpersonExample = new BrokenpersonExample();
        brokenpersonExample.createCriteria().andUseridEqualTo(data.getStudentId());

        List<Brokenperson> brokenpersonList = brokenpersonMapper.selectByExample(brokenpersonExample);
        if (brokenpersonList.size() != 0) {
            Brokenperson brokenperson = brokenpersonList.get(0);
            if (brokenperson.getTime() >= 3) {
                return TableModel.error("失信人员，无法进行预约");
            }
        }

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Date date3 = new Date(System.currentTimeMillis());

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date3);
        calendar.add(Calendar.DATE, 1);
        date3 = calendar.getTime();

        Appointmenttime appointmenttime_ = appointmenttimeMapper.selectByPrimaryKey(data.getTimeid());
        if (date3.after(appointmenttime_.getStarttime())) {
            return TableModel.error("用户必须提前预约开始时间24小时预约教师");
        }

        //限制用户只能对同一个老师预约一次
//        ApplybodyExample applybodyExample2 = new ApplybodyExample();
//        applybodyExample2.createCriteria().andAdminidEqualTo(data.getStudentId().toString()).andTeacheridEqualTo(data.getTeacherid()).andApplystatusEqualTo(1).andEndtimeGreaterThanOrEqualTo(date2);
//
//        if (applybodyMapper.countByExample(applybodyExample2) > 0) {
//            return TableModel.error("有未完成的预约，无法进行预约");
//        }

        Essay record = new Essay();

        BeanUtils.copyProperties(data, record);
        record.setAdminid(data.getStudentId());
        record.setEssayname(data.getEssayname());
        record.setOnlin(0);

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date_now = new Date(System.currentTimeMillis());
        System.out.println(date_now);

        record.setFinishtime(date_now);

        Stteacher stteacher = stteacherMapper.selectByPrimaryKey(data.getTeacherid());

        if (stteacher == null) {
            return TableModel.error("不存在该小老师");
        }

        Appointmenttime time = appointmenttimeMapper.selectByPrimaryKey(data.getTimeid());

        ApplybodyExample applybodyExample = new ApplybodyExample();
        applybodyExample.createCriteria().andTeacheridEqualTo(data.getTeacherid()).andAdminidEqualTo(data.getStudentId().toString()).andApplystatusEqualTo(0);

        if (applybodyMapper.countByExample(applybodyExample) >= 1) {
            return TableModel.error("已有预约申请在审核中");
        }

        if (time.getOccupy() != 1) {
            if (essayMapper.insertSelective(record) == 1) {
                //创建预约表单
                EssayExample essayExample = new EssayExample();
                essayExample.createCriteria().andTeacheridEqualTo(data.getTeacherid()).andAdminidEqualTo(data.getStudentId()).andEssaynameLike(data.getEssayname());
                essayExample.setOrderByClause("`finishtime` DESC");
                List<Essay> essayList = essayMapper.selectByExample(essayExample);
                if (essayList.size() == 0) {
                    return TableModel.error("预约申请失败");
                }
                Essay essay = essayList.get(0);

                Applybody applybody = new Applybody();
                applybody.setAdminid(data.getStudentId().toString());
                applybody.setBegintime(time.getStarttime());
                applybody.setEndtime(time.getEndtime());
                applybody.setApplystatus(0);
                applybody.setTeacherid(data.getTeacherid());

                applybody.setTimestamp(date_now);
                applybody.setEssayid(essay.getEssayid());
                applybody.setTotalpersonnum(1);
                applybodyMapper.insertSelective(applybody);

                return TableModel.success("预约申请成功!");
            }
            else {
                return TableModel.error("预约申请失败");
            }

        }
        else {
            return TableModel.error("预约失败!");
        }
    }

    @Override
    public TableModel changeImageForStteacher(ModifyImageInfo data) throws AllException {
        Integer teacherId = data.getTeacherId();
        String src = data.getSrc();

        Stteacher record = new Stteacher();
        record.setStteacherid(teacherId);
        record.setImagesrc(src);

        if (stteacherMapper.updateByPrimaryKeySelective(record) == 1) {
            return TableModel.success("修改成功");
        }
        else {
            return TableModel.error("修改失败");
        }
    }


    @Override
    public TableModel saveNullTimes(Integer teacherid) {
        TableModel tableModel=new TableModel();
        AppointmenttimeExample appointmenttimeExample=new AppointmenttimeExample();
        appointmenttimeExample.createCriteria().andTeacheridEqualTo(teacherid);
        appoinmenttimeMapper.deleteByExample(appointmenttimeExample);
        tableModel.setCode(200);
        return tableModel;
    }


}
