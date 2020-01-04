package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class fromCharCodeMethod extends RuleBase {


    private String html;
    private boolean hypothesis = false;

    public fromCharCodeMethod(String html) {
        super(html);
        this.html = html;
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
