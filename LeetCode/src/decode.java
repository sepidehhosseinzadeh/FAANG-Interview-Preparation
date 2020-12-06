import java.util.*;

public class decode {
	public String interpret(String command) {
		return command.replace("()", "o").replace("(", "").replace(")", "");
	}
	public String interpret_v1(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'G') sb.append('G');
			else if(s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
				i++;
				sb.append('o');
			} else {
				i += 3;
				sb.append("al");
			}

		}
		return sb.toString();
	}
}
