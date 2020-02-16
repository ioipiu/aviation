package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regulations {

  private Integer rid;
  private Integer classifyId;
  private Integer rno;
  private String alias;
  private String version;
  private String rname;
  private Integer status;
  private String icon;
  private String pdfName;
  private String pdfLink;
  private String desc;
  private Date createTime;
  private Date updateTime;


}
