package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lab4.Appointment;
import lab4.Department;
import lab4.Employee;
import util.JDBCUtil;

public class LectureDao {
    private JDBCUtil jdbcUtil = null;   // JDBCUtil 필드 선언
    
    public LectureDao() {               // 생성자 
        jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
        
/*      // JDBCUtil 이용 시 불필요: DBCP 활용       
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");   
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
*/
    }

/*  // JDBCUtil 이용 시 불필요: 내부적으로 connection 생성 및 사용 
    private Connection getConnection() {
        String url = "jdbc:oracle:thin:@dblab.dongduk.ac.kr:1521/orclpdb";      
        String user = "scott2";
        String passwd = "TIGER";

        // DBMS와의 연결 획득
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        return conn;
    }
*/
    
    public Department findDeptByName(String deptName) {
        /* 실습 #3의 printDeptInfo()를 변형. 
         * 부서정보 검색 후 Department DTO를 생성하고 검색 결과를 저장해서 return함
         * (검색 결과가 없을 경우 null을 반환) 
         */
        StringBuffer query = new StringBuffer();
        query.append("SELECT deptno, manager, COUNT(empno) AS numOfEmps ");
        query.append("FROM EMP0979 JOIN DEPT0979 USING (deptno) ");
        query.append("WHERE dname = ? ");
        query.append("GROUP BY deptno, manager");
        
        ResultSet rs = null;
        Department dept = null;
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{deptName}); // JDBCUtil에 질의문과 파라미터 설정   
        
        try {
            rs = jdbcUtil.executeQuery();
            
            if (rs.next()) {        // 검색 결과 존재
                dept = new Department();
                
                dept.setDeptNo(rs.getInt("deptno"));
                dept.setMgrNo(rs.getInt("manager"));
                dept.setNumOfEmps(rs.getInt("numOfEmps"));
                
                return dept;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
        }
        return null;
    } 

    public List<Employee> getAllEmpsInDept(int deptNo) {
        /* 실습 #3의 printAllEmpsInDept()를 변형.
         * ArrayList<Employee> 타입 객체를 생성한 후, 검색된 각 사원 정보에 대해
         * Employee DTO를 생성 및 저장하고 List 객체에 추가함. List 객체를 반환함
         */
        StringBuffer query = new StringBuffer();
        query.append("SELECT empno, ename, job, hiredate, sal, comm, deptNo ");
        query.append("FROM EMP0979 JOIN DEPT0979 USING (deptno) ");
        query.append("WHERE deptNo = ?");   
        query.append("ORDER BY empno ");

        ResultSet rs = null;

        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{deptNo});   // JDBCUtil에 질의문과 파라미터 설정   

