package com.vcredit.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/21 17:55
 */
@Data
public class EmailTask implements Serializable {
    private static final long serialVersionUID = 15455306918782924L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;
    private String email;
    private Long timestamp;
    private Boolean result;
    private String message;
}
