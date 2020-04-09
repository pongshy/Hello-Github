package com.shu.labrary.service.surface;


import com.shu.labrary.exception.AllException;
import com.shu.labrary.tools.TableModel;

import java.text.ParseException;
import java.util.List;

public interface AppointmentsService {

    public TableModel getAppointmentsin14days() throws ParseException;

    public TableModel getApplicationByOneTime(String day, Integer hour,Integer curr,Integer nums) throws ParseException;

    public TableModel getAllAppointments(Integer curr, Integer nums) throws ParseException;

    public TableModel deleteAppointments(List<Integer> appointIds) throws AllException;

    public TableModel selectAppointmentByDate(String startdate,String enddate, Integer curr, Integer nums) throws ParseException;

}
