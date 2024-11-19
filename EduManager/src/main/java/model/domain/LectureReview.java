package model.domain;

import model.domain.user.Student;

public class LectureReview {
    private long lectureReviewId;
    private String reviewTest;
    private Lecture lectureId;
    private Student memberId;
    
    public long getLectureReviewId() {
        return lectureReviewId;
    }
    public void setLectureReviewId(long lectureReviewId) {
        this.lectureReviewId = lectureReviewId;
    }
    public String getReviewTest() {
        return reviewTest;
    }
    public void setReviewTest(String reviewTest) {
        this.reviewTest = reviewTest;
    }
    public Lecture getLectureId() {
        return lectureId;
    }
    public void setLectureId(Lecture lectureId) {
        this.lectureId = lectureId;
    }
    public Student getMemberId() {
        return memberId;
    }
    public void setMemberId(Student memberId) {
        this.memberId = memberId;
    }
    
    @Override
    public String toString() {
        return "LectureReview [lectureReviewId=" + lectureReviewId + ", reviewTest=" + reviewTest + ", lectureId="
                + lectureId + ", memberId=" + memberId + "]";
    }
    
}
