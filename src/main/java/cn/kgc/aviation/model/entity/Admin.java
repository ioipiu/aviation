package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

  private Integer aid;
  private String aname;
  private String mobile;
  private String passWord;
  private Integer type;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
