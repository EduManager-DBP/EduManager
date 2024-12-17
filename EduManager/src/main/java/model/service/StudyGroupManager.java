package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.studygroup.StudyGroupDao;
import model.domain.StudyGroup;

public class StudyGroupManager {
    
    private static StudyGroupManager instance = new StudyGroupManager();
    private StudyGroupDao studyGroupDao;

    private StudyGroupManager() {
        studyGroupDao = new StudyGroupDao();
    }

    public static StudyGroupManager getInstance() {
        return instance;
    }

    public StudyGroup findStudyGroupById(long studyGroupId) throws SQLException {
        return studyGroupDao.findGroupInfo(studyGroupId);
    }
    public List<StudyGroup> getStudyGroupsExcludingStudent(String stuId) throws SQLException {
        return studyGroupDao.getStudyGroupsExcludingStudent(stuId);
    }

}
