package model.domain;

import model.domain.user.Student;

public class LectureEnrollment {
    private long enrollmentId;
    private Lecture lectureId;
    private Student memberId;
    
    public long getEnrollmentId() {
        return enrollmentId;
    }
    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
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
        return "LectureEnrollment [enrollmentId=" + enrollmentId + ", lectureId=" + lectureId + ", memberId=" + memberId
                + "]";
    }
}
