package db;

import java.sql.Connection;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println("연결을 시도합니다...");
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("연결 성공");
        } catch (Exception e) {
            System.out.println("연결 실패");
            e.printStackTrace();
        }
        System.out.println("프로그램 종료");
    }
}