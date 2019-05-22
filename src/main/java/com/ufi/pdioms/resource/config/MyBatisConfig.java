package com.ufi.pdioms.resource.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
public class MyBatisConfig {

    /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
//    @Bean
//    @ConditionalOnProperty(name = "febs.showsql", havingValue = "true")
//    SqlStatementInterceptor sqlStatementInterceptor() {
//        return new SqlStatementInterceptor();
//    }

    //@Bean
    public static PropertySourcesPlaceholderConfigurer mysqlConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

        String profile = System.getProperty("spring.profiles.active");
        String profiles = "spring.profiles";
        Resource resource = new ClassPathResource("application.yml");
        Properties properties = new Properties();

        try {

            List<PropertySource<?>> sources = new YamlPropertySourceLoader().load(resource.getFilename(), resource);
            for (PropertySource<?> propertySource : sources) {
                Map<String, Object> map = (Map) propertySource.getSource();
                if (!map.containsKey(profiles) || (map.get(profiles) + "").equals(profile)) {
                    properties.putAll(map);
                    properties.remove(profiles);
                }
            }
            configurer.setProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        configurer.setBeanName("mysqlConfigurer1");

        return configurer;
    }
}