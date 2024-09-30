package com.ohgiraffers.model.dto;

import java.sql.Date;

public class EmployeeDTO {


    /*DTD
    * 여러 계층 간의 데이터 전송을 위해 다양한 타입의 데이터를
    * 하나로 묶어주기 위한 클래스
    * 유사어로 DTO, VO, ENTITY 등등이 있다.
    * 1. 기본생성자
    * 2. getter/setter
    * 3. to string() 오버라이딩
    * 4. 모든 필드 초기화하는 생성자
    * 5. 필드 캡슐화 즉 private
    * DTO 필드 구성 예
    * 화면 위주로 구성
    * 데이터 베이스 기반으로 구성
    * */
    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private String salary;
    private String bonus;
    private String managerId;
    private Date hireDate;
    private Date enteDate;
    private String entYn;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public void setSalLevel(String salLevel) {
        this.salLevel = salLevel;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getEnteDate() {
        return enteDate;
    }

    public void setEnteDate(Date enteDate) {
        this.enteDate = enteDate;
    }

    public String getEntYn() {
        return entYn;
    }

    public void setEntYn(String entYn) {
        this.entYn = entYn;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", enteDate=" + enteDate +
                ", entYn='" + entYn + '\'' +
                '}';
    }

    public EmployeeDTO(String empId, String empName, String empNo, String email, String phone, String deptCode, String jobCode, String salLevel, String salary, String bonus, String managerId, Date hireDate, Date enteDate, String entYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.enteDate = enteDate;
        this.entYn = entYn;




    }
}
