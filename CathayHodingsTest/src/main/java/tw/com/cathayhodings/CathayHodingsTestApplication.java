package tw.com.cathayhodings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "tw.com.cathayhodings.controller", "tw.com.cathayhodings.service" })
public class CathayHodingsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CathayHodingsTestApplication.class, args);
    }
}
