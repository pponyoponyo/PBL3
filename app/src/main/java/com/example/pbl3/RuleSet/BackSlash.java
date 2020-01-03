package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;

public class BackSlash extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }

    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public BackSlash(String url) {
        super(url);
        this.url = url;
    }

    public void rule(){
        char [] c ;
        c = url.toCharArray();
        int backslashNum=0;

        for(int i=0; i<c.length; i++){
            if(c[i]=='\\'){
                backslashNum++;

            }
        }
        if(backslashNum>5){ // 기준 수정
            setHypothesis(true);
        }
    }


}
