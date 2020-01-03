package com.example.pbl3.RuleSet;

import com.example.pbl3.Method.RuleBase;
public class NumOfLines extends RuleBase {

    private String html;
    private boolean hypothesis = false;

    public NumOfLines(String url) {
        super(url);
       // html = getHtml();
    }

    public void rule() {

        int brNum = 0;

        // Number of lines <br> tag
        String[] checklines = html.split("<");
        for (int j = 0; j < checklines.length; j++) {
            if (checklines[j].contains("br>")) {
                brNum++;
            }
        }

        if(brNum>10){ // br 태그가 카운팅 된 경우 return true 한다! 개수는 임의 개수
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
