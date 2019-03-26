package org.parul.pmp;

import org.parul.pmp.controller.FileUploadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.File;

@SpringBootApplication
@EnableAsync
public class PmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmpApplication.class, args);
	}

}

