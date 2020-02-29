package cn.kgc.aviation.model.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "咨询服务")
public class Consulting {

  @ApiModelProperty("咨询服务id")
  private String zid;
  @ApiModelProperty("用户id")
  private String uid;
  @ApiModelProperty("用户姓名")
  private String cname;
  @ApiModelProperty("用户联系电话")
  private String phone;
  @ApiModelProperty("用户公司")
  private String company;
  @ApiModelProperty("用户咨询条款")
  private String terms;
  @ApiModelProperty("用户咨询内容")
  private String content;
  @ApiModelProperty("用户联系邮箱")
  private String email;
  @ApiModelProperty("用户微信")
  private String wechat;
  @ApiModelProperty("信息状态")
  private Integer status;
  @ApiModelProperty("咨询时间")
  private Date createTime;
  @ApiModelProperty("信息修改时间")
  private Date updateTime;

}
