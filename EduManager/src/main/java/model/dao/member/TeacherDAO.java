package model.dao.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.JDBCUtil;
import model.domain.member.Teacher;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스 USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행
 */
public class TeacherDAO {
	private JDBCUtil jdbcUtil = null;

	public TeacherDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}

	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO TEACHER VALUES (?, ?, ?, ?, ?)";
		Object[] param = new Object[] { teacher.getId(), teacher.getPwd(), teacher.getName(), teacher.getEmail(),
				teacher.getPhone() };
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate(); // insert 문 실행
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

	/**
	 * 기존의 사용자 정보를 수정. (이름, 전화번호)
	 */
	public int update(Teacher teacher) throws SQLException {
		String sql = "UPDATE TEACHER " + "SET pwd=?, email=?, phone=? " + "WHERE id=?";
		Object[] param = new Object[] { teacher.getPwd(), teacher.getEmail(), teacher.getPhone(), teacher.getId() };

		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

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

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(String id) throws SQLException {
		String sql = "DELETE FROM TEACHER WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { id }); // JDBCUtil에 delete문과 매개 변수 설정

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

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 저장하여 반환.
	 */
	public Teacher findTeacher(String id) throws SQLException {
		String sql = "SELECT pwd, name, email, phone " + "FROM TEACHER " + "WHERE id = ? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { id }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) { // 학생 정보 발견
				Teacher teacher = new Teacher( // User 객체를 생성하여 학생 정보를 저장
						id, rs.getString("pwd"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
				return teacher;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Teacher> findTeacherList() throws SQLException {
		String sql = "SELECT id, name, email, phone " + "FROM TEACHER " + "ORDER BY id";
		jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Teacher> teacherList = new ArrayList<Teacher>(); // User들의 리스트 생성
			while (rs.next()) {
				Teacher teacher = new Teacher( // User 객체를 생성하여 현재 행의 정보를 저장
						rs.getString("id"), null, rs.getString("name"), rs.getString("email"), rs.getString("phone"));
				teacherList.add(teacher); // List에 User 객체 저장
			}
			return teacherList;

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<Teacher> findTeacherList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT id, name, email, phone" + "FROM TEACHER " + "ORDER BY id";
		jdbcUtil.setSqlAndParameters(sql, null, // JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE, // cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			int start = ((currentPage - 1) * countPerPage) + 1; // 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) { // 커서를 시작 행으로 이동
				List<Teacher> teacherList = new ArrayList<Teacher>(); // User들의 리스트 생성
				do {
					Teacher teacher = new Teacher( // User 객체를 생성하여 현재 행의 정보를 저장
							rs.getString("id"), null, rs.getString("name"), rs.getString("email"),
							rs.getString("phone"));
					teacherList.add(teacher); // 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));
				return teacherList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사
	 */
	public boolean existingTeacher(String id) throws SQLException {
		String sql = "SELECT count(*) FROM TEACHER WHERE id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] { id }); // JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return false;
	}

}
