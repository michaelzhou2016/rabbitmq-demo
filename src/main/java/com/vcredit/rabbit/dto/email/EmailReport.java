package com.vcredit.rabbit.dto.email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author zhouliliang
 * @Description:
 * @Date: Created in 2018/5/21 17:57
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailReport implements Serializable {
    private static final long serialVersionUID = 8487821198684826100L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;
    private String email;
    @JsonProperty("email_id")
    private String emailId;
    private Boolean result;
    private String message;
    private Long timestamp;
}
