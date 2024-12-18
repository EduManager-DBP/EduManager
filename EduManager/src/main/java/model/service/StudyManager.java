package model.service;

import java.sql.SQLException;
import java.time.LocalDate;

import model.dao.studygroup.StudyAssignmentDao;
import model.dao.studygroup.StudyGroupDao;
import model.dao.studygroup.StudyNoticeDao;
import model.dao.studygroup.StudyScheduleDao;
import model.domain.Assignment;
import model.domain.Notice;
import model.domain.Schedule;
import model.domain.studyGroup.StudyGroup;

import java.util.List;

public class StudyManager {
    private static StudyManager instance = new StudyManager();
    private StudyGroupDao studyDao;
    private StudyScheduleDao scheduleDao;
    private StudyAssignmentDao assignmentDao;
    private StudyNoticeDao noticeDao;
    
    private StudyManager() {
        studyDao = new StudyGroupDao();
        scheduleDao = new StudyScheduleDao();
        assignmentDao = new StudyAssignmentDao();
        noticeDao = new StudyNoticeDao();
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
    
    
    //스터디 과제 목록 조회(특정 날짜)
    public List<Assignment> findAssignmentsByStudyIdAndDueDate(int studyId, LocalDate dueDate) {
    	return assignmentDao.findAssignmentsByStudyIdAndDueDate(studyId, dueDate);
    }
    //스터디 공지 목록 조회(특정 날짜)
    public List<Notice> findNoticesByStudyIdAndDueDate(int studyId, LocalDate createdAt) {
    	return noticeDao.findNoticesByStudyIdAndDueDate(studyId, createdAt);
    }
    //스터디 일정 목록 조회
    public List<Schedule> findSchedulesByFilters(long studygroupid, LocalDate startDate, String type, String dayOfWeek) {
    	return scheduleDao.findSchedulesByFilters(studygroupid, startDate, type, dayOfWeek);
    }

}