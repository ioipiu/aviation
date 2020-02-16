package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Introduction {

  private Integer id;
  private String desc;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
