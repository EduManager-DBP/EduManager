package model.domain.lecture;

import java.sql.Date;

public class Lecture {
    private long lectureId;
    private String name;
    private String img;
    private String category;
    private long capacity;
    private int level;
    private String description;
    private Date createAt;
    private String teacherId;
    private String teacherName;
    private Integer lectureRoom;
    //전화번호


	 public Lecture() {}
	 
	 
    public Lecture(long lectureId, String name, String img, String category, long capacity, int level,
			String description, Date createAt, String teacherId, String teacherName, Integer lectureRoom) {
		super();
		this.lectureId = lectureId;
		this.name = name;
		this.img = img;
		this.category = category;
		this.capacity = capacity;
		this.level = level;
		this.description = description;
		this.createAt = createAt;
		this.setTeacherId(teacherId);
		this.setTeacherName(teacherName);
		this.lectureRoom = lectureRoom;
	}
	public Lecture(String name, String img, String category, long capacity, int level, String description,
			String teacherId, Integer lectureRoom) {
		super();
		this.name = name;
		this.img = img;
		this.category = category;
		this.capacity = capacity;
		this.level = level;
		this.description = description;
		this.setTeacherId(teacherId);
		this.lectureRoom = lectureRoom;
	}
	
	

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }





	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(Integer lectureRoom) {
		this.lectureRoom = lectureRoom;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

}
