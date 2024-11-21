package com.training;

import java.util.Stack;

/* 페인트 칠하기
 * 
 * 그리디 알고리즘. 전에 풀었던 미사일과 유사하다.
 * 
 * 정수 n : 페인트를 칠할 벽의 길이
 * 정수 m : 롤러의 길이(한번에 칠할 수 있는 벽의 갯수)
 * 정수 배열 section : 페인트를 칠하기로 결정한 벽의 번호.
 * 
 * // section 배열 : 다시 칠해야 하는 구역을 오름차순으로 제공.
   // currentEnd : 현재 롤러로 커버할 수 있는 구역의 끝을 추적함.
   // section 배열을 순회하며, currentEnd를 넘어서는 구역을 만날 때마다 롤러를 배치하고,
   // 그 구역을 기준으로 롤러가 커버하는 범위를 업데이트.
   // 최소 롤러 횟수를 반환함.
 * 
 * 
 * */

public class Solution026_1 {

	public int solution(int n, int m, int[] section) {
		int count = 0; // 현재 롤러 횟수
		int currentEnd = 0; // 현재 롤러로 커버되는 끝 구간
		
		// 섹션마다 반복.
		for(int sec : section) {
			// 롤러로 커버 불가능한 구간을 만나면 새로운 롤러질 추가.
			if(sec > currentEnd) {
				count ++ ;
				currentEnd += sec + m -1;
			}
		}

		return count;
	}

}
