package lv2;

public class NumberPrint {
    public static void main(String[] args) {
        int n = 15;
        Solution3 solution = new Solution3();
        System.out.println("answer: "+solution.solution(n));

    }

}

class Solution3{
    public int solution(int n){
        int answer = 0;
        int num = 1;
        while(num <= n){
            int temp = 0;
            for(int i=num; i<=n; i++){
                temp += i;
                if(temp == n){
                    answer++;
                    break;
                }else if(temp > n) break;
            }
            num++;
        }

        return answer;
    }
}
