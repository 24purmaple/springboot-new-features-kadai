package com.example.samuraitravel.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //このクラスがエンティティという宣言
@Table(name = "houses") //データベースのテーブル"houses"に紐づく
@Data //フィールドを定義するとコンストラクタ、ゲッター、セッターも自動生成してくれる
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt; //いつ作成されたか　↑これ以上増やさないし更新もしないよってこと
	
	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;
}
//@Entityが行で横
//@Columnが列で縦

/* @Entityアノテーションは、Javaのエンティティクラスをデータベースのテーブルにマッピングします。エンティティクラスは、テーブルの行（レコード）に相当します。
 * @Columnアノテーションは、エンティティクラスのフィールドをデータベースのテーブルの列にマッピングします。フィールドは、テーブルの列に相当します。
 * @Tableアノテーションは、エンティティクラスがどのデータベースのテーブルにマッピングされるかを指定します。つまり、エンティティクラスが対応するテーブルを明示的に指定するために使用されます。 */

/* @Entityが行で横
 * @Columnが列で縦
 * これがテーブルを文字で表すってこと
 * それがデータベースのどのテーブルに紐づくか表す@Table
 * これがエンティティとデータベースの関係？ */