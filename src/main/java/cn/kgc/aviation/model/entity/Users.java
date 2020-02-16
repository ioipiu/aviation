package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

  private String uid;
  private String uname;
  private Integer gender;
  private String mobile;
  private String password;
  private Integer vip;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
