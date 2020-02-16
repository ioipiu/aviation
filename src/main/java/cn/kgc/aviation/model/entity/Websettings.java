package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Websettings {

  private Integer id;
  private String title;
  private Integer status;
  private String domain;
  private String logo;
  private String email;
  private Integer language;
  private Date createTime;
  private Date updateTime;

}
