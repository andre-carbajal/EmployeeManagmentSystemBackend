package net.anvian.employeemanagmentsystem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagmentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagmentSystemApplication.class, args);
    }

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Employee Management System")
                .description("Employee Management System API")
                .version("v1");
        return new OpenAPI().info(info);
    }

}
