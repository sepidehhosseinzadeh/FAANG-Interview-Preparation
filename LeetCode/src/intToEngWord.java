import java.util.*;

public class intToEngWord {
	public static void main(String[] args)
	{
		System.out.print(numberToWords(123123456));
	}
	static LinkedHashMap<Integer, String> map;
	public static String numberToWords(int num) {
		map = new LinkedHashMap<>();
		map.put(1000000000, "Billion");map.put(1000000, "Million");
		map.put(1000, "Thousand");map.put(100, "Hundred");
		map.put(90, "Ninety");map.put(80, "Eighty");
		map.put(70, "Seventy");map.put(60, "Sixty");
		map.put(50, "Fifty");map.put(40, "Forty");
		map.put(30, "Thirty");map.put(20, "Twenty");
		map.put(19, "Nineteen");map.put(18, "Eighteen");
		map.put(17, "Seventeen");map.put(16, "Sixteen");
		map.put(15, "Fifteen");map.put(14, "Fourteen");
		map.put(13, "Thirteen");map.put(12, "Twelve");
		map.put(11, "Eleven");
		map.put(10, "Ten");map.put(9, "Nine");
		map.put(8, "Eight");map.put(7, "Seven");
		map.put(6, "Six");map.put(5, "Five");
		map.put(4, "Four");map.put(3, "Three");
		map.put(2, "Two");map.put(1, "One");

		return convert(num);
	}
	public static String convert(int num) {
		if(num == 0) return "Zero";

		// go over map based on priority
		for(int k : map.keySet())
			if(num/k > 0)
				return (num >= 100 ? convert(num/k)+" " : "" ) + map.get(k) +
						(num%k == 0 ? "" : " "+convert(num%k));
		return "";
	}
}
