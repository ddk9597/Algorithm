package com.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution023 {

	public int solution(int[][] points, int[][] routes) {
        // 포인트 번호에 따라 좌표 매핑
        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // 충돌 횟수 계산
        int dangerousCount = 0;

        // 로봇들의 현재 위치와 목표 경로 설정
        int[][] robotPositions = new int[routes.length][];
        int[] progress = new int[routes.length];
        for (int i = 0; i < routes.length; i++) {
            robotPositions[i] = pointMap.get(routes[i][0]).clone();
            progress[i] = 0; // 각 로봇의 경로 진행 상태
        }

        boolean allFinished = false;
        while (!allFinished) {
            allFinished = true;
            Map<String, Integer> positionCount = new HashMap<>();

            for (int i = 0; i < routes.length; i++) {
                // 이미 모든 경로를 완료한 로봇은 스킵
                if (progress[i] == routes[i].length - 1) {
                    continue;
                }

                int[] currentPosition = robotPositions[i];
                int[] targetPosition = pointMap.get(routes[i][progress[i] + 1]);

                // 이동 수행
                if (currentPosition[0] != targetPosition[0]) {
                    currentPosition[0] += (currentPosition[0] < targetPosition[0]) ? 1 : -1;
                } else if (currentPosition[1] != targetPosition[1]) {
                    currentPosition[1] += (currentPosition[1] < targetPosition[1]) ? 1 : -1;
                }

                // 경로 완료 여부 체크
                if (Arrays.equals(currentPosition, targetPosition)) {
                    progress[i]++;
                    if (progress[i] < routes[i].length - 1) {
                        allFinished = false; // 여전히 이동 중인 로봇이 있음
                    }
                } else {
                    allFinished = false; // 아직 이동 중인 로봇이 있음
                }

                // 현재 좌표 기록
                String positionKey = currentPosition[0] + "," + currentPosition[1];
                positionCount.put(positionKey, positionCount.getOrDefault(positionKey, 0) + 1);
            }

            // 위험 상황 카운트
            for (int count : positionCount.values()) {
                if (count > 1) {
                    dangerousCount += count - 1;
                }
            }
        }

        return dangerousCount;
    }
	
	
}
