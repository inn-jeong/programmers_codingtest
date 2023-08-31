package lv2;

public class BracketCount {
    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";

        Solution2 solution = new Solution2();
        System.out.println("answer1 : "+solution.solution(s1));
        System.out.println("answer1 : "+solution.solution(s2));
        System.out.println("answer1 : "+solution.solution(s3));
    }
}

class Solution2{
    boolean solution(String s){
        boolean answer = true;
        char[] ch_s = s.toCharArray();
        int cnt_start = 0;
        int cnt_end = 0;

        for (int i=0; i<ch_s.length; i++){
            if(ch_s[i] == '(') cnt_start++;
            else cnt_end++;
            if(cnt_end > cnt_start) return false;
        }
        if(cnt_start == cnt_end) answer = true;
        else answer = false;

        return answer;
    }
}
