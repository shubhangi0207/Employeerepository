import java.util.HashMap;

public class ThreadExample {

	public static void main(String args[]) {
		String str = "Shubhangi";
		charCount(str);
	}

	public static void charCount(String str) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> ccm = new HashMap<Character, Integer>();
		char[] strArray = str.toCharArray();

		for (char c : strArray) {
			if (ccm.containsKey(c)) {
				ccm.put(c, ccm.get(c) + 1);
			} else {
				ccm.put(c, 1);
			}
		}

	}
}
