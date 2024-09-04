package SWEA_7468_창용_마을_무리의_개수;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// HashMap 만들기
			Map<Integer, List<Integer>> map = new HashMap<>();            
			
			// 입력 받기 (간선이 한 번만 주어지므로 나중에 편하게 시작점 , 끝점 모두 간선 입력)
			for(int i = 0; i < M; i++) {
                int K = sc.nextInt();
                int next = sc.nextInt();
				if(map.containsKey(K)) map.get(K).add(next);
                else {
                	map.put(K, new ArrayList<>());
                    map.get(K).add(next);
                }
                if(map.containsKey(next)) map.get(next).add(K);
                else {
                	map.put(next, new ArrayList<>());
                    map.get(next).add(K);
                }
			}
			
			// 연결된지 파악하기 위한 배열 생성
			boolean[] v = new boolean[N+1];
			
			// Queue 만들어서 매번 다음 이동할 부분 저장, poll
			Queue<Integer> queue = new LinkedList<>();
			int answer = 0;
			
			// 연결된 무리 나올 때마다 answer + 1
			for (int key : map.keySet()) {
				if(v[key]) {
					continue;
				}
                v[key] = true;
				List<Integer> li = map.get(key);
				for (int i = 0; i < li.size(); i++) {
					int num = li.get(i);
					if (!v[num]) {
						queue.add(num);
					}
				}
                
				while(!queue.isEmpty()) {
					int tmp = queue.poll();
                    if (v[tmp]) continue;
                    v[tmp] = true;
                    if (map.containsKey(tmp)) {
                        List<Integer> L = map.get(tmp);
                        for (int i = 0; i < L.size(); i++) {
                            int NUM = L.get(i);
                            if (v[NUM]) continue;
                            queue.add(NUM);
                        }
                    }
				}
				answer += 1;
			}
			
			// 1인 무리 더하기
			for (int i = 0; i < N+1; i++) {
				if (!v[i]) answer += 1;
			}
			
			// v[0]일 때 빼주기
            answer -= 1;
			System.out.println("#"+test+" "+answer);
		}
	}
}