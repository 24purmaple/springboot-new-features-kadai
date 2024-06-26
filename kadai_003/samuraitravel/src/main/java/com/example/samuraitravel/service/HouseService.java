package com.example.samuraitravel.service;
//サービス→リポジトリ→エンティティ→データベース→エンティティ→リポジトリ
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.form.HouseEditForm;
import com.example.samuraitravel.form.HouseRegisterForm;
import com.example.samuraitravel.repository.HouseRepository;

@Service
public class HouseService {
	private final HouseRepository houseRepository;
	
	public HouseService(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}
	
	@Transactional
	public void create(HouseRegisterForm houseRegisterForm) {
		House house = new House();
		MultipartFile imageFile = houseRegisterForm.getImageFile();
		
		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();	//元のファイル名を取得する
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			house.setImageName(hashedImageName);
		}
		
		house.setName(houseRegisterForm.getName());
		house.setDescription(houseRegisterForm.getDescription());
		house.setPrice(houseRegisterForm.getPrice());
		house.setCapacity(houseRegisterForm.getCapacity());
		house.setPostalCode(houseRegisterForm.getPostalCode());
		house.setAddress(houseRegisterForm.getAddress());
		house.setPhoneNumber(houseRegisterForm.getPhoneNumber());
		
		houseRepository.save(house);
	}
	
	@Transactional
	public void update(HouseEditForm houseEditForm) {
		House house = houseRepository.getReferenceById(houseEditForm.getId());
		MultipartFile imageFile = houseEditForm.getImageFile();
		
		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();	//元のファイル名を取得する
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			house.setImageName(hashedImageName);
		}
		
		house.setName(houseEditForm.getName());
		house.setDescription(houseEditForm.getDescription());
		house.setPrice(houseEditForm.getPrice());
		house.setCapacity(houseEditForm.getCapacity());
		house.setPostalCode(houseEditForm.getPostalCode());
		house.setAddress(houseEditForm.getAddress());
		house.setPhoneNumber(houseEditForm.getPhoneNumber());
		
		houseRepository.save(house);
	}

	// UUIDを使って生成したファイル名を返す
		//ファイル名の変更処理
	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");			//1.fileNameを「.」で区切る　区切ったものがfileNames (配列が{house, png}になってる)
		for (int i = 0; i < fileNames.length - 1; i++) {	//2.fileNames（house）がランダムなUUIDに書き変わる
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);//3.それに「.」「fileNames(png)」がくっついたものが hashedFileName
		return hashedFileName;								//4.それをreturnする
	}
	
	//画像ファイルを指定したファイルにコピーする
		//ファイルのコピー処理
	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);	//MultipartFileインターフェースが提供するメソッド。ファイルの内容を読み取るためのInputStreamオブジェクトを取得する。
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
