package 병합정렬;

import java.util.Arrays;

public class Solution {
	
	// 병합 정렬 하면서 매번 가져다가 임시로 쓸 arrSort 생성
	static int[] arrSort;
	public static void main(String[] args) {
		int[] arr = new int[] {1, 10, 100, 1000, 500, 200, 5};
		arrSort = new int[arr.length];
		mergeSort(arr, 0, arr.length-1);
		System.out.print(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		
		// 만약 right가 left보다 클 때 (무한 loop 안 돌도록)
		if (right > left) {
			
			// mid 값 설정
			int mid = (left+right)/2;
			
			// 재귀 돌리기
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			
			// 맨 아래부터 정렬 시작!
			int L = left;
			int R = mid+1;
			int idx = left;
			
			// L, R 중 하나 mid 혹은 right에 도달 할 때까지 낮은 값 먼저 입력
			while (L <= mid && R <= right) {
				if (arr[L] <= arr[R]) {
					arrSort[idx++] = arr[L++];
				}
				else {
					arrSort[idx++] = arr[R++];
				}
			}
			
			// 남은 값 모두 입력
			if (L <= mid) {
				for (int i = L; i <= mid; i++) {
					arrSort[idx++] = arr[i];
				}
			}
			else {
				for (int i = R; i <= right; i++) {
					arrSort[idx++] = arr[i];
				}
			}
			
			// 정렬한 값 기존 정렬로 옮겨주기 
			for (int i = left; i <= right; i++) {
				arr[i] = arrSort[i];
			}
		}
		
	}
}