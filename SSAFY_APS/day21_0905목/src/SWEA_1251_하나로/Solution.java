package SWEA_1251_하나로;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // T만큼 loop
        for (int test = 1; test <= T; test++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st1 = new StringTokenizer(br.readLine());
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int[][] map = new int[N][2];
        	List<List<Edge>> li = new ArrayList<>();
        	for (int i = 0; i < N; i++) {
        		map[i][0] = Integer.parseInt(st1.nextToken());
        		map[i][1] = Integer.parseInt(st2.nextToken());
        		li.add(new ArrayList<>());
        	}
        	for (int i = 0; i < N; i++) {
        		for (int j = i+1; j < N; j++) {
        			li.get(i).add(new Edge(Math.pow(map[i][0] - map[j][0], 2)+Math.pow(map[i][1] - map[j][1], 2), j));
        			li.get(j).add(new Edge(Math.pow(map[i][0] - map[j][0] , 2)+Math.pow(map[i][1]- map[j][1], 2), i));
        		}
        	}
        	double[] v = new double[N];
        	Arrays.fill(v, Double.MAX_VALUE);
        	boolean[] Vi = new boolean[N];
        	double answer = 0;
        	v[0] = 0;
        	int idx = 0;
        	for (int i = 0; i < N-1; i++) {
        		List<Edge> tmpL = li.get(idx);
        		Vi[idx] = true;
        		for (int j = 0; j <tmpL.size(); j++) {
        			int end = tmpL.get(j).end;
        			if (Vi[end]) continue;
        			double w = tmpL.get(j).w;
        			if (w < v[end]) {
        				v[end] = w;
        			}
        		}
        		double minW = Double.MAX_VALUE;
        		for (int j = 0; j < N; j++) {
        			if(Vi[j]) continue;
        			if(minW > v[j]) {
        				idx = j;
        				minW = v[j];
        			}
        		}
        	}
        	for (int j = 0; j < N; j++) {
        			answer += v[j];
    		}
            double E = Double.parseDouble(br.readLine());
            answer *= E;
            System.out.println("#" + test + " " + Math.round(answer));
        }
    }
    public static class Edge implements Comparable<Edge> {
    	double w;
    	int end;
    	
    	Edge(double w, int end) {
    		this.w = w;
    		this.end = end;
    	}
    	
    	@Override
    	public int compareTo(Edge e) {
    		if (e.w > this.w)
    			return -1;
    		else return 1;
    	}
    }
}

