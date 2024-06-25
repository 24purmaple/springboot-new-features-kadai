package com.example.samuraitravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //このクラスがエンティティという宣言
@Table(name = "verification_tokens") //データベースのテーブル"houses"に紐づく
@Data //フィールドを定義するとコンストラクタ、ゲッター、セッターも自動生成してくれる
public class VerificationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt; //いつ作成されたか　↑これ以上増やさないし更新もしないよってこと
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
}