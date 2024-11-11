package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Lecture;


public class LectureDao {
    private JDBCUtil jdbcUtil = null;   // JDBCUtil 필드 선언
    
    public LectureDao() {               // 생성자 
        jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
    }

 
    public int insertLecture(Lecture lecture) { // 강의 추가 
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("INSERT INTO Lecture (lectureId, name, img, category, capacity, level, createAt) ");
        query.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
        
        Object[] param = new Object[] {lecture.getLectureId(), lecture.getName(), lecture.getImg(), lecture.getCategory(), lecture.getCapacity(), lecture.getLevel(), lecture.getCreateAt()};
        
        jdbcUtil.setSqlAndParameters(query.toString(), param); // JDBCUtil에 질의문과 파라미터 설정   
        
        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
        }
        return result;
    } 

 // 강의 삭제 메서드
    public int deleteLecture(long lectureId) {
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("DELETE FROM Lecture WHERE lectureId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {lectureId}); // JDBCUtil에 질의문과 파라미터 설정

        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return result;
    }

    // 강의 수정 메서드
    public int updateLecture(Lecture lecture) {
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("UPDATE Lecture ");
        query.append("SET name = ?, img = ?, category = ?, capacity = ?, level = ?, createAt = ? ");
        query.append("WHERE lectureId = ?");

        Object[] param = new Object[] {
            lecture.getName(),
            lecture.getImg(),
            lecture.getCategory(),
            lecture.getCapacity(),
            lecture.getLevel(),
            lecture.getCreateAt(),
            lecture.getLectureId()
        };

        jdbcUtil.setSqlAndParameters(query.toString(), param); // JDBCUtil에 질의문과 파라미터 설정

        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return result;
    }
}
