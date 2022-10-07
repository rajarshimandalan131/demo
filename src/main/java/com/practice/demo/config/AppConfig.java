package com.practice.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/*We can use this way but @ConfigurationProperties has more power
class level
	@Configuration
	@PropertySource("classpath:application.properties")
variable level
	@Value("${spring.datasource.url}")
		private String url;
*/
/*we can use at springBootApplication class level
@ConfigurationPropertiesScan("com.baeldung.configurationproperties")
for scanning in custom locations*/
@Configuration
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "spring.datasource")
public class AppConfig {

//	@Value("${spring.datasource.url}")
	private static String url;
	private static String userName;
	private static String password;
	private static String driverClassName;
	
	 public static String getUrl() {
		return url;
	}



	public static void setUrl(String url) {
		AppConfig.url = url;
	}



	public static String getUserName() {
		return userName;
	}



	public static void setUserName(String userName) {
		AppConfig.userName = userName;
	}



	public static String getPassword() {
		return password;
	}



	public static void setPassword(String password) {
		AppConfig.password = password;
	}



	public static String getDriverClassName() {
		return driverClassName;
	}



	public static void setDriverClassName(String driverClassName) {
		AppConfig.driverClassName = driverClassName;
	}



	public void source()
	    {
		 System.out.println("AppConfig dataSource : " + url+ userName+ password+ driverClassName);
	    }
}
