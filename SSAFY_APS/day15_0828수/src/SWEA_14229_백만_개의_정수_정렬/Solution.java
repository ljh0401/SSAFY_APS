package SWEA_14229_백만_개의_정수_정렬;

import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		// 백만개의 정수 입력 받기
		Scanner sc = new Scanner(System.in);
		int[] can = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			can[i] = sc.nextInt();
		}
		
		// 정수 quickSort
		quickSort(can, 0, 1000000-1);
		System.out.print(can[500000]);
	}
	
	// Hoare partition으로 quicksort
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = partition(arr, left, right);
			if (pivot == left) {
				pivot += 1;
				quickSort(arr, pivot , right);
			}
			else {
				quickSort(arr, left, pivot - 1);
				quickSort(arr, pivot , right);
			}
		}	
	}
	
	// Hoare partition
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int L = left+1;
		int R = right;
		while(L <= R) {
			while(L <= R && arr[L] <= pivot) L++;
			while(arr[R] > pivot) R--;
			if (L < R) {
				swap(arr, L, R);
			}
		}
		swap(arr, left, R);
		return R;
	}
	
	// 서로 배열 인자 바꾸기
	public static void swap(int[]arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}
}