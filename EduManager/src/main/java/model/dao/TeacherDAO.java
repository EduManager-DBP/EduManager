package userDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDAO {
    private Connection conn;

    public TeacherDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertTeacher(TeacherDTO Teacher) throws SQLException {
        conn.setAutoCommit(false);

        try {
            UserDAO userDAO = new UserDAO(conn);
            userDAO.insertUser(Teacher);

            String sql = "INSERT INTO Teacher (memberId) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, Teacher.getUserId());
                pstmt.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
    

    public void updateTeacher(TeacherDTO Teacher) throws SQLException {
        UserDAO userDAO = new UserDAO(conn);
        userDAO.updateUser(Teacher);
    }


    public void deleteStudent(String userId) throws SQLException {
        UserDAO userDAO = new UserDAO(conn);
        userDAO.deleteUser(userId);
    }
}
