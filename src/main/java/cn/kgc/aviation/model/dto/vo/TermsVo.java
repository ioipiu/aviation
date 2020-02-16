package cn.kgc.aviation.model.dto.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-16 12:59
 * @version: V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TermsVo {
    private Integer tid;
    private Integer rid;
    private Integer did;
    private String tno;
    private String termsAlias;
    private String termsTitle;
    private String termsContent;
    private String termsVersion;
    private String termsKeyword;
    private Integer termsStatus;
    private String rname;
}
