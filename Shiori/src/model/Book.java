package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	//	オブジェクト保存
	public static void serialize(ArrayList<Book> list) {
		try {
			ObjectOutputStream objOutStream = new ObjectOutputStream(
					new FileOutputStream("src/model/Book.bin"));

			objOutStream.writeObject(list);
			objOutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	オブジェクト読み込み
	public static ArrayList<Book> deserialize() {
		List<Book> list = new ArrayList<Book>();
		try {
			ObjectInputStream objInStream = new ObjectInputStream(
					new FileInputStream("src/model/Book.bin"));

			List<Book> list2 = (ArrayList<Book>) objInStream.readObject();
			list = list2;
			objInStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return (ArrayList<Book>) list;
	}

}
