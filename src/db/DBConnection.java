package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//서버 IP주소 입력
    private static final String URL = "jdbc:mariadb://0.0.0.0:3306/test";
    //DB 사용자의 이름과 비밀번호 입력
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}