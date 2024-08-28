package 퀵정렬;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 10, 100, 1000, 500, 200, 5};
		quickSort(arr, 0, arr.length-1);
		System.out.print(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			
			// 기준이 될 좌표 ("h" 면 Hoare, 그 외는 Lomuto)
			int pivot = partition("l", arr, left, right);
			
			// 만약 pivot의 좌표가 처음 left 좌표와 같을 때 (left 값이 가장 작은 값일 때) pivot 좌표 +1, 우측만 보기
			if (pivot == left) {
				pivot += 1;
				quickSort(arr, pivot , right);
			}
			
			// 아니라면 왼쪽, 오른쪽 다 보기
			else {
				quickSort(arr, left, pivot - 1);
				quickSort(arr, pivot , right);
			}
		}	
	}
	
	public static int partition(String word, int[] arr, int left, int right) {
		// Hoare 파티션
		if (word.equals("h")) {
			
			// 기본 pivot 맨 왼쪽
			int pivot = arr[left];
			int L = left+1;
			int R = right;
			
			// pivot을 기준으로 왼쪽에는 pivot보다 작은 것, 오른쪽에는 pivot보다 큰 것 위치하도록
			while(L <= R) {
				while(L <= R && arr[L] <= pivot) L++;
				while(arr[R] > pivot) R--;
				if (L < R) {
					swap(arr, L, R);
				}
			}
			// 기본 pivot 위치를 값들 사이로 바꾸기
			swap(arr, left, R);
			return R;
		}
		
		// Lomuto 파티션
		else {
			
			// 기본 pivot 맨 오른쪽
			int pivot = arr[right];
			int idx = 0;
			
			// 만약 left가 0이면 기본 left 1로 바꿔주기
			if (left >0) idx = left -1;
			else left = 1;
			
			// pivot을 기준으로 작은 값들이 앞으로 가도록 배치
			for (int j = left; j < right; j++) {
				if (arr[j] <= pivot) {
					swap(arr, ++idx, j);
				}
			}
			
			// pivot 위치를 pivot 보다 큰 값이 오른쪽에 위치하도록 이동
			swap(arr, idx+1, right);
			return idx+1;
		}
	}
	
	// 서로 바꿔주는 메서드
	public static void swap(int[]arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;
	}
}