        try {           
            rs = jdbcUtil.executeQuery();

            List<Employee> empList = new ArrayList<Employee>();   
            

            while (rs.next()) {     // 커서를 통해 결과 행들을 하나씩 fetch
                Employee emp = new Employee();
                emp.setEmpNo(rs.getInt("empNo"));
                emp.seteName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setHireDate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDeptNo(rs.getInt("deptNo"));
                empList.add(emp);
             } 
            return empList;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
        }
        return null;
    }

    public Employee replaceManagerOfDept(Appointment appo) {
        /* 실습 #3의 replaceManagerOfDept()와 유사하나, 매개변수 전달을 위해 Appointment
         * DTO를 이용하고, 실행 결과로 기존 관리자 사원 정보를 포함하는 Employee DTO를 반환함
         */     
        // (부서번호, 새 관리자 번호, 새관리자 수당) 
        // String query1 = "SELECT manager FROM DEPT0979 WHERE deptNo = ?";
        StringBuffer query1 = new StringBuffer();
        query1.append("SELECT manager FROM DEPT0979 WHERE deptno = ?");
        jdbcUtil.setSqlAndParameters(query1.toString(), new Object[]{appo.getDeptNo()});    // JDBCUtil에 질의문과 파라미터 설정   
        int oldMgrNo = 0;
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if(rs.next()) {
                oldMgrNo = rs.getInt("manager"); // 기존 관리자 사번 
            } else {
                throw new SQLException("No Manager");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        
         // 기존 관리자의 정보 
        StringBuffer query2 = new StringBuffer();
        query2.append("SELECT empno, ename, job, hiredate, sal, comm, deptNo ");
        query2.append("FROM EMP0979 JOIN DEPT0979 USING (deptno) ");
        query2.append("WHERE deptno = ? ");
        jdbcUtil.setSqlAndParameters(query2.toString(), new Object[]{oldMgrNo});    // JDBCUtil에 질의문과 파라미터 설정   
        
        ResultSet rs1 = null;
        Employee emp = null;

        try {
            rs1 = jdbcUtil.executeQuery(); 
            if(rs1.next()) {
                emp = new Employee();
                emp.setEmpNo(rs1.getInt("empno"));
                emp.seteName(rs1.getString("ename"));
                emp.setJob(rs1.getString("job"));
                emp.setHireDate(rs1.getDate("hiredate"));
                emp.setSal(rs1.getDouble("sal"));
                emp.setComm(rs1.getDouble("comm"));
                emp.setDeptNo(rs1.getInt("deptNo"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        
        
        // 기존 관리자의 (M) 없애기 
        StringBuffer update1 = new StringBuffer();
        update1.append("UPDATE EMP0979 ");
        update1.append("SET ename = REPLACE(ename, '(M)', '') "); //   
        update1.append("WHERE empno = ?");              
        jdbcUtil.setSqlAndParameters(update1.toString(), new Object[]{oldMgrNo});   // JDBCUtil에 질의문과 파라미터 설정   
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        
        // 새로운 관리에 수당 더하고 관리자로 지정 
        StringBuffer update2 = new StringBuffer();
        update2.append("UPDATE EMP0979 ");
        update2.append("SET ename = ename || '(M)', comm = NVL(comm, 0) + ? ");
        update2.append("WHERE empno = ? ");
        Object[] param = new Object[] {appo.getNewComm(), appo.getNewManagerNo()};
        jdbcUtil.setSqlAndParameters(update2.toString(), param);    // JDBCUtil에 질의문과 파라미터 설정   
        
        try {
            jdbcUtil.executeUpdate();            
        } catch (Exception ex) {
            jdbcUtil.rollback();    // 트랜잭션 rollback 실행
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();      // 트랜잭션 commit 실행
            jdbcUtil.close();
        }
        
        // 관리자 변경  
        String update3 = "UPDATE DEPT0979 SET manager = ? WHERE deptNo = ?"; 
        Object[] param1 = new Object[] {appo.getNewManagerNo(), appo.getDeptNo()};
        jdbcUtil.setSqlAndParameters(update3.toString(), param1);   // JDBCUtil에 질의문과 파라미터 설정   
        
        try {
            jdbcUtil.executeUpdate();            
        } catch (Exception ex) {
            jdbcUtil.rollback();    // 트랜잭션 rollback 실행
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();      // 트랜잭션 commit 실행
            jdbcUtil.close();
        }
        
        
       return emp;
    }
    
    public Employee findEmpInfo(int empNo) {
        /* 실습 #3의 printEmpInfo()를 변형
         * 주어진 사번에 해당하는 사원 정보를 검색 후 Employee DTO를 생성 및 저장하고 반환함
         * (검색 결과가 없을 경우 null 을 반환) 
         */ 
        StringBuffer query = new StringBuffer();
        query.append("SELECT ename, job, hiredate, sal, comm, deptNo "); 
        query.append("FROM EMP0979 WHERE empno = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{empNo});    // JDBCUtil에 질의문과 파라미터 설정   

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            Employee emp = new Employee(rs.getInt("empNo"), rs.getString("ename"), rs.getString("job"), rs.getDate("hiredate"), rs.getDouble("sal"), rs.getDouble("comm"), rs.getInt("deptNo"));
                
            return emp; 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }
}
