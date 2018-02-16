package sk.akademiasovy.employees.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQL {

    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/employees";
    private String username="root";
    private String password="";

    public String getEmp(String name) {
        String result = "";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
            String query = " SELECT salaries.salary as sal FROM salaries "+
                    " INNER JOIN employees ON employees.emp_no=salaries.emp_no"+
                    " WHERE employees.last_name like '"+name+"'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("cn");
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
        return result;
    }
    public String test(){
        return ("Work well");
    }
}
