package com.shu.labrary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.StringUtils;
import com.mysql.jdbc.util.TimezoneDump;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.*;
import com.shu.labrary.pojo.*;
import com.shu.labrary.pojo.SsmPojo.SmsCodePojo;
import com.shu.labrary.pojo.SsmPojo.SmsCodeProvider;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.pojo.response.*;
import com.shu.labrary.service.surface.UserService;
import com.shu.labrary.tools.DateUtils;
import com.shu.labrary.tools.SsmSendTool;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private ApplybodyMapper applybodyMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private EssayMapper essayMapper;

    @Autowired
    private AppointmenttimeMapper appointmenttimeMapper;

    @Autowired
    private StudentqMapper studentqMapper;

    @Autowired
    private TeacherqMapper teacherqMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private BrokenpersonMapper brokenpersonMapper;

    @Autowired
    private StteacherMapper stteacherMapper;


    private String defaultUrl = "http://114.55.93.118/group1/M00/00/02/rBA7015HjXuAbh4iAAALaqoPL5I411.jpg";

    /**
     * @Description: 根据姓名返回对应教师信息
     * @Param: [NameInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-27
     */
    @Override
    public TableModel getInforFromName(NameInfo data) throws AllException {
        String name = data.getName();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, 1);
        date2 = calendar.getTime();

        TeacherExample teacherExample = new TeacherExample();
//        teacherExample.createCriteria().andTeachernameEqualTo(name);
        teacherExample.createCriteria().andTeachernameLike("%" + name + "%");

//        try {
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);

            if (teachers.size() == 0) {
                return TableModel.error("输入有误");
            }
            AppointmenttimeExample appoinmenttimeExample = new AppointmenttimeExample();

            DecimalFormat df = new DecimalFormat("0.0");

            List<TeacherInformationVO> list = new ArrayList<>();
            for (Teacher teacher : teachers) {
                TeacherInformationVO temp = new TeacherInformationVO();
                BeanUtils.copyProperties(teacher, temp);

                temp.setSatisfaction(df.format(Double.parseDouble(teacher.getSatisfaction())));

                AppointmenttimeExample.Criteria criteria = appoinmenttimeExample.createCriteria();
                criteria.andTeacheridEqualTo(teacher.getTeacherid()).andStarttimeGreaterThanOrEqualTo(date2).andOccupyEqualTo(0);

                List<Appointmenttime> appoinmenttimeList = appointmenttimeMapper.selectByExample(appoinmenttimeExample);
                temp.setAppointmentTimeList(appoinmenttimeList);

                Department department = departmentMapper.selectByPrimaryKey(teacher.getDepartment1id());
                temp.setAcademy(department.getDepartmentname());

                list.add(temp);
                appoinmenttimeExample.clear();
            }

            return TableModel.success(list);
