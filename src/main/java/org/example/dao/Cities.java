package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.jdbc.connection;

public class Cities {
    private int id;
    private String first_name;
    private int population;

    public Cities() {
    }

    public Cities(int id, String first_name, int population) {
        this.id = id;
        this.first_name = first_name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return
                "\nid            |  " + id + '\n' +
                        "first_name    |  " + first_name + '\n' +
                        "population    |  " + population + '\n';
    }

    public List<Cities> printAll() {
        List<Cities> cities = new ArrayList<>();
        String SQL = "SELECT * FROM cities";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                cities.add(new Cities(rs.getInt(1),
                        rs.getString(2), rs.getInt(3)));

            }
            return cities;

        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void findCitiesById(int id1) throws SQLException {
        try (PreparedStatement pr = connection().prepareStatement("select *from cities where id=?")) {
            pr.setInt(1, id1);
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()) {
                System.out.println("id \t             |  " + resultSet.getInt(1) +
                        "\nCountriesName \t |   " + resultSet.getString
                        (2) + "\narea\t         |  " + resultSet.getString(3));
                System.out.println();
            } else {
                System.out.println(id1 + " ушундай id жок");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



