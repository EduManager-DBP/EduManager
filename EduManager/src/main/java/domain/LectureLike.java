package domain;

import java.sql.Date;

public class LectureLike {
    private long lectureLikeId;
    private Date createAt;
    private Lecture lectureId;
    private StudentDTO memberId;
    
    public long getLectureLikeId() {
        return lectureLikeId;
    }
    public void setLectureLikeId(long lectureLikeId) {
        this.lectureLikeId = lectureLikeId;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
    
    
}
