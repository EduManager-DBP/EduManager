//package userDAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserDAO {
//    private Connection conn;
//
//    public UserDAO(Connection conn) {
//        this.conn = conn;
//    }
//
//    public void insertUser(UserDTO user) throws SQLException {
//        String checkSql = "SELECT COUNT(*) FROM Member WHERE memberId = ?";
//        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
//            checkStmt.setString(1, user.getUserId());
//            ResultSet rs = checkStmt.executeQuery();
//            if (rs.next() && rs.getInt(1) > 0) {
//                System.out.println("Error: memberId already exists.");
//                return; // 중복된 memberId가 존재하면 메서드를 종료
//            }
//        }
//
//        // 중복이 없으면 INSERT 수행
//        String sql = "INSERT INTO Member (memberId, userName, password) VALUES (?, ?, ?)";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, user.getUserId());
//            stmt.setString(2, user.getUserName());
//            stmt.setString(3, user.getPassword());
//            stmt.executeUpdate();
//            System.out.println("User (Student) inserted successfully!");
//        }
//    }
//
//    
//    public void updateUser(UserDTO user) throws SQLException {
//        String sql = "UPDATE Member SET userName = ?, password = ? WHERE memberId = ?";
//        
//        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, user.getUserName());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getUserId());
//            pstmt.executeUpdate();
//        }
//    }
//
//
//    public void deleteUser(String userId) throws SQLException {
//        String sql = "DELETE FROM Member WHERE userId = ?";
//
//        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, userId);
//            pstmt.executeUpdate();
//        }
//    }
//}
