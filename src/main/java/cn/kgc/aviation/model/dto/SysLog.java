package cn.kgc.aviation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 17:00
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog {
    private String sid;

    private String username;

    private String operation;

    private String method;

    private String params;

    private Date logDate;
}
