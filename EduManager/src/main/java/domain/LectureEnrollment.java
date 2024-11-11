package domain;

public class LectureEnrollment {
    private long enrollmentId;
    private Lecture lectureId;
    private StudentDTO memberId;
    
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
    public StudentDTO getMemberId() {
        return memberId;
    }
    public void setMemberId(StudentDTO memberId) {
        this.memberId = memberId;
    }
    
    @Override
    public String toString() {
        return "LectureEnrollment [enrollmentId=" + enrollmentId + ", lectureId=" + lectureId + ", memberId=" + memberId
                + "]";
    }
}
