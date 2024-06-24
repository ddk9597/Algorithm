package com.training;

/* 붕대 감기
 * 
 *  t초 동안 붕대를 감으면서 1초마다 x만큼의 체력을 회복함
 *  t초 연속 붕대 감는데 성공한다면 y만큼의 체력을 추가로 회복함
 *  체력 회복 상한은 캐릭터의 최대 체력임
 *  붕대를 감는 동안 공격을 당하면 기술이 취소되며 공격을 당하는 순간에는 체력 회복 불가
 *  몬스터에게 공격당해 기술이 취소당하거나 끝나면 그 즉시 다시 붕대감기를 사용, 연속 성공 시간이 0으로 초기화
 *  공격을 받으면 정해진 피해량만큼 체력이 줄어듬
 *  현재 체력이 0 이하가 되면 캐릭터가 죽으며 더 이상 체력 회복 불가함
 *  
 *  - 알아 낼 것
 *  붕대감기 기술의 정보, 캐릭터가 가진 최대 체력, 몬스터의 공격 패턴이 있다면 캐릭터가 끝까지 생존할 수 있는지
 *  
 *  - 주어진 것
 *  bandage : 붕대감기 기술의 시전 시간, 1초당 회복량, 추가 회복량을 담은 1차원 정수배열
 *  health : 최대 체력
 *  attacks : 몬스터의 공격 시간과 피해량을 담은 2차원 정수 배열
 *  - 결과로 낼 것
 *  return : 모든 공격이 끝난 직후 남은 체력
 *  만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return
 *  
 *  - 제한사항
 *  bandage는 [시전 시간, 초당 회복량, 추가 회복량] 형태의 길이가 3인 정수 배열입니다.
 *	1 ≤ 시전 시간 = t ≤ 50
 *	1 ≤ 초당 회복량 = x ≤ 100
 *	1 ≤ 추가 회복량 = y ≤ 100
 * 
 * **** 공격을 받아서 체력이 최대체력보다 낮아졌을 때 붕대감기 기술 시전 시작함!! ***
 * */
public class Solution003 {

	public static int solution(int[] bandage, int health, int[][] attacks) {
		int t = bandage[0]; // 붕대 감기 시전 시간 (초)
		int x = bandage[1]; // 1초당 회복량
		int y = bandage[2]; // 연속 성공 시 추가 회복량

		int currentHealth = health; // 현재 체력
		int success = 0; // 연속 성공 횟수
		int nextAttackTimer = 0; // 다음 공격의 인덱스
		int maxTime = attacks[attacks.length - 1][0]; // 가장 마지막 공격이 실행되는 시간

		// 시간 루프: 1초씩 진행하며 체력 회복과 공격을 처리
		for (int time = 1; time <= maxTime; time++) {
			// 현재 시간이 다음 공격 시간과 일치하면 공격 처리
			if (nextAttackTimer < attacks.length && time == attacks[nextAttackTimer][0]) {
				int damage = attacks[nextAttackTimer][1]; // 공격으로 인한 피해량
				currentHealth -= damage; // 현재 체력 감소
				nextAttackTimer++; // 다음 공격 인덱스 증가
				success = 0; // 연속 성공 횟수 초기화
			} else {
				// 공격이 없는 경우 붕대 감기 시도
				if (currentHealth < health) {
					success++; // 연속 성공 횟수 증가
					currentHealth = Math.min(health, currentHealth + x); // 체력 회복
					if (success == t) {
						currentHealth = Math.min(health, currentHealth + y); // 추가 회복
						success = 0; // 연속 성공 횟수 초기화
					}
				}
			}

			// 캐릭터의 체력이 0 이하가 되면 사망 처리
			if (currentHealth <= 0) {
				return -1; // 캐릭터 사망 시 -1 반환
			}
		}

		return currentHealth; // 모든 공격이 끝난 후 남은 체력 반환
	}
}
