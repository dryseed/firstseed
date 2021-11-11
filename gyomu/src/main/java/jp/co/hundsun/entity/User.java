package jp.co.hundsun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userCode;
    private String userName;
    private String userLevel;
    private String userPswd;
    private String userStatus;
    private String lockStatus;
    private String sex;
    private String phone;
    private String remark;
    private String operator;
    private String extFld1;
    private String extFld2;
}
