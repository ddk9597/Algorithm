package com.training;

// 정수 start_num와 end_num가 주어질 때, 
// start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

/*
 * 어떻게 할까
 * 1. 배열의 크기를 조정한다.
 *  -> 또는 List로 해도 된다.
 * 2. 시작숫자부터 1씩 커지는 반복문을 통해, 해당 반복문의 숫자를 배열에 저장한다
 * 
 * 
 * */
public class Solution009 {

	public int[] solution(int start_num, int end_num) {
		// 배열 크기를 end_num - start_num + 1 로 설정
		// List와 다른 점 : 배열은 크기를 조정해야됨. 고정된 크기를 가짐.
		int[] answer = new int[end_num - start_num + 1];

		// for 루프를 사용하여 start_num 부터 end_num 까지 배열에 채우기
		for (int i = 0; i <= end_num - start_num; i++) {
			answer[i] = start_num + i;
		}

		return answer;
	}

}
