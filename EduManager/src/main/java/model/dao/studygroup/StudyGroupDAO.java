package model.dao.studygroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.studyGroup.StudyGroup;
import model.domain.studyGroup.StudyGroupApplication;

public class StudyGroupDAO {
	private JDBCUtil jdbcUtil = null;

	public StudyGroupDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	public StudyGroup create(StudyGroup group) throws SQLException {
		try {
			String sql = "INSERT INTO StudyGroup (studyGroupId, name, img, description, capacity, category, createAt, leaderId) "
					+ "VALUES (SEQ_STUDY_GROUP_ID.nextval, ?, ?, ?, ?, ?, SYSDATE, ?)";
			Object[] param = new Object[] { group.getName(), group.getImg(), group.getDescription(),
					group.getCapacity(), group.getCategory(), group.getLeaderId() };

			jdbcUtil.setSqlAndParameters(sql, param);

			// StudyGroup에 id setting
			String key[]={"studyGroupId"};  // PK 컬럼(들)의 이름 배열       
			int result = jdbcUtil.executeUpdate(key);
            if (result > 0) {
            	ResultSet rs = jdbcUtil.getGeneratedKeys();
    		   	if(rs.next()) {
    		   		long generatedKey = rs.getLong(1);   // 생성된 PK 값
    		   		group.setStudyGroupId(generatedKey); 	// id필드에 저장  
    		   	}
    			return group;
            } 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	// 스터디 그룹 정보 수정
	public int update(StudyGroup group) throws SQLException {
		String sql = "UPDATE StudyGroup " + "SET name=?, img=?, description=?, capacity=?, category=? "
				+ "WHERE studyGroupId=? ";
		Object[] param = new Object[] { group.getName(), group.getImg(), group.getDescription(), group.getCapacity(),
				group.getCategory(), group.getStudyGroupId() };
		jdbcUtil.setSqlAndParameters(sql, param);
		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	// 스터디 그룹 정보 불러오기
	public StudyGroup findGroupInfo(long groupId) {

		try {
			StudyGroup group = new StudyGroup();
			String query = "SELECT studyGroupId, name, img, description, capacity, category, leaderId FROM StudyGroup WHERE studyGroupId= ?";
			jdbcUtil.setSqlAndParameters(query, new Object[] { groupId });

			ResultSet rs = jdbcUtil.executeQuery();

			if (rs.next()) {
				group.setStudyGroupId(groupId);
				group.setName(rs.getString("name"));
				group.setImg(rs.getString("img"));
				group.setDescription(rs.getString("description"));
				group.setCapacity(rs.getInt("capacity"));
				group.setCategory(rs.getString("category"));
				group.setLeaderId(rs.getString("leaderId"));
			} else {
				System.out.println("스터디그룹 정보를 찾을 수 없습니다.  " + groupId);
			}
			return group;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}

		return null;
	}

	// 특정 스터디그룹에 해당하는 정보 삭제
	public int remove(String groupId) throws SQLException {
		String sql = "DELETE FROM StudyGroup WHERE studyGroupId=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { groupId }); // JDBCUtil에 delete문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}

	// 스터디그룹 전체 보여주기
	public List<StudyGroup> getStudyGroupList() throws SQLException {
		List<StudyGroup> groupList = new ArrayList<>();
		String sql = "SELECT studyGroupId, name, img, description, capacity, category FROM StudyGroup";

		jdbcUtil.setSqlAndParameters(sql, new Object[] {});
		ResultSet rs = jdbcUtil.executeQuery();

		while (rs.next()) {
			StudyGroup group = new StudyGroup();
			group.setStudyGroupId(rs.getInt("studyGroupId"));
			group.setName(rs.getString("name"));
			group.setImg(rs.getString("img"));
			group.setDescription(rs.getString("description"));
			group.setCapacity(rs.getInt("capacity"));
			group.setCategory(rs.getString("category"));
			groupList.add(group);
		}

		jdbcUtil.close();
		return groupList;
	}

	public StudyGroupApplication createApplication(StudyGroupApplication application) throws SQLException {

		application.setStatus("진행중");

		// 스터디 그룹 요청 생성
		String sql = "INSERT INTO StudyGroupApplication (studyGroupApplicationId, status, createAt, memberId, studyGroupId) "
				+ "VALUES (SEQ_STUDY_GROUP_APPLICATION_ID.nextval, ?, SYSDATE, ?, ?)";
		Object[] param = new Object[] { application.getStatus(), application.getMemberId(),
				application.getStudyGroupId() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 insert문과 매개 변수 설정

		String key[] = { "studyGroupApplicationId" };
		try {
			jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if (rs.next()) {
				int generatedKey = rs.getInt(1);
				application.setStudyGroupApplicationId(generatedKey); // id필드에 저장
			}
			return application;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return null;
	}

	// 요청 상태를 "수락"으로 변경
	public void acceptApplication(long applicationId) throws SQLException {

		String updateStatusSql = "UPDATE StudyGroupApplication SET status = '수락' WHERE studyGroupApplicationId = ?";

		try {
			// 상태 변경 실행
			jdbcUtil.setSqlAndParameters(updateStatusSql, new Object[] { applicationId });
			jdbcUtil.executeUpdate();
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
	}

	// 팀원으로 가입된 스터디 그룹 가져오기
	public List<StudyGroup> getStudyGroupListByMember(String memberId) throws SQLException {
		List<StudyGroup> groupList = new ArrayList<>();

		String sql = "SELECT sg.studyGroupId, sg.name, sg.img, sg.description, sg.capacity, sg.category "
				+ "FROM StudyGroup sg " + "JOIN StudyGroupApplication sga ON sg.studyGroupId = sga.studyGroupId "
				+ "WHERE sga.memberId = ? AND sga.status = '수락' AND sg.leaderId != ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { memberId, memberId }); // memberId를 두 번 파라미터로 설정
		ResultSet rs = jdbcUtil.executeQuery();

		while (rs.next()) {
			StudyGroup group = new StudyGroup();
			group.setStudyGroupId(rs.getInt("studyGroupId"));
			group.setName(rs.getString("name"));
			group.setImg(rs.getString("img"));
			group.setDescription(rs.getString("description"));
			group.setCapacity(rs.getInt("capacity"));
			group.setCategory(rs.getString("category"));
			groupList.add(group);
		}

		jdbcUtil.close();
		return groupList;
	}

	// 팀장으로 가입된 스터디 가져오기
	public List<StudyGroup> getStudyGroupListByLeader(String memberId) throws SQLException {
		List<StudyGroup> groupList = new ArrayList<>();

		String sql = "SELECT studyGroupId, name, img, description, capacity, category " + "FROM StudyGroup "
				+ "WHERE leaderId = ?";

		jdbcUtil.setSqlAndParameters(sql, new Object[] { memberId });
		ResultSet rs = jdbcUtil.executeQuery();

		while (rs.next()) {
			StudyGroup group = new StudyGroup();
			group.setStudyGroupId(rs.getInt("studyGroupId"));
			group.setName(rs.getString("name"));
			group.setImg(rs.getString("img"));
			group.setDescription(rs.getString("description"));
			group.setCapacity(rs.getInt("capacity"));
			group.setCategory(rs.getString("category"));
			groupList.add(group);
		}

		jdbcUtil.close();
		return groupList;
	}

	public void toggleStudyGroupLike(String memberId, long studyGroupId) throws SQLException {
		try {

			String checkSql = "SELECT COUNT(*) FROM StudyGroupLike WHERE studyGroupId = ? AND memberId = ?";
			jdbcUtil.setSqlAndParameters(checkSql, new Object[] { studyGroupId, memberId });

			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);

				if (count > 0) {

					String deleteSql = "DELETE FROM StudyGroupLike WHERE studyGroupId = ? AND memberId = ?";
					jdbcUtil.setSqlAndParameters(deleteSql, new Object[] { studyGroupId, memberId });
					jdbcUtil.executeUpdate();
				} else {
					// 좋아요가 없다면 추가
					String insertSql = "INSERT INTO StudyGroupLike (studyLikeId, createAt, studyGroupId, memberId) "
							+ "VALUES (SEQ_STUDY_GROUP_LIKE_ID.nextval, SYSDATE, ?, ?)";
					jdbcUtil.setSqlAndParameters(insertSql, new Object[] { studyGroupId, memberId });
					jdbcUtil.executeUpdate();
				}
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
	}

	// 리뷰 작성을 위한 스터디 그룹 소속인지 아닌지 확인
	private boolean isMemberOfStudyGroup(String memberId, long studyGroupId) throws SQLException {
		String sql = "SELECT COUNT(*) FROM StudyGroupApplication WHERE studyGroupId = ? AND memberId = ? AND status = '수락'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { studyGroupId, memberId });

		ResultSet rs = jdbcUtil.executeQuery();
		if (rs.next()) {
			int count = rs.getInt(1);
			return count > 0;
		}
		return false;
	}

	// 스터디후기 생성
	public void createReview(String memberId, long studyGroupId, String reviewText) throws SQLException {
		try {
			if (isMemberOfStudyGroup(memberId, studyGroupId)) {

				String sql = "INSERT INTO StudyGroupReview (studyGroupReviewId, reviewText, createAt, studyGroupId, memberId) "
						+ "VALUES (SEQ_STUDY_GROUP_REVIEW_ID.nextval, ?, SYSDATE, ?, ?)";
				jdbcUtil.setSqlAndParameters(sql, new Object[] { reviewText, studyGroupId, memberId });

				jdbcUtil.executeUpdate();
			} else {
				System.out.println("해당 스터디 그룹에 소속되지 않았습니다. 리뷰를 작성할 수 없습니다.");
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
			throw new SQLException("예기치 않은 오류가 발생했습니다.", ex);
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
	}
}
