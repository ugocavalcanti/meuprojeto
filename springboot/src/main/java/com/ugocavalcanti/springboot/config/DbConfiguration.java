package com.ugocavalcanti.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DbConfiguration {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	@Profile("dev")
	@Bean
	public String getDevConnection() {
		System.out.println("Obtendo conexão para ambiente de Desenvolvimento...");
		System.out.println(this.url);
		System.out.println(this.username);
		
		return "DB Connection H2 em Dev";
	}
	
	@Profile("prod")
	@Bean
	public String getProdConnection() {
		System.out.println("Obtendo conexão para ambiente de Producao...");
		System.out.println(this.url);
		System.out.println(this.username);
		
		return "DB Connection MySQL em Dev";
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
