class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
        adjList.add(new ArrayList<>());
    }
    
    for (int[] pre : prerequisites) {
        adjList.get(pre[1]).add(pre[0]);
        inDegree[pre[0]]++;
    }
    
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        if (inDegree[i] == 0) {
            queue.offer(i);
        }
    }
    
    int count = 0;
    while (!queue.isEmpty()) {
        int course = queue.poll();
        count++;
        for (int nextCourse : adjList.get(course)) {
            if (--inDegree[nextCourse] == 0) {
                queue.offer(nextCourse);
            }
        }
    }
    
    return count == numCourses;
    }
}