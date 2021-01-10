import java.util.*;

public class reverseWords {
	public String reverseWords_v0(String s) {
		String[] w = s.split("\\s+"); // or split(" +")
		String res = "";
		int i = 0, j = w.length-1;
		while(i < j) {
			if(w[i].trim().equals("")) w[i++]="";
			else if(w[j].trim().equals("")) w[j--]="";
			else {
				String t = w[i];
				w[i] = w[j];
				w[j] = t;
				i++; j--;
			}
		}
		for(String t : w) res += t+" "; // String.join(" ", w)

		return res.trim();
	}

	public String reverseWords_v1(String s) {
		List<String> res = Arrays.asList(s.split(" +"));
		Collections.reverse(res);
		return String.join(" ", res).trim();
	}

	// no trim(), split(), StringBuilder,...
	public String reverseWords(String s) {
		char[] ch = s.toCharArray();
		reverse(ch, 0, ch.length-1);
		reverseWords(ch);
		return cleanSpace(ch);
	}
	void reverse(char[] ch, int i, int j) {
		while(i < j) {
			char t=ch[i];ch[i++]=ch[j];ch[j--]=t;
		}
	}
	void reverseWords(char[] ch) {
		for(int i = 0,n=ch.length; i < n; i++)
			if(ch[i] != ' ') {
				int j = i+1;
				while(j < n && ch[j] != ' ') j++;
				reverse(ch, i, j-1);
				i = j;
			}
	}
	String cleanSpace(char[] ch) {
		int i = 0, j = 0, n = ch.length;
		while(j < n) {
			while(j < n && ch[j]==' ') j++;
			while(j < n && ch[j]!=' ') ch[i++]=ch[j++];
			while(j < n && ch[j]==' ') j++; // this is for last spaces
			if(j < n) ch[i++]=' ';
		}
		return new String(ch).substring(0, i);
	}
}