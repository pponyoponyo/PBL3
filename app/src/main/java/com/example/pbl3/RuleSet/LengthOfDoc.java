package com.example.pbl3.RuleSet;

import com.example.pbl3.Method.RuleBase;
public class LengthOfDoc extends RuleBase {

    private String html;
    private boolean hypothesis = false;

    public LengthOfDoc(String html) {
        super(html);
        this.html = html;
    }

    public void rule(){

        String checkDocument = html;
        char [] d ; // null 로 초기화
        d = checkDocument.toCharArray(); // htmldocument 문자열을 char 배열로 설정

        // Document length
        if(d.length>100){ // 100은 임의 값
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
