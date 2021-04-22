package com.honda.am.cqp;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.xml.DOMConfigurator;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public void deleteOldLogFiles() {

		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinus6Months = currentDate.minusMonths(3);
		File path = new File("C:\\Honda\\Logs\\archive");
		String contents[] = path.list();
		if (contents != null) {
			for (int i = 0; i < contents.length; i++) {

				File file = new File(path + "\\" + contents[i]);
				System.out.println(file);
				String date = contents[i].split("\\.")[2];
				DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("yyyy_MM_dd");
				LocalDate local_date_2 = LocalDate.parse(date, formatter_2);

				if (local_date_2.isBefore(currentDateMinus6Months)) {
					Date date1 = java.sql.Date.valueOf(local_date_2);
					System.out.println(date1);
					file.delete();

				}
			}
		}

	}

	public void moveOldLogFilesToArchive() {

		LocalDate today = LocalDate.now();
		LocalDate eailer = today.minusDays(-1);
		File path = new File("C:\\Honda\\logs");
		String contents[] = path.list();
		for (int i = 0; i < contents.length; i++) {

			File file = new File(path + "\\" + contents[i]);

			if (!contents[i].equals("archive") && !contents[i].equals("logfile.log")) {
				if (contents.length >= 7) {

					System.out.println("files" + contents[i]);
					String date = contents[i].split("\\.")[2];
					DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("yyyy_MM_dd");
					LocalDate local_date_2 = LocalDate.parse(date, formatter_2);

					if (local_date_2.isBefore(today)) {
						Date date1 = java.sql.Date.valueOf(local_date_2);
						System.out.println(date1);
						Path temp;
						try {

							temp = Files.move(Paths.get(path + "\\" + contents[i]),
									Paths.get("C:\\Honda\\logs\\archive\\" + "\\" + contents[i]),
									StandardCopyOption.REPLACE_EXISTING);
							if (temp != null) {
								System.out.println("File moved successfully");
							} else {
								System.out.println("Failed to move the file");
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}
		}

	}

	public void createLogFiles() {

		// creates pattern layout
		PatternLayout layout = new PatternLayout();
		String conversionPattern = "[%p] %d [%t] %x %c %M - %m%n";
		layout.setConversionPattern(conversionPattern);

		// creates daily rolling file appender
		DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();

		rollingAppender.setFile("C:\\Honda\\Logs\\logfile.log");

		rollingAppender.setDatePattern("'.'yyyy_MM_dd'.log'");
		rollingAppender.setLayout(layout);
		rollingAppender.activateOptions();

		// configures the root logger
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.DEBUG);
		rootLogger.addAppender(rollingAppender);

		// creates a custom logger and log messages
		Logger logger = Logger.getLogger(Application.class.getName());

		logger.debug("this is a debug log message");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");
	}

	public static void main(String[] args) throws IOException, SQLException {
		DOMConfigurator.configure(".\\src\\main\\resources\\log4j2.xml");
		Application application = new Application();
		application.createLogFiles();
		application.moveOldLogFilesToArchive();
		application.deleteOldLogFiles();
		SpringApplication.run(Application.class, args);
	}
}
