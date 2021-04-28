package com.sid.autoEcole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sid.autoEcole.service.IAutoEcoleInitService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AutoEcoleApplication implements CommandLineRunner {
	
	@Autowired
	private IAutoEcoleInitService autoEcoleService;

	public static void main(String[] args) {
		SpringApplication.run(AutoEcoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		autoEcoleService.initStudent();
		autoEcoleService.initQuestion();
		autoEcoleService.initCdRom();
		autoEcoleService.initSerie();
		autoEcoleService.initOrder();
		autoEcoleService.initSession();
		autoEcoleService.initFaults();
		
		
	}

}
