package model.domain;

import java.sql.Date;

public class StudyGroup {
    
    private long studyGroupId;   
    private String name;        
    private String img;         
    private String description;  
    private long capacity;       
    private String category;    
    private Date createAt;
    private String leaderId;     

 
    public StudyGroup() {}

  
    public long getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(long studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public String toString() {
        return "StudyGroup [studyGroupId=" + studyGroupId + ", name=" + name + ", img=" + img + ", description="
                + description + ", capacity=" + capacity + ", category=" + category + ", createAt=" + createAt
                + ", leaderId=" + leaderId + "]";
    }
}