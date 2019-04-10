package com.goingao.develop.domain;

import lombok.Builder;
import lombok.Data;

/**
 * FIXME
 *
 * @author goingao
 * @date 2019-04-10
 */
@Data
@Builder
public class Person {
    private String id;
    private int age;
    private String name;
}
