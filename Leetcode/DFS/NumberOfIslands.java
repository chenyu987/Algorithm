/**
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
* 
* Example 1:
* 
* 11110
* 11010
* 11000
* 00000
* Answer: 1
* 
* Example 2:
* 
* 11000
* 11000
* 00100
* 00011
* Answer: 3
*/

/*
模型：迷宫问题 典型递归求解
每遇到'1'后, 把当前位置设为visited, 然后向四个方向递归搜索. 
*/

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int res = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// if current position hasn't been visited and it's a island, then search
				if (!visited[i][j] && grid[i][j] == '1') {
					res++;
					search(grid, visited, i, j);
				}
			}
		}
		return res;
    }
	private void search(char[][] grid, boolean[][] visited, int row, int col) {
		// check row, col valid; check current position is not visited and it's a '1'
		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == '1') {
			visited[i][j] = true;
			search(grid, visited, row-1, col);
			search(grid, visited, row, col+1);
			search(grid, visited, row+1, col);
			search(grid, visited, row, col-1);
		} 
	}	
}

 