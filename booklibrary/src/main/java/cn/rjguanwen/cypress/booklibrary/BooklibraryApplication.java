package cn.rjguanwen.cypress.booklibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("cn.rjguanwen.cypress.booklibrary.mapper") //扫描的mapper
@SpringBootApplication
public class BooklibraryApplication  extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BooklibraryApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(BooklibraryApplication.class, args);
    }

}
