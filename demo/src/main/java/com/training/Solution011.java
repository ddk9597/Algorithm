package com.training;

import java.util.Arrays;

/* 마지막 두 원소
 * 
 * 정수 리스트 num_list가 주어질 때, 
 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 
 * 마지막 원소가 그전 원소보다 크지 않다면 
 * 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.
 * 
 * 1. num_list의 길이를 구하기
 * 2. 마지막 원소 구하기
 * 3. 마지막 원소의 이전 원소 구하기
 * 4. 둘을 비교해서 추가한 새 배열 만들기.
 * 
 * */
public class Solution011 {

	public int[] solution(int[] num_list) {
		int length = num_list.length;

		int lastNum = num_list[length - 1];
		int secLastNum = num_list[length - 2];

		int newElement;
		if (lastNum > secLastNum) {
			newElement = lastNum - secLastNum;
		} else {
			newElement = lastNum * 2;
		}

		int[] answer = Arrays.copyOf(num_list, length + 1);
		answer[length] = newElement;

		return answer;
	}
}
