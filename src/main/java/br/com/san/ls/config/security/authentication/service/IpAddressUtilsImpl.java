package br.com.san.ls.config.security.authentication.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class IpAddressUtilsImpl implements IpAddressUtils {

	@Override
	public boolean existIp(String ip, String pathFile) {

		try (FileReader fileReader = new FileReader(pathFile); BufferedReader reader = new BufferedReader(fileReader)) {

			while (reader.ready()) {
				String line = reader.readLine();
				if (line.equals(ip)) {
					return true;
				}
			}

		} catch (IOException e) {
			return false;
		}
		return false;
	}

	@Override
	public void registerIdBlock(String ip, String pathFile) {

		File file = new File(pathFile);

		try (FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter writer = new BufferedWriter(fileWriter)) {

			if (file.exists() == false) {
				file.createNewFile();
			}

			writer.newLine();
			writer.append(ip);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
