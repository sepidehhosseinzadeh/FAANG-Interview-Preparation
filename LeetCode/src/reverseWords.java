import java.util.*;

public class reverseWords {
	public String reverseWords(String s) {
		String[] w = s.split("\\s+");
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
		for(String t : w)
			res += t+" ";
		return res.trim();
	}
}