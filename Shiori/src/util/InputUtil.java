package util;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import model.Book;

public class InputUtil {
	//	カテゴリ選択肢
	private static enum Category {
		COMIC(1, "漫画"), NOVEL(2, "小説"), MAGAZINE(3, "雑誌"), BUSINESSBOOK(4, "ビジネス書"), PICTUREBOOK(5,
				"絵本"), REFERENCEBOOK(6, "参考書");

		private final int num;
		private final String jpName;

		private Category(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	状態選択肢
	private static enum Situation {
		UNREAD(1, "未読"), READING(2, "途中"), FINISH(3, "読了");

		private final int num;
		private final String jpName;

		private Situation(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	並び替え対象選択肢
	private static enum SortSubject {
		ID(1, "ID"), TITLE(2, "タイトル"), CATEGORY(3, "カテゴリ"), SITUATION(4, "状態"), VOLUME(5,
				"途中巻数"), PAGE(6, "途中ページ"), LASTUPDATE(7, "更新日");

		private final int num;
		private final String jpName;

		private SortSubject(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	検索対象選択肢
	private static enum SearchSubject {
		TITLE(1, "タイトル"), CATEGORY(2, "カテゴリ"), SITUATION(3, "状態");

		private final int num;
		private final String jpName;

		private SearchSubject(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	一覧表示メニュー選択肢
	private static enum ShowBooksMenu {
		SEARCH(1, "検索"), SORT(2, "並び替え"), RETURN(0, "メニューに戻る");

		private final int num;
		private final String jpName;

		private ShowBooksMenu(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	更新、削除メニュー選択肢
	private static enum UpdateDeleteMenu {
		INPUTID(1, "対象のIDを入力"), SEARCH(2, "検索"), SORT(3, "並び替え"), RETURN(0, "メニューに戻る");

		private final int num;
		private final String jpName;

		private UpdateDeleteMenu(int num, String jpName) {
			this.num = num;
			this.jpName = jpName;
		}

		public int getNum() {
			return num;
		}

		public String getJpName() {
			return jpName;
		}
	}

	//	整数入力チェック
	private static int inputInt() {
		while (true) {
			try {
				int num = scan.nextInt();
				return num;
			} catch (InputMismatchException e) {
				System.out.print("有効な整数で入力してください: ");
				scan.next();
			}
		}
	}

	private static final Scanner scan = new Scanner(System.in);

	//	メニュー番号入力
	public int inputMenuNum() {
		int menuNum;
		while (true) {
			System.out.print("番号: ");
			menuNum = inputInt();

			if (menuNum >= 1 && menuNum <= 3) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		return menuNum;
	}

	//	書籍タイトル入力
	public String inputTitle() {
		System.out.println("書籍のタイトルを入力してください");
		System.out.print("タイトル: ");
		String title = scan.next();
		System.out.println();
		return title;
	}

	//	書籍カテゴリ入力
	public String inputCategory() {
		System.out.println("書籍のカテゴリを選択してください");
		System.out.println();
		for (Category category : Category.values()) {
			System.out.println(category.getNum() + ": " + category.getJpName());
		}
		System.out.println();
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 1 && choice <= 6) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}

		System.out.println();

		String result = "";
		for (Category category : Category.values()) {
			if (category.getNum() == choice) {
				result = category.getJpName();
			}
		}
		return result;
	}

	//	書籍状態入力
	public String inputSituation() {
		System.out.println("書籍の状態を選択してください");
		System.out.println();
		for (Situation situation : Situation.values()) {
			System.out.println(situation.getNum() + ": " + situation.getJpName());
		}
		System.out.println();
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 1 && choice <= 3) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}

		System.out.println();

		String result = "";
		for (Situation situation : Situation.values()) {
			if (situation.getNum() == choice) {
				result = situation.getJpName();
			}
		}
		return result;
	}

	//	途中巻数入力
	public int inputVolume() {
		System.out.println("途中の巻数を入力してください");
		System.out.print("巻数: ");
		int volume = inputInt();
		System.out.println();
		return volume;
	}

	//	途中ページ入力
	public int inputPage() {
		System.out.println("途中のページ数を入力してください");
		System.out.print("ページ数: ");
		int volume = inputInt();
		System.out.println();
		return volume;
	}

	//	検索対象選択肢入力
	public int inputSearchSubject() {
		System.out.println("何で検索しますか？");
		for (SearchSubject searchSubject : SearchSubject.values()) {
			System.out.println(searchSubject.getNum() + ": " + searchSubject.getJpName());
		}
		System.out.println();

		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 1 && choice <= 3) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();

		return choice;
	}

	//	並び替え対象選択肢入力
	public int inputSortSubject() {
		System.out.println("何で並び替えますか？");
		for (SortSubject sortSubject : SortSubject.values()) {
			System.out.println(sortSubject.getNum() + ": " + sortSubject.getJpName());
		}
		System.out.println();

		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 1 && choice <= 7) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();

		return choice;
	}

	//	並び替え昇順降順入力
	public int inputOrder() {
		System.out.println("昇順or降順?");
		System.out.println();

		System.out.println("1: 昇順");
		System.out.println("2: 降順");
		System.out.println();

		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();

		return choice;
	}

	//	一覧表示メニュー選択肢入力
	public int inputShowBooksMenu() {
		for (ShowBooksMenu showBksMenu : ShowBooksMenu.values()) {
			System.out.println(showBksMenu.getNum() + ": " + showBksMenu.getJpName());
		}
		System.out.println();
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 0 && choice <= 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();

		return choice;
	}

	//	更新、削除メニュー選択肢入力
	public int inputUpdateDeleteMenu() {
		for (UpdateDeleteMenu updDltMenu : UpdateDeleteMenu.values()) {
			System.out.println(updDltMenu.getNum() + ": " + updDltMenu.getJpName());
		}
		System.out.println();

		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice >= 0 && choice <= 3) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();

		return choice;
	}

	//	更新、削除対象ID入力
	public int inputUpdateDeleteId(List<Book> books) {
		int id;
		while (true) {
			System.out.print("ID: ");
			id = inputInt();

			if (id >= 1 && id <= books.size()) {
				break;
			} else {
				System.out.println("存在しないIDです");
			}
		}
		System.out.println();

		return id;

	}

	//	更新タイトル入力
	public String inputNewTitle(int id, List<Book> books) {
		System.out.println("タイトルを更新しますか？");
		System.out.println("1: 更新する");
		System.out.println("2: 更新しない");
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();
		String newTitle = books.get(id).getTitle();
		if (choice == 1) {
			newTitle = inputTitle();
		}

		return newTitle;
	}

	//	更新カテゴリ入力
	public String inputNewCategory(int id, List<Book> books) {
		System.out.println("カテゴリを更新しますか？");
		System.out.println("1: 更新する");
		System.out.println("2: 更新しない");
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();
		String newCategory = books.get(id).getCategory();
		if (choice == 1) {
			newCategory = inputCategory();
		}

		return newCategory;
	}

	//	更新状態入力
	public String inputNewSituation(int id, List<Book> books) {
		System.out.println("状態を更新しますか？");
		System.out.println("1: 更新する");
		System.out.println("2: 更新しない");
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();
		String newSituation = books.get(id).getSituation();
		if (choice == 1) {
			newSituation = inputSituation();
		}

		return newSituation;
	}

	//	更新途中巻数入力
	public int inputNewVolume(int id, List<Book> books) {
		System.out.println("途中の巻数を更新しますか？");
		System.out.println("1: 更新する");
		System.out.println("2: 更新しない");
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();
		int newVolume = books.get(id).getVolume();
		if (choice == 1) {
			newVolume = inputVolume();
		}

		return newVolume;
	}

	//	更新途中ページ入力
	public int inputNewPage(int id, List<Book> books) {
		System.out.println("途中のページを更新しますか？");
		System.out.println("1: 更新する");
		System.out.println("2: 更新しない");
		int choice;
		while (true) {
			System.out.print("番号: ");
			choice = inputInt();

			if (choice == 1 || choice == 2) {
				break;
			} else {
				System.out.println("存在しない選択肢です");
			}
		}
		System.out.println();
		int newPage = books.get(id).getPage();
		if (choice == 1) {
			newPage = inputPage();
		}

		return newPage;
	}

	public void closeScanner() {
		scan.close();
	}

	//	デバッグ
	public static void main(String[] args) {
		InputUtil input = new InputUtil();
		//		System.out.println(input.inputMenuNum());
		//		System.out.println(input.inputTitle());
		//		System.out.println(input.inputCategory());
		//		System.out.println(input.inputSituation());
		//		System.out.println(input.inputVolume());
		//		System.out.println(input.inputPage());
		//		System.out.println(input.inputShowBooksMenu());
		//		System.out.println(input.inputSearchSubject());
		//		System.out.println(input.inputOrder());
		//		System.out.println(input.inputUpdateDeleteMenu());
	}
}
