class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 1. 사용한 문자는 Set으로 관리한다.
        // 2. 문자열을 차례대로 순회한다.
        // 3. 현재 문자가 사용되지 않았다면 Set에 추가, 우측 포인터 이동, 최대 길이 업데이트
        // 4. 현재 문자가 사용되었다면 우측 포인터는 멈추고 좌측 포인터를 이동하며 Set에서 제거
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> used = new HashSet<>();
        int start = 0, end = 0;
        int maxLength = 0;
        int inputLength = s.length();

        // end 인덱스 기준 문자열 길이를 넘지 않을 때 까지 반복
        while (end < inputLength) {
            // 중복 문자열이 없는 경우 Set에 추가, 우측 포인터 이동 및 최대 길이 업데이트
            if (!used.contains(s.charAt(end))) {
                used.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else { // 중복 문자열이 있는 경우 Set에서 좌측 포인터의 문자 제거 및 한 칸 이동
                used.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }
}