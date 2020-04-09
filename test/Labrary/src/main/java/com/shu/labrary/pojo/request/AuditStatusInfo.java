package com.shu.labrary.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * program: AuditStatusInfo
 * description: 用户选择查看状态——审核，成功，拒绝
 * author: pongshy
 * create: 2020-1-31
 */
@Data
public class AuditStatusInfo {
    @NotNull(message = "用户不能玩为空")
    private Integer userId;

    @NotNull(message = "不能为空")
    private boolean success;

    @NotNull(message = "不能为空")
    private boolean fail;

    @NotNull(message = "不能为空")
    private boolean check;

//    @NotBlank(message = "不能为空")
//    private String success;
//
//    @NotBlank(message = "不能为空")
//    private String check;
//
//    @NotBlank(message = "不能为空")
//    private String fail;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isSuccess() {
        if(this.success)
        {
            return true;
        }else{
            return false;
        }
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFail() {
        return fail;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
//    public String getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(String success) {
//        this.success = success;
//    }
//
//    public String getCheck() {
//        return check;
//    }
//
//    public void setCheck(String check) {
//        this.check = check;
//    }
//
//    public String getFail() {
//        return fail;
//    }
//
//    public void setFail(String fail) {
//        this.fail = fail;
//    }
}
