package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class containDigits extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public containDigits(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){

       char [] d = {'0','1','2','3','4','5','6','7','8','9'}; // digits 배열 선언

        char [] c ;
        c = url.toCharArray(); // url을 char 문자로 변환


        for(int i=0; i<c.length; i++){
            for(int j=0; j<10; j++){
                if(c[i]==(d[j])){
                setHypothesis(true);
                }
            }
        }

    }
}
