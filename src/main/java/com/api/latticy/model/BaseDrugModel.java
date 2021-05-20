package com.api.latticy.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author Jianglq
 * @Date 2021/5/20 11:32
 * @Version 1.0
 * @Email 348663490@qq.com
 */
@Data
public class BaseDrugModel {
    private Long id;
    private String num;
    private String type;
    private String typeA;
    private String typeB;
    private String drugName;
    private String norms;
    private Date time;
}
