package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect {

  private Integer cid;
  private String uid;
  private Integer tid;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
