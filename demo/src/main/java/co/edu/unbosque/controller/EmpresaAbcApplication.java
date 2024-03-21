package co.edu.unbosque.controller;

import co.edu.unbosque.model.database.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class EmpresaAbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaAbcApplication.class, args);
		DatabaseConnection databaseConnection = DatabaseConnection.getInstance();

	}

}