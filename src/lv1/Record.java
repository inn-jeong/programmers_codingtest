package lv1;

import java.util.HashMap;
import java.util.Map;

public class Record {
    public static void main(String[] args) {
        String[] name = {"may","kein","kain","radi"};
        int[] yearning = {5,10,1,3};
        String [][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] scores = solution(name,yearning,photo);
        for (int score:scores) {
            System.out.println(score);
        }
    }
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> scores = new HashMap<>();
        for(int i=0; i<name.length; i++){
            scores.put(name[i],yearning[i]);
        }
        for (int i=0; i<photo.length; i++){
            int score = 0;
            for(String photo_name:photo[i]){
                if(scores.get(photo_name) != null){
                    score += scores.get(photo_name);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}
