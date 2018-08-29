package com.vcredit.rabbit.dto.bank;

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
 * @Date: Created in 2018/5/22 15:39
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankTaskFail implements Serializable {
    private static final long serialVersionUID = -220917773855224680L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;
    private String username;
    private String message;
    private Long timestamp;
}
