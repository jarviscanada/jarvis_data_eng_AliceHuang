package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {

  final Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);
  public static void main(String[] args) {
    JDBCExecutor jdbcExecutor = new JDBCExecutor();
    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
        "hplussport", "postgres", "password");
    try {
      Connection connection = dcm.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
      while(resultSet.next()){
        System.out.println(resultSet.getInt(1));
      }
    } catch (SQLException e) {
      jdbcExecutor.logger.error("unable to execute", e);
    }
  }
}
