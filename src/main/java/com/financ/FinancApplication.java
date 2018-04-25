package com.financ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.financ.interceptor.ScheduledTasks;

@SpringBootApplication
@EntityScan(basePackages = { "com.financ.model" })
@EnableJpaRepositories("com.financ.repository")
@EnableScheduling
public class FinancApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancApplication.class, args);
	}

	@Bean
	public ScheduledTasks scheduledTasks() {
		return new ScheduledTasks();
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
		return new Jackson2ObjectMapperBuilderCustomizer() {
			@SuppressWarnings("deprecation")
			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				// TODO Auto-generated method stub
				jacksonObjectMapperBuilder.dateFormat(new ISO8601DateFormat());
			}
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:4200");
			}
		};
	}

}
