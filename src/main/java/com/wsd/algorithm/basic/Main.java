package com.wsd.algorithm.basic;

import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		long m = cin.nextLong();
		int mul = 10000;
		int[][] A = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				A[i][j] = cin.nextInt();
				A[i][j]--;
			}
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1 * mul + 0, 0);
		List<Integer> order = new ArrayList<>();
		order.add(0);
		order.add(1);
		int today = 1;
		int yes = 0;
		while (true) {
			int nxt = A[today][yes];
			order.add(nxt);
			yes = today;
			today = nxt;
			if (map.containsKey(today * mul + yes)) {
				break;
			}
			map.put(today * mul + yes, order.size() - 2);
		}
		if (m < order.size()) {
			System.out.println(order.get((int)m - 1) + 1);
		} else {
			int first = map.get(today * mul + yes);
			int second = order.size() - 2;
			int circle = second - first;
			int left = (int) ((m - first) % circle);
			if (left == 0) {
				System.out.println(order.get(order.size() - 3) + 1);
			} else {
				System.out.println(order.get(first + left - 1) + 1);
			}
		}
    }
}