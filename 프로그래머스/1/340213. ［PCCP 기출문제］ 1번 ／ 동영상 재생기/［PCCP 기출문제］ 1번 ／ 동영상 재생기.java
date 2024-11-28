import java.util.Arrays;

class Solution {
    private int convertToSec(String time) { // 초로 변경
        String[] splitedTime = time.split(":");
        return Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]);
    }
    
    private boolean isInSkipRange(int time, int opStartSec, int opEndSec) { // 스킵 여부 확인
        return opStartSec <= time && time < opEndSec;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = convertToSec(video_len),
        posSec = convertToSec(pos),
        opStartSec = convertToSec(op_start),
        opEndSec = convertToSec(op_end);
        
        posSec = isInSkipRange(posSec, opStartSec, opEndSec) ? opEndSec : posSec;
        
        for (String command : commands) {
            if (command.equals("next")) {
                posSec = Math.min(posSec + 10, videoLenSec);
            } else {
                posSec = Math.max(posSec - 10, 0);
            }
            posSec = isInSkipRange(posSec, opStartSec, opEndSec) ? opEndSec : posSec;
        }
        
        // 분, 초 변환
        int minute = posSec / 60;
        int second = posSec % 60;
        return String.format("%02d:%02d", minute, second);
    }
}