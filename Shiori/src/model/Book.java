package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable {

	//	管理番号
	private int id;
	//	タイトル
	private String title;
	//	カテゴリ
	private String category;
	//	途中巻数
	private int volume;
	//	途中ページ
	private int page;
	//	状態（未読 or 途中 or 読了）
	private String situation;
	//	更新日
	private LocalDate lastUpdate;

	//	コンストラクタ
	public Book(int id, String title, String category, int volume, int page, String situation, LocalDate lastUpdate) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.volume = volume;
		this.page = page;
		this.situation = situation;
		this.lastUpdate = lastUpdate;
	}

	//	ゲッタ、セッタ
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
