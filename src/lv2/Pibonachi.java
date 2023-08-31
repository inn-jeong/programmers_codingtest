package lv2;

public class Pibonachi {
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 2;
        Solution5 solution = new Solution5();
        System.out.println("answer: "+solution.solution(n2));
    }
}

class Solution5{
    public int solution(int n){
        int answer = 0;
        int cnt=1;
        int temp1 = 0;
        int temp2 = 1;
        while(cnt<n){
            answer = temp1+temp2;
            temp1 = temp2;
            temp2 = answer;
            cnt++;
        }
        return answer%1234567;
    }

    int pibonachi(int n){
        int p0 = 0;
        int p1 = 1;
        int temp = 0;
        if(n == 0){
            return p0;
        } else if (n == 1) return p1;
        else if (n == 2) return p0 + p1;
        else if (n > 2){
            temp = pibonachi(n - 1) + pibonachi(n - 2);
            System.out.println(temp);
        }
        return temp;
    }
}
