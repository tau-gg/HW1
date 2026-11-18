public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;  // stop condition: path from vertex to itself
        }

        int min_path_length = m.length;  // real (non circular) path must be < m.length

        for (int pos = 0; pos < m.length; pos++) {
            if (pos != i && m[i][pos] == 1) {
                m[i][pos] = 0;  // Avoid loops - remove the edge taken in this path
                int this_path_length = findShortestPath(m, pos, j);  // Check current path
                m[i][pos] = 1;  // Restore matrix to previous state

                if (this_path_length != -1) {
                    min_path_length = Math.min(min_path_length, this_path_length + 1);
                }
            }
        }
        return min_path_length == m.length ? -1 : min_path_length;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}