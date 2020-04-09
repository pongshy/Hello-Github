package com.shu.labrary.pojo.request;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AgreeAppointmentInfo {
    @NotNull(message = "不能为空")
    private Integer requestId;

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }
}
