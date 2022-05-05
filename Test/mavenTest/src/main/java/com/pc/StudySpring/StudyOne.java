package com.pc.StudySpring;

import base.SimpleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author foreverqisui
 * spring源码学习第一天  2022/4/26 22:00
 */
public class StudyOne {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SimpleBean bean = context.getBean(SimpleBean.class);
        bean.send();
        context.close();
    }
}
