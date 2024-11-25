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


// 어떻게 풀어야 할까?
/*
 *  1. 현재 문자(c)와 인덱스(i)를 구별(map을 사용하는 것이 좋겠다)
 *  2. 현재 인덱스, 문자를 기준으로 c와 같고 i보다 작은 조건을 만족하는 문자가 있는지 찾고
 *  3. 없다면 -1 반환, 있다면 i 에서 해당 문자의 인덱스(ii)를 뺀다.
 * 
 * */ 
public class Solution004_1 {

	public int[] solution(String s) {
		// 결과를 저장할 배열, 문자열과 같은 크기를 가짐
		int[] result = new int[s.length()];
		
		// 각 문자가 마지막으로 등장한 위치를 저장하는 맵 saveLetters 선언
		Map<Character, Integer> saveLetters = new HashMap<>();
		
		// 길이만큼 반복
		for (int i = 0; i < s.length(); i++) {
			// 현재 인덱스의 문자를 기준으로 작동
			char currentChar = s.charAt(i);
			
			// saveLetters에 currentChar 보다 작은 인덱스에 같은 문자가 있다면
			if (saveLetters.containsKey(currentChar)) {
				result[i] = i - saveLetters.get(currentChar);
			
			// 없다면 -1을 반환
			} else {
				result[i] = -1;
			}
			
			// 뒤에 오는 i와의 비교를 위해 map에 c,i 저장
			saveLetters.put(currentChar, i);
		}

		return result;
	}

	
	// 잘 되는지 확인해보기
	public static void main(String[] args) {
		Solution004_1 sol = new Solution004_1();
		String s1 = "banana";
		String s2 = "foobar";

		int[] result1 = sol.solution(s1);
		int[] result2 = sol.solution(s2);

		// 출력 부분
		System.out.println("Result for 'banana':");
		for (int num : result1) {
			System.out.print(num + " ");
		}
		System.out.println();

		System.out.println("Result for 'foobar':");
		for (int num : result2) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
