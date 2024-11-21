package com.training;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 달리기 경주
 * 
 * 해설진들은 선수들이 자기 바로 앞의 선수를 추월 할 떄, 추월한 선수의 이름을 부른다.
 * "one", "dos", "tre" 선수들이 순서대로 달리고 있을 때, 
 * 해설진이 "dos"선수를 불렀다면 2등은 "dos"선수가 1등인 "one"선수를 추월했다는 것.
 * 즉, "dos"선수가 1등, "one"선수가 2등으로 바뀐다.
 * 
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 
 * 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 떄,
 * 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return하는 solution함수를 완성하라.
 * 
 * 
 * */

public class Solution024_2 {
	public String[] solution(String[] players, String[] callings) {
	
		// k : 선수 이름, v : 등수
		Map<String, Integer> rankMap = new HashMap<>();
		
		// 초기 등수를 rankMap에 저장.
		for(int i = 0 ; i < players.length ; i ++) {
			rankMap.put(players[i], i);
		}
		
		// callings 배열 처리
		for(String calledPlayer : callings) {
			// 호출된 선수의 현재 등수
			int currentRank = rankMap.get(calledPlayer);
			
			// 호출된 선수가 1등이 아니면 추월 처리
			if(currentRank > 0) {
				// 앞에 있는 선수의 이름
				String frontPlayer = players[currentRank -1];
				
				// 선수 위치를 서로 변경
				players[currentRank -1] = calledPlayer;
				players[currentRank] = frontPlayer;
				
				// Map에 등수 정보 업데이트
				rankMap.put(calledPlayer, currentRank -1); // 호명된 선수의 등수를 -1
				// 호명된 선수 앞의 선수의 등수를 호명된 선수의 변경 되기 전 등수로
				rankMap.put(frontPlayer, currentRank); 
				
			}
			
		}
		
		return players;
	}

	
}
