package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl")
@PropertySource("classpath:datasource.properties")
public class DaoApplicationContextConfig {

	private static String DB_DRIVER_PROPERTY = "db.driverClassName";
	private static String DB_URL_PROPERTY = "db.url";
	private static String DB_USERNAME_PROPERTY = "db.username";
	private static String DB_PASSWORD_PROPERTY = "db.password";

	@Resource
	private Environment environment;

	@Bean
	public HibernateJpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}

	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);

		return hibernateJpaVendorAdapter;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty(DB_DRIVER_PROPERTY));
		dataSource.setUrl(environment.getProperty(DB_URL_PROPERTY));
		dataSource.setUsername(environment.getProperty(DB_USERNAME_PROPERTY));
		dataSource.setPassword(environment.getProperty(DB_PASSWORD_PROPERTY));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		localContainerEntityManagerFactoryBean.setPersistenceUnitName("RequestRegistry");
		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
		localContainerEntityManagerFactoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaDialect(jpaDialect());
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties());

		return localContainerEntityManagerFactoryBean;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		
		properties.put("hibernate.id.new_generator_mappings", "false");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		return properties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
