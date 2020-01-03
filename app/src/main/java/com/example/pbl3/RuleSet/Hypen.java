package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class Hypen extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public Hypen(String url) {
        super(url);
        this.url = url;
    }


    public void rule(){
        char [] c ;
        c = url.toCharArray(); // url을 char 문자로 변환

        for(int i=0; i<c.length; i++){
            if(c[i]=='-'){
                setHypothesis(true);
            }
        }

    }
}
