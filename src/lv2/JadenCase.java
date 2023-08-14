package lv2;

import java.util.ArrayList;
import java.util.List;

public class JadenCase {
    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "   3people   unFollowed     me    ";

        Solution solution = new Solution();
        System.out.println(solution.solution(s1));
    }
}
class Solution{
    public String solution(String s) {
        String answer = "";
        String str = "";
        String blank = "";
        int cnt = 0;
        List<String> list = new ArrayList<>();

        //중복되는 공백을 그대로 추출하여 list에 저장
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' ') {
                if(!blank.equals("")){
                    list.add(blank);
                    blank="";
                }
                str += c;
            }else{
                if(!str.equals("")){
                    list.add(str);
                    str="";
                }
                blank += c;
            }
//            System.out.printf("[%c], blank=%s, str=%s\n",c,blank,str);
        }
        //마지막 값 list에 저장
        if(blank.equals("")) list.add(str);
        else list.add(blank);
        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            String str2 = list.get(i);
            if(!str2.contains(" ")){
                String first = str2.substring(0,1);
                String temp = str2.substring(1);
                first = first.toUpperCase();
                temp = temp.toLowerCase();
                list.set(i,first+temp);
            }
        }
        for(String str2:list){
            answer += str2;
        }
        return answer;
    }
}
