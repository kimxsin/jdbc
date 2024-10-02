package com.ohgiraffers.section02.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {

        /*  ?
        * - placeholder
        * - ? 의 갯수, 시작값 (1)*/
        Connection con = getConnection();

        // 쿼리문을 실행
        PreparedStatement pstmt = null;

        //실행 결과
        ResultSet rset = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 사번을 입력해주세요 : ");
        String empId = sc.nextLine();

        String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);



            rset = pstmt.executeQuery();

            if (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + "," + rset.getString ("EMP_NAME"));
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
