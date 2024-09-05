package SWEA_1238_Contact;

import java.util.*;

public class Solution {
	static Map<Integer, Set<Integer>> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			map = new HashMap<>();
			for (int i = 0; i < N/2; i++) {
				int num1 = sc.nextInt();
				int num2 = sc.nextInt();
				if (map.containsKey(num1)) {
					map.get(num1).add(num2);
				}
				else {
					map.put(num1, new HashSet<>());
					map.get(num1).add(num2);
				}
			}
			System.out.println("#"+test+" "+find(S));
		}
	}
	public static int find(int num) {
		boolean[] bb = new boolean[101];
		Queue<Int[]> queue = new LinkedList<>();
        queue.add(num);
        bb[num] = true;
		int idx = 0;
        int count = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
            if (!map.containsKey(tmp)) {
                idx = tmp;
                continue;
            }
			for (int n : map.get(tmp)) {
				if (bb[n]) continue;
				bb[n] = true;
				idx = Math.max(idx, n);
				if (map.containsKey(n)) queue.add(n);
			}
		}
		return idx;
	}
}