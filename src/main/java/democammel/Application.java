package democammel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@Import({Configuration.class, FileProcessRouteConfiguration.class})
public class Application  {


    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        SpringApplication.run(Application.class, args);
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.info("---STARTED---");


//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
