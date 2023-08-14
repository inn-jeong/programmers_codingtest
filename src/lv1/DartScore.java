package lv1;

import java.util.*;

public class DartScore {
    public static void main(String[] args) {
        String dartResult1 = "1S2D*3T";
        String dartResult2 = "1D2S#10S";
        String dartResult3 = "1D2S0T";
        Solution solution = new Solution();
        System.out.println("result :"+solution.solution(dartResult2));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] temp_result = dartResult.toCharArray();
        List<String> results = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        List<Integer> result_score = new ArrayList<>();
        String word="";
        String str_score="";

        List<Character> option = new ArrayList<>(Arrays.asList('*','#'));
        List<Character> bonus = new ArrayList<>(Arrays.asList('S','D','T'));

        //점수와 보너스 분리
        for(int i=0; i<temp_result.length; i++){
            if(temp_result[i] >='0' && temp_result[i] <= '9'){
                str_score += temp_result[i];
            }else if(bonus.contains(temp_result[i])){
                scores.add(Integer.parseInt(str_score));
                str_score = "";
                if(i<temp_result.length-1 && !option.contains(temp_result[i+1])){
                    results.add(""+temp_result[i]);
                }else{
                    word += temp_result[i];
                }
            }else{
                word += temp_result[i];
                results.add(word);
                word = "";
            }
            if(i == temp_result.length-1)results.add(word);
        }
        //test 출력
        for(String str :results){
            System.out.println(str);
        }
        System.out.println("-----------------");
        for(int score : scores){
            System.out.println(score);
        }

        for(int i=0; i<scores.size(); i++){
            char[] temp_bonus = results.get(i).toCharArray();

            if(temp_bonus[0] == 'S') result_score.add(scores.get(i));
            if(temp_bonus[0] == 'D') result_score.add(db(scores.get(i)));
            if(temp_bonus[0] == 'T') result_score.add(tp(scores.get(i)));

            if(temp_bonus.length==2){
                if(temp_bonus[1] =='#'){
                    result_score.set(i,result_score.get(i)*-1);
                }else{
                    if(i==0){
                        result_score.set(i,result_score.get(i)*2);
                    }else{
                        result_score.set(i-1,result_score.get(i)*2);
                        result_score.set(i,result_score.get(i)*2);
                    }
                }
            }
        }
        for(int score : result_score){
            answer += score;
        }

        return answer;
    }
    public int db(int score){
        return score*score;
    }
    public int tp(int score){
        return score*score*score;
    }
}
