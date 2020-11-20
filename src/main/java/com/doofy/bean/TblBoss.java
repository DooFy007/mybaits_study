package com.doofy.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * tbl_boss
 * @author 
 */
@Data
public class TblBoss implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    private static final long serialVersionUID = 1L;
}