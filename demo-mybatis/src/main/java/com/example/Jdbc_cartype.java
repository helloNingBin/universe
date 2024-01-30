package com.example;
import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;

public class Jdbc_cartype {
    // JDBC连接参数
    private static final String JDBC_URL = "jdbc:mysql://your_database_url/your_database_name";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    public static void main(String[] args) {
        // 注册 JDBC 驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 建立数据库连接
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 开始事务
            connection.setAutoCommit(false);

            // 执行增加操作
            insertData(connection);

            // 执行修改操作
            updateData(connection);

            // 提交事务
            connection.commit();
        } catch (SQLException e) {
            // 发生异常时回滚事务
            e.printStackTrace();
            System.err.println("Rolling back transaction...");
            rollbackTransaction();
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        String insertSql = "INSERT INTO org_car_type (c_name, i_level) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            // 设置参数
            preparedStatement.setString(1, "CarName");
            preparedStatement.setInt(2, 1);

            // 执行插入操作
            preparedStatement.executeUpdate();
        }
    }

    private static void updateData(Connection connection) throws SQLException {
        String updateSql = "UPDATE org_car_type SET c_name = ? WHERE i_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            // 设置参数
            preparedStatement.setString(1, "UpdatedCarName");
            preparedStatement.setLong(2, 1);

            // 执行更新操作
            preparedStatement.executeUpdate();
        }
    }

    private static void rollbackTransaction() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            // 回滚事务
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
