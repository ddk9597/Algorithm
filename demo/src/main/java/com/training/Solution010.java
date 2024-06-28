package com.training;

/*
 * 
 * 정수 n과 문자열 control이 주어집니다. 
 * control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

	"w" : n이 1 커집니다.
	"s" : n이 1 작아집니다.
	"d" : n이 10 커집니다.
	"a" : n이 10 작아집니다.
	위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
 * 
 *  어떻게 풀어야 할까
 *  
 *  1. control의 길이만큼 반복 .length()
 *  2. control의 인덱스에 할당된 문자마다 처리함 : charAt(i)
 *   -> case 구문으로 처리하면 되겠다.
 *   
 * */
class Solution010 {
	public int solution(int n, String control) {
		// 문자열 control을 하나씩 처리.
		for (int i = 0; i < control.length(); i++) {
			char command = control.charAt(i);
			switch (command) {
			case 'w':
				n += 1;
				break;
			case 's':
				n -= 1;
				break;
			case 'd':
				n += 10;
				break;
			case 'a':
				n -= 10;
				break;
			default:
				// 만약 정의되지 않은 문자가 들어온다면 아무것도 하지 않음
				break;
			}
		}

		return n;
	}
}
