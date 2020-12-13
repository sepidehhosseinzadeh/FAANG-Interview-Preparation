import java.util.*;

public class gameMaxMin {
	public static void main(String[] args)
	{
		System.out.print(stoneGameVII(new int[]{7,90,5,1,100,10,10,2}));
	}

	static TreeSet<Integer> score;
	public static int stoneGameVII(int[] stone) {
		score = new TreeSet<Integer>();
		play(0,stone.length-1, 0,0, stone);
		return Math.abs(score.first());
	}
	static int play(int l, int r, int alice, int bob, int[] stone) {
		if(l >= r) {
			score.add(alice-bob);
			return alice-bob;
		}

		// alice takes l or r, tries to max diff
		// bob takes the one that min the diff
		int a1 = alice+stone[l], a2 = alice+stone[r];
		int b1 = bob+stone[l+1], b2 = bob+stone[r-1];
		int b3 = bob+stone[r], b4 = bob+stone[l];

		int d1 = a1-b1, d2 = a1-b2, d3 = a1-b3;
		int d4 = a2-b1, d5 = a2-b2, d6 = a2-b4;

		if(d1 >= d4 && d1 >= d5 && d1 >= d6 ||
				d2 >= d4 && d2 >= d5 && d2 >= d6 ||
				d3 >= d4 && d3 >= d3 && d1 >= d6) { // alice : a1, l
			if(d1 <= d2 && d1 <= d3) { // bob d1, b1, l+1
				play(l+2, r, alice+stone[l], bob+stone[l+1], stone);
			} else { // d3, b3, r
				play(l+1, r-1, alice+stone[l], bob+stone[r], stone);
			}
		} else { // alice r
			if(d5 <= d4 && d5 <= d6) { // d5, b2, r-1
				play(l, r-2, alice+stone[r], bob+stone[r-1], stone);
			} else { // d6, b4, l
				play(l+1, r-1, alice+stone[r], bob+stone[l], stone);
			}
		}
		// int s1 = play(l+2, r, alice+stone[l], bob+stone[l+1], stone);
		// int s2 = play(l, r-2, alice+stone[r], bob+stone[r-1], stone);
		// int s3 = play(l+1, r-1, alice+stone[l], bob+stone[r], stone);
		// int s4 = play(l+1, r-1, alice+stone[r], bob+stone[l], stone);

		return 0;
//		if(l >= r) {
//			score.add(alice-bob);
//			return alice-bob;
//		}
//
//		// alice takes l or r, tries to max diff
//		// bob takes the one that min the diff
//		int a1 = alice+stone[l], a2 = alice+stone[r];
//
//		int b1 = bob+stone[l+1], b2 = bob+stone[r-1];
//		int b3 = bob+stone[r], b4 = bob+stone[l];
//
//		int d1 = a1-b1, d2 = a1-b2, d3 = a1-b3;
//		int d4 = a2-b1, d5 = a2-b2, d6 = a2-b4;
//
//		int s1 = play(l+2, r, alice+stone[l], bob+stone[l+1], stone);
//		int s2 = play(l, r-2, alice+stone[r], bob+stone[r-1], stone);
//		int s3 = play(l+1, r-1, alice+stone[l], bob+stone[r], stone);
//		int s4 = play(l+1, r-1, alice+stone[r], bob+stone[l], stone);
//
//		return 0;
	}
}
