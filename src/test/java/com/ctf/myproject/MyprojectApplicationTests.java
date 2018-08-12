package com.ctf.myproject;

import com.ctf.entity.DataDict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyprojectApplicationTests {

    @Test
    public void contextLoads() {
        Map map=new HashMap();
        map.put("","");
    }

    /**
     * 反射获取类
     */
    @Test
    public void testReflection(){
        try {
            // 1、通过Class.forName() 获取类
            Class<?> aClass1=Class.forName("com.ctf.entity.DataDict");
            System.out.println(aClass1);
        }catch (Exception e){

        }

        // 2、通过类名.class 获取
        Class<?> aClass2 = DataDict.class;
        System.out.println(aClass2);
        // 3、通过对象.getClass 获取
        DataDict dataDict=new DataDict();
        Class<?> aClass3 = dataDict.getClass();
        System.out.println(aClass3);
    }

    /**
     * 反射获取方法
     */
    @Test
    public void testReflectMethod(){
        try {
            // 获取所有的公共方法(包含父类)
            Class<?> aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Method[] methods=aClass.getMethods();
            for (Method method:methods){
                System.out.println("#####开始#####"+method+"####结束####");
            }
            // 获取当前类的所有方法（忽略修饰符、不包括父类）
            System.out.println("$$$$$$$$$$$$$$");
            // 获取所有接口
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Class<?>[] Interfaces=aClass.getInterfaces();
            for (Class<?> inter:Interfaces){
                System.out.println("#####开始#####"+inter+"####结束####");
            }
            System.out.println("$$$$$$$$$$$$$$");
            // 获取所有父类
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Class<?> superclass=aClass.getSuperclass();
            System.out.println("#####开始#####"+superclass+"####结束####");

            // 获取所有的构造方法

            // 获取所有的公共属性
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Field[] fields1=aClass.getFields();
            for (Field field:fields1){
                System.out.println("#####开始#####"+field+"####结束####");
            }
            // 获取改类（接口）的属性
            aClass=Class.forName("com.ctf.entity.DataDict");
            Field[] fields2=aClass.getDeclaredFields();
            for (Field field:fields2){
                System.out.println("#####开始#####"+field+"####结束####");
            }
            System.out.println("$$$$$$$$$$$$$$");
            // 获取当前反射所代表的类（接口）的实例
            aClass=Class.forName("com.ctf.entity.DataDict");
            Object o=aClass.newInstance();
            System.out.println(o);

        }catch (Exception e){

        }
    }
}
