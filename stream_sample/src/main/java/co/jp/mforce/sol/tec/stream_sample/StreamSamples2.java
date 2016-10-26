package co.jp.mforce.sol.tec.stream_sample;

import java.util.stream.Stream;

/**
 * �N�30�Έȏ�̑ΏۂƂ��ĂȂ񂩏�������
 *
 */
public class StreamSamples2 {
	private static final User[] users = new User[] { 
			new User(10, "�R�c"),
			new User(25, "���"), 
			new User(35, "����"),
			new User(50, "���R�Y�O") };

	/**
	 * foreach+if�ŃS�j���S�j��������
	 */
	public void �p�^�[��1_foreach�p�^�[��() {
		for (User user : users) {
			if (user.age >= 30) {
				writer(user);
			}
		}
	}

	/**
	 * Java8 �Œǉ����ꂽ Stream API �𗘗p�����p�^�[�� Ruby�Ƃ��ł悭�������邪�AJava8 �Ɍ�����Ă��Ȃ��ƃA���[ (->)
	 * �Ɍ˘f���C������̂Ŋ���Ă��������B
	 */
	public void �p�^�[��2_StreamAPI() {
		// Stream�̏ꍇ�A��{�I�ɃC���f�b�N�X�͎��Ȃ�
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
