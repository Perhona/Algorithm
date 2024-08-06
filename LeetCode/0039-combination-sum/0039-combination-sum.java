class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, candidates, new ArrayList<>(), 0, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, List<Integer> path, int startIdx, int target) {
        if (target < 0) {   // 전달받은 target이 0보다 작다면, path의 합이 목표값을 초과했으므로 리턴
            return;
        }

        if (target == 0) {  // 전달받은 target이 0과 같다면, path의 합이 목표값과 일치하므로 정답 리스트에 추가
            result.add(new ArrayList<>(path));  // 깊은 복사
            return;
        }

        // 자기 자신의 중복을 허용하기 때문에 가장 상위 for문의 i를 기준으로 재귀
        // ex) 2, 3, 6, 7의 경우 가장 상위 노드가 2라면 모든 하위 노드도 2부터 탐색
        for (int i = startIdx; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(result, candidates, path, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
        // target에서 현재 값을 빼주는 방식이 아니라면, 재귀 함수 호출 시 'sum' 변수에 누적 합을 저장 후 넘긴 뒤 target과 비교하는 방식도 가능하다.
    }
}