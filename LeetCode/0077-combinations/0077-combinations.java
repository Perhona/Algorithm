class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), n, k, 1);

        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> elements, int n, int k, int start) { // 17ms
        // 조합은 순열과 달리 이미 선택한 원소와 다음에 선택할 수 있는 원소를 구분할 필요가 없음
        // start 숫자를 +1씩 증가시켜 다음 숫자부터 반복할 수 있도록 함
        // k를 -1씩 감소시켜  k개만큼의 숫자 조합이 완성됐음을 확인한다.
        if (k == 0) {
            results.add(new ArrayList<>(elements));
            return;
        }

        for (int i = start; i <= n; i++) {
            elements.add(i);
            dfs(results, elements, n, k - 1, i + 1);
            elements.remove(elements.size() - 1);
        }
    }
}