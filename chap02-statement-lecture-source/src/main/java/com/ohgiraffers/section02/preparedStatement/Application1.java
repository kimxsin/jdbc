package com.ohgiraffers.section02.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        /*PreparedStatment <- 준비된 statement
        * Statement 는 SQL 쿼리문을 실행할 때마다 SQL 문이
        * DBMS 에 전송이 되어 DMMS 에서 SQL 문을 파싱하고 컴파일을
        * 하는 과과정을 거치게 된다
        * PreparedStatement 는 최초에 한 번 실행했을 시 SQL 문을 파싱하고 컴파일을 하지만,
        * 동일한 SQL 구문을 여러 번 실행하게 되면
        * 최초에 컴파일한 SQL 구문을 재사용하게 된다
        * 따라서 파싱하고 컴파일하는 과정을 생략하게 되어 성능이 향상이 된다*/
        // 연결 통로
        Connection con = getConnection();

        // 쿼리문을 실행
        PreparedStatement pstmt = null;

        //실행 결과
        ResultSet rset = null;

        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE";

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + " 번" + rset.getString ("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(con);
            close(pstmt);
        }
    }

}
