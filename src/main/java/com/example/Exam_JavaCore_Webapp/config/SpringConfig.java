package com.example.Exam_JavaCore_Webapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"com.example.Exam_JavaCore_Webapp"})
@EnableJpaRepositories(basePackages = {"com.example.Exam_JavaCore_Webapp.repository"})
@EnableTransactionManagement
public class SpringConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/upload/**", "/assets/**")
                .addResourceLocations("/WEB-INF/upload/", "/WEB-INF/assets/");
    }

    @Bean
    MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1024*1024*50);
        return resolver;
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        return  resolver;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/student");
        dataSource.setUsername("root");
        dataSource.setPassword("Quy123456");
        return dataSource;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        return properties;
    }
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.example.Exam_JavaCore_Webapp.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties());
        return factoryBean;
    }
    @Bean("transactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
