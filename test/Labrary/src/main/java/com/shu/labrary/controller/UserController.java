package com.shu.labrary.controller;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.pojo.response.TeacherSeeAppointmentVO;
import com.shu.labrary.service.surface.Teacherservice;
import com.shu.labrary.service.surface.UserService;
import com.shu.labrary.tools.TableModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.security.Principal;

/**
 * @Description: 用户页面接口
 * @Author: pongshy
 * @Date: 2020-1-27
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Teacherservice teacherservice;

    /**
     * @Description: 登录时，发送邮箱和手机号给前端
     * @Param: [userId]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-13
     */
    @GetMapping("getEmailAndPhone")
    @ResponseBody
    public TableModel getEmailAndPhone(@RequestParam(value = "userId", defaultValue = "1") Integer userId) throws AllException {
        if (userId == 1) {
            return TableModel.error("传输的用户账号为空");
        }

        return userService.getUserEmailAndPhone(userId);
    }


    /**
     * @Description: 小老师预约页面，根据姓名返回教师信息
     * @Param: [NameInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    @RequestMapping("loadStudentTeacherName")
    @ResponseBody
    public TableModel loadStudentTeacher(@Validated @RequestBody NameInfo data) throws AllException {

        return teacherservice.loadStudentTeacherMsg(data);
    }

    /**
     * @Description: 小老师预约页面，选择学院、校区，显示相应教师信息
     * @Param: [ShowTeacherMsgInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    @RequestMapping("loadDataAcademyStt")
    @ResponseBody
    public TableModel loadDataAcademyStt(@Validated @RequestBody ShowTeacherMsgInfo data) throws AllException {

        return teacherservice.loadDataAcademy(data);
    }

    /**
     * @Description: 小老师预约页面，选择校区，同时给出页码，显示默认为所有学院的老师
     * @Param: [ShowTeachersInCampusInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    @RequestMapping("loadDataCampusStt")
    @ResponseBody
    public TableModel loadDataCampusStt(@Validated @RequestBody ShowTeachersInCampusInfo data) throws AllException {

        return teacherservice.loadDataCampus(data);
    }

    /**
     * @Description: 根据姓名返回对应教师信息
     * @Param: [NameInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-27
     */
    @RequestMapping(value = "loadDataName")
    @ResponseBody
    public TableModel loadDataName(@Validated @RequestBody NameInfo data) throws AllException {
        if (data.getName() == null) {
            return TableModel.error("请输入姓名");
        }

        return userService.getInforFromName(data);
    }

    /**
     * @Description: 用户选择学院、校区，显示相应教师信息
     * @Param: [ShowTeacherMsgInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-30
     */
    @RequestMapping(value = "loadDataAcademy", method = RequestMethod.POST)
    @ResponseBody
    public TableModel loadDataAcademy(@RequestBody @Validated ShowTeacherMsgInfo data) throws AllException {
        if (data.getCampsuList().isEmpty() || data.getAcademy().isEmpty()) {
            return TableModel.success("输入内容不能为空", 0);
        }

        return userService.showTeacherMsg(data);
    }

    /**
     * @Description: 用户选择校区，同时给出页码，显示默认为所有学院的老师
     * @Param: [ShowTeachersInCampusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    @RequestMapping(value = "loadDataCampus")
    @ResponseBody
    public TableModel loadDataCampus(@RequestBody @Validated ShowTeachersInCampusInfo data) throws AllException {

        return userService.showTeachersInCampus(data);
    }

    /**
     * @Description: 用户上传学生信息，论文地址及教师Id给后端
     * @Param: [ConfirmPaperUpload]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping("userConfirmsAppointment")
    @ResponseBody
    public TableModel userConfirmsAppointment(@Validated @RequestBody ConfirmPaperUploadInfo data) throws AllException {

        return userService.userConfirmsAppointment(data);
    }

    /**
     * @Description: 用户预约小老师
     * @Param: [ConfirmPaperUploadInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    @RequestMapping("userAppointStteacher")
    @ResponseBody
    public TableModel userAppointStteacher(@Validated @RequestBody ConfirmPaperUploadInfo data) throws AllException {

        return teacherservice.userConfirmStteacher(data);
    }

    /**
     * @Description: 用户选择查看预约状况——审核，成功，拒绝
     * @Param: [AuditStatusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping(value = "userCheckStatus", method = RequestMethod.POST)
    @ResponseBody
    public TableModel showCheckedInformation(@Validated @RequestBody AuditStatusInfo data) throws AllException {

        return userService.showCheckedStatus(data);
    }

    /**
     * @Description: 用户查看被拒绝的具体原因
     * @Param: [ShowRefusedReasonInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping(value = "showRefusedReason")
    @ResponseBody
    public TableModel showRefusedReason(@Validated @RequestBody ShowRefusedReasonInfo data) throws AllException {

        return userService.refusedReason(data);
    }

    /**
     * @Description: 老师查看预约情况
     * @Param: [AuditStatusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping("showAppointmentForTeacher")
    @ResponseBody
    public TableModel showAppointmentForTeacher(@Validated @RequestBody AuditStatusInfo data) throws AllException {

        return userService.showAppointmentForTeacher(data);
    }

    /**
     * @Description: 显示学生个人信息
     * @Param: [userId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @GetMapping("getStudentInformation")
    @ResponseBody
    public TableModel showStudentInformation(@RequestParam(value = "userId") @NotBlank(message = "userId不能为空") String userId) throws AllException {

        return userService.getStudentInformation(userId);
    }

    /**
     * @Description: 修改学生个人信息
     * @Param: [StudnetInformationInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping("changeStudentInformation")
    @ResponseBody
    public TableModel changeStudentInformation(@Validated @RequestBody StudentInformationInfo data) throws AllException {

        return userService.changeStudentInformation(data);
    }

    /**
     * @Description: 显示教师个人信息
     * @Param: [teacherId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @GetMapping("showTeacherPersonal")
    @ResponseBody
    public TableModel showTeacherInformation(@RequestParam(value = "teacherId") @NotNull(message = "teacherId不能为空") Integer teacherId) throws AllException {

        return userService.showTeacherPersonalInformation(teacherId);
    }

    /**
     * @Description: 教师修改个人头像
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-22
     */
    @RequestMapping("changeImage")
    @ResponseBody
    public TableModel changeImage(@RequestBody @Validated ModifyImageInfo data) throws AllException {
        if (data.getSrc().isEmpty()) {
            return TableModel.error("头像地址为空");
        }

        return userService.modifyTeacherImage(data);
    }

    /**
     * @Description: 修改教师个人信息
     * @Param: [ChangeTeacherInformationInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    @RequestMapping("changeTeacherPersonal")
    @ResponseBody
    public TableModel changeTeacherPersonalInformation(@Validated @RequestBody ChangeTeacherInformationInfo data) throws AllException {

        return userService.changeTeacherPersonalInformation(data);
    }

    /**
     * @Description: 教师查看自己的预约时间
     * @Param: [teacherId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    @GetMapping("seeAppointmentTime")
    @ResponseBody
    public TableModel seeTeacherAppointmentTime(@RequestParam(value = "teacherId") @NotNull(message = "教师Id不能为空") Integer teacherId) throws AllException {

        return userService.teacherSeeAppointmentTime(teacherId);
    }

    /**
     * @Description: 教师修改预约时间
     * @Param: [ChangeAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    @RequestMapping("changeAppointmentTime")
    @ResponseBody
    public TableModel changeAppointmentTime(@Validated @RequestBody ChangeAppointmentTimeInfo data) throws AllException {

        return userService.changeTeacherAppointmentTime(data);
    }

    /**
     * @Description: 教师增加预约时间
     * @Param: [AddAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-5
     */
    @RequestMapping("addAppointmentTime")
    @ResponseBody
    public TableModel addAppointmentTime(@Validated @RequestBody AddAppointmentTimeInfo data) throws AllException {

        return userService.addTeacherAppointmentTime(data);
    }

    /**
     * @Description: 教师删除预约时间
     * @Param: [DeleteAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-5
     */
    @RequestMapping("deleteAppointmentTime")
    @ResponseBody
    public TableModel deleteAppointmentTime(@Validated @RequestBody DeleteAppointmentTimeInfo data) throws AllException {

        return userService.deleteTeacherAppointmentTime(data);
    }

    /**
     * @Description: 问卷加载
     * @Param: [StudentQuestionInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    @RequestMapping("questionLoading")
    @ResponseBody
    public TableModel studentQuestion(@Validated @RequestBody StudentQuestionInfo data) throws AllException {

        return userService.studentQuestion(data);
    }


    /**
     * @Description: 学生问卷填写
     * @Param: [StudentFillQuestionInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    @RequestMapping("studentFillTheQuestion")
    @ResponseBody
    public TableModel studentFillTheQuestion(@Validated @RequestBody StudentFillQuestionInfo data) throws AllException {

        return userService.studentFill(data);
    }

    /**
     * @Description: 教师填写问卷
     * @Param: [TeacherFillQuestion]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    @RequestMapping("teacherFillTheQuestion")
    @ResponseBody
    public TableModel teacherFillTheQuestion(@Validated @RequestBody TeacherFillQuestionInfo data) throws AllException {

        return userService.teacherFill(data);
    }

    /**
     * @Description: 用户填写小老师问卷
     * @Param: [StudentFillQuestionInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    @RequestMapping("studentFillStteacherQuestion")
    @ResponseBody
    public TableModel studentFillStteacherQuestion(@Validated @RequestBody StudentFillQuestionInfo data) throws AllException {

        return userService.studentFillStteacherQ(data);
    }


    /**
     * @Description: 用户登录后，后端向前端发送是否有问卷,返回list, educationList, duty,identity(表明他在这份订单中是辅导者还是被辅导者)
     * @Param: [userId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    @GetMapping("loadQuestions")
    @ResponseBody
    public TableModel demo(@RequestParam(value = "userId", defaultValue = "1") @NotNull(message = "用户Id不能为空") Integer userId) throws AllException {


        return userService.loadQuestionsForUser(userId);
    }

    /**
     * @Description: 用户预约时,发送验证码
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    @GetMapping("sendSsmCode")
    @ResponseBody
    public TableModel sendSsmCode(HttpServletRequest httpServletRequest, Principal principal) throws AllException {
        if (StringUtils.isEmpty(principal.getName()))
        {
            return TableModel.error("请登录");
        }
        return userService.sendSsmCode(principal.getName(),httpServletRequest);
    }


    /**
     * @Description: 用户预约时,校验验证码
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    @GetMapping("checkMsgCode")
    @ResponseBody
    public TableModel checkMsgCode(HttpServletRequest httpServletRequest, Principal principal,@RequestParam("msgCode")String msgCode) throws AllException {
        if (StringUtils.isEmpty(principal.getName()) || StringUtils.isEmpty(msgCode))
        {
            return TableModel.error("请登录");
        }
        return userService.checkMsgCode(principal.getName(),httpServletRequest,msgCode);
    }
}
