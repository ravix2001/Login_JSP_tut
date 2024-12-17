package org.example.login_in_jsp.dao;

import java.sql.*;

public class loginDAO {

    String url = "jdbc:mysql://localhost:3306/login_jsp";
    String username = "root";
    String password = "Ravi@2001";

    public boolean check(String uname, String pass) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        }catch(ClassNotFoundException e){
            System.out.println("Driver not found");
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database successfully");
            String query = "select * from login where uname = ? and pass = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
