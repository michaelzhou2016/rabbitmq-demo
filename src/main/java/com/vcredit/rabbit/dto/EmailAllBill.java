/**  
 * Project Name:api-webhook  
 * File Name:EmailBill.java  
 * Package Name:com.example.service.webhook.billitem  
 * Date:2016年7月19日下午3:26:59  
 * Copyright (c) 2016, yuandong@51dojo.com All Rights Reserved.  
 *  
*/  
  
package com.vcredit.rabbit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**  
 * ClassName:EmailBill <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016年7月19日 下午3:26:59 <br/>  
 * @author   yuandong  
 * @version    
 * @since    JDK 1.6  
 * @see        
 */
@Data
public class EmailAllBill implements Serializable {
    private static final long serialVersionUID = 3098258835637485156L;
    @JsonProperty("task_id")
	private String taskId;
    @JsonProperty("email_id")
    private String emailId;  //emailId是一个邮箱在魔蝎数据中的唯一标识，和邮箱是1V1
    @JsonProperty("email")
    private String email;    //邮箱
    @JsonProperty("user_id")
    private String userId;   //创建任务时传过来的userid
    @JsonProperty("bill_count")
    private Integer billCount;  //此次爬取到的账单数量
}
  
