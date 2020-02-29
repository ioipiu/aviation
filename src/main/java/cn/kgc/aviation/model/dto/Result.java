package cn.kgc.aviation.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 15:29
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "响应数据",description = "响应回的对象")
public class Result<T> implements Serializable {
    @ApiModelProperty("响应码")
    private Integer code;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;
}
