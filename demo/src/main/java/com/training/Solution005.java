package com.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 가장 많이 받은 선물
 * 선물을 주고 받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받는 지 예측
 * 
 * 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
 * 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
 * 
 * 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 
 * 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
 * 
 * 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
 * 
 * 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. 
 * B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 
 * 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
 * 
 * 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
 * 
 * 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.
 *
 * 친구들의 이름을 담은 1차원 문자열 배열 friends
 * 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다. 
 * 
 * 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
 * 
 * 
 * 제한 사항
 * 	2 ≤ friends.length = 친구들의 수 ≤ 50
 *	friends의 원소는 친구의 이름을 의미하는 알파벳 소문자로 이루어진 길이가 10 이하인 문자열입니다.
 *	이름이 같은 친구는 없습니다.
 *	1 ≤ gifts.length ≤ 10,000
 *	gifts의 원소는 "A B"형태의 문자열입니다. 
 *	A는 선물을 준 친구의 이름을 B는 선물을 받은 친구의 이름을 의미하며 공백 하나로 구분됩니다.
 *	A와 B는 friends의 원소이며 A와 B가 같은 이름인 경우는 존재하지 않습니다.
 *
 * */

/* 어떻게 풀어야 할까
 * 
 * 1. 서로 준 선물 비교
 *
 * 2. 선물 지수(giftQuotient) 비교
 * 	1). 선물을 준 사람 카운트(Map giver<name:give>)
 * 	2). 선물을 받은 사람 카운트 (Map receiver<name:receive>)
 * 	3). giver, reveiver를 비교, 선물지수 추출
 * 
 * */
public class Solution005 {
	public int solution(String[] friends, String[] gifts) {

		int a = friends.length;

		// giftQuotient 비교하기 위한 List 객체 생성
		List<String> giveCount = new ArrayList<>();
		List<String> receiveCount = new ArrayList<>();

		// 서로 준 선물 비교하기 위한 map 객체 생성
		Map<String, Integer> compare = new HashMap<>();

		// friends Array를 순회하면서 값 비교하기
		for (int i = 0; i < a; i++) {
			// 1. freinds 배열에 있다면 compare의 Key에 추가, value는 우선 0으로 설정
			if (!friends[i].isEmpty()) {
				compare.put(friends[i], 0);
			}
		}

		// 2. gifts의 i 번째 인덱스의 첫번째 문자가 compare에 있다면 해당 Key의 value를 =+1
		for (String gift : gifts) {
			String[] parts = gift.split(" ");
			String giver = parts[0];
			String receiver = parts[1];

			// 3. 주는 사람, 받는 사람 각각을 List에 중복 여부 상관 없이 추가
			giveCount.add(giver);
			receiveCount.add(receiver);
		}

		// 4. 선물 지수 구하기
		// friends Array를 순회하면서 각각 giver, receiver에 있는 수를 확인 후 선물 지수 계산하기
		for (String name : friends) {

			int given = 0;
			int received = 0;

			// given ++ 조건 및 수행
			for (String giver : giveCount) {
				if (giver.equals(name)) {
					given++;
				}
			}

			for (String receiver : receiveCount) {
				if (receiver.equals(name)) {
					received++;
				}
			}
			
			int giftQuotient = given - received;
			compare.put(name, giftQuotient);

		}

		// 최종 결산하기

		int answer = 0;
		return answer;
	}
}
