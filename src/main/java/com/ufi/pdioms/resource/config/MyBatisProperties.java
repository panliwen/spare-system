package com.ufi.pdioms.resource.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * Created by Administrator on 2019/1/1.
 */
@Configuration
//@org.springframework.context.annotation.PropertySource(value = {"file:${user.home}/application-mysql.yml", "classpath:application-mysql.yml"},ignoreResourceNotFound = true,factory = YamlPropertyLoaderFactory.class)
public class MyBatisProperties {

    //    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean app = new YamlPropertiesFactoryBean();
        app.setResources(new ClassPathResource("application.yml"));
        String profile = app.getObject().get("spring.profiles.active") + "";

        YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
        Resource resource = new ClassPathResource("application.yml");
        Properties properties = new Properties();
        try {
            List<PropertySource<?>> sources = sourceLoader.load(resource.getFilename(), resource);
            for (PropertySource<?> propertySource : sources) {
                Map map = (Map) propertySource.getSource();
                if (!map.containsKey("spring.profiles") || (map.get("spring.profiles") + "").equals(profile)) {
                    properties.putAll(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        configurer.setProperties(properties);
        return configurer;
    }
}
