package com.training;

import java.util.ArrayList;
import java.util.List;

/* 바탕화면 정리(프로그래머스)
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 * 
 * 
 * 바탕화면은 각 칸이 정사각형인 격자판.
 * 바탕화면의 상태를 나타낸 문자열 배열 wallpaper.
 * 
 * 파일들은 바탕화면의 격자칸에 위치하고 있음.
 * 바탕화면의 격자점들은 바탕화면의 가장 왼쪽 위를(0,0)으로 시작. x,y좌표로 표현됨
 * 빈 칸은 ".", 파일이 있는 칸은 "#" 의 값을 가짐.
 * 
 * 드래그를 하면 파일들을 선택할 수 있고, 선택된 파일들을 삭제 가능함.
 * 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한번에 지우려고 함.
 * 
 * 한번의 드래그로 모든 파일 삭제하기!
 * 
 * 드래그는 바탕화면의 격자점S(lux, luy) 부터 격자점E(rdx, rdy)로 이동.
 * 드래그한 거리는 |rdx - lux| + |rdy-luy|
 * 
 * 
 * wallpaper가 매개변수로 주어질 때,
 * 바탕화면의 파일을 한번에 샂게하기 위해 최소한의 이동거리를 갖는 드래그의
 * 시작점과 끝점을 담은 정수 배열을 return하는 solution함수를 작성하라.
 * 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면
 * 정수 배열 [lux, luy, rdx, rdy]를 return하면 됨.
 * 
 * 제한사항 -----
- 1 ≤ wallpaper의 길이 ≤ 50
- 1 ≤ wallpaper[i]의 길이 ≤ 50
- wallpaper의 모든 원소의 길이는 동일/
- wallpaper[i][j]는 바탕화면에서 
  i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
- wallpaper[i][j]는 "#" 또는 "."의 값만 가집니다.
- 바탕화면에는 적어도 하나의 파일이 있습니다.
- 드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 
  lux < rdx, luy < rdy를 만족해야 합니다.
 * 
 * */

// 배열의 최대, 최솟값음 Math.max(), Math.min()를 사용한다.
/*
 * 이 문제는 단순하게 접근해도 된다.
 * 전체 #의 좌표 중 가장 작은 (x,y), 가장 큰(x,y)를 반환하기만 하면 그만.
 * 
 * */

public class Solutuon028_2 {

	public int[] solution(String[] wallpaper) {

		// 최소, 최대 좌표를 초기화
		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rdx = Integer.MIN_VALUE;
		int rdy = Integer.MIN_VALUE;
		
		// 바탕화면 배열 탐색
		for(int i = 0 ; i < wallpaper.length ; i ++) {
			for(int j = 0 ; j < wallpaper[i].length(); j ++) {
				
				if(wallpaper[i].charAt(j) == '#') {
					lux = Math.min(lux, j);
					luy = Math.min(luy, j);
					rdx = Math.max(rdx, j);
					rdy = Math.min(rdy, j);
				}
			}
		}
		
		return new int[] {lux, luy, rdx, rdy};
    }
	
}
