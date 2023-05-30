package com.labreporting.labreporting.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import com.labreporting.labreporting.config.AppConfiguration;

@Service
public class FileService {

	private AppConfiguration appConfiguration;

	private Tika tika;

	public FileService(AppConfiguration appConfiguration) {
		this.appConfiguration = appConfiguration;
		this.tika = new Tika();
	}

	public String writeBase64EncodedStringToFile(String image) throws IOException {

		String fileName = generateRandomName();
		File target = new File(appConfiguration.getUploadPath() + "/" + fileName);
		OutputStream outputStream = new FileOutputStream(target);

		byte[] base64enoded = Base64.getDecoder().decode(image);

		outputStream.write(base64enoded);
		outputStream.close();
		return fileName;
	}

	public String generateRandomName() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public void deleteFile(String oldImageName) {
		if (oldImageName == null) {
			return;
		}
		try {
			Files.deleteIfExists(Paths.get(appConfiguration.getUploadPath(), oldImageName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String detectType(String value) {
		byte[] base64encoded = Base64.getDecoder().decode(value);
		return tika.detect(base64encoded);
	}

}