package com.training;

import java.util.HashMap;
import java.util.Map;

public class Solution029_2 {

	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		
		// 1. 이름과 점수를 매핑
		Map<String, Integer> yearningScore = new HashMap<>();
		
		for(int i = 0 ; i < name.length ; i ++) {
			yearningScore.put(name[i], yearning[i]);
		}
		
		// 2차원 배열을 탐색하여 각 사진의 추억 점수 계산
		// 2차 배열은 length 로 행을 찾고, for each문으로 열(1차배열)을 찾는다.
		int [] answer = new int[photo.length];
		for(int i = 0 ; i < photo.length ; i ++) {
			int score = 0;
			for(String person : photo[i]) {
				score += yearningScore.getOrDefault(person, 0);
			}
		}
		
		
		return null;
		
	}
	
	
}
