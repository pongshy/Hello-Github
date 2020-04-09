package com.shu.labrary.controller;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.Appointmenttime;
import com.shu.labrary.pojo.News;
import com.shu.labrary.pojo.request.*;
import com.shu.labrary.service.surface.*;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @Description: 管理页面接口
 * @Param: []
 * @Return: com.meeting.model.tools.TableModel
 * @Author: 陈兴宇
 * @Date: 2020-1-1
 */
@Controller
@CrossOrigin
@RequestMapping("monitor")
public class ManagerController {
    @Autowired
    private Departmentservice departmentservice;

    @Autowired
    private Teacherservice teacherservice;

    @Autowired
    private EssayService essayService;

    @Autowired
    private AppointmentsService appointmentsService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BrokenPersonService brokenPersonService;

    @Autowired
    private ManagerService managerService;
    /**
     * @Description: 查询所有学生
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchStudent")
    @ResponseBody
    public TableModel SearchStudent(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                    @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
        if (curr <= 0 || nums <= 0) {
            return TableModel.error("输入有误!");
        }
        return studentService.searchStudentInformation(curr, nums);
    }

    /**
     * @Description: 删除一些学生
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteStudent")
    @ResponseBody
    public TableModel deleteStudent(@RequestParam("requestiId") List<Integer> requestiId) throws AllException {
        if (requestiId.isEmpty()) {
            return TableModel.error("输入为空!");
        }
        return studentService.deleteSomeStudent(requestiId);
    }


    /**
     * @Description: 查询一些学生
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping(value = "searchStudentById")
    @ResponseBody
    public TableModel searchStudentById(@RequestParam("UserId") String UserId) {
        if (UserId.isEmpty()) {
            return TableModel.error("输入为空!");
        }
        return studentService.searchStudentById(UserId);
    }

    /**
     * @Description: 查询老师信息
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchTeacher")
    @ResponseBody
    public TableModel SearchTeacher(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                    @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
        if (curr <= 0 || nums <= 0) {
            return TableModel.error("输入有误!");
        }
        return teacherservice.searchTeacherInformation(curr, nums);
    }

    /**
     * @Description: 查询失信人员信息
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchDishonestPerson")
    @ResponseBody
    public TableModel searchDishonest(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                      @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
        if (curr <= 0 || nums <= 0) {
            return TableModel.error("输入有误!");
        }
        return brokenPersonService.searchBrokenPersonInformation(curr, nums);
    }

    /**
     * @Description: 删除失信人员信息
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteDishonest")
    @ResponseBody
    public TableModel deleteDishonest(@RequestParam("requestiId") List<Integer> data) throws AllException {
        if (data.isEmpty()) {
            return TableModel.error("输入为空!");
        }
        return brokenPersonService.deleteSomeBrokenPerson(data);
    }

    /**
     * @Description: 设置失信人员
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("addDishonest")
    @ResponseBody
    public TableModel addDishonest(AddBrokenPersonInfo data) throws AllException {
        if (data==null) {
            return TableModel.error("输入有误!");
        }
        return brokenPersonService.addDishonestPerson(data);
    }


    /**
     * @Description: 搜索管理员
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchManager")
    @ResponseBody
    public TableModel searchManager(@RequestParam(value = "curr", defaultValue = "1") Integer curr,
                                    @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
        if (curr<=0 || nums<=0)
        {
            return TableModel.error("输入有误！");
        }
        return managerService.searchManager(curr, nums);
    }

    /**
     * @Description: 删除管理员
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteMangers")
    @ResponseBody
    public TableModel deleteMangers(@RequestParam("requestiId") List<Integer> list) throws AllException {
        if (list.isEmpty())
        {
            return TableModel.error("参数为空，无法删除");
        }
        return managerService.deleteMangers(list);
    }


    /**
     * @Description: 增加管理员
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("addMangers")
    @ResponseBody
    public TableModel addMangers(@Validated @RequestBody ManagerAddVo addTeamodel) throws AllException {
        if (addTeamodel==null)
        {
            return TableModel.error("参数为空");
        }
        return managerService.addMangers(addTeamodel);
    }


    /**
     * @Description: 查询四个显示框参数：当前预约数等
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchCircle")
    @ResponseBody
    public TableModel searchCircle() throws AllException {

        return managerService.searchCircle();
    }


    /**
     * @Description: 查询轮播框图片地址
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchPictureSrc")
    @ResponseBody
    public TableModel searchPictureSrc() throws AllException {
        return managerService.searchPictureSrc();
    }


    /**
     * @Description: 查询部门编号
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchdep")
    @ResponseBody
    public TableModel searchdep() throws AllException {

        return departmentservice.serchdepartment();
    }


    /**
     * @Description: 根据部门编号查询该部门所有教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchteacherbydepid")
    @ResponseBody
    public TableModel searchteacherbydepid(
            @RequestParam("category1id") Integer category1id,
            @RequestParam(value = "curr", defaultValue = "1") Integer curr,
            @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
            if (curr<=0 || nums<=0 || category1id<=0){
                    return TableModel.error("输入不正确");
            }
        return teacherservice.findteacherbydepid(category1id, curr, nums);
    }


    /**
     * @Description: 根据教师id或者姓名查询教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchteacherbyid")
    @ResponseBody
    public TableModel searchteacherbyid(@RequestParam("inputtexts") Object object) throws AllException {
        if (object==null)
        {
            return TableModel.error("输入不正确");
        }
        return teacherservice.findallteacher(object);
    }


    /**
     * @Description: 添加老师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("addteacher")
    @ResponseBody
    public TableModel addteacher(@Validated @RequestBody AddTeamodel addTeamodel) throws AllException {
        if (addTeamodel==null)
        {
            return TableModel.error("输出信息有误");
        }
        return teacherservice.addteacher(addTeamodel);
    }


    /**
     * @Description: 改变教师状态
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("updateTeacherStatus")
    @ResponseBody
    public TableModel updateTeacherStatus(
            @RequestParam("teacherid") String teacherid,
            @RequestParam("teacherstatus") Boolean teacherstatus) throws AllException {
        if (teacherid.isEmpty() ||teacherid=="" ||teacherstatus==null)
        {
            TableModel.error("输入信息有误");
        }
        return teacherservice.updateTeacherStatus(Integer.parseInt(teacherid), teacherstatus);
    }


    /**
     * @Description: 删除教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteteacherdata")
    @ResponseBody
    public TableModel deleteteacherdata(
            @RequestParam("deleteids") List<Integer> deletedata) throws IOException {
        if (deletedata==null)
        {
            TableModel.error("输入有误");
        }
        return teacherservice.deleteteacherservice(deletedata);
    }


    /**
     * @Description: 查询在申请中的论文
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchEssayonapplying")
    @ResponseBody
    public TableModel searchEssayonapplying(
            @RequestParam(value = "curr", defaultValue = "1") Integer curr,
            @RequestParam(value = "isupdate", defaultValue = "0") Integer isupdate,
            @RequestParam(value = "nums", defaultValue = "1") Integer nums) throws AllException {
        if (curr<=0 || nums<=0 || isupdate>1 || isupdate<0)
        {
            TableModel.error("输入有误");
        }
        return essayService.searchEssayonapplying(curr, nums, isupdate);
    }


    /**
     * @Description: 删除论文
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteessay")
    @ResponseBody
    public TableModel deleteessay(@RequestParam("deleteids") List<Integer> deleteids) throws AllException {
        if (deleteids.isEmpty())
        {
            TableModel.error("输入有误");
        }
        return essayService.deleteessays(deleteids);
    }


    /**
     * @Description: 查询论文
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchEssays")
    @ResponseBody
    public TableModel searchEssays(@RequestParam("essayid") Object essayid) throws AllException {
        if (essayid==null)
        {
            TableModel.error("输入有误");
        }
        return essayService.searchEssays(essayid);
    }


    /**
     * @Description: 查询未来14天预约
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("getAppointmentsin14days")
    @ResponseBody
    public TableModel getAppointmentsin14days() throws ParseException {

        return appointmentsService.getAppointmentsin14days();
    }


    /**
     * @Description: 查询某一天的预约信息
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("getApplicationByOneTime")
    @ResponseBody
    public TableModel getApplicationByOneTime(
            @RequestParam("hourtime") String day,
            @RequestParam("hour") Integer hour, Integer curr, Integer nums) throws ParseException {
        if (curr<=0 || nums<=0 ||day.isEmpty() ||hour>14 ||hour<1)
        {
            TableModel.error("输入信息有误");
        }
        return appointmentsService.getApplicationByOneTime(day, hour, curr, nums);
    }


    /**
     * @Description: 查询所有的预约
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("selectAllAppoinments")
    @ResponseBody
    public TableModel selectAllAppoinments(Integer curr, Integer nums) throws ParseException {
        if (curr<=0 || nums<=0)
        {
            TableModel.error("用户信息有误");
        }
        return appointmentsService.getAllAppointments(curr, nums);
    }


    /**
     * @Description: 删除预约
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteAppointments")
    @ResponseBody
    public TableModel deleteAppointments(
            @RequestParam("deleteids") List<Integer> deleteids) throws AllException {
        if (deleteids.isEmpty())
        {
            TableModel.error("用户信息有误");
        }
        return appointmentsService.deleteAppointments(deleteids);
    }


    /**
     * @Description: 查询两个时间间隔的预约
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping(value = "selectAppointmentByDate")
    @ResponseBody
    public TableModel selectAppointmentByDate(
            @RequestParam("inputstartdate") String inputstartdate,
            @RequestParam("inputenddate") String inputenddate,
            Integer curr, Integer nums) throws ParseException {
        if (curr<=0 || nums<=0 || inputenddate.isEmpty() || inputenddate.isEmpty())
        {
            TableModel.error("信息输入有误");
        }
        return appointmentsService.selectAppointmentByDate(inputstartdate, inputenddate, curr, nums);
    }



    /**
     * @Description: 上传新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("uploadNews")
    @ResponseBody
    public TableModel uploadNews(@Validated @RequestBody News news) throws AllException {
        return managerService.insert(news);
    }



    /**
     * @Description: 查询新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchNews")
    @ResponseBody
    public TableModel searchNews(@RequestParam("newsId") Integer newsId) throws AllException {
        if (newsId<=0 || newsId>Integer.MAX_VALUE)
        {
            TableModel.error("输入信息有误");
        }
        return managerService.searchNews(newsId);
    }



    /**
     * @Description: 查询最近发布的新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchNewsForLatest")
    @ResponseBody
    public TableModel searchNewsForLatest() throws AllException {
        return managerService.searchNewsForLatest();
    }



    /**
     * @Description: 查询所有的新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchNewsManager")
    @ResponseBody
    public TableModel searchNewsManager(@RequestParam("curr") Integer curr) throws AllException {
        if (curr<=0)
        {
            TableModel.error("输入信息有误");
        }
        return managerService.searchNewsManager(curr);
    }


    /**
     * @Description: 删除新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteNews")
    @ResponseBody
    public TableModel deleteNews(@RequestParam("deleteids") List<Integer> deleteids) throws AllException {
        if (deleteids.isEmpty())
        {
            TableModel.error("输入信息有误");
        }
        return managerService.deleteNews(deleteids);
    }


    /**
     * @Description: 查找两个时间之间的新闻
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("selectNewsByDate")
    @ResponseBody
    public TableModel selectNewsByDate(
            @RequestParam("inputstartdate") String inputstartdate,
            @RequestParam("inputenddate") String inputenddate, Integer curr) throws ParseException, AllException {
        if (inputenddate.isEmpty() || inputenddate.isEmpty() ||curr<=0)
        {
            TableModel.error("输入信息有误");
        }
        return managerService.selectNewsByDate(inputstartdate, inputenddate, curr);
    }



    /**
     * @Description: 修改教师编辑时间时，先查找原有时间
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchEditTimes")
    @ResponseBody
    public TableModel searchEditTimes(
            @Validated @RequestParam("teacherid") String teacherid) throws ParseException {
        if (teacherid.isEmpty())
        {
            TableModel.error("教师信息有误");
        }
        return teacherservice.searchEditTimes(Integer.parseInt(teacherid));
    }



    /**
     * @Description: 修改教师编辑时间时，先查找原有时间
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("saveTimes")
    @ResponseBody
    public TableModel saveTimes(@RequestBody Appointmenttime[] time) throws ParseException {
        if (time==null)
        {
            TableModel.error("信息有误");
        }
        return teacherservice.saveTimes(time);
    }


    /**
     * @Description: 将教师预约时间置空
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @RequestMapping("saveNullTimes")
    @ResponseBody
    public TableModel saveNullTimes(@RequestParam("teacherid") String teacherid) throws ParseException {
        if (teacherid.isEmpty())
        {
            TableModel.error("信息有误");
        }
        return teacherservice.saveNullTimes(Integer.parseInt(teacherid));
    }


    /**
     * @Description: 著名教授界面查询一个部门的所有教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("selectTeacherInFamous")
    @ResponseBody
    public TableModel selectTeacherInFamous(@RequestParam("departmentid") String departmentid) throws ParseException, AllException {
        if (departmentid.isEmpty())
        {
            TableModel.error("信息有误");
        }
        return managerService.selectTeacherInFamous(Integer.parseInt(departmentid));
    }

    /**
     * @Description: 著名教授界面查询一个部门的所有教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("uploadFamouTeacher")
    @ResponseBody
    public TableModel uploadFamouTeacher(@Validated @RequestBody FamousTeacherInfo famousTeacherInfo) throws  AllException {
        if (famousTeacherInfo==null)
        {
            TableModel.error("信息有误");
        }

        return managerService.uploadFamouTeacher(famousTeacherInfo);
    }

    /**
     * @Description: 著名教授界面查询一个部门的所有教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("deleteFamouTeacher")
    @ResponseBody
    public TableModel deleteFamouTeacher(@RequestParam("teacherName")String teacherName) throws  AllException {
        if (teacherName==null)
        {
            TableModel.error("信息有误");
        }

        return managerService.deleteFamouTeacher(teacherName);
    }



    /**
     * @Description: 设置轮播图界面查询最近三个月的新闻名称
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchNewsName")
    @ResponseBody
    public TableModel searchNewsName() throws  AllException {

        return managerService.searchNewsName();
    }



    /**
     * @Description: 上传新的轮播图
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("uploadFamPic")
    @ResponseBody
    public TableModel uploadFamPic(@Validated @RequestBody AddFamousPic addFamousPic) throws  AllException {

        if (addFamousPic==null)
        {
            return TableModel.error("输入信息不对");
        }

        return managerService.uploadFamPic(addFamousPic);
    }




    /**
     * @Description: 添加学生教师方法
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("addToStteacher")
    @ResponseBody
    public TableModel addToStteacher(@RequestParam("requestiId")List<Integer>adminList) throws  AllException {

        if (adminList==null)
        {
            return TableModel.error("输入信息不对");
        }

        return managerService.addToStteacher(adminList);
    }




    /**
     * @Description: 查询学生教师的方法
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @GetMapping("searchStteacher")
    @ResponseBody
    public TableModel searchStteacher(@RequestParam("curr")Integer curr) throws  AllException {

        if (curr<=0)
        {
            return TableModel.error("输入信息不对");
        }

        return managerService.searchStteacher(curr);
    }



    /**
     * @Description: 学生教师信息修改
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("upDateStTeacher")
    @ResponseBody
    public TableModel upDateStTeacher(@Validated @RequestBody StTeacherInfo stTeacherInfo) throws  AllException {

        if (stTeacherInfo==null)
        {
            return TableModel.error("输入信息不对");
        }

        return managerService.upDateStTeacher(stTeacherInfo);
    }



    /**
     * @Description: 删除学生教师
     * @Param: []
     * @Return: com.meeting.model.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-1-1
     */
    @PostMapping("deleteStTeacher")
    @ResponseBody
    public TableModel deleteStTeacher(@RequestParam("deleteids") List<Integer> deleteids) throws  AllException {

        if (deleteids==null)
        {
            return TableModel.error("输入信息不对");
        }

        return managerService.deleteStTeacher(deleteids);
    }
}
