package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulting {

  private String zid;
  private String uid;
  private String cname;
  private String phone;
  private String company;
  private String terms;
  private String content;
  private String email;
  private String wechat;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
