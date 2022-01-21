package org.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.dao.jdbc.connection;

public class Countries_President {
    private int id;
    private String country_name;
    private String First_name;
    private String Last_name;

    public Countries_President(int id, String country_name, String first_name, String last_name) {
        this.id = id;
        this.country_name = country_name;
        First_name = first_name;
        Last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    @Override
    public String toString() {
        return "Countries_President{" +
                "id=" + id +
                ", country_name='" + country_name + '\n' +
                ", First_name='" + First_name + '\n' +
                ", Last_name='" + Last_name + '\n' +
                '}';
    }

    public static void printCountries_President() {
        String SQL = "SELECT * FROM countries_President";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "  " + rs.getString("country_name") + "   "
                        + rs.getString("First_name") +
                       "  " + rs.getString("Last_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
}

