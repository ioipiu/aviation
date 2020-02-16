package cn.kgc.aviation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-13 10:27
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Options implements Serializable {

    private Integer value;
    private String label;
    private List<Options> children;

}
