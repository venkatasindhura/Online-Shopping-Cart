package com.ksn.shoppingbackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.ksn.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3308/onlineshopping";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect"; 
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "password";
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
		
	}
	//sessionFactory bean will be available
	@Bean
	public SessionFactory getsessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.ksn.shoppingbackend.dto");
		return builder.buildSessionFactory();
		
	}
	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	//transactionManagerBean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
