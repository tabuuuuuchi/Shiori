package main;

import java.util.ArrayList;
import java.util.List;

import constant.MenuConst;
import model.Book;
import service.BookService;
import util.InputUtil;

public class Main {

	public static void main(String[] args) {
		//	各クラス定義
		MenuConst menuConst = new MenuConst();
		BookService bookService = new BookService();
		InputUtil inputUtil = new InputUtil();

		//	データ読み込み
		bookService.deserialize();

		while (true) {

			//	終了判定に使用
			boolean finishJudge = false;
			//	検索、並び替えがされているかの判定に使用
			boolean searchSortJudge = false;
			//	検索、並び替え済みデータ格納
			List<Book> newBooks = new ArrayList<>();

			//	開始メニュー
			menuConst.displayMenu();
			int menuChoice = inputUtil.inputMenuNum();

			switch (menuChoice) {
			//	終了
			case 0:
				finishJudge = true;
				break;
			//	書籍登録
			case 1:
				bookService.addBook(inputUtil.inputTitle(), inputUtil.inputCategory(), inputUtil.inputSituation(),
						inputUtil.inputVolume(), inputUtil.inputPage());
				System.out.println("書籍データを1件追加しました。");
				System.out.println();
				break;
			//	書籍一覧表示
			case 2:
				while (true) {
					//	一覧表示終了判定に使用
					boolean showBksFinishJudge = false;

					//	全データ表示
					if (searchSortJudge) {
						bookService.showBooks(newBooks);
						newBooks.clear();
						//	検索済みデータ表示
					} else {
						bookService.showBooks(bookService.getBooks());
					}

					int showBksMnChoice = inputUtil.inputShowBooksMenu();
					switch (showBksMnChoice) {
					//	検索
					case 1:
						searchSortJudge = true;
						int searchChoice = inputUtil.inputSearchSubject();
						String searchWord = "";

						switch (searchChoice) {
						//	タイトルで検索
						case 1:
							searchWord = inputUtil.inputTitle();
							break;
						// カテゴリで検索
						case 2:
							searchWord = inputUtil.inputCategory();
							break;
						//	状態で検索
						case 3:
							searchWord = inputUtil.inputSituation();
							break;
						}

						newBooks = bookService.searchBook(searchChoice, searchWord);
						break;

					//	並び替え
					case 2:
						searchSortJudge = true;
						int sortChoice = inputUtil.inputSortSubject();
						int orderChoice = inputUtil.inputOrder();
						newBooks = bookService.sortBook(sortChoice, orderChoice);
						break;

					//	メニューに戻る
					case 0:
						searchSortJudge = false;
						showBksFinishJudge = true;
						break;
					}

					//	一覧表示終了判定
					if (showBksFinishJudge) {
						break;
					}
				}
				break;
			//	書籍更新
			case 3:
				while (true) {
					//	更新終了判定に使用
					boolean updateFinishJudge = false;

					//	全データ表示
					if (searchSortJudge) {
						bookService.showBooks(newBooks);
						newBooks.clear();
						//	検索済みデータ表示
					} else {
						bookService.showBooks(bookService.getBooks());
					}

					int updateMnChoice = inputUtil.inputUpdateDeleteMenu();
					switch (updateMnChoice) {
					//	データ更新
					case 1:
						searchSortJudge = false;
						updateFinishJudge = true;
						int updateId = inputUtil.inputUpdateDeleteId(bookService.getBooks());
						bookService.updateBook(
								updateId, inputUtil.inputNewTitle(updateId, bookService.getBooks()),
								inputUtil.inputNewCategory(updateId, bookService.getBooks()),
								inputUtil.inputNewSituation(updateId, bookService.getBooks()),
								inputUtil.inputNewVolume(updateId, bookService.getBooks()),
								inputUtil.inputNewPage(updateId, bookService.getBooks()));

						System.out.println("書籍データを1件更新しました");
						System.out.println();
						break;

					//	検索
					case 2:
						searchSortJudge = true;
						int searchChoice = inputUtil.inputSearchSubject();
						String searchWord = "";

						switch (searchChoice) {
						//	タイトルで検索
						case 1:
							searchWord = inputUtil.inputTitle();
							break;
						// カテゴリで検索
						case 2:
							searchWord = inputUtil.inputCategory();
							break;
						//	状態で検索
						case 3:
							searchWord = inputUtil.inputSituation();
							break;
						}

						newBooks = bookService.searchBook(searchChoice, searchWord);
						break;

					//	並び替え
					case 3:
						searchSortJudge = true;
						int sortChoice = inputUtil.inputSortSubject();
						int orderChoice = inputUtil.inputOrder();
						newBooks = bookService.sortBook(sortChoice, orderChoice);
						break;

					//	メニューに戻る
					case 0:
						searchSortJudge = false;
						updateFinishJudge = true;
						break;
					}

					//	更新終了判定
					if (updateFinishJudge) {
						break;
					}
				}
				break;
			//	書籍削除
			case 4:
				while (true) {
					//	削除終了判定に使用
					boolean deleteFinishJudge = false;

					//	全データ表示
					if (searchSortJudge) {
						bookService.showBooks(newBooks);
						newBooks.clear();
						//	検索済みデータ表示
					} else {
						bookService.showBooks(bookService.getBooks());
					}

					int updateMnChoice = inputUtil.inputUpdateDeleteMenu();
					switch (updateMnChoice) {
					//	データ削除
					case 1:
						searchSortJudge = false;
						deleteFinishJudge = true;
						int deleteId = inputUtil.inputUpdateDeleteId(bookService.getBooks());
						bookService.deleteBook(deleteId);
						System.out.println("書籍データを1件削除しました");
						System.out.println();
						break;

					//	検索
					case 2:
						searchSortJudge = true;
						int searchChoice = inputUtil.inputSearchSubject();
						String searchWord = "";

						switch (searchChoice) {
						//	タイトルで検索
						case 1:
							searchWord = inputUtil.inputTitle();
							break;
						// カテゴリで検索
						case 2:
							searchWord = inputUtil.inputCategory();
							break;
						//	状態で検索
						case 3:
							searchWord = inputUtil.inputSituation();
							break;
						}

						newBooks = bookService.searchBook(searchChoice, searchWord);
						break;

					//	並び替え
					case 3:
						searchSortJudge = true;
						int sortChoice = inputUtil.inputSortSubject();
						int orderChoice = inputUtil.inputOrder();
						newBooks = bookService.sortBook(sortChoice, orderChoice);
						break;

					//	メニューに戻る
					case 0:
						searchSortJudge = false;
						deleteFinishJudge = true;
						break;
					}

					//	削除終了判定
					if (deleteFinishJudge) {
						break;
					}
				}
				break;
			}

			//	終了判定
			if (finishJudge) {
				break;
			}
		}
		//	データ保存
		bookService.serialize();
		inputUtil.closeScanner();
		System.out.println("Shioriを終了します。");
	}
}
