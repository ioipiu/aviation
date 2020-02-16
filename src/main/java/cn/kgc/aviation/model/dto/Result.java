package cn.kgc.aviation.model.dto;

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
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
}
