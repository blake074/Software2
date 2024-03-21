package co.edu.unbosque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.edu.unbosque.model.database")
public class EmpresaAbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpresaAbcApplication.class, args);
    }

}
