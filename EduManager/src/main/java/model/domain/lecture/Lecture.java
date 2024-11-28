package model.domain.lecture;

import java.sql.Date;

public class Lecture {
    private long lectureId;
    private String name;
    private String img;
    private String category;
    private long capacity;
    private String level;
    private Date createAt;
    private String teacherId;

    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId=teacherId;
        
    }
    
    @Override
    public String toString() {
        return "Lecture [lectureId=" + lectureId + ", name=" + name + ", img=" + img + ", category=" + category
                + ", capacity=" + capacity + ", level=" + level + ", createAt=" + createAt + "]";
    }

  

}
