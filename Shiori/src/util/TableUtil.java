package util;

public class TableUtil {
	//	全角を2、半角を1としてカウントし、指定の幅（半角換算）になるように右側にスペースを埋める
	private static String padRight(String text, int totalWidth) {
		if (text == null)
			text = "";

		// 文字列の実際の表示幅（半角換算）を計算
		double doubleCurrentWidth = 0;
		boolean fullWidthJudge = false;
		for (char c : text.toCharArray()) {
			// 全角文字を大まかに判定
			if (String.valueOf(c).getBytes().length > 1) {
				doubleCurrentWidth += 1.7; // 全角は1.7幅
			} else {
				doubleCurrentWidth += 1; // 半角は1幅
			}
		}
		int currentWidth = (int) doubleCurrentWidth;

		//	不足している幅の分だけ半角スペースを足す
		int paddingSize = totalWidth - currentWidth;
		if (paddingSize <= 0) {
			return text; // すでに指定幅を超えている場合はそのまま返す
		}
		return text + " ".repeat(paddingSize);
	}

	//	1行分のデータを文字幅を考慮して出力するメソッド
	public void printRow(String c1, String c2, String c3, String c4, String c5, String c6, String c7, int w1,
			int w2, int w3, int w4, int w5, int w6, int w7) {
		System.out.printf("| %s | %s | %s | %s | %s | %s | %s |%n",
				padRight(c1, w1),
				padRight(c2, w2),
				padRight(c3, w3),
				padRight(c4, w4),
				padRight(c5, w5),
				padRight(c6, w6),
				padRight(c7, w7));
	}

	//	罫線出力メソッド
	public void printLine(int w1, int w2, int w3, int w4, int w5, int w6, int w7) {
		System.out.printf("+-%s-+-%s-+-%s-+-%s-+-%s-+-%s-+-%s-+%n", "-".repeat(w1), "-".repeat(w2), "-".repeat(w3),
				"-".repeat(w4), "-".repeat(w5), "-".repeat(w6), "-".repeat(w7));
	}

	//	デバッグ
	//	public static void main(String[] args) {
	//		TableUtil table = new TableUtil();
	//
	//		int w1 = 5;
	//		int w2 = 10;
	//		int w3 = 12;
	//		int w4 = 10;
	//		int w5 = 15;
	//		int w6 = 20;
	//		int w7 = 30;
	//
	//		table.printLine(w1, w2, w3, w4, w5, w6, w7);
	//		table.printRow(
	//				"あ",
	//				"iue",
	//				"おか",
	//				"kiくけ",
	//				"くけこさsisuせそ",
	//				"sisusesota",
	//				null,
	//				w1, w2, w3, w4, w5, w6, w7);
	//		table.printLine(w1, w2, w3, w4, w5, w6, w7);
	//		System.out.println(String.valueOf("く".toCharArray()).getBytes().length);
	//	}
}
