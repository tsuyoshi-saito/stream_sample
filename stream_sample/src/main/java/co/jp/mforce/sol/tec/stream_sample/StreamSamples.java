package co.jp.mforce.sol.tec.stream_sample;

import java.util.function.ObjIntConsumer;
import java.util.stream.Stream;

/**
 * String�z���W���o�͂ɏo�������̃T���v��
 *
 */
public class StreamSamples {
	private static final String[] names = { "�R�c", "���", "���X��" };

	/**
	 * �C���f�b�N�X�Ń��[�v������p�^�[���B 
	 * ���ẪR�[�h�ł��邪�A�ǂ����Ă��C���f�b�N�X���~�������ȊO�͎g��Ȃ��B
	 * �g���o�[�X�ړI�Ŏg���ꍇ�A�u�C���f�b�N�X���~�����v�̂��u�g���o�[�X�������v�̂��킩���̂Ŕ񐄏�
	 */
	public void �C���f�b�N�X��() {
		for (int i = 0; i < names.length; i++) {
			this.writer(names[i], i);
		}
	}

	/**
	 * �v�f���g���o�[�X�������Ȃ��ʓI�ȍ\���B
	 * foreach �܂��͊g��for���ƌĂ΂��B
	 */
	public void foreach��() {
		// �C���f�b�N�X���~�����Ȃ�ʓr��`���K�v
		for (String name : names) {
			this.writer(name);
		}
	}

	/**
	 * Java8 �Œǉ����ꂽ Stream API �𗘗p�����p�^�[��
	 * Ruby�Ƃ��ł悭�������邪�AJava8 �Ɍ�����Ă��Ȃ��ƃA���[ (->) �Ɍ˘f���C������̂Ŋ���Ă��������B
	 */
	public void StreamAPI��() {
		// Stream�̏ꍇ�A��{�I�ɃC���f�b�N�X�͎��Ȃ�
		Stream.of(names).forEach(s -> writer(s));
	}

	/**
	 * StreamAPI���g�������B�ł��C���f�b�N�X���ق����B
	 * ����ȗ~����Ȃ��Ȃ��ɁB
	 */
	public void eachWithIndex��Stream��() {
		this.eachWithIndex(names, (name, index) -> this.writer(name, index));
	}
	
	/**
	 * �I�}�P�B
	 * �C���f�b�N�X�t��for���[�v��Stream���ۂ�����������B
	 * @param <T>
	 * @param s
	 */
	private <T> void eachWithIndex(T[] items,ObjIntConsumer<T> consumer){
		for (int i = 0; i < items.length; i++) {
			consumer.accept(items[i], i);
		}
	}

	// String���o�������B
	private void writer(String s) {
		System.out.println(s);
	}

	// �C���f�b�N�X�t����String���o�������B
	private void writer(String s, int index) {
		System.out.println(String.format("%s:%s", index, s));
	}
}
