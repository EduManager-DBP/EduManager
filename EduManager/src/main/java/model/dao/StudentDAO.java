//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import domain.StudentDTO;
//
//public class StudentDAO {
//    private Connection conn;
//
//    public StudentDAO(Connection conn) {
//        this.conn = conn;
//    }
//
//    public void insertStudent(StudentDTO student) throws SQLException {
//        conn.setAutoCommit(false);
//
//        try {
//            UserDAO userDAO = new UserDAO(conn);
//            userDAO.insertUser(student);
//
//            String sql = "INSERT INTO Student (memberId, ageRange) VALUES (?, ?)";
//            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//                pstmt.setString(1, student.getUserId());
//                pstmt.setInt(2, student.getAgeRange());
//                pstmt.executeUpdate();
//            }
//
//            conn.commit();
//        } catch (SQLException e) {
//            conn.rollback();
//            throw e;
//        } finally {
//            conn.setAutoCommit(true);
//        }
//    }
//    
//
//    public void updateStudent(StudentDTO student) throws SQLException {
//        UserDAO userDAO = new UserDAO(conn);
//        userDAO.updateUser(student);
//    }
//
//
//    public void deleteStudent(String userId) throws SQLException {
//        UserDAO userDAO = new UserDAO(conn);
//        userDAO.deleteUser(userId);
//    }
//}
