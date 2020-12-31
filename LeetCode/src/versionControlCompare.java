import java.util.*;

public class versionControlCompare {
	public int compareVersion_v0(String version1, String version2) {
		String[] v1 = version1.split("[.]");
		String[] v2 = version2.split("[.]");
		int i = 0, j = 0, n = v1.length, m = v2.length;
		while(i < n || j < m) {
			while(i < n && j < m) {
				if(Integer.parseInt(v1[i]) ==
						Integer.parseInt(v2[j])) {
					i++; j++;
				} else
					return Integer.compare(Integer.parseInt(v1[i]),
							Integer.parseInt(v2[j]));
			}
			// one reaches end
			while(i < n && Integer.parseInt(v1[i]) == 0) i++;
			while(j < m && Integer.parseInt(v2[j]) == 0) j++;
			if(i < n && Integer.parseInt(v1[i]) > 0) return 1;
			if(j < m && Integer.parseInt(v2[j]) > 0) return -1;
		}
		// both reach end
		return 0;
	}

	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int n = v1.length, m = v2.length;
		for(int i = 0; i < Math.max(n,m); i++) {
			int val1 = i < n ? Integer.valueOf(v1[i]) : 0;
			int val2 = i < m ? Integer.valueOf(v2[i]) : 0;
			if(val1 != val2) return Integer.compare(val1, val2);
		}
		return 0;
	}
}