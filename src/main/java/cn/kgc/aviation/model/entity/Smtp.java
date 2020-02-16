package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smtp {

  private Integer id;
  private String email;
  private String server;
  private String username;
  private String password;
  private Integer sendNum;
  private String loginType;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
