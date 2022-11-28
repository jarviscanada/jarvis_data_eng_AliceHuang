package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JDBCExecutor {

  private final Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);
  public static void main(String[] args) {
    JDBCExecutor jdbcExecutor = new JDBCExecutor();
    DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
        "hplussport", "postgres", "password");
    try{
      Connection connection = dcm.getConnection();
      OrderDAO orderDAO = new OrderDAO(connection);
      List<Order> orders = orderDAO.getOrdersForCustomer(789);
      orders.forEach(System.out::println);
    }catch(SQLException e){
      jdbcExecutor.logger.error("Unable to execute", e);
    }
  }
}
