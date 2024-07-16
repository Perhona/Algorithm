class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        StringBuilder output = new StringBuilder();

        // 기준을 옮기면서 이전의 값들과 비교해야 하므로 Stack에 저장
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Integer> charCnt = new HashMap<>();
        Map<Character, Boolean> isUsed = new HashMap<>();

        // 각 문자별 등장 횟수 저장
        for (char c : chars) {
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        for (char c : chars) {
            // 이미 사용된 문자는 건너뛰고, 등장 횟수도 감소시킴
            if (isUsed.getOrDefault(c, false)) {
                charCnt.put(c, charCnt.get(c) - 1);
                continue;
            }

            // 스택의 문자가 순회중인 문자보다 크고 등장 횟수가 남아있다면 스택 문자 추출 및 해당 문자 사용 여부 false 처리
            // 등장 횟수가 남았고 더 사전 순서 상 더 큰 문자는 다음에 다시 등장시키게 됨
            while (!stack.isEmpty() && stack.peek() > c && charCnt.get(stack.peek()) > 0) {
                isUsed.put(stack.pop(), false);
            }

            // 순회중인 문자는 중복되지만 않는다면 무조건 저장 및 사용됨으로 처리, 등장 횟수 감소
            stack.push(c);
            isUsed.put(c, true);
            charCnt.put(c, charCnt.get(c) - 1);
        }

        // 스택 문자열 반환 (역순으로 추가)
        while (!stack.isEmpty()) {
            output.insert(0, stack.pop());
        }
        return output.toString();
    }
}