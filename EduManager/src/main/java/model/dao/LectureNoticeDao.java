package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.domain.LectureNotice;

public class LectureNoticeDao {

    private JDBCUtil jdbcUtil = new JDBCUtil();

    // 공지사항 추가
    public int insertNotice(LectureNotice notice) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO LectureNotice (lectureNoticeId, createAt, title, description) ");
        query.append("VALUES (?, ?, ?, ?)");

        Object[] params = new Object[] {
            notice.getLectureNoticeId(),
            notice.getCreateAt(),
            notice.getTitle(),
            notice.getDescription()
        };

        jdbcUtil.setSqlAndParameters(query.toString(), params);

        int result = 0;
        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return result;
    }

    // 공지사항 삭제
    public int deleteNotice(long lectureNoticeId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM LectureNotice WHERE lectureNoticeId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {lectureNoticeId});

        int result = 0;
        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return result;
    }

    // 공지사항 수정
    public int updateNotice(LectureNotice notice) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE LectureNotice ");
        query.append("SET createAt = ?, title = ?, description = ? ");
        query.append("WHERE lectureNoticeId = ?");

        Object[] params = new Object[] {
            notice.getCreateAt(),
            notice.getTitle(),
            notice.getDescription(),
            notice.getLectureNoticeId()
        };

        jdbcUtil.setSqlAndParameters(query.toString(), params);

        int result = 0;
        try {
            result = jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return result;
    }

    // 공지사항 조회 (특정 공지사항 ID 기준)
    public LectureNotice getNoticeById(long lectureNoticeId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM LectureNotice WHERE lectureNoticeId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {lectureNoticeId});

        LectureNotice notice = null;
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                notice = new LectureNotice();
                notice.setLectureNoticeId(rs.getLong("lectureNoticeId"));
                notice.setCreateAt(rs.getDate("createAt"));
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return notice;
    }

    // 공지사항 목록 조회 (전체 공지)
    public List<LectureNotice> getAllNotices() {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM LectureNotice");

        jdbcUtil.setSqlAndParameters(query.toString(), null);

        List<LectureNotice> notices = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                LectureNotice notice = new LectureNotice();
                notice.setLectureNoticeId(rs.getLong("lectureNoticeId"));
                notice.setCreateAt(rs.getDate("createAt"));
                notice.setTitle(rs.getString("title"));
                notice.setDescription(rs.getString("description"));
                notices.add(notice);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return notices;
    }
}