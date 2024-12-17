package model.dao.lecture;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.JDBCUtil;

public class LectureLikeDao {
    private JDBCUtil jdbcUtil = new JDBCUtil();
    
    public boolean isLikedByUser(String memberId, long lectureId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM LectureLike WHERE stuId = ? AND lectureId = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{memberId, lectureId});

        ResultSet rs = jdbcUtil.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // 좋아요가 있으면 true, 없으면 false
        }
        return false;
    }

    // 좋아요 추가
    public void addLike(String memberId, long lectureId) throws SQLException {
        String sql = "INSERT INTO LectureLike (lectureLikeId, createAt, lectureId, stuId) "
                     + "VALUES (SEQ_STUDY_GROUP_LIKE_ID.nextval, SYSDATE, ?, ?)";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{lectureId, memberId});
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // resource 반환
        }
    }

    // 좋아요 삭제
    public void removeLike(String memberId, long lectureId) throws SQLException {
        String sql = "DELETE FROM LectureLike WHERE lectureId = ? AND stuId = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{lectureId, memberId});
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close(); // resource 반환
        }
    }
}
