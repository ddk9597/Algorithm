package com.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* 데이터 분석
 * data : 2차원 배열, 정렬한 데이터가 담긴 이차우너 정수 리스트
 * ext : 데이터를 뽑아낼지 의미하는 문자열
 * val_ext : 뽑아낼 정보의 기준값을 나타내는 정수
 * sort_by : 정보를 정렬할 기준이 되는 문자열
 * 
 * 문제 조건
 * 
 * data에서 ext값이 val_ext 보다 작은 데이터만 뽑은 후, 
 * sort_by에 해당하는 값을 기준으로
 * 오름차순으로 정렬
 * 
 * [[code, date, maximum, remain]]
 * 
 * */

/*
 * 데이터를 필터링 한 뒤, 지정된 정렬 기준에 따라 오름차순으로 정렬함
 * 
 * 
 * 
 * */

public class Solution031_1 {
	public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {

		// 필터링할 인덱스, 정렬할 인덱스 결정
		int extIndex = getIndex(ext);
		int sortIndex = getIndex(sort_by);

		// 조건을 만족하는 데이터 필터링
		List<int[]> filteredData = new ArrayList<>();
		for (int[] row : data) {
			if (row[extIndex] < val_ext) {
				filteredData.add(row);
			}
		}

		// 정렬
		filteredData.sort(Comparator.comparingInt(o -> o[sortIndex]));

		return filteredData;
	}

	private int getIndex(String key) {
		switch (key) {
		case "code":
			return 0;
		case "data":
			return 1;
		case "maximum":
			return 2;
		case "remain":
			return 3;
		default:
			throw new IllegalArgumentException("잘못된 키 값입니다 :" + key);
		}
	}

}
