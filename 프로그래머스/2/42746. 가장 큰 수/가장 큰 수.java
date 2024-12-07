import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];
        for (int i=0;i<numStrs.length;i++) {
            numStrs[i] = numbers[i]+"";
        }
        
        Arrays.sort(numStrs, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if (numStrs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String n : numStrs) {
            sb.append(n);
        }
        return sb.toString();
    }
}