//        }
//        catch (Exception e) {
//            throw new AllException(EmAllException.DATABASE_ERROR);
//        }
    }

    @Override
    public TableModel showTeacherMsg(ShowTeacherMsgInfo data) throws AllException {
        String campus = data.getCampsuList();
        String academy = data.getAcademy();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, 1);
        date2 = calendar.getTime();

        List<TeacherInformationVO> list = new ArrayList<>();

        try {
            DepartmentExample departmentExample = new DepartmentExample();
            TeacherExample teacherExample = new TeacherExample();
            departmentExample.createCriteria().andDepartmentnameEqualTo(academy);

            List<Department> departments = departmentMapper.selectByExample(departmentExample);

            Department department = departments.get(0);
            Integer departmentId = department.getDepartmentid();

            if (campus.equals("全部")) {
                teacherExample.createCriteria().andDepartment1idEqualTo(departmentId);
            }
            else {
                teacherExample.createCriteria().andCampusEqualTo(campus).andDepartment1idEqualTo(departmentId);
            }

            PageHelper.startPage(data.getPage(), 12);
            List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);

            if (teachers.size() == 0) {
                return TableModel.success("暂时没有教师", 0);
            }
            AppointmenttimeExample appoinmenttimeExample = new AppointmenttimeExample();

            DecimalFormat df = new DecimalFormat("0.0");

            for (Teacher teacher : teachers) {
                TeacherInformationVO temp = new TeacherInformationVO();
                BeanUtils.copyProperties(teacher, temp);

                temp.setSatisfaction(df.format(Double.parseDouble(teacher.getSatisfaction())));

                AppointmenttimeExample.Criteria criteria = appoinmenttimeExample.createCriteria();
                criteria.andTeacheridEqualTo(teacher.getTeacherid()).andStarttimeGreaterThanOrEqualTo(date2);
                List<Appointmenttime> appointmenttimeList = appointmenttimeMapper.selectByExample(appoinmenttimeExample);

                temp.setAcademy(department.getDepartmentname());
                temp.setAppointmentTimeList(appointmenttimeList);

                list.add(temp);
                appoinmenttimeExample.clear();
            }
            PageInfo pageInfo = new PageInfo(teachers);
            int total = (int)pageInfo.getTotal();
            return TableModel.success(list, total);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel showCheckedStatus(AuditStatusInfo data) throws AllException {
        Integer studentId = data.getUserId();

        boolean success = data.isSuccess();
        boolean fail = data.isFail();
        boolean checked = data.isCheck();

        if (!success && !fail && !checked) {
            return TableModel.success("成功", 0);
        }

//        try {
            ApplybodyExample applybodyExample = new ApplybodyExample();

            ApplybodyExample.Criteria criteria = applybodyExample.createCriteria();
            ApplybodyExample.Criteria criteria1 = applybodyExample.createCriteria();
            ApplybodyExample.Criteria criteria2 = applybodyExample.createCriteria();

            if (success) {
                criteria.andApplystatusEqualTo(1);
                criteria.andAdminidEqualTo(studentId.toString());
            }
            if (checked) {
                criteria1.andApplystatusEqualTo(0);
                criteria1.andAdminidEqualTo(studentId.toString());
            }
            if (fail) {
                criteria2.andApplystatusEqualTo(-1);
                criteria2.andAdminidEqualTo(studentId.toString());
            }
            applybodyExample.or(criteria1);
            applybodyExample.or(criteria2);

            List<Applybody> applybodyList = applybodyMapper.selectByExample(applybodyExample);

            if (applybodyList.size() == 0) {
                return TableModel.success("成功", 0);
            }

            AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
            List<ShowAppointmentVO> list = new ArrayList<>();
            for (Applybody applybody : applybodyList) {
                ShowAppointmentVO temp = new ShowAppointmentVO();
                BeanUtils.copyProperties(applybody, temp);
                temp.setBeginTime(DateUtils.DatetoStr(applybody.getBegintime()));
                temp.setEndTime(DateUtils.DatetoStr(applybody.getEndtime()));
                temp.setTimeStamp(DateUtils.DatetoStr(applybody.getTimestamp()));

                if (applybody.getApplystatus() == -1) {
                    temp.setApplystatus(3);
                }
                else if (applybody.getApplystatus() == 0) {
                    temp.setApplystatus(1);
                }
                else if (applybody.getApplystatus() == 1) {
                    temp.setApplystatus(2);
                }

                Integer teacherId = applybody.getTeacherid();
                appointmenttimeExample.createCriteria().andOccupyEqualTo(0).andTeacheridEqualTo(teacherId);
                List<Appointmenttime> appointmenttimeList = appointmenttimeMapper.selectByExample(appointmenttimeExample);
                temp.setAppointmentTimeList(appointmenttimeList);

                Admin admin = adminMapper.selectByPrimaryKey(teacherId);

                if (admin.getDuty().equals("教职工")) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
                    BeanUtils.copyProperties(teacher, temp);
                    Department department = departmentMapper.selectByPrimaryKey(teacher.getDepartment1id());

                    temp.setAcademy(department.getDepartmentname());
                }
                else if (admin.getDuty().equals("学生教师")) {
                    Stteacher stteacher = stteacherMapper.selectByPrimaryKey(teacherId);
                    BeanUtils.copyProperties(stteacher, temp);
                    Department department = departmentMapper.selectByPrimaryKey(stteacher.getDepartmentid());
                    temp.setAcademy(department.getDepartmentname());
                    temp.setEmail(admin.getEmail());
                    temp.setPhone(admin.getPhone());
                    temp.setTeachername(admin.getName());
                }

                appointmenttimeExample.clear();
                list.add(temp);
            }

            return TableModel.success(list);
