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
@ApiModel(description = "响应信息")
public class Users {
  @ApiModelProperty("用户id")
  private String uid;
  @ApiModelProperty("用户名称")
  private String uname;
  @ApiModelProperty("用户性别")
  private Integer gender;
  @ApiModelProperty("用户登录手机号")
  private String mobile;
  @ApiModelProperty("用户登录密码")
  private String password;
  @ApiModelProperty("用户是否为会员0不是1是")
  private Integer vip;
  @ApiModelProperty("用户账号状态0禁用1可用")
  private Integer status;
  @ApiModelProperty("用户注册时间")
  private Date createTime;
  @ApiModelProperty("用户信息被修改的最后时间")
  private Date updateTime;

}
