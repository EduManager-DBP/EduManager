package model.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.dao.studygroup.StudyGroupDao;
import model.domain.lecture.LectureReview;
import model.domain.studyGroup.StudyGroup;
import model.domain.studyGroup.StudyGroupReview;


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
    

    public boolean isMemberOfStudyGroup(String memberId, long studyGroupId) throws SQLException {
        return studyGroupDao.isMemberOfStudyGroup(memberId, studyGroupId);
    }

    
    //스터디 후기 작성
    public StudyGroupReview createStudyReview(StudyGroupReview groupReview) throws SQLException {
        return studyGroupDao.insertReview(groupReview);
                 
    }
   
    //강의 후기 가져오기
    public List< StudyGroupReview> getReviewsByGroupId(Long groupId) throws SQLException {
        return  studyGroupDao.getReviewsByGroupId(groupId);
    }
    
   
    
}
