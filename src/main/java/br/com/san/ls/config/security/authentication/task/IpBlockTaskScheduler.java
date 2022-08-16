package br.com.san.ls.config.security.authentication.task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.san.ls.config.security.authentication.constant.FilePathConstant;

@Component
@EnableScheduling
public class IpBlockTaskScheduler {

	@Scheduled(cron = "0 59 23 ? * *", zone = "America/Sao_Paulo")
	public void clearFile() {
		File file = new File(FilePathConstant.PATH_FILE_ID_BLOCK);
		try (FileWriter fileWriter = new FileWriter(file, false);
				BufferedWriter writer = new BufferedWriter(fileWriter)) {

			writer.write("");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
