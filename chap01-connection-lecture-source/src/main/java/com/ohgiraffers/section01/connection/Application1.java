package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {
        /*DB 접속을 위한 connection 인스턴스 생성*/
        // finally 블럭에서 자원해제를 위한 과정
        Connection con = null;
        /*사용할 드라이버 등록*/
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /*connection 객체는 인터페이스이기 떄문에
            * 직접적으로 인스턴스 생성이 불가능하디.*/
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost/employee","ohgiraffers", "ohgiraffers");
                System.out.println("con = " + con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
