import java.util.*;

public class removeComments {
	public List<String> removeComments(String[] line) {
		List<String> res = new ArrayList<>();
		int m = line.length;
		for(int l = 0; l < m; l++) {
			StringBuilder lineWO = new StringBuilder("");
			char[] ch = line[l].toCharArray();
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == '/' &&
						i+1 < ch.length &&(ch[i+1] == '*'|| ch[i+1] == '/')) {
					if(ch[i+1] == '/') break;
					else if(ch[i+1] == '*') {
						i += 2;
						boolean end = false;
						while(!end) {
							for(int j = i; j+1 < ch.length; j++)
								if(ch[j]=='*' && ch[j+1]=='/') {
									end = true;
									i = j+1;
									break;
								}
							if(!end) {
								l++;
								// we guaranteed to have end
								ch = line[l].toCharArray();
								i = 0;
							}
						}

					}
				}
				else
					lineWO.append(ch[i]);
			}
			if(lineWO.length() > 0)
				res.add(lineWO.toString());
		}
		return res;
	}
}