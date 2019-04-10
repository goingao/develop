package com.goingao.develop.toolkit.spring;

import com.goingao.develop.domain.Animal;
import com.goingao.develop.domain.Person;
import org.springframework.beans.BeanUtils;

/**
 * orika功能很强，但是不利于代码阅读
 * spring 的 beanUtils 不同的属性名，需要手动 getset，性能也不会太差
 *
 * @author goingao
 * @date 2019-04-10
 */
public class BeanUtil {
    public static void main(String[] args) {
        Person person = Person.builder().id("1").age(18).name("goingao").build();
        Animal animal = new Animal();
        BeanUtils.copyProperties(person, animal);
        System.out.println(animal.toString());
        animal.setPkId(person.getId());
        System.out.println(animal.toString());
    }
}
