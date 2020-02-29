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
@ApiModel(description = "意见反馈")
public class Feedback {

  @ApiModelProperty("意见反馈id")
  private String fid;
  @ApiModelProperty("用户id")
  private String uid;
  @ApiModelProperty("用户反馈内容")
  private String content;
  @ApiModelProperty("信息状态0未读1已读")
  private Integer status;
  @ApiModelProperty("反馈时间")
  private Date createTime;
  @ApiModelProperty("信息修改时间")
  private Date updateTime;

}
