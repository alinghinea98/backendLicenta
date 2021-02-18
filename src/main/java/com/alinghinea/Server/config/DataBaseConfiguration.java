package com.alinghinea.Server.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

//pt Configuration = cand va rula aplicatia, IoC va detecta Bean-urile
//PropertySource //calea unde se afla proprietatile
//daca vreau sa consider fisierul de proprietati optional: pun ignoreResourceNotFound=true dupa value

@Configuration
@PropertySource(value = "classpath:database.properties")
public class DataBaseConfiguration {

	private static final String PACKAGES_TO_SCAN=  "com.alinghinea.Server.entities";

	//Cu Autowired ii spun containerului ca aceasta clasa *DataBaseConfiguration* are nevoie de aceasta variabila env

	@Autowired
	private Environment env; //declarare obiect de tip environment.Instantierea e facuta de Spring
	
	@Value(value= "${hibernate.show_sql}")
	private String hibernateShowSql;

	//in caz ca avem mai mult de un obiect de acelasi timp, el o va prioritiza pe cea adnotata cu primary
		@Primary
		@Bean
		public DataSource dataSource() { 
			HikariDataSource dataSource = new HikariDataSource(); 
			dataSource.setJdbcUrl(env.getRequiredProperty("database.url")); 
			dataSource.setUsername(env.getRequiredProperty("database.username"));   
			dataSource.setPassword(env.getRequiredProperty("database.password"));
			return dataSource; 
		}
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) { 
			LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean(); 
			emf.setDataSource(dataSource());  //obtinem conexiunea la baza de date
			emf.setPackagesToScan(PACKAGES_TO_SCAN); //pachetul in care avem entitati
			 
			HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); 
			
			emf.setJpaVendorAdapter(adapter);
			 
			Map<String, Object> hibernateProperties = new HashMap<>();
			hibernateProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.ddl-auto")); //pt ddl-auto, asta genereaza tabele pe baza @Entity. De preferat e sa folosim update in ddl-auto. Se va crea si utiliaza daca e nevoie
			hibernateProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect")); 
			hibernateProperties.put("hibernate.show_sql", hibernateShowSql);  
			emf.setJpaPropertyMap(hibernateProperties); //jpa = java persistance API
			return emf;
		} 
		  
		@Bean
		public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { //il intalnim la nivel de service, la nivel de clasa sau metoda, cu anotatia @Transactional
			return new JpaTransactionManager(emf);
		}
		@Bean 
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation() { //cand baza de date arunca o Exception se va traduce intr-o exceptie generala de la Spring
			return new PersistenceExceptionTranslationPostProcessor();
		}
		

	}
	//pt mai multe proprietati folosim PropertySources care ia un array {@PropertySource(ceva),@PropertySource(altceva)}
	//Cu Spring ar fi trebuit sa punem si @ComponentScan ca sa stie de unde sa ia, SpringBoot ia automat

