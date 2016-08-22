package uk.co.rparkinson.SuperSimpleStockMarket;

// import uk.co.rparkinson.SuperSimpleStockMarket.model.*;
// import uk.co.rparkinson.SuperSimpleStockMarket.service.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
