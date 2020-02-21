package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-21 18:42
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private String roles;
    private String introduction;
    private String avatar;
    private String name;
}
