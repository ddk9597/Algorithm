package com.training;

import java.util.HashSet;
import java.util.Set;


/*머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다. 
 * 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다. 
 * 문자열 배열 babbling이 매개변수로 주어질 때, 
 * 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 * 
 * 
 * */
public class Solution014 {

	  // 조카가 발음할 수 있는 단어의 개수를 반환하는 함수
    public int solution(String[] babbling) {
        // 유효한 발음 단어들을 저장하는 집합
        Set<String> validWords = new HashSet<>();
        validWords.add("aya");
        validWords.add("ye");
        validWords.add("woo");
        validWords.add("ma");

        int count = 0;  // 발음할 수 있는 단어의 개수를 저장할 변수

        // 주어진 배열을 순회하면서 각 단어가 발음할 수 있는지 확인
        for (String word : babbling) {
            if (canPronounce(word, validWords)) {
                count++;
            }
        }

        return count;  // 발음할 수 있는 단어의 총 개수를 반환
    }

    // 주어진 단어가 유효한 단어들로만 구성되어 있는지 확인하는 함수
    private boolean canPronounce(String word, Set<String> validWords) {
        // 유효한 단어들을 하나씩 제거하면서 단어를 검사
        for (String validWord : validWords) {
            if (word.contains(validWord)) {
                word = word.replace(validWord, " ");  // 유효한 단어를 공백으로 대체
            }
        }
        // 모든 유효한 단어를 제거한 후 남은 문자열이 비어 있는지 확인
        return word.trim().isEmpty();
    }
	
}
