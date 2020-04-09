package com.shu.labrary.tools;
import lombok.Data;

@Data
public class TableModel<T>
{
    public TableModel()
    {
        super();
        this.code=0;
        this.msg=null;
    }
    private int code;
    private String msg;
    private int count;
    private Object data;
    private String[] time1;
    private String[][] time2;

    public static TableModel success(Object data) {
        TableModel tableModel = new TableModel();

        tableModel.setCode(200);
        tableModel.setMsg("操作成功");
        tableModel.setData(data);

        return tableModel;
    }

    public static TableModel success(Object data, int total) {
        TableModel tableModel = new TableModel();

        tableModel.setCode(200);
        tableModel.setMsg(null);
        tableModel.setCount(total);
        tableModel.setData(data);

        return tableModel;
    }

    public static TableModel success(String msg) {
        TableModel tableModel = new TableModel();

        tableModel.setCode(200);
        tableModel.setMsg(msg);
        tableModel.setCount(0);

        return tableModel;
    }

    public static TableModel error(String message) {
        TableModel tableModel = new TableModel();
        tableModel.setCode(500);
        tableModel.setMsg(message);
        tableModel.setCount(0);

        return tableModel;
    }





}
