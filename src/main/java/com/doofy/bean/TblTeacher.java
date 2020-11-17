package com.doofy.bean;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ${ClassName}
 * @Description: ${Description}
 * @Author DooFy
 * @Date 2020/11/17
 * @Version ${Version}
 **/
@Data
public class TblTeacher {
    private Integer id;

    private String name;

    private List<TblStudent> students;
}