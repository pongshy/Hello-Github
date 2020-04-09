package com.shu.labrary.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shu.labrary.exception.AllException;
import com.shu.labrary.exception.EmAllException;
import com.shu.labrary.mapper.ApplybodyMapper;
import com.shu.labrary.mapper.AppointmenttimeMapper;
import com.shu.labrary.pojo.Applybody;
import com.shu.labrary.pojo.Appointmenttime;
import com.shu.labrary.pojo.AppointmenttimeExample;
import com.shu.labrary.service.surface.AppointmentsService;
import com.shu.labrary.tools.DateUtils;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AppointmentsServiceImpl implements AppointmentsService {
    @Autowired
    ApplybodyMapper applybodyMapper;

    @Autowired
    AppointmenttimeMapper appointmenttimeMapper;

    @Override
    public TableModel getAppointmentsin14days() throws ParseException {
        TableModel tableModel = new TableModel();
        String[] strdate = new String[14];
        String[][] hoursdata = new String[14][14];
        List<Map> applybodies = applybodyMapper.getAppointmentsin14days();
        for (Map applybody : applybodies) {
            String beginTimeStr = applybody.get("beginTime").toString();
            Date begindate = DateUtils.strToDate(beginTimeStr);
            int dayDiffer = DateUtils.getDayDiffer(new Date(), begindate);
            SimpleDateFormat formathour = new SimpleDateFormat("HH");
            String newhourStr = formathour.format(begindate);
            hoursdata[dayDiffer][Integer.parseInt(newhourStr) - 8] = "存在预约";
        }
        for (int i = 0; i < 14; i++) {
            SimpleDateFormat alldaysformat = new SimpleDateFormat("MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, i);
            String days = alldaysformat.format(calendar.getTime());
            strdate[i] = days;
        }
        tableModel.setTime2(hoursdata);
        tableModel.setTime1(strdate);
        tableModel.setCode(0);
        return tableModel;
    }


    @Override
    public TableModel getApplicationByOneTime(String day, Integer hour, Integer curr, Integer nums) throws ParseException {
        TableModel tableModel = new TableModel();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat formatyear = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatMonth = new SimpleDateFormat("MM");
        String hourstr = (hour + 7) + "";
        String startdate = day + " " + hourstr + ":00:00";
        Date newdate = new Date();
        String startmonth = day.substring(0, 2);
        String thisyear = formatyear.format(newdate);
        int newyear = Integer.parseInt(thisyear);
        String thismonth = formatMonth.format(newdate);
        if (thismonth.equals("12") && startmonth.equals("01")) {
            newyear = newyear + 1;
        }
        String startfinaltime = newyear + "-" + startdate;
        Date startfinalDate = formatter.parse(startfinaltime, pos);
        PageHelper.startPage(curr, nums);
        List<Map> list = applybodyMapper.selectApplicationByOneTime(startfinalDate);
        PageInfo pageInfo = new PageInfo(list, 5);
        int count= (int) pageInfo.getTotal();

        PageHelper.startPage(curr, nums);
        List<Map> list2 = applybodyMapper.selectApplicationByOneTime2(startfinalDate);
        PageInfo pageInfo2 = new PageInfo(list2, 5);
        count+=pageInfo2.getTotal();
        list.addAll(list2);

        tableModel.setCount(count);
        tableModel.setData(list);
        tableModel.setCode(0);
        return tableModel;
    }


    @Override
    public TableModel getAllAppointments(Integer curr, Integer nums) throws ParseException {
        try {
            TableModel tableModel = new TableModel();
            PageHelper.startPage(curr, nums);
            List<Map> list = applybodyMapper.selectAppointsMents();
            PageInfo pageInfo = new PageInfo(list, 5);
            int count= (int) pageInfo.getTotal();
            PageHelper.startPage(curr, nums);
            List<Map> list2 = applybodyMapper.selectAppointsMents2();
            PageInfo pageInfo2 = new PageInfo(list2, 5);
            count+=pageInfo2.getTotal();
            list.addAll(list2);

            tableModel.setCount(count);
            tableModel.setData(list);
            tableModel.setCode(0);
            return tableModel;
        } catch (Exception e) {
            e.printStackTrace();
            return TableModel.error("Error");
        }
    }


    @Override
    public TableModel deleteAppointments(List<Integer> appointIds) throws AllException {
        try {
            TableModel tableModel = new TableModel();
            for (Integer appointId : appointIds) {
                //查询这个预约对应的教师辅导时间
                Applybody applybody = applybodyMapper.selectByPrimaryKey(appointId);
                Integer teacherid = applybody.getTeacherid();
                Date begintime = applybody.getBegintime();

                //如果辅导开始时间距离现在24小时以上
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, 1);
                Date newDate = calendar.getTime();

                if (begintime.after(newDate)) {
                    //重置预约时间可选择状态
                    AppointmenttimeExample appointmenttimeExample = new AppointmenttimeExample();
                    appointmenttimeExample.createCriteria().andTeacheridEqualTo(teacherid).andStarttimeEqualTo(begintime);
                    List<Appointmenttime> appointmenttimes = appointmenttimeMapper.selectByExample(appointmenttimeExample);

                    if (appointmenttimes.size() != 0) {
                        appointmenttimes.get(0).setOccupy(0);
                        appointmenttimeMapper.updateByPrimaryKeySelective(appointmenttimes.get(0));
                    }
                }
                applybodyMapper.deleteByPrimaryKey(appointId);

            }
            tableModel.setMsg("200");
            return tableModel;
        } catch (Exception e) {
            throw new AllException(EmAllException.DATABASE_ERROR);
        }
    }


    @Override
    public TableModel selectAppointmentByDate(String startdate, String enddate, Integer curr, Integer nums) throws ParseException {
        TableModel tableModel = new TableModel();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newstartdate = formatter.parse(startdate);
        Date newenddate = formatter.parse(enddate);
        PageHelper.startPage(curr, nums);
        List<Map> list = applybodyMapper.selectAppointmentByDate(newstartdate, newenddate);
        PageInfo pageInfo = new PageInfo(list, 5);
        int count= (int) pageInfo.getTotal();
        PageHelper.startPage(curr, nums);
        List<Map> list2 = applybodyMapper.selectAppointmentByDate2(newstartdate, newenddate);
        PageInfo pageInfo2= new PageInfo(list2, 5);
        count+=pageInfo2.getTotal();
        list.addAll(list2);
        tableModel.setCount(count);
        tableModel.setData(list);
        tableModel.setCode(0);
        return tableModel;
    }

}
