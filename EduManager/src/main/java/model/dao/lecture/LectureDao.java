package model.dao.lecture;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

import model.dao.JDBCUtil;
import model.domain.Notice;
import model.domain.lecture.Lecture;

public class LectureDao {
    private JDBCUtil jdbcUtil = null; // JDBCUtil 필드 선언

    public LectureDao() { // 생성자
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }

    public Lecture createLecture(Lecture lecture) { // 강의 추가
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("INSERT INTO Lecture (lectureId, name, img, category, capacity, lectureLevel, createdAt, teacherId, lectureRoom, description) ");
        query.append("VALUES (SEQ_LECTURE_ID.nextval, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?) ");

        Object[] param = new Object[] {lecture.getName(), lecture.getImg(),
                lecture.getCategory(), lecture.getCapacity(), lecture.getLevel(), lecture.getTeacherId(), lecture.getLectureRoom(), lecture.getDescription()};

        jdbcUtil.setSqlAndParameters(query.toString(), param); // JDBCUtil에 질의문과 파라미터 설정

        try {
            result = jdbcUtil.executeUpdate();
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	if(rs.next()) {
		   		int generatedKey = rs.getInt(1);   // 생성된 PK 값
		   		lecture.setLectureId(generatedKey); 	// id필드에 저장  
		   	}
		   	return lecture;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return null;
    }

   
    
    // 강의 삭제 메서드
    public int deleteLecture(long lectureId) {
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("DELETE FROM Lecture WHERE lectureId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { lectureId }); // JDBCUtil에 질의문과 파라미터 설정

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
        query.append("SET name = ?, img = ?, category = ?, capacity = ?, lectureLevel = ?, lectureRoom = ?, description = ? ");
        query.append("WHERE lectureId = ?");

        Object[] param = new Object[] { lecture.getName(), lecture.getImg(), lecture.getCategory(),
                lecture.getCapacity(), lecture.getLevel(), lecture.getLectureRoom(), lecture.getDescription(), lecture.getLectureId() };

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
    
    //강의 상세 조회
    public Lecture findLectureById(long lectureId) {
    	StringBuffer query = new StringBuffer();
        query.append("SELECT name, description, img, category, capacity, lectureLevel, teacherId, createdAt, lectureroom ");
        query.append("FROM lecture ");
        query.append("WHERE lectureId = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { lectureId });

        try {
        	Lecture lecture = null;
            ResultSet rs = jdbcUtil.executeQuery(); // 질의 실행
            if (rs.next()) {
            	lecture = new Lecture();
            	lecture.setLectureId(lectureId);
            	lecture.setName(rs.getString("name"));
            	lecture.setDescription(rs.getString("description"));
            	lecture.setImg(rs.getString("img"));
            	lecture.setCategory(rs.getString("category"));
            	lecture.setCapacity(rs.getLong("capacity"));
                lecture.setLevel(rs.getInt("lectureLevel"));
            	lecture.setTeacherId(rs.getString("teacherId"));
            	lecture.setLectureRoom(rs.getInt("lectureroom"));
				/*
				 * Date sqlDate = rs.getDate("createdAt"); LocalDate localDate =
				 * sqlDate.toLocalDate(); lecture.setCreateAt(localDate);
				 */
            }
            return lecture;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return null;
    }
}
