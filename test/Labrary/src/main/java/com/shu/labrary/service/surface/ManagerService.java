package com.shu.labrary.service.surface;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.pojo.News;
import com.shu.labrary.pojo.request.AddFamousPic;
import com.shu.labrary.pojo.request.FamousTeacherInfo;
import com.shu.labrary.pojo.request.ManagerAddVo;
import com.shu.labrary.pojo.request.StTeacherInfo;
import com.shu.labrary.tools.TableModel;

import java.text.ParseException;
import java.util.List;

public interface ManagerService {
    TableModel searchManager(Integer curr,Integer nums) throws AllException;

    TableModel deleteMangers(List<Integer> list) throws AllException;

    TableModel addMangers(ManagerAddVo addTeamodel) throws AllException;

    TableModel searchCircle() throws AllException;

    TableModel searchPictureSrc() throws AllException;

    TableModel insert(News news) throws AllException;

    TableModel searchNews(Integer newsId) throws AllException;

    TableModel searchNewsForLatest() throws AllException;

    TableModel searchNewsManager(Integer curr) throws AllException;

    TableModel selectNewsByDate(String inputstartdate, String inputenddate, Integer curr) throws ParseException, AllException;

    TableModel deleteNews(List<Integer> deleteids) throws AllException;

    TableModel selectTeacherInFamous(int parseInt) throws AllException;

    TableModel uploadFamouTeacher(FamousTeacherInfo famousTeacherInfo) throws AllException;

    TableModel deleteFamouTeacher(String teacherName);

    TableModel searchNewsName() throws AllException;

    TableModel uploadFamPic(AddFamousPic addFamousPic) throws AllException;

    TableModel addToStteacher(List<Integer> adminList) throws AllException;

    TableModel searchStteacher(Integer curr) throws AllException;

    TableModel upDateStTeacher(StTeacherInfo stTeacherInfo) throws AllException;

    TableModel deleteStTeacher(List<Integer> deleteids) throws AllException;
}
