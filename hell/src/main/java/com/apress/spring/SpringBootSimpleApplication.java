package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import java.io.PrintStream;

@SpringBootApplication
public class SpringBootSimpleApplication implements CommandLineRunner, ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);

    @Autowired
    @Value("${text}")
    String info;

    @Bean
    public String info(){
        return info;
    }

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(SpringBootSimpleApplication.class);
//		app.setBanner(new Banner() {
//            @Override
//            public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
//            printStream.print("\n\n\tThis is my own Banner!!!\n\n".toUpperCase());}
//        });
//		app.run(args);
//
        new SpringApplicationBuilder(SpringBootSimpleApplication.class).bannerMode(Banner.Mode.CONSOLE).web(false).run(args);
//
//        Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
//        new SpringApplicationBuilder(SpringBootSimpleApplication.class).listeners(new ApplicationListener<ApplicationEvent>() {
//            @Override
//            public void onApplicationEvent(ApplicationEvent applicationEvent) {
//                log.info("##### > "+ applicationEvent.getClass().getCanonicalName());
//            }
//        }).run(args);
	}



    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("### > ApplicationRunner implementation");
        log.info("### > Get info from the bean : " + info());
        args.getNonOptionArgs().forEach(s -> log.info(s));
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("### > CommandLineRunner implementation");
        log.info("### > Get info from the bean : " + info());
        for (String s : strings) {
            log.info(s);
        }
    }
}
