package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.studygroup.StudyGroupDao;
import model.domain.studyGroup.StudyGroup;


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

    public List<StudyGroup> StudyGroupListByLeader(String stuId) throws SQLException {
        return studyGroupDao.getStudyGroupListByLeader(stuId);
    }
    
    public List<StudyGroup> StudyGroupListByMember(String stuId) throws SQLException {
        return studyGroupDao.getStudyGroupListByMember(stuId);
    }
    
    public List<StudyGroup> StudyGroupLikeList(String stuId) throws SQLException {
        return studyGroupDao.getLikedStudyGroups(stuId);
    }
    
    public boolean isLikedByUser(String memberId, long studyGroupId) throws SQLException {
        return studyGroupDao.isLikedByUser(memberId, studyGroupId);
    }

    // 좋아요 토글
    public void toggleStudyGroupLike(String memberId, long studyGroupId) throws SQLException {
        boolean isLiked = isLikedByUser(memberId, studyGroupId);
        if (isLiked) {
            // 좋아요가 있다면 삭제
            studyGroupDao.removeLike(memberId, studyGroupId);
        } else {
            // 좋아요가 없다면 추가
            studyGroupDao.addLike(memberId, studyGroupId);
        }
    }
    
}
