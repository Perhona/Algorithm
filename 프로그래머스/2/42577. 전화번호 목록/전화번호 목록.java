import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. for문 두 번 사용 시 시간 초과
        // 2. 배열 정렬 후 다음 요소와의 비교(OK
        // 3. 해시셋 사용
        
        Set<String> phoneSet = new HashSet<>();
        for (String number : phone_book) {
            phoneSet.add(number);
        }
        
        for (String number : phone_book) {
            for (int i=1;i<number.length();i++) {
                if (phoneSet.contains(number.substring(0,i))) return false;
            }
        }
        
        return true;
    }
}