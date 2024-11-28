package model.dao.lecture;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.lecture.Lecture;

public class LectureDao {
    private JDBCUtil jdbcUtil = null; // JDBCUtil 필드 선언

    public LectureDao() { // 생성자
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }

    public int insertLecture(Lecture lecture) { // 강의 추가
        StringBuffer query = new StringBuffer();
        int result = 0;
        query.append("INSERT INTO Lecture (lectureId, name, img, category, capacity, level, createAt) ");
        query.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");

        Object[] param = new Object[] { lecture.getLectureId(), lecture.getName(), lecture.getImg(),
                lecture.getCategory(), lecture.getCapacity(), lecture.getLevel(), lecture.getCreateAt() };

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
        query.append("SET name = ?, img = ?, category = ?, capacity = ?, level = ?, createAt = ? ");
        query.append("WHERE lectureId = ?");

        Object[] param = new Object[] { lecture.getName(), lecture.getImg(), lecture.getCategory(),
                lecture.getCapacity(), lecture.getLevel(), lecture.getCreateAt(), lecture.getLectureId() };

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
    
    
    public List<Lecture> getAllLectures() {
        StringBuffer query = new StringBuffer();
        query.append("SELECT lectureId, name, img, category, capacity, lecturelevel, teacherId ");
        query.append("FROM Lecture");

        jdbcUtil.setSqlAndParameters(query.toString(), null); // 파라미터 없음
        List<Lecture> lectureList = new ArrayList<>(); // 결과를 담을 리스트

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 쿼리 실행
            
            while (rs.next()) {
                // 각 열의 값을 Lecture 객체에 매핑
                Lecture lecture = new Lecture();
                lecture.setLectureId(rs.getLong("lectureId"));
                lecture.setName(rs.getString("name"));
                lecture.setImg(rs.getString("img"));
                lecture.setCategory(rs.getString("category"));
                lecture.setCapacity(rs.getInt("capacity"));
                lecture.setLevel(rs.getString("lecturelevel"));

                // 로그 찍기: Lecture 객체의 각 필드 값 출력
                System.out.println("Lecture ID: " + lecture.getLectureId());
                System.out.println("Lecture Name: " + lecture.getName());
                System.out.println("Lecture Img: " + lecture.getImg());
                System.out.println("Lecture Category: " + lecture.getCategory());
                System.out.println("Lecture Capacity: " + lecture.getCapacity());
                System.out.println("Lecture Level: " + lecture.getLevel());

                lectureList.add(lecture); // 리스트에 추가
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // 리소스 해제
        }
        return lectureList; // 결과 반환
    }
    
    public Lecture getLectureById(long lectureId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT lectureId, name, img, category, capacity, lecturelevel, teacherId ");
        query.append("FROM Lecture WHERE lectureId = ?"); // lectureId로 조건 추가
       
        List<Object> params = new ArrayList<>();
        params.add(lectureId);

        Object[] paramsArray = params.toArray();

        jdbcUtil.setSqlAndParameters(query.toString(), paramsArray); 
        Lecture lecture = null;

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 쿼리 실행

            if (rs.next()) {
                // 강의 데이터가 있으면 Lecture 객체에 매핑
                lecture = new Lecture();

                String name = rs.getString("name");
                String img = rs.getString("img");
                String category = rs.getString("category");
                int capacity = rs.getInt("capacity");
                String level = rs.getString("lecturelevel");
                String teacherId = rs.getString("teacherId");

                lecture.setLectureId(lectureId); // lectureId는 메서드 파라미터로 전달받음
                lecture.setName(name);
                lecture.setImg(img);
                lecture.setCategory(category);
                lecture.setCapacity(capacity);
                lecture.setLevel(level);
                lecture.setTeacherId(teacherId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // 리소스 해제
        }

        return lecture; // 결과 반환
    }
}
