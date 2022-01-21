package org.example.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.jdbc.connection;

public class Countries {
    private int id;
    private String first_name;
    private String capital_city;
    private int population;







    public Countries(int id, String first_name, String capital_city, int population) {
        this.id = id;
        this.first_name = first_name;
        this.capital_city = capital_city;
        this.population = population;
    }

    public Countries() {
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

    public String getCapital_city() {
        return capital_city;
    }

    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
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
                "\nid              |   " + id + '\n' +
                "first_name      |   " + first_name + '\n' +
                "capital_city    |   " + capital_city + '\n' +
                "population      |   " + population +'\n';

    }

    public List<Countries> printAll() {
        List<Countries> countries = new ArrayList<>();
        String SQL = "SELECT * FROM countries";
        try (Connection conn = connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                countries.add(new Countries(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getInt(4)));

            }
            return countries;

        } catch (
                SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;


        }
    }


