package com.algo.reminders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.algo.object.ConfigureReminders;

@SpringBootApplication
@ComponentScan(basePackages = { "com.algo.object", "com.algo.reminders", "com.algo.email" })
public class RemindersV2Application {

	private static final Logger log = LoggerFactory.getLogger(RemindersV2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(RemindersV2Application.class, args);
		System.exit(0);
	}

	public static Logger getLogger() {
		return log;
	}

	@Autowired
	private ConfigureReminders config;

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			if (args.length == 1)
				config.sendEmails = true;
			config.configure();
			
		};
	}
}
