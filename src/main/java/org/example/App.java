package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public List<String> getRecordData(String email) {
        List<String> data = new ArrayList<>();
        Connection con = getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("select subject from records where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.add(rs.getString("subject"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            throw new TestException(e);
        }
        return data;
    }

    public Connection getConnection(){
        return null;
    }

    static class TestException extends RuntimeException{
        public TestException() {
        }

        public TestException(String message) {
            super(message);
        }

        public TestException(String message, Throwable cause) {
            super(message, cause);
        }

        public TestException(Throwable cause) {
            super(cause);
        }

        public TestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
