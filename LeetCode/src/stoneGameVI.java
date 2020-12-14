import java.util.*;

public class stoneGameVI {

	// stone values do not matter, it is the balance that determines the outcome of the game.
	// combined values are important. Sort stones by their sum value for Alice and Bob.
	// Because, Alice first sould take a stone with high value for herself and
	// also high value of Bob's (so Bob can't take it).
	// Assume there are only two stones.

	// Assume a stone valued [a,b] for Alice and Bod.
	// Alice takes it, worth a for Alice,
	// Bob takes it, worth b for Bob,
	// we can also consider that it worth -b for Alice.
	// The difference will be a+b.
	// That's the reason why we need to sort based on a+b.
	// For n=2, we have [a1,a2], [b1,b2]
	// For Alice, she can choose a1, so the diff is a1-b2, or choose a2, gets a2-b1
	// if a1+b1==a2+b2, then a1-b2=a2-b1, pick anyone
	// if a1+b1>a2+b2, then a1-b2>a2-b1, pick a1
	// so sort by ai+bi


	/*
	More formal proof:

	First stone values a1, b1 for Alice and Bob respectively.
	Second stone values a2, b2 for Alice and Bob respectively.
	Let S1 = a1 + b1 and S2 = a2 + b2

	Stone #	Alice's score	Bob's score
	1	    a1 = S1 - b1	    b1
	2	    a2 = S2 - b2	    b2
	Let F be the points difference between the two players: the sum of Alice's points minus the sum of Bob's points

	If Alice picks stone #1:

	F = a1 - b2 = (S1 - b1) - b2 = S1 - (b1 + b2)
	If Alice picks stone #2:

	F = a2 - b1 = (S2 - b2) - b1 = S2 - (b1 + b2)
	b1 + b2 is fixed for given stone values. So Alice should pick a stone with maximum sum of values to maximize F and make it positive.

	General case
	For N stones:

	F = ∑Si - (b1 + b2 + ... + bN) , where i in the numbers of stones that are picked by Alice.
	So the strategy for Alice whould be to pick each time a stone with maximum sum of values for Alice and Bob.

	Same strategy works for Bob who needs to minimize F and make it negative:

	F = (a1 + a2 + ... + aN) - ∑Sj , where j in the numbers of stones that are picked by Bob.
	*/

	public int stoneGameVI(int[] aliceV, int[] bobV) {
		int n = aliceV.length;

		int[][] val = new int[n][];
		for(int i = 0; i < n; i++) val[i] = new int[] {aliceV[i], bobV[i]};
		Arrays.sort(val, (i,j) -> j[0]+j[1] - (i[0]+i[1]));

		int aliceScore = 0, bobScore = 0;
		for(int turn = 0; turn < n; turn++)
			if(turn%2 == 0) aliceScore += val[turn][0];
			else bobScore += val[turn][1];

		return aliceScore-bobScore == 0 ? 0 : aliceScore-bobScore > 0 ? 1 : -1;
	}
}