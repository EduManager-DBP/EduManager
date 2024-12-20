package model.dao.studygroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.Assignment;
import model.domain.Notice;

import java.sql.Date;
import java.time.LocalDate;

public class StudyNoticeDao {
    private JDBCUtil jdbcUtil = null; // JDBCUtil 필드 선언

    public StudyNoticeDao() { // 생성자
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }

    // 공지 생성
    public void createNotice(int studygroupid, String title, String description, LocalDate createdAt) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO studynotice (studynoticeid, studygroupid, title, description, createat) ");
        query.append("VALUES (SEQ_STUDY_NOTICE_ID.nextval, ?, ?, ?, ?)");

        // SQL 쿼리와 매개변수 설정
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { studygroupid, title, description, createdAt});

        try {
            int rs = jdbcUtil.executeUpdate(); // 질의 실행 (INSERT문은 executeUpdate로 실행)
            if (rs > 0) {
                System.out.println("공지사항이 성공적으로 생성되었습니다.");
            } else {
                System.out.println("공지 생성에 실패했습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // 연결 자원 해제
        }
    }

    // 공지 상세 조회
    public Notice findNoticeById(int noticeId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT studynoticeid, studygroupid, title, description, createat ");
        query.append("FROM studynotice ");
        query.append("WHERE studynoticeid = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { noticeId });

        try {
            Notice notice = null;
            ResultSet rs = jdbcUtil.executeQuery(); // 질의 실행
            if (rs.next()) {
                notice = new Notice();
                notice.setId(noticeId);
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
                notice.setStudyId(rs.getInt("studygroupid"));
                
                Date sqlDate = rs.getDate("createat");
                LocalDate localDate = sqlDate.toLocalDate();
                notice.setCreateat(localDate);
            }
            return notice;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return null;
    }

    // 강의 아이디로 강의 공지 목록 조회
    public List<Notice> findNoticesBystudygroupid(int studygroupid) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT studynoticeid, title, description, createat ");
        query.append("FROM studynotice ");
        query.append("WHERE studygroupid = ? ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { studygroupid });
        List<Notice> notices = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 질의 실행
            while (rs.next()) {
                Notice notice = new Notice();
                notice.setId(rs.getInt("studynoticeid"));
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
                notice.setStudyId(studygroupid);
                
                Date sqlDate = rs.getDate("createat");
                LocalDate localDate = sqlDate.toLocalDate();
                notice.setCreateat(localDate);

                notices.add(notice); // 리스트에 공지 추가
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }

        return notices;
    }
    
    public List<Notice> searchNotices(int studygroupid, String searchParam) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT studynoticeid, title, description, createat ");
        query.append("FROM studynotice ");
        query.append("WHERE studygroupid = ? ");

        if (searchParam != null && !searchParam.trim().isEmpty()) {
            query.append("AND (title LIKE ? OR description LIKE ?) ");
        }

        List<Object> params = new ArrayList<>();
        params.add(studygroupid); // studygroupid 추가

        if (searchParam != null && !searchParam.trim().isEmpty()) {
            params.add("%" + searchParam + "%"); // 제목 검색 조건
            params.add("%" + searchParam + "%"); // 내용 검색 조건
        }

        jdbcUtil.setSqlAndParameters(query.toString(), params.toArray()); // SQL과 파라미터 설정
        List<Notice> notices = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 쿼리 실행
            while (rs.next()) {
                Notice notice = new Notice();
                notice.setId(rs.getInt("studynoticeid"));
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
                notice.setStudyId(studygroupid);

                Date sqlDate = rs.getDate("createat");
                LocalDate localDate = sqlDate.toLocalDate();
                notice.setCreateat(localDate);

                notices.add(notice); // 리스트에 공지 추가
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }

        return notices;
    }
    
 // 강의 아이디로 강의 공지 목록 조회
    public List<Notice> findNoticesByStudyIdAndDueDate(int studygroupid, LocalDate createdAt) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT studynoticeid, title, description, createat ");
        query.append("FROM studynotice ");
        query.append("WHERE studygroupid = ? AND TRUNC(createat) = ?");

        java.sql.Date sqlDueDate = java.sql.Date.valueOf(createdAt);
        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { studygroupid, sqlDueDate });
        List<Notice> notices = new ArrayList<>();

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 질의 실행
            while (rs.next()) {
                Notice notice = new Notice();
                notice.setId(rs.getInt("studynoticeid"));
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
                notice.setStudyId(studygroupid);
                notice.setCreateat(rs.getDate("createat").toLocalDate());

                notices.add(notice); // 리스트에 공지 추가
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }

        return notices;
    }

    // 공지 삭제
    public void deleteNoticeById(int noticeId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM studynotice ");
        query.append("WHERE studynoticeid = ?");

        // SQL 쿼리와 매개변수 설정
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { noticeId });

        try {
            int rs = jdbcUtil.executeUpdate(); // DELETE 문은 executeUpdate로 실행
            if (rs > 0) {
                System.out.println("공지사항이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("공지 삭제에 실패했습니다. 해당 ID의 공지가 존재하지 않습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // 연결 자원 해제
        }
    }

    // 공지 수정
    public void updateNotice(int noticeId, String title, String description) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE studynotice ");
        query.append("SET title = ?, description = ? ");
        query.append("WHERE studynoticeid = ?");

        // SQL 쿼리와 매개변수 설정
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { title, description, noticeId });

        try {
            int rs = jdbcUtil.executeUpdate(); // UPDATE 문은 executeUpdate로 실행
            if (rs > 0) {
                System.out.println("공지사항이 성공적으로 업데이트되었습니다.");
            } else {
                System.out.println("공지 업데이트에 실패했습니다. 해당 ID의 공지가 존재하지 않습니다.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // 연결 자원 해제
        }
    }
}
