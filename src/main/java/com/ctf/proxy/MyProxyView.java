package com.ctf.proxy;

import com.ctf.jdbc.JdbcService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyProxyView implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        try {
            PreparedStatement pstmt=null;
            String name=method.getName();
            Class<?> aClass=method.getReturnType();
            JdbcService jdbcService=new JdbcService();
            Connection con = jdbcService.getJdbc();
            if("findAll".equals(name)){
                 pstmt=con.prepareStatement("select * from ga_data_dict");
                ResultSet rs=pstmt.executeQuery();
                int col = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= col; i++) {
                        System.out.print(rs.getString(i) + "\t");
                        if ((i == 2) && (rs.getString(i).length() < 8)) {
                            System.out.print("\t");
                        }
                    }
                    System.out.println("");
                }
            }
            pstmt.close();
            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
