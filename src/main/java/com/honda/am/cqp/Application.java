package com.honda.am.cqp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.honda.am.cqp.util.LoggingUtil;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, SQLException {

		LoggingUtil logging = new LoggingUtil();
		logging.createLogFiles();
		logging.moveOldLogFilesToArchive();
		logging.deleteOldLogFiles();
		SpringApplication.run(Application.class, args);
	}
}
