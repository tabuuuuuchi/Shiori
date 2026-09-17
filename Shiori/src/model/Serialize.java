package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialize {

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
