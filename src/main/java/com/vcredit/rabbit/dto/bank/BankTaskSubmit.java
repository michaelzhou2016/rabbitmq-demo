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
 * @Date: Created in 2018/5/22 15:31
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankTaskSubmit implements Serializable {
    private static final long serialVersionUID = 966492906814265537L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("bank_id")
    private String bankId;
    @JsonProperty("login_target")
    private String loginTarget;
    @JsonProperty("login_type")
    private String loginType;
    private String account;
    private Long timestamp;
}
