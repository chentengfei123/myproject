package com.ctf.myproject;

import com.ctf.entity.DataDict;
import com.ctf.jpa.DataDictJpa;
import com.ctf.proxy.MyProxyView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.concurrent.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
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
            System.out.println("$$$$$$$$$$$$$$获取所有接口");
            // 获取所有接口
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Class<?>[] Interfaces=aClass.getInterfaces();
            for (Class<?> inter:Interfaces){
                System.out.println("#####开始#####"+inter+"####结束####");
            }
            System.out.println("$$$$$$$$$$$$$$获取所有父类");
            // 获取所有父类
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
            Class<?> superclass=aClass.getSuperclass();
            System.out.println("#####开始#####"+superclass+"####结束####");

            System.out.println("$$$$$$$$$$$$$$开始构造方法￥￥￥￥￥￥");
            // 获取所有的构造方法
            aClass=Class.forName("com.ctf.entity.DataDict");
            Constructor<?>[] constructors=aClass.getConstructors();
            for(Constructor<?> constructor:constructors){
                System.out.println("#####开始#####"+constructor+"####结束####");
            }
            System.out.println("$$$$$$$$$$$$$$开始获取属性");
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
            System.out.println("$$$$$$$$$$$$$$获取反射类的实例");
            // 获取当前反射所代表的类（接口）的实例
            aClass=Class.forName("com.ctf.entity.DataDict");
            Object o=aClass.newInstance();
            System.out.println(o);
            // 操作属性
            System.out.println("$$$$$$$$$$$$$$操作属性111111111");
            ((DataDict)o).setDictId("0000000");
            System.out.println(o.toString());
            Field field=aClass.getDeclaredField("keyId");
            field.setAccessible(true);
            System.out.println("$$$$$$$$$$$$$$操作属性222222222");
            field.set(o,1000001);
            System.out.println(o.toString());
            // 操作方法
            aClass=Class.forName("com.ctf.jpa.DataDictJpa");
//            Object o1=aClass.newInstance();
            Method method=aClass.getDeclaredMethod("findAll",null);
            method.setAccessible(true);
            method.invoke(null,null);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    /**
     * 通过动态代理实现接口
     */
    @Test
    public void testProxy(){
        DataDictJpa dataDictJpa=(DataDictJpa) Proxy.newProxyInstance(MyProxyView.class.getClassLoader(),new Class[]{DataDictJpa.class},new MyProxyView());
        List<DataDict> dataDicts=dataDictJpa.findAll();
    }

    /**
     * 测试CountDownLatch
     *
     */
    public  void testCountDownLatch(){
        try {
            CountDownLatch countDownLatch=new CountDownLatch(2);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程1开始执行1");
                        Thread.sleep(1);
                        System.out.println("线程1开始执行2");
                        countDownLatch.countDown();
                    }catch (Exception e){

                    }

                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程2开始执行1");
                        Thread.sleep(1);
                        System.out.println("线程2开始执行2");
                        countDownLatch.countDown();
                    }catch (Exception e){

                    }
                }
            }).start();
            countDownLatch.await();
            System.out.println("主线程结束");
        }catch (Exception e){

        }

    }

    /**
     *测试cyclicBarrier
     */
    @Test
    public  void testCyclicBarrier(){
        CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        for(int i = 0 ; i < 5 ; i++ ){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程2开始执行1");
                    try {
                        cyclicBarrier.await();
                    }catch (Exception e){

                    }
                    System.out.println("线程2全部执行完毕");
                }
            }).start();
        }
    }

    /**
     *测试Semaphore 信号量
     *
     */
    @Test
    public  void testSemaphore(){
        Semaphore semaphore=new Semaphore(3);
        for(int i = 0 ; i < 5 ; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(semaphore.availablePermits()>0){
                        System.out.println("有位置");
                    }else{
                        System.out.println("没位置");
                    }
                    try {
                        semaphore.acquire();
                        System.out.println("终于有位置了位置");
                        Thread.sleep(1000);
                        System.out.println("终于结束了");
                    }catch (Exception e){

                    }finally {
                        semaphore.release();
                    }


                }
            }).start();
        }

    }

    /**
     * 并发队列
     */
    public static void main(String[] args){
//        ConcurrentLinkedDeque concurrentLinkedDeque=new ConcurrentLinkedDeque();
//        for(int i = 0 ; i < 10 ; i ++){
//            concurrentLinkedDeque.add(i);
//        }
//        for(int i = 0 ; i < 10 ; i ++){
//            System.out.println(concurrentLinkedDeque.poll());
//        }

        // 阻塞队列
        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(5);
        for(int i = 0 ; i < 10 ; i ++){
            int size=arrayBlockingQueue.size();
            if(size == 5){
                continue;
            }
            arrayBlockingQueue.add(i);
        }
        for(int i = 0 ; i < 10 ; i ++){
            System.out.println(arrayBlockingQueue.poll());
        }
    }

}
