import java.util.*;

public class codecStrs {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for(String s : strs) {
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> ret = new ArrayList<String>();
		int i = 0;
		while(i < s.length()) {
			int slash = s.indexOf('/', i);
			int size = Integer.valueOf(s.substring(i, slash));
			i = slash + size + 1;
			ret.add(s.substring(slash + 1, i));
		}
		return ret;
	}
}
class Codec_v0 {
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		if (strs.size() == 0) return Character.toString((char)258);

		String d = Character.toString((char)257);
		StringBuilder sb = new StringBuilder();
		for(String s: strs) {
			sb.append(s);
			sb.append(d);
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		String d = Character.toString((char)258);
		if (s.equals(d)) return new ArrayList();

		d = Character.toString((char)257);
		return Arrays.asList(s.split(d, -1));
	}
}