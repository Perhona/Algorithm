import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. for문 두 번 사용 시 시간 초과
        Arrays.sort(phone_book);
        
        for (int i=0;i<phone_book.length -1;i++) {
            String phoneNumber = phone_book[i];
            if (phone_book[i+1].startsWith(phoneNumber)) return false;
        }
        
        return true;
    }
}