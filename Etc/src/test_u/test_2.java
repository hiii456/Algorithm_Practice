package test_u;
import java.util.*;

public class test_2 {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] maps = {{0,0,1},{0,0,1},{0,1,1}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		int cnt = 0;
		int[] arr = {1,2,3};
		String[] arr2 = {"asa","sdsd"};
		// primitive 타입을 Wrapper 클래스로(여기서는 int에서 Integer로) 형변환해주지 않기 때문에,
		//primitive 타입의 배열은, Arrays.asList()로는 List로 변환할 수 없습니다.
		List<int[]> list = Arrays.asList(arr);
		List<String> list2 = Arrays.asList(arr2);
		System.out.println(list.get(0));
		System.out.println(list2.toString());
		
        visited = new boolean[maps.length][maps[0].length];

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length; j++){
                if(maps[i][j]==0 || visited[i][j])	continue;
                answer += dfs(i,j,0,maps);
                cnt++;
            }
        }
		System.out.println(answer);
		System.out.println(cnt);
	}
	public static int dfs(int r,int c,int sum,int[][] maps){
		visited[r][c] = true;
		
        for(int d=0; d<4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!isPossible(nr,nc,maps) || maps[nr][nc] == 0){
                sum += 1;
            }

            if(!isPossible(nr,nc,maps))   continue;
            if(visited[nr][nc] || maps[nr][nc] == 0)    continue;
            
            dfs(nr,nc,sum,maps);

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
