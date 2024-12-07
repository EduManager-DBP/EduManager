package model.service;

import java.sql.SQLException;
import model.dao.lecture.LectureDao;
import model.dao.lecture.LectureScheduleDao;
import model.dao.studygroup.StudyGroupDAO;
import model.dao.studygroup.StudyScheduleDao;
import model.domain.Schedule;
import model.domain.lecture.Lecture;
import model.domain.studyGroup.StudyGroup;

import java.util.List;

public class StudyManager {
    private static StudyManager instance = new StudyManager();
    private StudyGroupDAO studyDao;
    private StudyScheduleDao scheduleDao;
    
    private StudyManager() {
        studyDao = new StudyGroupDAO();
        scheduleDao = new StudyScheduleDao();
    }

    public static StudyManager getInstance() {
        return instance;
    }

	/*
	 * public List<Lecture> findLectureList() throws SQLException{ return
	 * lectureDao.getAllLectures(); }
	 */
    
    public StudyGroup findStudyById(long studyId) throws SQLException {
        return studyDao.findGroupInfo(studyId);
    }
    public StudyGroup createStudy(StudyGroup study) throws SQLException {
		return studyDao.create(study);		
	}
    public int updateStudy(StudyGroup study) throws SQLException{
		return studyDao.update(study);
	}	
    
    //정기 일정
    public int createSchedule (Schedule schedule)throws SQLException{
    	return scheduleDao.createSchedule(schedule);
    }
    public List<Schedule> findScheduleById(long studyId) throws SQLException {
    	return scheduleDao.findSchedulesByStudyId(studyId);
    }
    public void updateSchedule (Schedule schedule)throws SQLException{
    	scheduleDao.updateSchedule(schedule);
    }
    public List<Integer> findScheduleIdsByStudyId(long studyId) throws SQLException {
    	return scheduleDao.findScheduleIdsByStudyId(studyId);
    }
    public void deleteScheduleById(int scheduleId) {
    	scheduleDao.deleteScheduleById(scheduleId);
    }
}