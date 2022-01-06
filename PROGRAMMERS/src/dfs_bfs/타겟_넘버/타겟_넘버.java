package dfs_bfs.타겟_넘버;

public class 타겟_넘버 {
	static int answer = 0;
	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
        return answer;
    }
	private static void dfs(int[] numbers, int target, int idx, int sum) {
		// numbers의 값을 모두 계산했으면 
		if(idx==numbers.length) {
            // 타겟 넘버와 sum이 같으면 answer+1
			if(sum==target) {
				answer++;
			}
            return;
		}
        
        sum += numbers[idx];
        dfs(numbers, target, idx+1, sum);
        // 원래 값으로 복귀 
        sum -= numbers[idx];
        sum += (-1)*numbers[idx];
        dfs(numbers, target, idx+1, sum);

	}

}
