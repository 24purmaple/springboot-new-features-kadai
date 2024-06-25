package com.example.samuraitravel.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewEditForm {
	
	@NotNull
	private Integer id;
	
	@NotNull(message = "評価を選択してください")
	@Min(value = 0, message = "星の数を入力してください。")
	@Max(value = 5, message = "星の数は5以下の数を入力してください。")
	private int rating;
	
	@NotBlank(message = "レビューを入力してください。")
	private String review;
}