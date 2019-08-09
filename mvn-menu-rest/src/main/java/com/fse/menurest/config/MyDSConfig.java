package com.fse.menurest.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration 
@EnableWebMvc
@EnableTransactionManagement //add annotation based tx management
@ComponentScan(basePackages="com.fse.menurest")
@PropertySource("classpath:database.properties")
public class MyDSConfig {
	
	//config files are auto injected a bean of type Environment
	//Environment var will help to fetch the values from properties files
	
	@Autowired
	private Environment environment;
	
	//configure and expose Connection Pool DS
	@Bean
	public DataSource poolDataSource() {
		
		//create connection pool
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		
		//set the jdbc driver
		
		try {
			dataSource.setDriverClass(this.environment.getProperty("driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//set database conn prop
		dataSource.setJdbcUrl(this.environment.getProperty("url"));
		dataSource.setUser(this.environment.getProperty("dbuser"));
		dataSource.setPassword(this.environment.getProperty("dbPassword"));
		
		//set Connection Pool Prop
		dataSource.setInitialPoolSize(Integer.parseInt(this.environment.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt(this.environment.getProperty("connection.pool.minPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt(this.environment.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(Integer.parseInt(this.environment.getProperty("connection.pool.maxIdleTime")));
		return dataSource;
	
	}
	
	
	//helper method to assemble hibernate prop
	private Properties getHibernateProperties() {
		
		Properties props=new Properties();
		
		props.setProperty("hibernate.dialect", this.environment.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", this.environment.getProperty("hibernate.show_sql"));
		
		return props;
	}
	
	
	//Create a method to configure and expose sessionFactory as bean
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		//create SessionFactory
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		
		//configure the SessionFactory
		
		//1. set the dataSource
		sessionFactory.setDataSource(this.poolDataSource());
		
		//2. set the hibernate prop
		sessionFactory.setHibernateProperties(this.getHibernateProperties());
		
		//3. set entity package
		sessionFactory.setPackagesToScan(this.environment.getProperty("hibernate.packagesToScan"));
		
		
		return sessionFactory;
		
	}
	
	//method to configure and expose the tx-manager as bean (used my spring framework)
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		//set Tx-manager based on SessionFactory
		HibernateTransactionManager txManager=new HibernateTransactionManager();
		
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
}
