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

public class BookService {
	private final List<Book> books = new ArrayList<>();

	//	書籍追加メソッド
	public void addBook(String title, String category, int volume, int page, String situation) {
		Book book = new Book((books.size() + 1), title, category, volume, page, situation, LocalDate.now());
		books.add(book);
	}

	//	書籍一覧表示メソッド
	public void showBooks() {

	}

	public void updateBook() {

	}

	public void deleteBook() {

	}

	//	オブジェクト保存
	public void serialize(ArrayList<Book> list) {
		try {
			ObjectOutputStream objOutStream = new ObjectOutputStream(
					new FileOutputStream("Book.bin"));

			objOutStream.writeObject(list);
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
		BookService methods = new BookService();
		methods.addBook("鬼滅", "漫画", 1, 53, "途中");
		for (Book book : methods.books) {
			System.out.println(book.getId());
		}
	}
}
