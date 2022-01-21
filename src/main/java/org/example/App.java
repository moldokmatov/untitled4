package org.example;

import org.example.dao.Cities;
import org.example.dao.Countries;
import org.example.dao.Countries_President;
import org.example.dao.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
//        System.out.println( "Hello World!" );
//        jdbc jdbc = new jdbc();
//        jdbc.connection();
        Cities cities = new Cities();
        System.out.println(cities.printAll());
        Countries countries = new Countries();
        System.out.println(countries.printAll());
        Countries_President.printCountries_President();

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        int id = scanner.nextInt();
        Cities cities1=new Cities();
        cities1.findCitiesById(id);



    }
}




