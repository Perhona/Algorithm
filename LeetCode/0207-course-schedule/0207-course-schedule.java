class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)
            return true;

        List<Integer> elements = Arrays.stream(prerequisites).flatMap(arr -> Stream.of(arr[0], arr[1]))
                .collect(Collectors.toList());
        int totalCnt = elements.size();
        int equalN = totalCnt - (prerequisites.length - 1);
        return equalN == numCourses;
    }
}