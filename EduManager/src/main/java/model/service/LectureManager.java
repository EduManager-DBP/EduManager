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

    public List<Lecture> findLectureList() throws SQLException{
        return lectureDao.getAllLectures();
    }
    
    public Lecture findLectureById(long lectureId) throws SQLException {
        return lectureDao.getLectureById(lectureId);
    }
    
}