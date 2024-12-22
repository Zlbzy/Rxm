package com.eddy.rxm.common.log.init;

import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 通过环境变量形式注入 logging.file
 * 自动维护
 * @author Nick
 * @since 2023.10.7
 */
public class ApplicationLoggerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        String appName = environment.getProperty("spring.application.type");

        String logBase = environment.getProperty("LOGGING_PATH", "logs");

        System.setProperty("logging.file", String.format("%s/%s/debug.log", logBase, appName));

    }
}
