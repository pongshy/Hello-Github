package com.shu.labrary.controller;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.service.surface.AppointmentsService;
import com.shu.labrary.service.surface.Teacherservice;
import com.shu.labrary.service.surface.UserService;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 教师页面接口
 * @Author: pongshy
 * @Date: 2020-1-13
 */
@CrossOrigin
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private Teacherservice teacherservice;

    @Autowired
    private UserService userService;


    /**
     * @Description: 首页显示明星教师
     * @Param: []
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-4
     */
    @GetMapping("showTeachers")
    @ResponseBody
    public TableModel showAllTeachers() throws AllException {

        return teacherservice.showInformation();
    }

    /**
     * @Description: 教师页面——教师同意预约
     * @Param: [AgreeAppointmentInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    @RequestMapping("agreeAppointment")
    @ResponseBody
    public TableModel agreeAppointment(@Validated @RequestBody AgreeAppointmentInfo data) throws AllException {

        return teacherservice.agreeAppointment(data);
    }

    /**
     * @Description: 教师页面——教师拒绝预约
     * @Param: [RefuseAppointmentInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    @RequestMapping("refuseAppointment")
    @ResponseBody
    public TableModel refuseAppointment(@Validated @RequestBody RefuseAppointmentInfo data) throws AllException {

        return teacherservice.refuseAppointment(data);
    }




    /**
     * @Description: 显示小老师个人信息
     * @Param: [userId]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    @GetMapping("showPersonalInformation")
    @ResponseBody
    public TableModel showPersonalInformation(@RequestParam(value = "userId", defaultValue = "1") Integer userId) throws AllException {
        if (userId == 1) {
            return TableModel.error("显示失败");
        }

        return teacherservice.showPersonalStteacher(userId);
    }

    /**
     * @Description: 修改小老师个人信息
     * @Param: [ChangeStTeacherInformation]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    @PostMapping("changeStTeacherPersonal")
    @ResponseBody
    public TableModel changeStTeacherPersonal(@Validated @RequestBody ChangeStTeacherInformationInfo data) throws AllException {

        return teacherservice.changeStteacherInfor(data);
    }

    /**
     * @Description: 小老师同意预约
     * @Param: [AgreeAppointmentInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    @RequestMapping("stTeacherAgreeAppointment")
    @ResponseBody
    public TableModel stTeacherAgreeAppointment(@Validated @RequestBody AgreeAppointmentInfo data) throws AllException {

        return teacherservice.stteacherAgreeAppointment(data);
    }

    /**
     * @Description: 小老师查看自己被预约的状况
     * @Param: [AudiStatusInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    @RequestMapping("showAppointmentForstteacher")
    @ResponseBody
    public TableModel showAppointmentForstteacher(@Validated @RequestBody AuditStatusInfo data) throws AllException {

        return teacherservice.stteacherSeeAppointment(data);
    }



    /**
     * @Description: 小老师修改个人头像
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    @RequestMapping("changeStteacherImage")
    @ResponseBody
    public TableModel changeStteacherImage(@Validated @RequestBody ModifyImageInfo data) throws AllException {

        return teacherservice.changeImageForStteacher(data);
    }






}
