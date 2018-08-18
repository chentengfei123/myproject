package com.ctf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcService {

    /**
     * 加载数据源
     */
    public  Connection  getJdbc(){
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://192.168.179.132:3306/test","test","123456");
        }catch (Exception e){
            System.out.print(e.getStackTrace());
        }
        return conn;
    }

}
