package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class LengthOfURL extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public LengthOfURL(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){

        String checkDot = url;
        char [] c ; // null 로 초기화
        c = checkDot.toCharArray(); // 문자열을 char 배열로 설정

        //Length of URL (길이개수 수정함)
        if(c.length>50){
            setHypothesis(true);
        }
    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }
}
