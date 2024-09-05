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
		Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, num});
        bb[num] = true;
		int idx = 0;
        int count = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if (idx != tmp[0] ) {
				idx = tmp[0];
				count = tmp[1];
			}
			else {
				count = Math.max(count, tmp[1]);
			}
            if (!map.containsKey(tmp[1])) {
            	continue;
            }
			for (int n : map.get(tmp[1])) {
				if (bb[n]) continue;
				bb[n] = true;
				queue.add(new int[] {idx+1, n});
			}
		}
		return count;
	}
}