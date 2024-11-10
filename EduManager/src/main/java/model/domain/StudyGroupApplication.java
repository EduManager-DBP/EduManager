package model.domain;

import java.sql.Date;

public class StudyGroupApplication {
    private int studyGroupApplicationId; 
    private String status;              
    private String memberId;            
    private int studyGroupId;          
    private Date createAt;         
    
   
    public StudyGroupApplication() {
    }

    
    public StudyGroupApplication(String status, String memberId, int studyGroupId) {
        this.status = status;
        this.memberId = memberId;
        this.studyGroupId = studyGroupId;
    }

    public int getStudyGroupApplicationId() {
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

    public int getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(int studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}