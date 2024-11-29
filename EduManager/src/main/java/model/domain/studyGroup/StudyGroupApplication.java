package model.domain;

import java.sql.Date;

public class StudyGroupApplication {
    private long studyGroupApplicationId; 
    private String status;              
    private String memberId;            
    private long studyGroupId;          
    private Date createAt;         
    
   
    public StudyGroupApplication() {
    }

    
    public StudyGroupApplication(String status, String memberId, long studyGroupId) {
        this.status = status;
        this.memberId = memberId;
        this.studyGroupId = studyGroupId;
    }

    public long getStudyGroupApplicationId() {
        return studyGroupApplicationId;
    }

    public void setStudyGroupApplicationId(int studyGroupApplicationId) {
        this.studyGroupApplicationId = studyGroupApplicationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public long getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(long studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}