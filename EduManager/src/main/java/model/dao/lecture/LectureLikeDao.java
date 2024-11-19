package model.dao.lecture;

import model.dao.JDBCUtil;
import model.domain.lecture.LectureLike;

public class LectureLikeDao {
    private JDBCUtil jdbcUtil = new JDBCUtil();

    // 좋아요 추가
    public int insertLike(LectureLike like) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO LectureLike (lectureLikeId, createAt, lectureId, memberId) ");
        query.append("VALUES (?, ?, ?, ?)");

        Object[] params = new Object[] { like.getLectureLikeId(), like.getCreateAt(),
                like.getLectureId().getLectureId(), // Lecture 객체에서 ID 추출
                // like.getMemberId().getMemberId() // StudentDTO 객체에서 ID 추출
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

    // 좋아요 삭제
    public int deleteLike(long lectureLikeId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM LectureLike WHERE lectureLikeId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] { lectureLikeId });

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
}
