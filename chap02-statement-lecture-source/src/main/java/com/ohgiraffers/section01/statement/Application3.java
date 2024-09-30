package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {

    public static void main(String[] args) {

        /* title. Scanner 사용해서 사번을 입력받고, 해당 사번의 사원 정보를
         *       EmployeeDTO 를 통해 객체에 담아서 출력 */
        // 1. 커넥션 만들기
        Connection con = getConnection();
        // 2. statement 객체 만들기
        Statement stmt = null;
        // 3. 결과를 담을 resultset 만들기
        ResultSet rset = null;
        // 4. EmployeeDTO null로 초기화
        EmployeeDTO emp = null;
        // 5. 스캐너 생성
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사번을 입력해주세요 : ");
        // 6. 스캐너 사번 입력
        String empId = sc.nextLine();
        // 7. 쿼리문 작성
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
        // 8. 예외처리
        try {
            stmt = con.createStatement();
            // 9. rset 에 결과 담기
            rset = stmt.executeQuery(query);
            // 10. 조회한 결과를 객체에 담기
            if (rset.next()) {
                emp = new EmployeeDTO();

                emp.setEmpId(rset.getString("EMP_ID"));
                emp.setEmpName(rset.getString("EMP_NAME"));
                emp.setEmpNo(rset.getString("EMP_NO"));
                emp.setEmail(rset.getString("EMAIL"));
                emp.setPhone(rset.getString("PHONE"));
                emp.setDeptCode(rset.getString("DEPT_CODE"));
                emp.setJobCode(rset.getString("JOB_CODE"));
                emp.setSalLevel(rset.getString("SAL_LEVEL"));
                emp.setSalary(rset.getInt("SALARY"));
                emp.setBonus(rset.getDouble("BONUS"));
                emp.setManagerId(rset.getString("MANAGER_ID"));
                emp.setHireDate(rset.getDate("HIRE_DATE"));
                emp.setEntDate(rset.getDate("ENT_DATE"));
                emp.setEntYn(rset.getString("ENT_YN"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
        System.out.println("emp = " + emp);

    }
}
