package com.training;

/* 당신은 동영상 재생기를 만들고 있습니다. 
 * 당신의 동영상 재생기는 10초 전으로 이동, 10초 후로 이동, 오프닝 건너뛰기 3가지 기능을 지원합니다. 
 * 각 기능이 수행하는 작업은 다음과 같습니다.
 * 
 * 10초 전으로 이동: 사용자가 "prev" 명령을 입력할 경우 
 * 동영상의 재생 위치를 현재 위치에서 10초 전으로 이동합니다. 
 * 현재 위치가 10초 미만인 경우 영상의 처음 위치로 이동합니다. 
 * 영상의 처음 위치는 0분 0초입니다.
 * 
 * 10초 후로 이동: 사용자가 "next" 명령을 입력할 경우 
 * 동영상의 재생 위치를 현재 위치에서 10초 후로 이동합니다. 
 * 동영상의 남은 시간이 10초 미만일 경우 영상의 마지막 위치로 이동합니다. 
 * 영상의 마지막 위치는 동영상의 길이와 같습니다.
 * 
 * 오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 
 * 자동으로 오프닝이 끝나는 위치로 이동합니다.
 * 
 * 동영상의 길이를 나타내는 문자열 video_len, 
 * 기능이 수행되기 직전의 재생위치를 나타내는 문자열 pos, 
 * 오프닝 시작 시각을 나타내는 문자열 op_start, 
 * 오프닝이 끝나는 시각을 나타내는 문자열 op_end, 
 * 사용자의 입력을 나타내는 1차원 문자열 배열 commands가 매개변수로 주어집니다. 
 * 이때 사용자의 입력이 모두 끝난 후 동영상의 
 * 위치를 "mm:ss" 형식으로 return 하도록 solution 함수를 완성해 주세요.
 * 
 * 
 * */

public class Solution021 {
	 public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
	        // Helper: 시간 문자열 "mm:ss"를 초 단위로 변환
	        int timeToSeconds(String time) {
	            String[] parts = time.split(":");
	            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
	        }

	        // Helper: 초 단위를 "mm:ss" 형식의 문자열로 변환
	        String secondsToTime(int seconds) {
	            int minutes = seconds / 60;
	            int secs = seconds % 60;
	            return String.format("%02d:%02d", minutes, secs);
	        }

	        // 동영상 길이와 재생 위치, 오프닝 구간의 초 단위 값 계산
	        int videoLen = timeToSeconds(video_len);
	        int position = timeToSeconds(pos);
	        int opStart = timeToSeconds(op_start);
	        int opEnd = timeToSeconds(op_end);

	        // 각 명령 처리
	        for (String command : commands) {
	            if (command.equals("prev")) {
	                // 10초 전으로 이동
	                position = Math.max(position - 10, 0);
	            } else if (command.equals("next")) {
	                // 10초 후로 이동
	                position = Math.min(position + 10, videoLen);
	            }

	            // 오프닝 구간 처리
	            if (opStart <= position && position <= opEnd) {
	                position = opEnd;
	            }
	        }

	        // 최종 위치를 "mm:ss" 형식으로 변환하여 반환
	        return secondsToTime(position);
	    }

	    public static void main(String[] args) {
	        // 테스트 케이스
	        String video_len = "05:00";
	        String pos = "00:20";
	        String op_start = "00:00";
	        String op_end = "00:15";
	        String[] commands = {"prev", "prev", "next", "next"};

	        String result = solution(video_len, pos, op_start, op_end, commands);
	        System.out.println(result); // 결과 출력
	    }
	        
	        
	        
	       

}
