package SWEA_7733_치즈_도둑;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class Solution {
    static boolean[][] cheese;
    static int[] dC = { 0, 1, -1, 0 };
    static int[] dR = { 1, 0, 0, -1 };
    static int N;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

		// T 만큼 loop
        for (int test = 1; test <= T; test++) {
            N = sc.nextInt();
            cheese = new boolean[N][N];

			// Map에 입력 받기
            Map<Integer, ArrayList<int[]>> find = new HashMap<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int num = sc.nextInt();
                    if (find.containsKey(num)) {
                        find.get(num).add(new int[] { i, j });
                    } else {
                        find.put(num, new ArrayList<>());
                        find.get(num).add(new int[] { i, j });
                    }
                }
            }

			// 기본 max 설정
            int max = 0;

			// 100부터 0까지 loop
            for (int i = 100; i > 0; i--) {
                
				// 만약 해당 맛의 치즈가 있으면 그 부위 재생시키고 떨어진 치즈들 find;
				if (find.containsKey(i)) {
                    List<int[]> tmp = find.get(i);
                    for (int j = 0; j < tmp.size(); j++) {
                        int[] nums = tmp.get(j);
                        cheese[nums[0]][nums[1]] = true;
                    }
                    int why = find();
 
                    max = Math.max(max, why);
                }
            }
            System.out.println("#" + test + " " + max);
        }
    }
 
    static boolean[][] C;
 
	// 떨어진 치즈 섬들 찾기
    public static int find() {
        C = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheese[i][j] && !C[i][j]) {
                    C[i][j] = true;
                    del(i, j);
                    answer += 1;
                }
            }
        }
        return answer;
    }
 

	// delta 탐색 하기
    public static void del(int c, int r) {
        for (int i = 0; i < 4; i++) {
            int CC = c + dC[i];
            int RR = r + dR[i];
            try {
                if (cheese[CC][RR] && !C[CC][RR]) {
                    C[CC][RR] = true;
                    del(CC, RR);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }
}