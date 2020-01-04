package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class IframeTag extends RuleBase {

    private String html;
    private boolean hypothesis = false;

    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public IframeTag(String html) {
        super(html);
        this.html = html;
    }


    public void rule(){
        String[] checkBig = html.split("<");// < 기준으로 문장 쪼개서 단어로 배열만들기
        for(int i=0; i<checkBig.length;i++){
            String [] checkMid = checkBig[i].split(">");
            for(int j=0; j<checkMid.length; j++){
                String [] checkSmall = checkMid[j].split(" ");
                for(int k=0; k<checkSmall.length; k++){

                    //Number of iframes
                    if(checkSmall[k].equals("iframe")){
                        setHypothesis(true);
                    }


                }

            }

        }



    }


}
