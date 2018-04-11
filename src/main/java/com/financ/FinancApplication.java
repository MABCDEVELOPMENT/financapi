package com.financ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.financ.model" })
@EnableJpaRepositories("com.financ.repository")
public class FinancApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancApplication.class, args);
	}

	// @Bean
	// public DataSource dataSource(){
	// DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// dataSource.setDriverClassName("org.postgresql.Driver");
	// dataSource.setUrl("jdbc:postgresql://localhost:5432/financ");
	// dataSource.setUsername("postgres");
	// dataSource.setPassword("idkfa0101");
	// return dataSource;
	// }
}
