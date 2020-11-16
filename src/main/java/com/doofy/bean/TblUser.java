package com.doofy.bean;

import lombok.Data;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/16
 * @Version ${Version}
 **/
@Data
public class TblUser {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;
}