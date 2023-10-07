package com.gl.mongodb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbApplication {
    private static final Logger LOG = LogManager.getLogger(MongodbApplication.class);
    public static ConfigurableEnvironment PROPERTIES;

    @Autowired
    private ConfigurableEnvironment myEnv;
    public static void main(String[] args) {

        SpringApplication.run (MongodbApplication.class, args);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup()
            throws Exception {
        LOG.info("-------------> hello world, I have just started up <-----------");

        initProperties();
        LOG.info("-------------> Config is done ! <-----------");

        LOG.info("server.port: " + getProperty("server.port"));
        LOG.info("spring boot version : 2.7.14 " );
        LOG.info("spring.data.mongodb.host : " + getProperty("spring.data.mongodb.host"));
        LOG.info("spring.data.mongodb.port : " + getProperty("spring.data.mongodb.port"));
        LOG.info("spring.data.mongodb.database : " + getProperty("spring.data.mongodb.database"));

    }
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public void initProperties() throws IOException {
        PROPERTIES = myEnv;
    }

}
