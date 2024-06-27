package com.training;

/* 성격 유형 검사하기
 * 
 * 카카오 성격 유형 검사지 만들기
 * 다음과 같은 4개 지표로 성격 유형을 구분함
 * 성격은 각 지표에서 두 유형 중 하나로 결정됨
 * 지표번호
 * 	1. R, T
 * 	2. C, F
 * 	3. J, M
 * 	4. A, N
 * 
 * 성격 유형은 총 16가지가 나올 수 있음
 * 검사지에는 총 n 개의 질문이 있고 
 * 각 질문에는 아래와 같은 7개의 선택지가 있음
 * 	1. 매우 비동의 (앞 또는 뒤 지표 3점)
 * 	2. 비동의	(앞 또는 뒤 지표 2점)
 * 	3. 약간 비동의 (앞 또는 뒤 지표1점)
 *  4. 모르겠음 (모두 0점
 *  5. 약간 동의 (뒤 또는 앞 지표 1점)
 *  6. 동의 (뒤 또는 앞 지표 2점)
 *  7. 매우 동의 (뒤 또는 앞 지표 3점)
 * 
 * 각 질문은 1가지 지표로 성격 유형 점수를 판단함
 * 예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있음
 * 검사 결과는 모든 질문의 성격 유형 점수를 더하여
 * 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단함
 * 단, 하나의 지표에서 각 성격 유형 점수가 같으면,
 * 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단함
 * 
 * 질문마다 주어지는 Array
 * 	1. 1차원 String Array survey 	  	: 판단하는 지표를 담음
 * 	   원소 : "RT", "TR", "FC", "CF", 
 * 			 "MJ", "JM", "AN", "NA" 중 하나.
 * 
 *	2. 1차원 Integer Array choices  	: 선택지를 담음
 *	   길이 : servey의 길이
 *	   형태 : ["AN", "CF", "MJ", "RT", "NA"] ...
 *	3. choices[i] = 검사자가 선택한 i + 1 번째 질문의 선택지임
 *
 * 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return하도록
 * solution 함수를 완성
 * 
 * 
 * 조건
 * 
 * 
 * 보자.. 
 * 	결과값은
 * 	R, T -> 0
 * 	C, F -> 1
 * 	J, M -> 2
 * 	A, N -> 3
 *  순으로 나열됨 survey의 순서에 상관 없이. (이를 "s순서"라 칭하자.)
 *  
 *  각 s순서의 알파벳 중 선택되는 넘들은
 *  choices[i] + 1 의 값과, 
 *  각 순서 중 먼저 왔느냐, 나중에 왔느냐에 따라 결정됨
 *  
 *  그러니까, choices는 1~7인데 4인 경우를 제외하고
 *  1~3 : 앞자리에 4-n 만큼 점수를 더함
 *  4 	: 모두에게 0점을 더함
 *  5~7 : 뒷자리에 n-4 만큼 점수를 더함
 *  
 *  즉, 'N', 'A' 동일한 두 문자로 이루어진 survey,  
 *  choices가 3으로 동일해도
 *  
 *  'NA', 'AN' 인가에 따라 결과가 달라짐
 *  	NA : N에 1점 추가
 *  	AN : A에 1점 추가
 * 
 * */
public class Solution007 {

	public static String solution(String[] survey, int[] choices) {
		// 성격 유형 점수를 저장하기 위한 Map 초기화
		Map<Character, Integer> scores = new HashMap<>();
		scores.put('R', 0);
		scores.put('T', 0);
		scores.put('C', 0);
		scores.put('F', 0);
		scores.put('J', 0);
		scores.put('M', 0);
		scores.put('A', 0);
		scores.put('N', 0);

		// survey와 choices를 순회하면서 점수 계산
		for (int i = 0; i < survey.length; i++) {
			char type1 = survey[i].charAt(0);
			char type2 = survey[i].charAt(1);
			int choice = choices[i];

			if (choice < 4) {
				// 비동의 쪽
				scores.put(type1, scores.get(type1) + (4 - choice));
			} else if (choice > 4) {
				// 동의 쪽
				scores.put(type2, scores.get(type2) + (choice - 4));
			}
			// choice가 4일 때는 점수가 변하지 않으므로 아무 것도 하지 않음
		}

		// 최종 성격 유형 결정
		StringBuilder result = new StringBuilder();
		result.append(scores.get('R') >= scores.get('T') ? 'R' : 'T');
		result.append(scores.get('C') >= scores.get('F') ? 'C' : 'F');
		result.append(scores.get('J') >= scores.get('M') ? 'J' : 'M');
		result.append(scores.get('A') >= scores.get('N') ? 'A' : 'N');

		return result.toString();
	}
}
