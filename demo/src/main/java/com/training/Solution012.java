package com.training;

/* 이어 붙인 두 수 
 * 
 * 정수가 담긴 리스트 num_list가 주어집니다. 
 * num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.
 * 
 * */
public class Solution012 {

	public int solution(int[] num_list) {

		// 1. 홀수만 이어 붙인 수
		StringBuilder horse = new StringBuilder();

		// 2. 짝수만 이어 붙인 수
		StringBuilder jax = new StringBuilder();

		// i 가 0부터 시작한다면 length보다 작아야됨(이하 안됨!)
		for (int i = 1; i <= num_list.length; i++) {

			int x = num_list[i];
			// 홀수인 경우
			if (x % 2 != 0) {
				horse.append(x);
			}
			// 짝수인 경우
			if (x % 2 == 0) {
				jax.append(x);
			}
		}

		int horseNum = horse.length() > 0 ? Integer.parseInt(horse.toString()) : 0;
		int jaxNum = jax.length() > 0 ? Integer.parseInt(jax.toString()) : 0;
		
		return horseNum + jaxNum;

	}
}
