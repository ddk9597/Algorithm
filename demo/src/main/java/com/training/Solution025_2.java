package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * 명예의 전당 TV 프로그램
 * 매일 1명의 가수가 노래를 부르고, 문자투표로 점수를 부여함.
 * 매일 출연한 가수가 지금까지 출연 가수들의 점수 중 상위 k번째 이내이면 해당 가수의 점수를 명전 목록에 올려 기념함.
 * 즉, 프로그램 시작 이후 초기에 k일 까지는 모든 출연가수의 점수가 명전에 오름.
 * k일 다음부터는 출연 가수의 점수가 기존의 명전 목록의 k번째 순위의 가수 점수보다 높으면,
 * 출연 가수의 점수가 명전에 오르고 기존의 k번째 순위의 점수는 명전에서 내려오게 됨.
 * 
 * 매일 최하위 점수를 발표함.
 * 
 * 명전 목록의 점수의 개수 k, 1일부터 마지막날 까지 출연한 가수들의 점수인 score가 주어질 때,
 * 매일 발표된 명전의 최하위 점수를 return하는 solution 함수를 작성하라.
 * 
 * */


// PriorityQueue 사용

public class Solution025_2 {
	 public int[] solution(int k, int[] score) {
	        // 결과를 저장할 리스트
	        List<Integer> answer = new ArrayList<>();
	        
	        // 최소 힙 선언 (우선순위 큐)
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        
	        // 점수를 순회
	        for (int s : score) {
	            // 현재 점수를 힙에 추가
	            minHeap.add(s);
	            
	            // 힙의 크기가 k를 초과하면 최솟값 제거
	            if (minHeap.size() > k) {
	                minHeap.poll();
	            }
	            
	            // 현재 힙의 루트(최솟값)를 결과에 추가
	            answer.add(minHeap.peek());
	        }
	        
	        // 리스트를 배열로 변환 후 반환
	        return answer.stream().mapToInt(i -> i).toArray();
	    }
	    
	    public static void main(String[] args) {
	    	Solution025_2 solution = new Solution025_2();
	        
	        int k = 3;
	        int[] score = {10, 100, 20, 150, 1, 200, 1000, 50};
	        
	        int[] result = solution.solution(k, score);
	        System.out.println(Arrays.toString(result));
	    }
	    
}

