package com.elbike.config;

import com.elbike.dao.UserDao;
import com.elbike.dao.UserDaoImpl;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class SpringDBConfig {

	@Autowired
	DataSource dataSource;
                    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:database1.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
                System.out.println("database connect"); 
        return dataSource;
    }
     
    @Bean
    public UserDao getUserDao() {
        return new UserDaoImpl(getDataSource());
    }
//
//	/*@Bean
//	public JdbcTemplate getJdbcTemplate() {
//		return new JdbcTemplate(dataSource);
//	}*/
//
//	@Bean
//	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
//		return new NamedParameterJdbcTemplate(dataSource);
//	}
//
//	@Bean
//	public DataSource getDataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder.setName("testdb").setType(EmbeddedDatabaseType.HSQL)
//				.addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
//		return db;
//	}
//
//	@PostConstruct
//	public void startDBManager() {
//
//		// hsqldb
//		// DatabaseManagerSwing.main(new String[] { "--url",
//		// "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
//
//	}

}