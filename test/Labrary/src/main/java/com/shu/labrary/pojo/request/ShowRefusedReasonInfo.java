package com.shu.labrary.pojo.request;

import javax.validation.constraints.NotNull;

/**
 * @Description: 用户查看被拒绝的具体原因
 * @Param: [ShowRefuseReasonInfo]
 * @Return: com.shu.labrary.tools.TableModel
 * @Author: pongshy
 * @Date: 2020-1-31
 */
public class ShowRefusedReasonInfo {
    @NotNull(message = "requestId不能为空")
    private Integer requestId;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
