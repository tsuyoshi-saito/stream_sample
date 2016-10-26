package co.jp.mforce.sol.tec.stream_sample;

import java.util.function.ObjIntConsumer;
import java.util.stream.Stream;

/**
 * String配列を標準出力に出すだけのサンプル
 *
 */
public class StreamSamples {
	private static final String[] names = { "山田", "鈴木", "佐々木" };

	/**
	 * インデックスでループさせるパターン。 
	 * 太古のコードであるが、どうしてもインデックスが欲しい時以外は使わない。
	 * トラバース目的で使う場合、「インデックスが欲しい」のか「トラバースしたい」のかわからんので非推奨
	 */
	public void インデックス回し() {
		for (int i = 0; i < names.length; i++) {
			this.writer(names[i], i);
		}
	}

	/**
	 * 要素をトラバースしたいなら一般的な構文。
	 * foreach または拡張for文と呼ばれる。
	 */
	public void foreach回し() {
		// インデックスが欲しいなら別途定義が必要
		for (String name : names) {
			this.writer(name);
		}
	}

	/**
	 * Java8 で追加された Stream API を利用したパターン
	 * Rubyとかでよく見かけるが、Java8 に見慣れていないとアロー (->) に戸惑う気がするので慣れておきたい。
	 */
	public void StreamAPI回し() {
		// Streamの場合、基本的にインデックスは取れない
		Stream.of(names).forEach(s -> writer(s));
	}

	/**
	 * StreamAPIを使いたい。でもインデックスもほしい。
	 * そんな欲張りなあなたに。
	 */
	public void eachWithIndex風Stream回し() {
		this.eachWithIndex(names, (name, index) -> this.writer(name, index));
	}
	
	/**
	 * オマケ。
	 * インデックス付きforループをStreamっぽく見せかける。
	 * @param <T>
	 * @param s
	 */
	private <T> void eachWithIndex(T[] items,ObjIntConsumer<T> consumer){
		for (int i = 0; i < items.length; i++) {
			consumer.accept(items[i], i);
		}
	}

	// Stringを出すだけ。
	private void writer(String s) {
		System.out.println(s);
	}

	// インデックス付きでStringを出すだけ。
	private void writer(String s, int index) {
		System.out.println(String.format("%s:%s", index, s));
	}
}
