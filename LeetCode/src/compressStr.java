import java.util.*;

public class compressStr {
	public int compress(char[] ch) {
		int j = 0, n = ch.length;
		for(int i = 0; i < n;) {
			int cnt = 0;
			for(int k = i; k < n; k++)
				if(ch[i] == ch[k]) cnt++;
				else break;
			ch[j++] = ch[i];
			if(cnt > 1) {
				for(char c : (cnt+"").toCharArray())
					ch[j++] = c;
			}
			i += cnt;
		}

		return j;
	}
}