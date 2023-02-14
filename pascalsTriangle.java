// https://leetcode.com/problems/pascals-triangle/solutions/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        var result = new ArrayList<List<Integer>>(numRows);
        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        // add the initial row (if base case it will never be reached)
        if (numRows == 1)
            return result;
        generateR(numRows, result);
        return result;
    }

    public List<Integer> generateR(int numRows, List<List<Integer>> result) {
        ArrayList<Integer> currentList;

        // base case
        if (numRows == 2) {
            currentList = new ArrayList<Integer>(Arrays.asList(1, 1));
            result.add(currentList);
            return currentList;
        }

        var parentList = generateR(numRows - 1, result);

        currentList = new ArrayList<Integer>();
        currentList.add(1);

        for (int i = 1; i < numRows - 1; i++) {
            currentList.add(parentList.get(i - 1) + parentList.get(i));
        }

        currentList.add(1);
        result.add(currentList);

        return currentList;
    }
}