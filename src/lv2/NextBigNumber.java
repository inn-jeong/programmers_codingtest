package lv2;

public class NextBigNumber {
    public static void main(String[] args) {
        int n1 = 78;
        int n2 = 15;
        Solution4 solution = new Solution4();
        System.out.println("answer : "+solution.solution(n2));
    }
}

class Solution4{
    public int solution(int n){
        int answer = 0;
        int cnt_n = countBinary(Integer.toBinaryString(n));
        int temp = n;
        while(true){
            temp++;
            int cnt_temp = countBinary(Integer.toBinaryString(temp));
            if(cnt_temp == cnt_n){
                answer = temp;
                break;
            }
        }
        return answer;
    }

    public int countBinary(String s){
        int cnt = 0;
        char[] ch_num = s.toCharArray();
        for(char ch: ch_num){
            if(ch == '1') cnt++;
        }
        return cnt;
    }
}
