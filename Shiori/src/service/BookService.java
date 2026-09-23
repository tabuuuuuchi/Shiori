package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import util.TableUtil;

public class BookService {
	private final List<Book> books = new ArrayList<>();

	//	書籍追加
	public void addBook(String title, String category, String situation, int volume, int page) {
		Book book = new Book((books.size() + 1), title, category, situation, volume, page, LocalDate.now());
		books.add(book);
	}

	//	書籍一覧表示
	public void showBooks() {
		TableUtil table = new TableUtil();
		//	各列の幅
		int idWidth = 5;
		int titleWidth = 25;
		int categordWidth = 10;
		int situationWidth = 10;
		int volumeWidth = 10;
		int pageWidth = 10;
		int lastUpdateWidth = 12;

		//	上部罫線出力
		table.printLine(idWidth, titleWidth, categordWidth, situationWidth, volumeWidth, pageWidth, lastUpdateWidth);
		//	列名出力
		table.printRow(
				"ID",
				"タイトル",
				"カテゴリ",
				"状態",
				"途中巻数",
				"途中ページ",
				"更新日",
				idWidth, titleWidth, categordWidth, situationWidth, volumeWidth, pageWidth, lastUpdateWidth);
		//	区切り線
		table.printLine(idWidth, titleWidth, categordWidth, situationWidth, volumeWidth, pageWidth, lastUpdateWidth);
		System.out.println();

		//	データ出力
		for (Book book : books) {
			table.printRow(
					String.valueOf(book.getId()),
					book.getTitle(),
					book.getCategory(),
					book.getSituation(),
					String.valueOf(book.getVolume()),
					String.valueOf(book.getPage()),
					book.getLastUpdate().toString(),
					idWidth, titleWidth, categordWidth, situationWidth, volumeWidth, pageWidth, lastUpdateWidth);
		}

		//	下部罫線出力
		table.printLine(idWidth, titleWidth, categordWidth, situationWidth, volumeWidth, pageWidth, lastUpdateWidth);
		System.out.println();
	}

	public void updateBook(int id, String newTitle, String newCategory, String newSituation, int newVolume,
			int newPage) {
		for (Book book : books) {
			if (book.getId() == id) {
				book.setTitle(newTitle);
				book.setCategory(newCategory);
				book.setSituation(newSituation);
				book.setVolume(newVolume);
				book.setPage(newPage);
				book.setLastUpdate(LocalDate.now());
			}
		}
	}

	public void deleteBook() {

	}

	//	オブジェクト保存
	public void serialize() {
		try {
			ObjectOutputStream objOutStream = new ObjectOutputStream(
					new FileOutputStream("Book.bin"));

			objOutStream.writeObject(books);
			objOutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	オブジェクト読み込み
	public void deserialize() {
		try {
			ObjectInputStream objInStream = new ObjectInputStream(
					new FileInputStream("Book.bin"));

			List<Book> list = (ArrayList<Book>) objInStream.readObject();
			for (Book book : list) {
				books.add(book);
			}
			objInStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//	デバッグ
	public static void main(String[] args) {
		BookService bookService = new BookService();
		//		bookService.deserialize();
		bookService.addBook("鬼滅の刃", "漫画", "途中", 1, 53);
		bookService.addBook("銀魂", "漫画", "途中", 54, 100);
		bookService.addBook("銀河鉄道の夜", "小説", "途中", 1, 200);
		bookService.showBooks();
		bookService.updateBook(1, "ゼクシィ", "雑誌", "未読", 0, 0);
		bookService.showBooks();
		//		bookService.serialize();
	}
}
