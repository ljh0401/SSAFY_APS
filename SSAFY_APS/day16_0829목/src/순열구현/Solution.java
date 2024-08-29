package 순열구현;

import java.util.Arrays;

public class Solution {
	static int[] arr, str;
	static int N;
	public static void main(String[] args) {
		arr = new int[] {0, 1, 2, 3};
		str = new int[4];
		N = arr.length;
		perm(0, 0);
	}
	
	// swap
//	public static void perm(int n, int k) {
//		if (k == n) {
//			System.out.println(Arrays.toString(arr));
//			return;
//		}
//		for (int i = k; i < n; i++) {
//			swap(i, k);
//			perm(n, k+1);
//			swap(i, k);
//		}
//	
//	}
	
	// bit
	public static void perm(int idx, int v) {
		if (idx == N) {
			System.out.println(Arrays.toString(str));
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((v & (1 << i)) != 0) {
				continue;
			}
			str[idx] = arr[i];
			perm(idx+1, v | (1<<i));
		}
	}
	
	
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b]= tmp;
	}
}