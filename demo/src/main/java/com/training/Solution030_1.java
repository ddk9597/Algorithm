package com.training;

import java.util.LinkedList;
import java.util.Queue;

/* 1x1 크기의 칸들로 이뤄진 직사각형 격자 형태의 미로
 * 각 칸은 통로 또는 벽으로 구성됨.
 * 통로인 칸으로만 이동 가능.
 * 
 * 탈출 문은 경로 상의 레버를 당긴 후에 열 수 있음
 * 
 * 즉, 
 * 시작지점 -> 레버 -> 탈출문 또는
 * 시작지점 -> 탈출문 -> 레버 -> 탈출문
 * 순으로 이동해야됨
 * 
 * 만일 시작지점 -> 레버 
 * 탈출문 -> 레버 로 도달 할 수 없다면 -1을 반환하고,
 * 
 * 탈출 가능하다면 이동한 칸의 갯수를 반환.
 * 
 * maps는 다음과 같은 형식으로 주어진다.
 * ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]
 * */

// 어케해야되니..
public class Solution030_1 {
	
	// 전역변수 : 이동기능
	// 일단 좌표 이동이니까 x,y축의 이동 기능을 만들어보자
	public static final int[] coordiX = {-1, 1, 0, 0};
	public static final int[] coordiY = {0, 0, -1, 1};
	
	
	public int solution(String[] maps) {
		
		// 지역변수 : 지도를 만들기 위한 재료 초기화
		int rows = maps.length;
		int cols = maps[0].length();
		char[][] grid = new char[rows][cols];
		int [] start = null;
		int [] lever = null;
		int [] exit = null;
		
		// 지도 만들기
		for(int i = 0 ; i < rows ; i ++) {
			grid[i] = maps[i].toCharArray();
			for(int j = 0 ; j < cols ; j ++) {
				if(grid[i][j] == 'S') start = new int[] {i, j};
				else if(grid[i][j] == 'L') lever = new int[] {i, j};
				else if(grid[i][j] == 'E') exit = new int[] {i, j};
			}
		}
		
		// 최단거리 탐색 알고리즘에 사용되는 bfs라는게 있구나..
		
		// bfs로 최단거리 계산
		int toLever = bfs(grid, start, lever, rows, cols);
		int toExit = bfs(grid, lever, exit, rows, cols);
		
		// 3. 결과 반환
		// 레버나 출구로 갈 수 없는 경우 -1을 반환
		if(toLever == -1 || toExit == -1) return -1;
		
		return toLever + toExit; // 총 걸리는 시간을 반환
	}
	
	// bfs 설정하기
	// linkedList로 Queue를 구현해서 FIFO를 이용한다.

	/* ---- BFS의 주요 개념
	 * 1. 탐색 방식
	 * 	BFS는 시작 지점부터 탐색을 시작.
	 * 	먼저 가까운 칸(노드)를 모두 방문한 뒤, 더 먼 노드로 이동함
	 * 	트리나 그래프를 층(layer) 단위로 탐색하는 것과 비슷
	 * 
	 * 2. FIFO 방식
	 * 	BFS는 큐(Queue) 자료구조를 사용하여 탐색할 노드(칸)을 관리함
	 * 	큐는 FIFO원칙을 따르므로, 먼저 탐색해야 할 노드가 먼저 처리됨
	 * 
	 * 3. 최단 경로 보장
	 * 	가중치가 없는 그래프에서 BFS는 탐색 과정에서 처음 도달한 경로가
	 *  최단 경로임을 보장함.
	 * 
	 * ---- BFS 작동 원리
	 * 1. 초기화
	 * 	시작 지점을 큐에 넣는다
	 * 	방문한 노드를 기록하기 위한 visitied 배열을 초기화한다.
	 * 
	 * 2. 탐색
	 * 	큐에서 노드를 꺼내 해당 노드의 모든 인접 노드를 큐에 추가한다.
	 *  인접 노드가 이미 방문한 노드라면 큐에 추가하지 않는다.
	 *  
	 * 3. 종료
	 *  목표 지점에 도달하면 탐색을 종료하고 경로 길이를 반환한다.
	 *  큐가 비어도 목표에 도달하지 못하면 탐색 실패로 간주한다.
	 * */
	private int bfs(char[][] grid, int[] start, int[] target, int rows, int cols) {
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rows][cols];
		
		
		queue.offer(new int[]{start[0], start[1], 0}); // 시작 위치와 시간
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()) {
        	int[] current = queue.poll();
        	int x = current[0];
        	int y = current[1];
        	int time = current[2];
        	
        	if(x == target[0] && y == target[1]) return time;
        	
        	for (int i = 0; i < 4; i++) {
                int nx = x + coordiX[i], ny = y + coordiY[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                        && !visited[nx][ny] && grid[nx][ny] != 'X') { // 벽은 탐색 불가
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, time + 1});
                }
            }
        	
        	
        
		}
		
		return -1;
	}
}
