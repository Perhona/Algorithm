class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);
            if (!results.containsKey(sorted)) {
                results.put(sorted, new ArrayList<>());
            }
            
            results.get(sorted).add(s);
        }
        return new ArrayList<>(results.values());
    }
}