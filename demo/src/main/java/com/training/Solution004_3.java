package com.training;

import java.util.HashMap;
import java.util.Map;

/* 가장 가까운 같은 글자
 * 
 * 문자열 s 가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 글자가 어디에 있는지 알고 싶다.
 * 예를 들어 s = "banana" 일 경우, 각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행 가능함
 * 	- b : 처음 나와서 자신의 앞에 같은 글자가 없음, 이는 -1로 표현
 * 	- a : 처음 나와서 자신의 앞에 같은 글자가 없음, 이는 -1로 표현
 * 	- n : 처음 나와서 자신의 앞에 같은 글자가 없음, 이는 -1로 표현
 *  - a : 자신 보다 두 칸 앞에 a가 있음, 이는 2로 표현
 *  - n : 자신 보다 두 칸 앞에 n이 있음, 이는 2로 표현
 *  - a : 자신 보다 두 칸, 네 칸 앞에 a가 있음, 이 중 가장 가까운 a는 두 칸 앞의 것이고, 이는 2로 표현
 *  따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
 *  
 *  제한 사항
 *  	1 =< s.length() =< 100000
 *  	s는 영어 소문자로만 이루어져 있음
 * */

public class Solution004_3 {

	public int[] solution(String s) {

		// 결괏 값을 저장할 result 배열 초기화
		int[] result = new int[s.length()];
		
		// 주어진 문자열을 각 인덱스마다 순회하여 현재 값을 저장함.
		
		// 각 letter별 값을 저장할 Map
		Map<Character, Integer>letters = new HashMap<>();
		
		// 현재 인덱스의 Character가 lettes에 없다면 -1을 result에 저장
		// 있다면 현재 인덱스와 그 다음으로 작은인덱스에 위치한 문자의 인덱스의 차이를 반환
		for(int i = 0 ; i < s.length() ; i ++) {
			char currentChar = s.charAt(i);
			
			if(letters.containsKey(currentChar)) {
				result[i] = i - letters.get(currentChar);
			} else result[i] = -1 ;
			
			letters.put(currentChar, i);
		}
		
		return result;
	}

}
