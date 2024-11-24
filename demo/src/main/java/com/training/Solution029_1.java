package com.training;

import java.util.HashMap;
import java.util.Map;

/* 그리움 점수 매기기
 * 프로그래머스 Lv 1.
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 
 * 인물 배열 name,
 * 점수 배열 yearning
 * 각 사진에 속한 인물 2차원 배열 photo
 * 
 * */

public class Solution029_1 {
	
	 public int[] solution(String[] name, int[] yearning, String[][] photo) {
	        // 1. 이름과 그리움 점수를 매핑
	        Map<String, Integer> yearningScore = new HashMap<>();
	        for (int i = 0; i < name.length; i++) {
	            yearningScore.put(name[i], yearning[i]);
	        }

	        // 2. 각 사진의 추억 점수 계산
	        int[] answer = new int[photo.length];
	        for (int i = 0; i < photo.length; i++) {
	            int score = 0;
	            for (String person : photo[i]) {
	                score += yearningScore.getOrDefault(person, 0); // 점수가 없으면 0으로 처리
	            }
	            answer[i] = score;
	        }

	        return answer;
	    }
}
