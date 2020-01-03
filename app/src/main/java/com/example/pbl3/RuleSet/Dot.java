package com.example.pbl3.RuleSet;

import com.example.pbl3.Method.RuleBase;
public class Dot extends RuleBase {

    private String url;
    private boolean hypothesis = false;

    public Dot(String url) {
        super(url);
        this.url = url;
    }

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }


    public void rule(){
        char [] c ;
        c = url.toCharArray();
        int dotNum=0;


        for(int i=0; i<c.length-1; i++){
           /* if(c[i]=='.'&&c[i+1]=='.'){
                setHypothesis(true);
            } 이것도 근데 맞는 맥락이기는 함. 아래는 논문 출처로 개수 기준으로 맞추기 위해 수정한 결과*/
           if(c[i]=='.'){
               dotNum++;
           }
        }

        if(dotNum>2){
            setHypothesis(true); // 개수 기준 수정
        }
    }

}
