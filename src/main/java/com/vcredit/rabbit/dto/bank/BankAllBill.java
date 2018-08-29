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
 * @Date: Created in 2018/5/22 15:40
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankAllBill implements Serializable {
    private static final long serialVersionUID = -7289738353539751052L;
    @JsonProperty("task_id")
    private String taskId;
    @JsonProperty("user_id")
    private String userId;

    public BankAllBill(String taskId, String userId) {
        this.taskId = taskId;
        this.userId = userId;
    }
}
