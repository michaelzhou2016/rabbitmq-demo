package com.vcredit.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/21 17:24
 */
@Data
public class EmailTaskSubmit implements Serializable {
    private static final long serialVersionUID = 9027028495557780819L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;
    private String email;
    private Long timestamp;
}
