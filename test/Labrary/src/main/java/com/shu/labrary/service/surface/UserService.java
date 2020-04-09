package com.shu.labrary.service.surface;



import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.tools.TableModel;

import javax.servlet.http.HttpServletRequest;

/**
 * @Program: UserSerive
 * @Description: 用户页面接口
 * @Author: pongshy
 * @Date: 2020-1-27
 */
public interface UserService {

    /**
     * @Description: 根据姓名返回对应教师信息
     * @Param: [NameInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-27
     */
    public TableModel getInforFromName(NameInfo data) throws AllException;

    /**
     * @Description: 用户选择学院、校区，显示相应教师信息
     * @Param: [ShowTeacherMsgInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-30
     */
    public TableModel showTeacherMsg(ShowTeacherMsgInfo data) throws AllException;

    /**
     * @Description: 用户选择查看状态——审核，成功，拒绝
     * @Param: [AuditStatusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel showCheckedStatus(AuditStatusInfo data) throws AllException;


    /**
     * @Description: 用户查看被拒绝的具体原因
     * @Param: [ShowRefusedReasonInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel refusedReason(ShowRefusedReasonInfo data) throws AllException;

    /**
     * @Description: 老师查看预约情况
     * @Param: [AuditStatusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel showAppointmentForTeacher(AuditStatusInfo data) throws AllException;

    /**
     * @Description: 显示学生个人信息
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel getStudentInformation(String userId) throws AllException;

    /**
     * @Description: 修改学生个人信息
     * @Param: [StudnetInformationInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel changeStudentInformation(StudentInformationInfo data) throws AllException;

    /**
     * @Description: 显示教师个人信息
     * @Param: [teacherId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel showTeacherPersonalInformation(Integer teacherId) throws AllException;

    /**
     * @Description: 修改教师个人信息
     * @Param: [ChangeTeacherInformationInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel changeTeacherPersonalInformation(ChangeTeacherInformationInfo data) throws AllException;

    /**
     * @Description: 用户上传学生信息，论文地址及教师Id给后端
     * @Param: [ConfirmPaperUpload]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-31
     */
    public TableModel userConfirmsAppointment(ConfirmPaperUploadInfo data) throws AllException;

    /**
     * @Description: 教师查看自己的预约时间
     * @Param: [teacherId]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    public TableModel teacherSeeAppointmentTime(Integer teacherId) throws AllException;

    /**
     * @Description: 教师修改预约时间
     * @Param: [ChangeAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-5
     */
    public TableModel changeTeacherAppointmentTime(ChangeAppointmentTimeInfo data) throws AllException;

    /**
     * @Description: 教师增加预约时间
     * @Param: [AddAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-5
     */
    public TableModel addTeacherAppointmentTime(AddAppointmentTimeInfo data) throws AllException;

    /**
     * @Description: 教师删除预约时间
     * @Param: [DeleteAppointmentTimeInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-5
     */
    public TableModel deleteTeacherAppointmentTime(DeleteAppointmentTimeInfo data) throws AllException;

    /**
     * @Description: 学生对老师的问卷加载
     * @Param: [StudentQuestionInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    public TableModel studentQuestion(StudentQuestionInfo data) throws AllException;

    /**
     * @Description: 学生填写问卷
     * @Param: [StudentFillQuestionInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    public TableModel studentFill(StudentFillQuestionInfo data) throws AllException;

    /**
     * @Description: 教师填写问卷
     * @Param: [TeacherFillQuestion]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-7
     */
    public TableModel teacherFill(TeacherFillQuestionInfo data) throws AllException;

    /**
     * @Description: 首页加载有图片新闻，5条
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    public TableModel pictureNews() throws AllException;

    /**
     * @Description: 首页加载无图片新闻，15条
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    public TableModel showNews() throws AllException;

    /**
     * @Description: 前端发送一个当前页码序号，后端发送总共的新闻总数以及10条新闻
     * @Param: [cur]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    public TableModel showNewsPage(Integer cur) throws AllException;

    /**
     * @Description: 用户选择校区，同时给出页码，显示默认为所有学院的老师
     * @Param: [ShowTeachersInCampusInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    public TableModel showTeachersInCampus(ShowTeachersInCampusInfo data) throws AllException;

    /**
     * @Description: 用户登录后，后端向前端发送是否有问卷
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-19
     */
    public TableModel loadQuestionsForUser(Integer userId) throws AllException;

    /**
     * @Description: 教师修改个人头像
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-22
     */
    public TableModel modifyTeacherImage(ModifyImageInfo data) throws AllException;



    /**
     * @Description: 发送邮件验证码
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-22
     */
    public TableModel sendSsmCode(String name, HttpServletRequest httpServletRequest) throws AllException;

    /**
     * @Description: 验证邮件验证码
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-22
     */
    public TableModel checkMsgCode(String name, HttpServletRequest httpServletRequest, String msgCode);

    /**
     * @Description: 用户填写小老师问卷
     * @Param: [StudentFillQuestionInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    public TableModel studentFillStteacherQ(StudentFillQuestionInfo data) throws AllException;

    /**
     * @Description: 登录时，发送邮箱给前端
     * @Param: [userId]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-13
     */
    public TableModel getUserEmailAndPhone(Integer userId) throws AllException;

}
