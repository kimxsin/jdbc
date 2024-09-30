package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        /*쿼리문을 저장하고 실행할 수 있는 기능을 하는 인터페이스
        * Statement*/

        Statement stmt = null;

        /*select 결과 집합을 받아올 수 있는 인터페이스
        * ResultSet*/

        ResultSet rset = null;

        try {
            stmt = con.createStatement(); // connection 인스턴스 생성
           rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

             while (rset.next()) {
                 /*next() : resultset 을 목록화시켜 행이 존재하면 true
                 * 존재 하니 않으면 false 를 반환한다*/
                 System.out.println(rset.getString("EMP_ID") + "번" + rset.getString("EMP_NAME"));
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(rset);
            close(stmt);
        }


    }
}
