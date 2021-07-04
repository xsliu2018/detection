package top.xsliu.detection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DetectionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DetectionApplication.class, args);
    }

}
