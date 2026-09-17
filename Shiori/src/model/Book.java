package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

	//	管理番号
	private int id;
	//	食材名
	private String name;
	//	カテゴリ
	private String category;
	//	保存場所
	private String storage;
	//	更新日
	private LocalDate updateDate;
	//	賞味期限
	private LocalDate bestByDate;
	//	消費期限
	private LocalDate useByDate;
	//	在庫判定
	private boolean stock;

	//	コンストラクタ
	public Book(int id, String name, String category, String storage, LocalDate updateDate, LocalDate bestByDate,
			LocalDate useByDate, boolean stock) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.storage = storage;
		this.updateDate = updateDate;
		this.bestByDate = bestByDate;
		this.useByDate = useByDate;
		this.stock = stock;
	}

	//	ゲッタ、セッタ
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateByDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public LocalDate getBestByDate() {
		return bestByDate;
	}

	public void setBestByDate(LocalDate bestByDate) {
		this.bestByDate = bestByDate;
	}

	public LocalDate getUseByDate() {
		return useByDate;
	}

	public void setUseByDate(LocalDate useByDate) {
		this.useByDate = useByDate;
	}

	public boolean getStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

}
