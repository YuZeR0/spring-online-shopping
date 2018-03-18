package com.gunjankharel.shoppingbackend.config;

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
@ComponentScan(basePackages={"com.gunjankharel.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	// Changes based on the DBMS
	final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	final static String DATABASE_DRIVER = "org.h2.Driver";
	final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	final static String DATABASE_USERNAME = "sa";
	final static String DATABASE_PASSWORD = "";
	
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	@Bean()
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.gunjankharel.shoppingbackend");
		
		return builder.buildSessionFactory();
	}

	// All Hibernate properties will be returned here
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		
		return properties;
	}
	
	
	// TransactionManager Bean to manage the transaction
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager (sessionFactory);
		return transactionManager;
	}
	
}
