package com.guangzhou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @auther ZHS
 * @create 2020/6/27 14:18
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id; //对应数据表的BIGINT
    private String serial;
}
