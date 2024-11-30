package model.service;

import java.sql.SQLException;
import model.dao.lecture.LectureDao;
import model.domain.lecture.Lecture;

import java.util.List;

public class LectureManager {
    private static LectureManager instance = new LectureManager();
    private LectureDao lectureDao;

    private LectureManager() {
        lectureDao = new LectureDao();
    }

    public static LectureManager getInstance() {
        return instance;
    }

	/*
	 * public List<Lecture> findLectureList() throws SQLException{ return
	 * lectureDao.getAllLectures(); }
	 */
    
    public Lecture findLectureById(long lectureId) throws SQLException {
        return lectureDao.findLectureById(lectureId);
    }
    public Lecture createLecture(Lecture lecture) throws SQLException {
		return lectureDao.createLecture(lecture);		
	}
    public int updateLecture(Lecture lecture) throws SQLException{//, LectureNotFoundException {
		return lectureDao.updateLecture(lecture);
	}	
    
    public Lecture getLectureById(long lectureId) throws SQLException {
        return lectureDao.getLectureById(lectureId);
    }
    
    public List<Lecture> getLecturesExcludingStudent(String stuId) throws SQLException {
        return lectureDao.getLecturesExcludingStudent(stuId);
    }

}