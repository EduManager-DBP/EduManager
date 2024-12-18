package model.service;

import java.sql.SQLException;
import model.dao.lecture.LectureDao;
import model.dao.lecture.LectureLikeDao;
import model.dao.lecture.LectureScheduleDao;
import model.domain.Schedule;

import model.domain.lecture.Lecture;

import java.util.List;

public class LectureManager {
    private static LectureManager instance = new LectureManager();
    private LectureDao lectureDao;

    private LectureScheduleDao scheduleDao;
    private LectureLikeDao lectureLikeDao;
    
    private LectureManager() {
        lectureDao = new LectureDao();
        scheduleDao = new LectureScheduleDao();
       lectureLikeDao = new LectureLikeDao();
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
    
    
    public boolean isLikedByUser(String memberId, long lectureId) throws SQLException {
        return lectureLikeDao.isLikedByUser(memberId, lectureId);
    }

    public void toggleLectureLike(String memberId, long lectureId) throws SQLException {
        boolean isLiked = isLikedByUser(memberId, lectureId);
        if (isLiked) {
            // 좋아요가 있다면 삭제
            lectureLikeDao.removeLike(memberId, lectureId);
        } else {
            // 좋아요가 없다면 추가
            lectureLikeDao.addLike(memberId, lectureId);
        }
    }
    
    public List<Lecture> LectureLikeList(String stuId) throws SQLException {
        return lectureLikeDao.getLikedLectures(stuId);
    }
  
    
    //정기 일정
    public int createSchedule (Schedule schedule)throws SQLException{
    	return scheduleDao.createSchedule(schedule);
    }
    public List<Schedule> findScheduleById(long lectureId) throws SQLException {
    	return scheduleDao.findSchedulesBylectureId(lectureId);
    }
    public void updateSchedule (Schedule schedule)throws SQLException{
    	scheduleDao.updateSchedule(schedule);
    }
    public List<Integer> findScheduleIdsBylectureId(long lectureId) throws SQLException {
    	return scheduleDao.findScheduleIdsBylectureId(lectureId);
    }
    public void deleteScheduleById(int scheduleId) {
    	scheduleDao.deleteScheduleById(scheduleId);
    }

}