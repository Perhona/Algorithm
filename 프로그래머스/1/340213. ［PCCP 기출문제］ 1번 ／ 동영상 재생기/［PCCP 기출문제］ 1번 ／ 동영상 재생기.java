class Solution {
    private static final String start = "00:00";
    private static String current = "";
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        current = pos;
        System.out.println("current: "+current);
        skipOp(op_start, op_end);
        
        for (String command : commands) {
            System.out.println("comand: " +command);
            if (command.equals("prev")) {
                current = calculate(current, -10);
                if (!isBigger(start, current)) {
                    current = start;
                }
            }
            if (command.equals("next")) {
                current = calculate(current, 10);
                if (isBigger(video_len, current)) {
                    current = video_len;
                }
            }
            System.out.println("check prev or next: " + current);
            skipOp(op_start, op_end);
            System.out.println("check op: " + current);
        }
        return current;
    }
    
    private void skipOp(String op_start, String op_end) {
        if (isBigger(op_start, current) && !isBigger(op_end, current)) {
            System.out.println("move to op_end");
            current = op_end;
        }
    }
    private boolean isBigger(String baseTime, String newTime) {
        String[] baseTimeArr = baseTime.split(":");
        String[] newTimeArr = newTime.split(":");
        int baseMinute = Integer.parseInt(baseTimeArr[0]);
        int baseSecond = Integer.parseInt(baseTimeArr[1]);
        int newMinute = Integer.parseInt(newTimeArr[0]);
        int newSecond = Integer.parseInt(newTimeArr[1]);
        
        if (baseMinute - newMinute > 0) {
            return false;
        } else if (baseMinute - newMinute < 0) {
            return true;
        }
        
        if (baseSecond - newSecond > 0) {
            return false;
        } else {
            return true;
        }
    }
    
    private String calculate (String baseTime, int number) {
        String[] baseTimeArr = baseTime.split(":");
        int baseMinute = Integer.parseInt(baseTimeArr[0]);
        int baseSecond = Integer.parseInt(baseTimeArr[1]);
        baseSecond += number;
        System.out.printf("baseTime: %s, number: %d, baseSecond: %d \n", baseTime, number, baseSecond);
        if (baseSecond < 0) {
            baseMinute--;
            baseSecond += 60;
        }
        if (baseSecond > 60) {
            baseMinute++;
            baseSecond -= 60;
        }
        return String.format("%02d:%02d", baseMinute, baseSecond);
    }
}