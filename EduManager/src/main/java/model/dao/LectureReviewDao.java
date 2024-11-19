package model.dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.domain.LectureReview;

public class LectureReviewDao {

    private JDBCUtil jdbcUtil = new JDBCUtil();

    // 강의 리뷰 등록
    public int insertReview(LectureReview review) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO LectureReview (lectureReviewId, reviewTest, lectureId, memberId) ");
        query.append("VALUES (?, ?, ?, ?)");

        Object[] params = new Object[] {
            review.getLectureReviewId(),
            review.getReviewTest(),
            review.getLectureId().getLectureId(), // Lecture 객체에서 ID 추출
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

    // 강의 리뷰 삭제
    public int deleteReview(long lectureReviewId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM LectureReview WHERE lectureReviewId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {lectureReviewId});

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

    // 강의 리뷰 수정
    public int updateReview(LectureReview review) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE LectureReview ");
        query.append("SET reviewTest = ?, lectureId = ?, memberId = ? ");
        query.append("WHERE lectureReviewId = ?");

        Object[] params = new Object[] {
            review.getReviewTest(),
            review.getLectureId().getLectureId(), // Lecture 객체에서 ID 추출
            review.getLectureReviewId()
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

    // 강의 리뷰 조회 (특정 강의 ID 기준)
    public List<LectureReview> getReviewsByLectureId(long lectureId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT * FROM LectureReview WHERE lectureId = ?");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {lectureId});

        List<LectureReview> reviews = new ArrayList<>();
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                LectureReview review = new LectureReview();
                review.setLectureReviewId(rs.getLong("lectureReviewId"));
                review.setReviewTest(rs.getString("reviewTest"));
                // Lecture 및 StudentDTO 로드는 필요 시 추가 가능
                reviews.add(review);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return reviews;
    }
}