package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application2 {

    public static void main(String[] args) {

        /* index 1. Connection 연결 통로 생성 */
        Connection con = getConnection();

        /* index 2. 통로를 통해 실행시킬 Query 문을 담을객체 생성 */
        Statement stmt = null;

        /* index 3. 실행 된 Query 결과를 담을 객체 생성 */
        ResultSet rset = null;

        try {
            /* index 4. Connection 의 createStatement() 를 통한 인스턴스 생성 */
            stmt = con.createStatement();

            Scanner sc = new Scanner(System.in);
            System.out.println("조회하실 사번을 입력해주세요 : ");
            String empId = sc.nextLine();
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            /*5. executeQuery() 로 쿼리문을 싱행하고 결과를 resultset 으로 반환*/
            rset = stmt.executeQuery(query);

            /*6. resultset 에 담긴 결과 집합을 next() 반복으로 출력
            **/
            if(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + "번" + rset.getString("EMP_NAME"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            /*사용한 자원 반납*/
            close(con);
            close(rset);
            close(stmt);
        }


    }




}
