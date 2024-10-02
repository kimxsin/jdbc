package com.ohgiraffers.section02.preparedStatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application5 {
    public static void main(String[] args) {


        Connection con = getConnection();

        PreparedStatement pstmt = null;

        ResultSet rset = null;

        List<EmployeeDTO> empList = null;

        // 1명의 회원정보를 관리할 EmployeeDTO 사용
        EmployeeDTO emp = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("조회하실 이름을 입력해주세요 : ");
        String empName = sc.nextLine();

        // 프로퍼티 파일에 SQL 문 작성
        Properties prop = new Properties();



        try {

            try {
                prop.loadFromXML(
                        new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml")
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String query = prop.getProperty("selectByFamilyName");
                System.out.println("query = " + query);
                

            pstmt = con.prepareStatement(query);
            pstmt.setString(1,empName);
            
            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while(rset.next()) {
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
                empList.add(emp);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(con);
            close(pstmt);
        }
        for(EmployeeDTO empDTO : empList) {
            System.out.println("이름 = " + empDTO);

        }
    }
}
