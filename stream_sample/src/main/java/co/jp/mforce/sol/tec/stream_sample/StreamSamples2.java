package co.jp.mforce.sol.tec.stream_sample;

import java.util.stream.Stream;

/**
 * 年齢が30歳以上の対象としてなんか処理する
 *
 */
public class StreamSamples2 {
	private static final User[] users = new User[] { 
			new User(10, "山田"),
			new User(25, "鈴木"), 
			new User(35, "佐藤"),
			new User(50, "加山雄三") };

	/**
	 * foreach+ifでゴニョゴニョするやつ
	 */
	public void パターン1_foreachパターン() {
		for (User user : users) {
			if (user.age >= 30) {
				writer(user);
			}
		}
	}

	/**
	 * Java8 で追加された Stream API を利用したパターン Rubyとかでよく見かけるが、Java8 に見慣れていないとアロー (->)
	 * に戸惑う気がするので慣れておきたい。
	 */
	public void パターン2_StreamAPI() {
		// Streamの場合、基本的にインデックスは取れない
		Stream.of(users).filter(u -> u.age >= 30).forEach(s -> writer(s));
	}

	private void writer(User u) {
		System.out.println(u.name);
	}

}

class User {
	int age;
	String name;

	public User(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
