package com.web_site.real_estate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.ailef.snapadmin.external.SnapAdminAutoConfiguration;

//@RequestMapping("https://web-site-real-estate.com")
@ImportAutoConfiguration(SnapAdminAutoConfiguration.class)
@SpringBootApplication
public class WebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
	}

}