//        }
//        catch (Exception e) {
//            throw new AllException(EmAllException.DATABASE_ERROR);
//        }
    }

    @Override
    public TableModel refusedReason(ShowRefusedReasonInfo data) throws AllException {
        Integer requestId = data.getRequestId();

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(requestId);

            if (applybody == null) {
                return TableModel.error("不存在该预约");
            }
            if (applybody.getApplystatus() != -1) {
                return TableModel.error("输入有误!");
            }
            String reason = applybody.getRefusereason();

            return TableModel.success(reason, 0);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel showAppointmentForTeacher(AuditStatusInfo data) throws AllException {
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

            Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
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
//                Collections.sort(essayList, new Comparator<Essay>() {
//                    @Override
//                    public int compare(Essay o1, Essay o2) {
//                        return (o2.getFinishtime().after(o1.getFinishtime())) ? 1 : -1;
//                    }
//                });
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

                BeanUtils.copyProperties(teacher, temp);

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
    public TableModel getStudentInformation(String userId) throws AllException {
        Integer id = Integer.parseInt(userId);

        try {
            Admin user = adminMapper.selectByPrimaryKey(id);
            if (user == null) {
                return TableModel.error("不存在该用户");
            }

            Department department = departmentMapper.selectByPrimaryKey(user.getDepartmentid());
            Admin admin = adminMapper.selectByPrimaryKey(Integer.parseInt(userId));

            ShowStudentVO studentVO = new ShowStudentVO();

            studentVO.setAcademy(department.getDepartmentname());
            studentVO.setName(user.getName());
            studentVO.setStudentId(user.getAdminid().toString());
            studentVO.setTelephone(user.getPhone());
            studentVO.setEmail(admin.getEmail());

            return TableModel.success(studentVO);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }


    }

    @Override
    public TableModel changeStudentInformation(StudentInformationInfo data) throws AllException {
        String phoneNumber = data.getTelephone();
        Integer userId = data.getUserId();

        try {
            Admin record = adminMapper.selectByPrimaryKey(userId);

            if (!data.getTelephone().isEmpty()) {
                record.setPhone(phoneNumber);
            }
            if (!data.getEmail().isEmpty()) {
                record.setEmail(data.getEmail());
            }
            if (adminMapper.updateByPrimaryKeySelective(record) > 0) {
                return TableModel.success("修改成功!");
            }
            else {
                return TableModel.error("修改失败!");
            }
        }
        catch(Exception e) {
//            throw new AllException(EmAllException.DATABASE_ERROR);
            return TableModel.error("输入有误!");
        }

    }

    @Override
    public TableModel showTeacherPersonalInformation(Integer teacherId) throws AllException {
        try {
            Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);

            TeacherInformationVO teacherInformationVO = new TeacherInformationVO();
            BeanUtils.copyProperties(teacher, teacherInformationVO);

            //控制小数点位数——0.0
            DecimalFormat df = new DecimalFormat("0.0");
            teacherInformationVO.setSatisfaction(df.format(Double.parseDouble(teacher.getSatisfaction())));

            Integer departmentId = teacher.getDepartment1id();

            Department department = departmentMapper.selectByPrimaryKey(departmentId);

            teacherInformationVO.setAcademy(department.getDepartmentname());
            if (teacherInformationVO.getImagesrc().isEmpty()) {
                teacherInformationVO.setImagesrc(defaultUrl);
            }

            return TableModel.success(teacherInformationVO);
        }
        catch (Exception e) {
            return TableModel.error("输入有误!");
        }


    }

    @Override
    public TableModel changeTeacherPersonalInformation(ChangeTeacherInformationInfo data) throws AllException {
        Teacher record = new Teacher();

        BeanUtils.copyProperties(data, record);
        record.setTeacherid(data.getTeacherId());

        try {
            if (teacherMapper.updateByPrimaryKeySelective(record) > 0) {
                Admin admin = new Admin();

                admin.setAdminid(data.getTeacherId());
                admin.setEmail(data.getEmail());
                if (adminMapper.updateByPrimaryKeySelective(admin) > 0) {
                    return TableModel.success("修改成功!");
                }
                else {
                    return TableModel.error("修改失败");
                }
            }
            else {
                return TableModel.error("修改失败!");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel userConfirmsAppointment(ConfirmPaperUploadInfo data) throws AllException {
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

        System.out.println(date2);

        ApplybodyExample applybodyExample2 = new ApplybodyExample();
        applybodyExample2.createCriteria().andAdminidEqualTo(data.getStudentId().toString()).andTeacheridEqualTo(data.getTeacherid()).andApplystatusEqualTo(1).andEndtimeGreaterThanOrEqualTo(date2);


        if (applybodyMapper.countByExample(applybodyExample2) > 0) {
            return TableModel.error("有未完成的预约，无法进行预约");
        }

        Essay record = new Essay();

        BeanUtils.copyProperties(data, record);
        record.setAdminid(data.getStudentId());
        record.setEssayname(data.getEssayname());

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date_now = new Date(System.currentTimeMillis());
        System.out.println(date_now);

        record.setFinishtime(date_now);

//        try {
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andTeacheridEqualTo(data.getTeacherid());
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);

            if (teacherList == null || teacherList.size() == 0) {
                return TableModel.error("不存在该教师");
            }
            Teacher teacher = teacherList.get(0);
            record.setOnlin(teacher.getOnline());

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
    public TableModel teacherSeeAppointmentTime(Integer teacherId) throws AllException {
        List<TeacherNormalTimeVO> list = new ArrayList<>();

        AppointmenttimeExample appoinmenttimeExample = new AppointmenttimeExample();
        appoinmenttimeExample.createCriteria().andTeacheridEqualTo(teacherId);

        try {
            List<Appointmenttime> appoinmenttimes = appointmenttimeMapper.selectByExample(appoinmenttimeExample);

            if (appoinmenttimes.size() == 0) {
                return TableModel.success("暂时还没有设置时间", 0);
            }

            for (Appointmenttime appointmenttime : appoinmenttimes) {
                TeacherNormalTimeVO temp = new TeacherNormalTimeVO();

                BeanUtils.copyProperties(appointmenttime, temp);
                temp.setStartTime(DateUtils.DatetoStr(appointmenttime.getStarttime()));
                temp.setEndTime(DateUtils.DatetoStr(appointmenttime.getEndtime()));

                list.add(temp);
            }

            return TableModel.success(list);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel changeTeacherAppointmentTime(ChangeAppointmentTimeInfo data) throws AllException {
        Integer Id = data.getId();
        Date startTime = DateUtils.strToDate(data.getStartTime());
        Date endTime = DateUtils.strToDate(data.getEndTime());

        if (startTime.after(endTime)) {
            return TableModel.error("开始时间不能晚于结束时间");
        }

        String start = DateUtils.DatetoStr(startTime);
        String end = DateUtils.DatetoStr(endTime);

        String start_time = start.substring(start.indexOf(" ") + 1);
        String end_time = end.substring(end.indexOf(" ") + 1);

        String standard_start = "08:00:00";
        String standard_end = "21:00:00";

        String ss_standard = "";
        String ss_start = "";

        for (int i = 0; i < standard_start.length(); ++i) {
            if (start_time.charAt(i) == ':' && standard_start.charAt(i) == ':') {
                continue;
            }
            ss_standard += standard_start.charAt(i);
            ss_start += start_time.charAt(i);
        }

        Integer compare_start = Integer.parseInt(ss_start);
        Integer compare_standard_start = Integer.parseInt(ss_standard);

        if (compare_start < compare_standard_start) {
            return TableModel.error("开始的时间不能早于早上8点之前");
        }

        String temp_standard_end = "";
        String temp_end_time = "";

        for (int i = 0; i < end_time.length(); ++i) {
            if (end_time.charAt(i) == ':' && standard_end.charAt(i) == ':') {
                continue;
            }

            temp_end_time += end_time.charAt(i);
            temp_standard_end += standard_end.charAt(i);
        }
        Integer compareEnd_time = Integer.parseInt(temp_end_time);
        Integer compareEnd_standard_time = Integer.parseInt(temp_standard_end);

        if (compareEnd_time > compareEnd_standard_time) {
            return TableModel.error("结束时间不能晚于晚上9点");
        }

        try {
            Appointmenttime appointmenttime = appointmenttimeMapper.selectByPrimaryKey(Id);

            if (appointmenttime.getOccupy() != 0) {
                return TableModel.error("该预约已同意，无法修改");
            }

            AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
            appointmenttimeExample.createCriteria().andStarttimeBetween(startTime, endTime).andTeacheridEqualTo(appointmenttime.getTeacherid()).andIdNotEqualTo(Id);

            AppointmenttimeExample.Criteria criteria = appointmenttimeExample.createCriteria();
            criteria.andEndtimeBetween(startTime, endTime).andTeacheridEqualTo(appointmenttime.getTeacherid()).andIdNotEqualTo(Id);

            AppointmenttimeExample.Criteria criteria1 = appointmenttimeExample.createCriteria();
            criteria1.andStarttimeLessThanOrEqualTo(startTime).andEndtimeGreaterThanOrEqualTo(endTime).andTeacheridEqualTo(appointmenttime.getTeacherid()).andIdNotEqualTo(Id);

            if (appointmenttimeMapper.countByExample(appointmenttimeExample) != 0) {
                return TableModel.error("修改后的时间冲突，无法设置此时间");
            }

            appointmenttimeExample.or(criteria);
            appointmenttimeExample.or(criteria1);

            Appointmenttime record = new Appointmenttime();
            record.setId(Id);
            record.setStarttime(startTime);
            record.setEndtime(endTime);

            if (appointmenttimeMapper.updateByPrimaryKeySelective(record) == 1) {
                return TableModel.success("修改成功");
            }
            else {
                return TableModel.error("修改失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel addTeacherAppointmentTime(AddAppointmentTimeInfo data) throws AllException {
        Date startTime = DateUtils.strToDate(data.getStartTime());
        Date endTime = DateUtils.strToDate(data.getEndTime());

        //还差设置不能设置过去的时间
        //因为debug，所以这个限制先不写会比较好

        if (startTime.after(endTime)) {
            return TableModel.error("开始时间不能晚于结束时间!");
        }

        String start = DateUtils.DatetoStr(startTime);
        String end = DateUtils.DatetoStr(endTime);

        String start_time = start.substring(start.indexOf(" ") + 1);
        String end_time = end.substring(end.indexOf(" ") + 1);

        String standard_start = "08:00:00";
        String standard_end = "21:00:00";

        String ss_standard = "";
        String ss_start = "";

        for (int i = 0; i < standard_start.length(); ++i) {
            if (start_time.charAt(i) == ':' && standard_start.charAt(i) == ':') {
                continue;
            }
            ss_standard += standard_start.charAt(i);
            ss_start += start_time.charAt(i);
        }

        Integer compare_start = Integer.parseInt(ss_start);
        Integer compare_standard_start = Integer.parseInt(ss_standard);

        if (compare_start < compare_standard_start) {
            return TableModel.error("开始的时间不能早于早上8点之前");
        }

        String temp_standard_end = "";
        String temp_end_time = "";

        for (int i = 0; i < end_time.length(); ++i) {
            if (end_time.charAt(i) == ':' && standard_end.charAt(i) == ':') {
                continue;
            }

            temp_end_time += end_time.charAt(i);
            temp_standard_end += standard_end.charAt(i);
        }
        Integer compareEnd_time = Integer.parseInt(temp_end_time);
        Integer compareEnd_standard_time = Integer.parseInt(temp_standard_end);

        if (compareEnd_time > compareEnd_standard_time) {
            return TableModel.error("结束时间不能晚于晚上9点");
        }

        AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
        appointmenttimeExample.createCriteria().andStarttimeBetween(startTime, endTime).andTeacheridEqualTo(data.getTeacherId());

        AppointmenttimeExample.Criteria criteria = appointmenttimeExample.createCriteria();
        criteria.andEndtimeBetween(startTime, endTime).andTeacheridEqualTo(data.getTeacherId());

        AppointmenttimeExample.Criteria criteria1 = appointmenttimeExample.createCriteria();
        criteria1.andStarttimeLessThanOrEqualTo(startTime).andEndtimeGreaterThanOrEqualTo(endTime).andTeacheridEqualTo(data.getTeacherId());

        appointmenttimeExample.or(criteria);
        appointmenttimeExample.or(criteria1);

        if (appointmenttimeMapper.countByExample(appointmenttimeExample) != 0) {
            return TableModel.error("设置时间冲突，无法设置此时间");
        }

        Appointmenttime record = new Appointmenttime();
        record.setTeacherid(data.getTeacherId());
        record.setStarttime(startTime);
        record.setEndtime(endTime);
        try {
            if (appointmenttimeMapper.insertSelective(record) > 0) {
                return TableModel.success("增加成功");
            }
            else {
                return TableModel.error("增加失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }

    }

    @Override
    public TableModel deleteTeacherAppointmentTime(DeleteAppointmentTimeInfo data) throws AllException {
        Integer Id = data.getId();

        try {
            Appointmenttime appointmenttime = appointmenttimeMapper.selectByPrimaryKey(Id);
            if (appointmenttime.getOccupy() != 0) {
                return TableModel.error("该预约时间无法删除");
            }

            if (appointmenttimeMapper.deleteByPrimaryKey(Id) == 1) {
                return TableModel.success("删除成功");
            } else {
                return TableModel.error("删除失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel studentQuestion(StudentQuestionInfo data) throws AllException {
        QuestionsLoadingVO questionsLoadingVO = new QuestionsLoadingVO();
        questionsLoadingVO.setRequestId(data.getRequestId());

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(data.getRequestId());
            Integer teacherId = applybody.getTeacherid();
            questionsLoadingVO.setStartTime(DateUtils.DatetoStr(applybody.getBegintime()));
            questionsLoadingVO.setEndTime(DateUtils.DatetoStr(applybody.getEndtime()));

            Admin user = adminMapper.selectByPrimaryKey(teacherId);

            if (user.getDuty().equals("教职工")) {
                Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
                questionsLoadingVO.setHelpintention(teacher.getHelpintention());

                if (data.getIdentity() == 0) {                  //此订单中，此用户是被辅导者
                    questionsLoadingVO.setPerson_name(teacher.getTeachername());

                    return TableModel.success(questionsLoadingVO);
                }
                else if (data.getIdentity() == 1) {             //该订单中，此用户是辅导者
                    String studentId = applybody.getAdminid();

                    Admin student = adminMapper.selectByPrimaryKey(Integer.parseInt(studentId));
                    questionsLoadingVO.setPerson_name(student.getName());

                    return TableModel.success(questionsLoadingVO);
                }
            }
            else if (user.getDuty().equals("学生教师")) {
                Stteacher stteacher = stteacherMapper.selectByPrimaryKey(teacherId);
                questionsLoadingVO.setHelpintention(stteacher.getHelpintention());

                if (data.getIdentity() == 0) {                  //此订单中，该用户是被辅导的人
                    questionsLoadingVO.setPerson_name(stteacher.getStteachername());

                    return TableModel.success(questionsLoadingVO);
                }
                else if (data.getIdentity() == 1) {             //此订单中，该用户是辅导者
                    Integer studentId = Integer.parseInt(applybody.getAdminid());

                    Admin student = adminMapper.selectByPrimaryKey(studentId);
                    questionsLoadingVO.setPerson_name(student.getName());

                    return TableModel.success(questionsLoadingVO);
                }
            }
            else {
                return TableModel.error("管理员设置有误");
            }

            return TableModel.error("error");
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel studentFill(StudentFillQuestionInfo data) throws AllException {
        Studentq record = new Studentq();

        Applybody applybody = applybodyMapper.selectByPrimaryKey(data.getRequestId());

        record.setOntime(data.getOnTime());
        record.setTeachermark(data.getTeacherMark());
        record.setMsgmark(data.getMsgMark());
        record.setAdvice(data.getAdvice());
        record.setId(data.getId());
        record.setRequestid(data.getRequestId());
        record.setStudentid(Integer.parseInt(applybody.getAdminid()));
        record.setFinish(1);

        try {
            if (studentqMapper.updateByPrimaryKeySelective(record) == 1) {
                //更新教师评分
                Integer teacherId = applybody.getTeacherid();

                Admin teacher_admin = adminMapper.selectByPrimaryKey(teacherId);

                if (teacher_admin.getDuty().equals("教职工")) {
                    Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
                    Double mark = 0.0;

                    mark += Double.parseDouble(teacher.getSatisfaction()) * (teacher.getOrdernumber() - 1);
                    mark = (mark + data.getTeacherMark()) / teacher.getOrdernumber();

                    Teacher record_teacher = new Teacher();
                    record_teacher.setTeacherid(teacherId);
                    record_teacher.setSatisfaction(mark.toString());
                    teacherMapper.updateByPrimaryKeySelective(record_teacher);
                }
                else if (teacher_admin.getDuty().equals("学生教师")) {
                    Stteacher stteacher = stteacherMapper.selectByPrimaryKey(teacherId);
                    Double mark = 0.0;

                    mark += Double.parseDouble(stteacher.getSatisfaction()) * (stteacher.getOrdernumber() - 1);
                    mark = (mark + data.getTeacherMark()) / stteacher.getOrdernumber();

                    Stteacher record_stteacher = new Stteacher();
                    record_stteacher.setStteacherid(teacherId);
                    record_stteacher.setSatisfaction(mark.toString());
                    stteacherMapper.updateByPrimaryKeySelective(record_stteacher);
                }
                else {
                    return TableModel.error("出错");
                }

                return TableModel.success("填写成功");
            }
            else {
                return TableModel.error("填写失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel teacherFill(TeacherFillQuestionInfo data) throws AllException {
        Teacherq record = new Teacherq();

        record.setId(data.getId());
        record.setAbsent(data.getAbsent());
        record.setStudentmark(data.getStudentMark());
        record.setAdvice(data.getAdvice());
        record.setFinish(1);
        record.setRequsetid(data.getRequestId());

        try {
            Applybody applybody = applybodyMapper.selectByPrimaryKey(data.getRequestId());
            record.setTeacherid(applybody.getTeacherid());
            if (teacherqMapper.updateByPrimaryKeySelective(record) == 1) {
                //更新失信人员
                if (data.getAbsent() == 1) {
                    Integer userId = Integer.parseInt(applybody.getAdminid());
                    BrokenpersonExample brokenpersonExample = new BrokenpersonExample();

                    brokenpersonExample.createCriteria().andUseridEqualTo(userId);
                    List<Brokenperson> brokenpersonList = brokenpersonMapper.selectByExample(brokenpersonExample);
                    if (brokenpersonList.size() == 1) {
                        Brokenperson brokenperson = brokenpersonList.get(0);

                        brokenperson.setReason("该用户没有参加预约的辅导");
                        brokenperson.setTime(brokenperson.getTime() + 1);
                        brokenpersonMapper.updateByExampleSelective(brokenperson, brokenpersonExample);
                    }
                    else if (brokenpersonList.size() == 0) {
                        //此用户之前是没有失信记录，现在要创建失信记录
                        Brokenperson brokenperson = new Brokenperson();

                        Admin admin = adminMapper.selectByPrimaryKey(userId);
                        brokenperson.setUserid(userId);
                        brokenperson.setName(admin.getName());
                        brokenperson.setReason("该用户没有参加预约的辅导");
                        brokenperson.setTime(1);

                        brokenpersonMapper.insertSelective(brokenperson);
                    }
                    else {
                        return TableModel.error("系统出错");
                    }
                }
                return TableModel.success("填写成功");
            }
            else {
                return TableModel.error("填写失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel pictureNews() throws AllException {
        NewsExample newsExample = new NewsExample();
        newsExample.createCriteria().andHavepictureEqualTo(1);

        try {
            List<News> newsList = newsMapper.selectByExample(newsExample);
            if (newsList.size() == 0) {
                return TableModel.success("暂无有图片的新闻", 0);
            }
            newsList.sort(((o1, o2) -> o2.getNewstime().after(o1.getNewstime()) ? 1 : -1));

            Integer newsId = 0;
            FileExample fileExample = new FileExample();
            List<ShowPictureNewsVO> list = new ArrayList<>();
            int i = 0;
            for (News news : newsList) {
                if (i >= 5) {
                    break;
                }
                ShowPictureNewsVO temp = new ShowPictureNewsVO();

                newsId = news.getNewsid();
                fileExample.createCriteria().andNewsidEqualTo(newsId);
                File file = fileMapper.selectByExample(fileExample).get(0);

                temp.setNewId(newsId);
                temp.setNewsname(news.getNewsname());
                temp.setPicturesrc(file.getFilesrc());

                list.add(temp);
                fileExample.clear();
                ++i;
            }

            return TableModel.success(list);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel showNews() throws AllException {
        NewsExample newsExample = new NewsExample();
        newsExample.createCriteria().andHavepictureEqualTo(1);

//        try {
            List<News> newsList = newsMapper.selectByExample(newsExample);
            if (newsList.size() == 0) {
                return TableModel.success("暂无新闻");
            }
            newsList.sort(((o1, o2) -> (o2.getNewstime().after(o1.getNewstime()) ? 1 : -1)));

            FileExample fileExample = new FileExample();

            int i = 0;
            List<ShowNewsWithoutPicturesVO> list = new ArrayList<>();
            for (News news : newsList) {
                if (i > 2) {
                    break;
                }
                ShowNewsWithoutPicturesVO temp = new ShowNewsWithoutPicturesVO();

                fileExample.createCriteria().andNewsidEqualTo(news.getNewsid());
                File file = fileMapper.selectByExample(fileExample).get(0);

                temp.setNewsurl(file.getFilesrc());
                temp.setNewsId(news.getNewsid());
                temp.setNewsname(news.getNewsname());
                temp.setNewstype(news.getNewstype());
                temp.setNewstime(DateUtils.DatetoStr(news.getNewstime()));

                fileExample.clear();
                list.add(temp);
                ++i;
            }

            return TableModel.success(list);
//        }
//        catch (Exception e) {
//            throw new AllException(EmAllException.DATABASE_ERROR);
//        }
    }

    @Override
    public TableModel showNewsPage(Integer cur) throws AllException {
        NewsExample newsExample = new NewsExample();
        newsExample.createCriteria().andNewsidIsNotNull();

        try {
            Integer total = newsMapper.countByExample(newsExample);

            //DESC是降序，ASC是升序
            newsExample.setOrderByClause("`newstime` DESC");
            PageHelper.startPage(cur, 10);
            List<News> newsList = newsMapper.selectByExample(newsExample);

            int i = 1;
            List<NewsVO> newsVOList = new ArrayList<>();
            for (News news : newsList) {
                NewsVO temp = new NewsVO();

                BeanUtils.copyProperties(news, temp);
                temp.setNewsTime(DateUtils.DatetoStr(news.getNewstime()));
                temp.setId(i);

                ++i;
                newsVOList.add(temp);
            }
            return TableModel.success(newsVOList, total);
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel showTeachersInCampus(ShowTeachersInCampusInfo data) throws AllException {
        Integer page = data.getPage();
        String campus = data.getCampus();

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date2 = new Date(System.currentTimeMillis());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date2);
        calendar.add(Calendar.DATE, 1);
        date2 = calendar.getTime();

        TeacherExample teacherExample = new TeacherExample();
        if (campus.equals("全部")) {
            teacherExample.createCriteria().andCampusIsNotNull();
        }
        else {
            teacherExample.createCriteria().andCampusEqualTo(campus);
        }

        PageHelper.startPage(page, 12);
        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
        if (teacherList.size() == 0) {
            return TableModel.success("暂时没有教师", 0);
        }

        DecimalFormat df = new DecimalFormat("0.0");

        List<TeacherInformationVO> list = new ArrayList<>();

        AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
        for (Teacher teacher : teacherList) {
            TeacherInformationVO temp = new TeacherInformationVO();

            BeanUtils.copyProperties(teacher, temp);
            temp.setSatisfaction(df.format(Double.parseDouble(teacher.getSatisfaction())));

            appointmenttimeExample.createCriteria().andTeacheridEqualTo(teacher.getTeacherid()).andStarttimeGreaterThanOrEqualTo(date2);
            List<Appointmenttime> appointmenttimes = appointmenttimeMapper.selectByExample(appointmenttimeExample);
            temp.setAppointmentTimeList(appointmenttimes);

            Department department = departmentMapper.selectByPrimaryKey(teacher.getDepartment1id());
            temp.setAcademy(department.getDepartmentname());

            list.add(temp);
            appointmenttimeExample.clear();
        }

        PageInfo pageInfo = new PageInfo(teacherList);
        int total = (int)pageInfo.getTotal();

        return TableModel.success(list, total);
    }

    @Override
    public TableModel loadQuestionsForUser(Integer userId) throws AllException {
        Admin admin = adminMapper.selectByPrimaryKey(userId);

        String duty = admin.getDuty();

        ApplybodyExample applybodyExample = new ApplybodyExample();
        TeacherqExample teacherqExample = new TeacherqExample();
        List<Integer> requestId_list = new ArrayList<>();    //待填写问卷的订单号
        List<QuestionIdAndRequestIdVO> list = new ArrayList<>();
        List<QuestionIdAndRequestIdVO> educatedList = new ArrayList<>();    //作为被辅导者时的问卷

        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
        Date date = new Date(System.currentTimeMillis());

        ShowNotFinishedQuestionsVO showNotFinishedQuestionsVO = new ShowNotFinishedQuestionsVO();

        //作为辅导者时，是否有问卷
        applybodyExample.createCriteria().andTeacheridEqualTo(userId).andApplystatusEqualTo(1).andEndtimeLessThanOrEqualTo(date);
        List<Applybody> applybodyList = applybodyMapper.selectByExample(applybodyExample);

        if (applybodyList.size() != 0) {
            for (Applybody applybody : applybodyList) {
                requestId_list.add(applybody.getRequestid());
            }
            teacherqExample.createCriteria().andRequsetidIn(requestId_list).andFinishEqualTo(0);
            List<Teacherq> teacherqs = teacherqMapper.selectByExample(teacherqExample);

            if (teacherqs.size() != 0) {
                for (Teacherq teacherq : teacherqs) {
                    QuestionIdAndRequestIdVO temp = new QuestionIdAndRequestIdVO();

                    temp.setQuestionId(teacherq.getId());
                    temp.setRequestId(teacherq.getRequsetid());
                    temp.setIdentity(1);
                    list.add(temp);
                }
                showNotFinishedQuestionsVO.setList(list);
            }
        }

        //该用户作为被辅导者时，所要填写的问卷
        ApplybodyExample applybodyExample1 = new ApplybodyExample();
        applybodyExample1.createCriteria().andAdminidEqualTo(userId.toString()).andApplystatusEqualTo(1).andEndtimeLessThanOrEqualTo(date);
        List<Applybody> applybodyList1= applybodyMapper.selectByExample(applybodyExample1);

        if (applybodyList1.size() != 0) {
            for (Applybody applybody : applybodyList1) {
                requestId_list.add(applybody.getRequestid());
            }
            StudentqExample studentqExample = new StudentqExample();
            studentqExample.createCriteria().andRequestidIn(requestId_list).andFinishEqualTo(0);
            List<Studentq> studentqs = studentqMapper.selectByExample(studentqExample);

            if (studentqs.size() != 0) {
                for (Studentq studentq : studentqs) {
                    QuestionIdAndRequestIdVO temp = new QuestionIdAndRequestIdVO();

                    temp.setRequestId(studentq.getRequestid());
                    temp.setQuestionId(studentq.getId());
                    temp.setIdentity(0);

                    educatedList.add(temp);
                }
                showNotFinishedQuestionsVO.setEducatedList(educatedList);
            }
        }

//        if (flag == 1) {
//            applybodyExample.createCriteria().andTeacheridEqualTo(userId).andApplystatusEqualTo(1).andEndtimeLessThanOrEqualTo(date);
//            List<Applybody> applybodyList = applybodyMapper.selectByExample(applybodyExample);
//
//            if (applybodyList.size() == 0) {
//                return TableModel.success("暂无问卷");
//            }
//
//            for (Applybody applybody : applybodyList) {
//                Integer requestId = applybody.getRequestid();
//                requestId_list.add(requestId);
//            }
//            teacherqExample.createCriteria().andRequsetidIn(requestId_list).andFinishEqualTo(0);
//            List<Teacherq> teacherqs = teacherqMapper.selectByExample(teacherqExample);
//
//            if (teacherqs.size() == 0) {
//                return TableModel.success("暂无问卷");
//            }
//            for (Teacherq teacherq : teacherqs) {
//                QuestionIdAndRequestIdVO temp = new QuestionIdAndRequestIdVO();
//
//                temp.setQuestionId(teacherq.getId());
//                temp.setRequestId(teacherq.getRequsetid());
//                list.add(temp);
//            }
//            showNotFinishedQuestionsVO.setList(list);
//        }
//        else if (flag == 0) {
//            applybodyExample.createCriteria().andAdminidEqualTo(userId.toString()).andApplystatusEqualTo(1).andEndtimeLessThanOrEqualTo(date);
//            List<Applybody> applybodyList = applybodyMapper.selectByExample(applybodyExample);
//
//            if (applybodyList.size() == 0) {
//                return TableModel.success("暂无问卷");
//            }
//
//            for (Applybody applybody : applybodyList) {
//                Integer requestId = applybody.getRequestid();
//                requestId_list.add(requestId);
//            }
//            StudentqExample studentqExample = new StudentqExample();
//            studentqExample.createCriteria().andRequestidIn(requestId_list).andFinishEqualTo(0);
//            List<Studentq> studentqs = studentqMapper.selectByExample(studentqExample);
//
//            if (studentqs.size() == 0) {
//                return TableModel.success("暂无问卷");
//            }
//            for (Studentq studentq : studentqs) {
//                QuestionIdAndRequestIdVO temp = new QuestionIdAndRequestIdVO();
//
//                temp.setRequestId(studentq.getRequestid());
//                temp.setQuestionId(studentq.getId());
//
//                list.add(temp);
//            }
//            showNotFinishedQuestionsVO.setList(list);
//        }

        showNotFinishedQuestionsVO.setDuty(duty);

        return TableModel.success(showNotFinishedQuestionsVO);
    }

    @Override
    public TableModel modifyTeacherImage(ModifyImageInfo data) throws AllException {
        Integer teacherId = data.getTeacherId();
        String src = data.getSrc();

        Teacher record = new Teacher();
        record.setTeacherid(teacherId);
        record.setImagesrc(src);

        if (teacherMapper.updateByPrimaryKeySelective(record) == 1) {
            return TableModel.success("修改成功");
        }
        else {
            return TableModel.error("修改失败");
        }
    }

    @Override
    public TableModel sendSsmCode(String name, HttpServletRequest httpServletRequest) throws AllException {

        TableModel tableModel=new TableModel();

        try {
            //查询用户邮箱
            Admin admin = adminMapper.selectByPrimaryKey(Integer.parseInt(name));
            if (StringUtils.isNullOrEmpty(admin.getEmail()))
            {
               tableModel.setCode(500);
                return tableModel;
            }

            String emailAddress=admin.getEmail();
            if (!emailAddress.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$"))
            {

                tableModel.setCode(500);
                return tableModel;
            }

            SmsCodePojo smsCode = SmsCodeProvider.createSmsCode();
            httpServletRequest.getSession().setAttribute(name,smsCode);

            //发送验证码
            SsmSendTool.SendCheckCode(emailAddress,smsCode.getSmsCode());

            tableModel.setCode(200);
            return tableModel;

        }catch (Exception e)
        {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel checkMsgCode(String name, HttpServletRequest httpServletRequest, String msgCode) {
        TableModel tableModel=new TableModel();
        //获取真正验证码
        SmsCodePojo smsCodePojo= (SmsCodePojo) httpServletRequest.getSession().getAttribute(name);
        String trueCode = smsCodePojo.getSmsCode();
        Date ssmDate=smsCodePojo.getSendDate();

        if (msgCode.trim().equals(trueCode))
        {
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(ssmDate);
            calendar.add(Calendar.MINUTE,10);
            Date time = calendar.getTime();

            if (time.after(new Date()))
            {
                tableModel.setCode(200);
                tableModel.setMsg("验证码正确");
                httpServletRequest.getSession().removeAttribute(name);
            }else
            {
                tableModel.setCode(500);
                tableModel.setMsg("验证码已经过期");
            }
        }else
        {
            tableModel.setMsg("验证码不正确或为空");
            tableModel.setCode(500);
        }
        return tableModel;
    }

    @Override
    public TableModel studentFillStteacherQ(StudentFillQuestionInfo data) throws AllException {
        Studentq record = new Studentq();

        Applybody applybody = applybodyMapper.selectByPrimaryKey(data.getRequestId());

        record.setOntime(data.getOnTime());
        record.setTeachermark(data.getTeacherMark());
        record.setMsgmark(data.getMsgMark());
        record.setAdvice(data.getAdvice());
        record.setId(data.getId());
        record.setRequestid(data.getRequestId());
        record.setStudentid(Integer.parseInt(applybody.getAdminid()));
        record.setFinish(1);

        try {
            if (studentqMapper.updateByPrimaryKeySelective(record) == 1) {
                //更新教师评分
                Integer teacherId = applybody.getTeacherid();
                Stteacher stteacher = stteacherMapper.selectByPrimaryKey(teacherId);
                Double mark = 0.0;

                mark += Double.parseDouble(stteacher.getSatisfaction()) * (stteacher.getOrdernumber() - 1);
                mark = (mark + data.getTeacherMark()) / stteacher.getOrdernumber();

                Stteacher record_teacher = new Stteacher();
                record_teacher.setStteacherid(teacherId);
                record_teacher.setSatisfaction(mark.toString());
                stteacherMapper.updateByPrimaryKeySelective(record_teacher);

                return TableModel.success("填写成功");
            }
            else {
                return TableModel.error("填写失败");
            }
        }
        catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }

    @Override
    public TableModel getUserEmailAndPhone(Integer userId) throws AllException {
        Admin user = adminMapper.selectByPrimaryKey(userId);

        if (user == null) {
            return TableModel.error("不存在该账户");
        }

        ShowUserEmailAndPhoneVO showUserEmailAndPhoneVO = new ShowUserEmailAndPhoneVO();
        showUserEmailAndPhoneVO.setEmail(user.getEmail());
        showUserEmailAndPhoneVO.setPhone(user.getPhone());

        return TableModel.success(showUserEmailAndPhoneVO);
    }
}
