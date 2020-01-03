package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class fromCharCodeMethod extends RuleBase {


    private String html;
    private boolean hypothesis = false;

    public fromCharCodeMethod(String url) {
        super(url);
       // html = getHtml();
    }

    public void rule(){

        if(html.contains("fromCharCode()")){
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
