package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // 조회 (SELECT)
    public void selectAll() {
        String sql = "SELECT `number`, name, phone FROM students ORDER BY `number`";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            int count = 0;
            while (rs.next()) {
                System.out.printf("번호: %d, 이름: %s, 전화번호: %s%n",
                        rs.getInt("number"), rs.getString("name"), rs.getString("phone"));
                count++;
            }
            if (count == 0) {
                System.out.println("저장된 데이터가 없습니다.");
            } else {
                System.out.println("총 " + count + "건 조회됨");
            }
        } catch (SQLException e) {
            System.out.println("❌ 조회 오류: " + e.getMessage());
        }
    }

    // 삽입 (INSERT)
    public void insert(int number, String name, String phone) {
        String sql = "INSERT INTO students (`number`, name, phone) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, number);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            int result = pstmt.executeUpdate();
            System.out.println(result + "건 삽입 완료");

        } catch (SQLException e) {
            System.out.println("삽입 오류: " + e.getMessage());
        }
    }

    // 수정 (UPDATE) - 번호가 일치하는 행의 이름, 전화번호를 바꾼다
    public void update(int number, String name, String phone) {
        String sql = "UPDATE students SET name = ?, phone = ? WHERE `number` = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setInt(3, number);
            int result = pstmt.executeUpdate();
            if (result == 0) {
                System.out.println("해당 번호(" + number + ")의 데이터가 없습니다.");
            } else {
                System.out.println(result + "건 수정 완료");
            }

        } catch (SQLException e) {
            System.out.println("수정 오류: " + e.getMessage());
        }
    }

    // 삭제 (DELETE)
    public void delete(int number) {
        String sql = "DELETE FROM students WHERE `number` = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, number);
            int result = pstmt.executeUpdate();
            if (result == 0) {
                System.out.println("해당 번호(" + number + ")의 데이터가 없습니다.");
            } else {
                System.out.println(result + "건 삭제 완료");
            }

        } catch (SQLException e) {
            System.out.println("삭제 오류: " + e.getMessage());
        }
    }
}
