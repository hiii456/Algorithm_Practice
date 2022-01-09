package test_u;

public class test_1 {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] maps = {{0,0,1},{0,0,1},{0,1,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
        visited = new boolean[maps.length][maps[0].length];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length; j++){
                if(maps[i][j]==1){
                    answer += dfs(i,j,0,maps);
                }
            }
        }
		System.out.println(answer);
	}
	public static int dfs(int r,int c,int sum,int[][] maps){
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isPossible(nr,nc,maps) || maps[nr][nc] == 0){
                sum += 1;
            }

            if(!isPossible(nr,nc,maps))   continue;
            if(visited[nr][nc] || maps[nr][nc] == 0)    continue;
            
            visited[nr][nc] = true;
            dfs(nr,nc,sum,maps);
            visited[nr][nc] = false;

        }

        return sum;
    }

    public static boolean isPossible(int r,int c,int[][] maps){
        if(r<0 || c<0 || r>=maps.length || c>= maps[0].length){
            return false;
        }
        return true;
    }

}
