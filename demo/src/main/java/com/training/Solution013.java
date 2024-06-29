package com.training;
/* 원소들의 곱과 합 
 * 정수가 담긴 리스트 num_list가 주어질 때, 
 * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 
 * 크면 0을 return하도록 solution 함수를 완성해주세요.
 * 
 * */

public class Solution013 {
	public int solution(int[] num_list) {

		int m = 1; // 곱셈용 int
		int p = 0; // 덧셈용 int

		for (int i = 0; i < num_list.length; i++) {
			int x = num_list[i];
			m *= x;
			p += x;
		}

		int p2 = p * p;
		if (m < p2)
			return 1;
		else
			return 0;

	}
}
