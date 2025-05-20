import java.util.ArrayList;

public class Client {

    static ArrayList<ArrayList<Integer>> A = Map.getMap();

    public static void main(String[] args) {
        findPathAndPrint(A);
    }

    public static void findPathAndPrint(ArrayList<ArrayList<Integer>> map) {
        ArrayList<Point> path = new ArrayList<>();
        boolean[][] visited = new boolean[map.size()][map.get(0).size()];

        int[] start = findStart(map);
        if (start == null) {
            System.out.println("No starting point found.");
            return;
        }

        dfs(map, visited, start[0], start[1], path);

        System.out.println("Path coordinates:");
        for (Point p : path) {
            System.out.println("A[" + p.row + "][" + p.col + "]");
        }

        System.out.println("\nPath visualized:");
        printPath(map, path);
    }

    public static int[] findStart(ArrayList<ArrayList<Integer>> map) {
        int rows = map.size();
        int cols = map.get(0).size();

        for (int col = 0; col < cols; col++) {
            if (getValue(map, 0, col) == 1 && hasNeighbor(map, 0, col)) return new int[]{0, col};
            if (getValue(map, rows - 1, col) == 1 && hasNeighbor(map, rows - 1, col)) return new int[]{rows - 1, col};
        }
        for (int row = 0; row < rows; row++) {
            if (getValue(map, row, 0) == 1 && hasNeighbor(map, row, 0)) return new int[]{row, 0};
            if (getValue(map, row, cols - 1) == 1 && hasNeighbor(map, row, cols - 1)) return new int[]{row, cols - 1};
        }
        return null;
    }

    public static boolean hasNeighbor(ArrayList<ArrayList<Integer>> map, int row, int col) {
        int rows = map.size();
        int cols = map.get(0).size();
        if (row > 0 && getValue(map, row - 1, col) == 1) return true;
        if (row < rows - 1 && getValue(map, row + 1, col) == 1) return true;
        if (col > 0 && getValue(map, row, col - 1) == 1) return true;
        if (col < cols - 1 && getValue(map, row, col + 1) == 1) return true;
        return false;
    }

    public static int getValue(ArrayList<ArrayList<Integer>> map, int row, int col) {
        try {
            return map.get(row).get(col);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> map, boolean[][] visited, int row, int col, ArrayList<Point> path) {
        if (row < 0 || col < 0 || row >= map.size() || col >= map.get(0).size()) return;
        if (getValue(map, row, col) != 1 || visited[row][col]) return;

        visited[row][col] = true;
        path.add(new Point(row, col));

        dfs(map, visited, row - 1, col, path);
        dfs(map, visited, row + 1, col, path);
        dfs(map, visited, row, col - 1, path);
        dfs(map, visited, row, col + 1, path);
    }

    public static void printPath(ArrayList<ArrayList<Integer>> map, ArrayList<Point> path) {
        String[][] display = new String[map.size()][map.get(0).size()];

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(0).size(); j++) {
                display[i][j] = map.get(i).get(j) == 1 ? " " : " ";
            }
        }

        for (Point p : path) {
            display[p.row][p.col] = "1";
        }

        for (String[] row : display) {
            for (String cell : row) {
                System.out.print("[ " + cell + " ]");
            }
            System.out.println();
        }
    }
}

class Point {
    int row, col;

    Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}