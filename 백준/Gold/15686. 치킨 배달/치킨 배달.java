import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    static int N, M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chickens = new ArrayList<>();
    static int[][] dist; // [집 인덱스][치킨집 인덱스]
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houses.add(new Point(i, j));
                else if (val == 2) chickens.add(new Point(i, j));
            }
        }

        // 거리 미리 계산
        int houseCnt = houses.size(), chickenCnt = chickens.size();
        dist = new int[houseCnt][chickenCnt];
        for (int i = 0; i < houseCnt; i++) {
            for (int j = 0; j < chickenCnt; j++) {
                Point h = houses.get(i);
                Point c = chickens.get(j);
                dist[i][j] = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
            }
        }

        combination(0, 0, new boolean[chickens.size()]);
        System.out.println(min);
    }

    static void combination(int start, int depth, boolean[] selected) {
        if (depth == M) {
            int total = 0;
            for (int i = 0; i < houses.size(); i++) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (selected[j]) {
                        minDist = Math.min(minDist, dist[i][j]);
                    }
                }
                total += minDist;
            }
            min = Math.min(min, total);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[i] = true;
            combination(i + 1, depth + 1, selected);
            selected[i] = false;
        }
    }
}
