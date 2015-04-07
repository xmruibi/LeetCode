package string.ReadNCharacter;

public class Reader4 {
	protected int read4(char[] buf) {
		int readByte = 4;
		return Math.min(buf.length, readByte);
	}
}
