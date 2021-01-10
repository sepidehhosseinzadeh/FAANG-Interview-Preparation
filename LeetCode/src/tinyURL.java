import java.util.*;

public class tinyURL {
	public class Codec {
		String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, String> revMap = new HashMap<>();

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			if(map.containsKey(longUrl)) return map.get(longUrl);
			String key = "";
			for(int i = 0; i < 6; i++) {
				char rand = alphabet.charAt((int)(Math.random()*alphabet.length()));
				key += rand;
			}
			map.put(longUrl, key);
			revMap.put(key, longUrl);
			return key;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			return revMap.containsKey(shortUrl) ? revMap.get(shortUrl) : null;
		}
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));