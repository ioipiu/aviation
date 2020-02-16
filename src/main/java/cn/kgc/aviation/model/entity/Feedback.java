package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

  private String fid;
  private String uid;
  private String content;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
