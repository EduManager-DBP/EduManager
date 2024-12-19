package model.domain;

import java.time.LocalDate;

public class Assignment {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private LocalDate createat;
    private String textFile;
    private int lectureId;
    private int studyId;

    
    public Assignment(){}

    public Assignment(int id, String title, String description, LocalDate dueDate, LocalDate createat, String textFile,
            int lectureId) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.createat = createat;
        this.textFile = textFile;
        this.lectureId = lectureId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public LocalDate getCreateat() {
        return createat;
    }


    public void setCreateat(LocalDate createat) {
        this.createat = createat;
    }


    public String getTextFile() {
        return textFile;
    }


    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }


    public int getLectureId() {
        return lectureId;
    }


    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }


    @Override
    public String toString() {
        return "Assignment [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
                + ", createat=" + createat + ", textFile=" + textFile + ", lectureId=" + lectureId + "]";
    }

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}
    

}
