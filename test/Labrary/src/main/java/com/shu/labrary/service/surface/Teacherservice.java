package com.shu.labrary.service.surface;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.Appointmenttime;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.tools.TableModel;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
public interface Teacherservice {

    public TableModel findteacherbydepid(int depid,Integer curr,Integer nums) throws AllException;

    public TableModel findallteacher(Object searchtext) throws AllException;

    public TableModel addteacher(AddTeamodel addTeacherModel) throws AllException;

    public TableModel deleteteacherservice(List<Integer> deletedata) throws IOException;

    public TableModel updateTeacherStatus(Integer teacherid, Boolean free) throws AllException;

    public TableModel searchTeacherInformation(Integer curr, Integer nums) throws AllException;

    public TableModel saveNullTimes(Integer teacherid);

    /**
     * @Description: 教师同意预约
     * @Param: [AgreeAppointmentInfo]
     * @Return: com.shu.labrary.tools.picture.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    public TableModel agreeAppointment(AgreeAppointmentInfo data) throws AllException;

    /**
     * @Description: 教师拒绝预约
     * @Param: [RefuseAppointmentInfo]
     * @Return: com.shu.labrary.tools.picture.TableModel
     * @Author: pongshy
     * @Date: 2020-1-15
     */
    public TableModel refuseAppointment(RefuseAppointmentInfo data) throws AllException;

    /**
     * @Description: 显示教师信息
     * @Param: [RefuseAppointmentInfo]
     * @Return: com.shu.labrary.tools.picture.TableModel
     * @Author: pongshy
     * @Date: 2020-1-19
     */
    public TableModel showInformation() throws AllException;

    TableModel searchEditTimes(Integer teacherid);

    TableModel saveTimes(Appointmenttime[] time) throws ParseException;

    /**
     * @Description: 小老师预约页面，根据姓名返回教师信息
     * @Param: [NameInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    public TableModel loadStudentTeacherMsg(NameInfo data) throws AllException;

    /**
     * @Description: 小老师预约页面，选择学院、校区，显示相应教师信息
     * @Param: [ShowTeacherMsgInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    public TableModel loadDataAcademy(ShowTeacherMsgInfo data) throws AllException;

    /**
     * @Description: 小老师预约页面，选择校区，同时给出页码，显示默认为所有学院的老师
     * @Param: [ShowTeachersInCampusInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    public TableModel loadDataCampus(ShowTeachersInCampusInfo data) throws AllException;

    /**
     * @Description: 显示小老师个人信息
     * @Param: [userId]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    public TableModel showPersonalStteacher(Integer userId) throws AllException;

    /**
     * @Description: 修改小老师个人信息
     * @Param: [ChangeStTeacherInformation]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-9
     */
    public TableModel changeStteacherInfor(ChangeStTeacherInformationInfo data) throws AllException;

    /**
     * @Description: 小老师同意预约
     * @Param: [AgreeAppointmentInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    public TableModel stteacherAgreeAppointment(AgreeAppointmentInfo data) throws AllException;

    /**
     * @Description: 小老师查看自己被预约的状况
     * @Param: [AudiStatusInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    public TableModel stteacherSeeAppointment(AuditStatusInfo data) throws AllException;

    /**
     * @Description: 用户预约小老师
     * @Param: [ConfirmPaperUploadInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    public TableModel userConfirmStteacher(ConfirmPaperUploadInfo data) throws AllException;

    /**
     * @Description: 小老师修改个人头像
     * @Param: [ModifyImageInfo]
     * @Return: com.shu.labrary.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-3-10
     */
    public TableModel changeImageForStteacher(ModifyImageInfo data) throws AllException;

}
