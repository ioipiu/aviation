package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terms {

  private Integer tid;
  private Integer rid;
  private Integer did;
  private String tno;
  private String termsAlias;
  private String termsTitle;
  private String termsContent;
  private String termsVersion;
  private String termsKeyword;
  private Integer termsStatus;
  private Date createTime;
  private Date updateTime;

}
