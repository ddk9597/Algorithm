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

		// 반환할 결과를 저장할 배열. 주어진 문자열과 같은 크기를 가짐.
		int[] result = new int[s.length()];

		// 각 문자가 마지막으로 등장한 위치를 저장하는 맵 saveLetters선언
		Map<Character, Integer> saveLetters = new HashMap<>();

		// 주어진 문자열의 길이만큼 반복
		for (int i = 0; i < s.length(); i++) {
			// 현재 인덱스의 묹를 기준으로 작동함
			char currentChar = s.charAt(i);

			// saveLetters에 currentChar보다 작은 인덱스에 같은 문자가 있는지 확인
			// 있다면 결괏값의 i번째 인덱스의 값 == i - 같은 글자의 인덱스번호.
			if (saveLetters.containsKey(currentChar)) {
				result[i] = i - saveLetters.get(currentChar);

				// 없으면 -1을 반환함
			} else {
				result[i] = -1;

			}

			// 뒤에 오는 i와의 비교를 위해 map에 c,i 저장
			saveLetters.put(currentChar, i);

		}

		return result;
	}

}
