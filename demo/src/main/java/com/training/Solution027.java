package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 요격 시스템
 * 
 * A 나라가 B 나라를 침공하였습니다. B 나라의 대부분의 전략 자원은 아이기스 군사 기지에 집중되어 있기 때문에 A 나라는 B 나라의 아이기스 군사 기지에 융단폭격을 가했습니다.
 * A 나라의 공격에 대항하여 아이기스 군사 기지에서는 무수히 쏟아지는 폭격 미사일들을 요격하려고 합니다. 
 * 이곳에는 백발백중을 자랑하는 요격 시스템이 있지만 운용 비용이 상당하기 때문에 미사일을 최소로 사용해서 모든 폭격 미사일을 요격하려 합니다.
 * A 나라와 B 나라가 싸우고 있는 이 세계는 2 차원 공간으로 이루어져 있습니다. A 나라가 발사한 폭격 미사일은 x 축에 평행한 직선 형태의 모양이며 개구간을 나타내는 정수 쌍 (s, e) 형태로 표현됩니다. B 나라는 특정 x 좌표에서 y 축에 수평이 되도록 미사일을 발사하며, 발사된 미사일은 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격할 수 있습니다. 단, 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없습니다. 요격 미사일은 실수인 x 좌표에서도 발사할 수 있습니다.
 * 각 폭격 미사일의 x 좌표 범위 목록 targets이 매개변수로 주어질 때, 모든 폭격 미사일을 요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.
 * 
 * 제한 사항
 * 1 ≤ targets의 길이 ≤ 500,000
 * targets의 각 행은 [s,e] 형태입니다.
 * 이는 한 폭격 미사일의 x 좌표 범위를 나타내며, 개구간 (s, e)에서 요격해야 합니다.
 * 0 ≤ s < e ≤ 100,000,000
 * 
 * 
 * */

// 구간 스케쥴링 문제로 접근 가능.
// 그리디 알고리즘을 활용해 해결 가능함.
// 구간들을 끝나닌 지점을 기준으로 정렬한 뒤, 겹치지 않는 구간을 선택하는 것.

/* 1. 구간 정렬
 * targets리스트를 종료 지점 e를 기준으로 오름차순 정렬.
 * 종료 지점을 기준으로 정렬하면, 가장 빨리 끝나는 구간을 먼저 선택해 효율적으로 구간 커버 가능.
 * 
 * 2. 요격 미사일 발사 지점 선택
 * 현재 발사된 미사일이 커버할 수 없는 구간이 나타나면 새로운 미사일으 발사.
 * 미사일의 발사 위치는 현재 선택된 구간의 끝점 e로 설정함.
 * 
 * 3. 요격 횟수 계산
 * 각 구간을 순회하며 요격 미사일의 개수를 최소화 한다.
 * 
 * 
 * */

public class Solution027 {
	
	public int solution(int[][] targets) {
        // 구간의 종료 지점 e를 기준으로 오름차순 정렬
		
		// 2차원 배열 targets를 특정 기준(각행의 두번째 요소의 값인 o[1])으로 정렬
		// Arrays.sort : 배열을 정렬하는 메서드, 정렬 기준을 지정하지 않으면 기본 정렬 방식(오름차순)으로 정렬됨.
		// 2차원배열의 특정 요소를 기준으로 정렬하려면 Comparator를 사용하여 기준을 명시한다.
		// Comparator.comaringInt() : 비교 기준이 정수일 때 사용되는 메서드로, 정렬 기준을 설정한다.
		// o -> o[1] : 람다 표현식, 배열 o의 두 번째 요소인 o[1]을 기준으로 정렬하겠다는 뜻.
       
		Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int missiles = 0;  // 발사한 미사일 수
        double lastMissilePosition = -1;  // 마지막 미사일 발사 위치

        // 모든 구간을 순회
        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            // 현재 구간이 마지막 미사일이 커버하지 못하면 새 미사일 발사
            if (lastMissilePosition < start) {
                missiles++;  // 새로운 미사일 발사
                lastMissilePosition = end - 0.1;  // 종료 지점 바로 이전에 발사
            }
        }

        return missiles;
    }
}
