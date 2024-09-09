package SWEA_1267_작업순서;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10번의 loop
		int T = 10;
		for (int test = 1; test <= T; test++) {
			
			// V, E 입력 받기
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			// 전입 차수 저장 배열 nums, 각 노드에서 다음 노드로 이어진 간선 저장 Map map 설정 
			int[] nums = new int[V+1];
			Map<Integer, List<Integer>> map = new HashMap<>();
			
			// 값 입력
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				List<Integer> list = map.getOrDefault(start, new ArrayList<>());
				list.add(end);
				nums[end] += 1;
				map.put(start, list);
			}
			
			// 위상 정렬하기 위한 queue 생성
			Queue<Integer> queue = new LinkedList<>();
			
			// 전입 차수 0인 시작 노드들 queue에 저장
			for (int i = 1; i < V+1; i++) {
				if(nums[i] == 0) {
					queue.add(i);
				}
			}
			
			// 출력값 저장할 StringBuilder 생성
			StringBuilder sb = new StringBuilder();
			sb.append('#');
			sb.append(test);
			
			// queue가 비어있지 않을 때 loop
			while(!queue.isEmpty()) {
				int num1 = queue.poll();
				sb.append(' ');
				sb.append(num1);
				if (!map.containsKey(num1)) continue;
				for (int num : map.get(num1)) {
					nums[num] -= 1;
					if (nums[num] == 0) {
						queue.add(num);
					}
				}
			}
			
			// 정답 출력
			System.out.println(sb);
		}
	}
}

