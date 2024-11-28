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

    
}