package com.doofy.bean;

import lombok.Data;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/17
 * @Version ${Version}
 **/
@Data
public class TblStudent {
    private Integer id;

    private String name;

    private Integer tid;

    private TblTeacher teachers;
}