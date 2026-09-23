package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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
	public void showBooks(List<Book> bookList) {
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
		for (Book book : bookList) {
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

	//	書籍更新機能
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

	//	書籍削除機能
	public void deleteBook(int id) {
		books.remove(id - 1);
		for (Book book : books) {
			if (book.getId() > id) {
				book.setId(book.getId() - 1);
			}
		}
	}

	//	書籍検索機能
	public List<Book> searchBook(int judge, String searchWord, List<Book> bookList) {
		List<Book> newBookList = new ArrayList<>();
		switch (judge) {
		//	タイトルで並び替え
		case 1:
			for (Book book : bookList) {
				if (book.getTitle().contains(searchWord)) {
					newBookList.add(book);
				}
			}
			break;
		//	カテゴリで並び替え
		case 2:
			for (Book book : bookList) {
				if (book.getCategory().contains(searchWord)) {
					newBookList.add(book);
				}
			}
			break;
		//	状態で並び替え
		case 3:
			for (Book book : bookList) {
				if (book.getSituation().contains(searchWord)) {
					newBookList.add(book);
				}
			}
			break;
		}
		return newBookList;
	}

	//	書籍並び替え機能
	public List<Book> sortBook(int judge, int orderJudge, List<Book> bookList) {
		List<Book> newBookList = new ArrayList<>();
		List<Integer> sortedIntList = new ArrayList<>();
		List<String> sortedStrList = new ArrayList<>();
		List<LocalDate> sortedDateList = new ArrayList<>();
		Collator collator = Collator.getInstance(Locale.JAPANESE);

		switch (judge) {
		//	IDで並び替え
		case 1:
			for (Book book : bookList) {
				sortedIntList.add(book.getId());
			}

			//	昇順
			if (orderJudge == 1) {
				Collections.sort(sortedIntList);
				for (int id : sortedIntList) {
					for (Book book : bookList) {
						if (book.getId() == id) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedIntList.sort(Comparator.reverseOrder());
				for (int id : sortedIntList) {
					for (Book book : bookList) {
						if (book.getId() == id) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}
			break;
			//	タイトルで並び替え
		case 2:
			for (Book book : bookList) {
				sortedStrList.add(book.getTitle());
			}

			//	昇順
			if (orderJudge == 1) {
				sortedStrList.sort(collator);
				;
				for (String title : sortedStrList) {
					for (Book book : bookList) {
						if (book.getTitle() == title) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedStrList.sort(((Comparator<Object>) collator).reversed());
				for (String title : sortedStrList) {
					for (Book book : bookList) {
						if (book.getTitle() == title) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}
			break;
			//	カテゴリで並び替え
		case 3:
			for (Book book : bookList) {
				sortedStrList.add(book.getCategory());
			}

			//	昇順
			if (orderJudge == 1) {
				sortedStrList.sort(collator);
				;
				for (String category : sortedStrList) {
					for (Book book : bookList) {
						if (book.getCategory() == category) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedStrList.sort(((Comparator<Object>) collator).reversed());
				for (String category : sortedStrList) {
					for (Book book : bookList) {
						if (book.getCategory() == category) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}
			break;
			//	状態で並び替え
		case 4:
			for (Book book : bookList) {
				sortedStrList.add(book.getSituation());
			}

			//	昇順
			if (orderJudge == 1) {
				sortedStrList.sort(collator);
				;
				for (String situation : sortedStrList) {
					for (Book book : bookList) {
						if (book.getSituation() == situation) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedStrList.sort(((Comparator<Object>) collator).reversed());
				for (String situation : sortedStrList) {
					for (Book book : bookList) {
						if (book.getSituation() == situation) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}
			break;
			//	途中巻数で並び替え
		case 5:
			for (Book book : bookList) {
				sortedIntList.add(book.getVolume());
			}

			//	昇順
			if (orderJudge == 1) {
				Collections.sort(sortedIntList);
				for (int volume : sortedIntList) {
					for (Book book : bookList) {
						if (book.getVolume() == volume) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedIntList.sort(Comparator.reverseOrder());
				for (int volume : sortedIntList) {
					for (Book book : bookList) {
						if (book.getVolume() == volume) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}
			break;
			//	途中ページで並び替え
		case 6:
			for (Book book : bookList) {
				sortedIntList.add(book.getPage());
			}

			//	昇順
			if (orderJudge == 1) {
				Collections.sort(sortedIntList);
				for (int page : sortedIntList) {
					for (Book book : bookList) {
						if (book.getPage() == page) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedIntList.sort(Comparator.reverseOrder());
				for (int page : sortedIntList) {
					for (Book book : bookList) {
						if (book.getPage() == page) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
			}break;
			//	更新日で並び替え
		case 7:
			for (Book book : bookList) {
				sortedDateList.add(book.getLastUpdate());
			}

			//	昇順
			if (orderJudge == 1) {
				sortedDateList.sort(LocalDate::compareTo);
				for (LocalDate lastUpdate : sortedDateList) {
					for (Book book : bookList) {
						if (book.getLastUpdate() == lastUpdate) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
							break;
						}
					}
				}
				//	降順
			} else if (orderJudge == 2) {
				sortedDateList.sort(Comparator.reverseOrder());
				for (LocalDate lastUpdate : sortedDateList) {
					for (Book book : bookList) {
						if (book.getLastUpdate() == lastUpdate) {
							if (newBookList.contains(book)) {
								continue;
							}
							newBookList.add(book);
						}
					}
				}
			}
			break;
		}

		return newBookList;
	}

	//	データ保存機能
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

	//	データ読み込み機能
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
		//			bookService.deserialize();
		bookService.addBook("鬼滅の刃", "漫画", "途中", 1, 53);
		bookService.addBook("銀魂", "漫画", "途中", 54, 100);
		bookService.addBook("銀河鉄道の夜", "小説", "途中", 1, 200);
		bookService.addBook("あいうえお", "雑誌", "未読", 0, 0);
		bookService.addBook("aiueo", "絵本", "読了", 100, 123);
		bookService.books.get(4).setLastUpdate(LocalDate.of(2026, 9, 22));
		bookService.showBooks(bookService.books);
		//		bookService.deleteBook(1);
		//		bookService.updateBook(1, "ゼクシィ", "雑誌", "未読", 0, 0);
//		bookService.showBooks(bookService.searchBook(3, "途中", bookService.books));
		bookService.showBooks(bookService.sortBook(7, 2, bookService.books));
		//			bookService.serialize();
	}
}
