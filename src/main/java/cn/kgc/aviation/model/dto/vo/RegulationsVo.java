package cn.kgc.aviation.model.dto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 18:48
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsVo {

    private Integer rid;
    private Integer classifyId;
    private Integer rno;
    private String alias;
    private String version;
    private String rname;
    private Integer status;

}
