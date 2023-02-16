class Solution {
    // public String longestCommonPrefix(String[] strs) {
    // // initialize the first element in the Trie
    // var root = new TrieNode(null);

    // for(String s: strs) {
    // if(s.isEmpty()) return "";
    // insertString(root, s);
    // }

    // return findLongestPrefix(root);
    // }

    // class TrieNode {
    // Character c;
    // Map<Character, TrieNode> edges;
    // // don't need it for this implementation
    // boolean isWord;

    // TrieNode(Character c) {
    // this.c = c;
    // edges = new HashMap<Character, TrieNode>();
    // }
    // }

    // private String findLongestPrefix(TrieNode root) {

    // StringBuilder builder = new StringBuilder();
    // while(root.edges.keySet().size() == 1) {
    // for(Character c : root.edges.keySet()) {
    // builder.append(c);
    // root = root.edges.get(c);
    // }
    // if(root.isWord) break;
    // }

    // return builder.toString();
    // }

    // private void insertString(TrieNode root, String string) {
    // for(char c: string.toCharArray()) {
    // root.edges.putIfAbsent(c, new TrieNode(c));
    // root = root.edges.get(c);
    // }
    // root.isWord = true;
    // }

    // first Node will have c as null

    /**
     * Solution that uses sorting. It pulls out the first and last string (biggest
     * difference)
     * and finds the common prefix.
     * 
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        var minLen = Math.min(s1.length(), s2.length());

        var builder = new StringBuilder();

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                builder.append(s1.charAt(i));
            } else {
                break;
            }
        }

        return builder.toString();
    }
}