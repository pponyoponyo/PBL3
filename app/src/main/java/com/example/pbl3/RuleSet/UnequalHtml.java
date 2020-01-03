package com.example.pbl3.RuleSet;
import com.example.pbl3.Method.RuleBase;
public class UnequalHtml extends RuleBase {

    private String html;
    private boolean hypothesis = false;


    public boolean isHypothesis() {
        return hypothesis;
    }
    public void setHypothesis(boolean hypothesis) {
        this.hypothesis = hypothesis;
    }

    public UnequalHtml(String url) {
        super(url);
      //  html = getHtml();
    }

    public void rule(){
        int htmlTagNum=0;
        String[] checkBig = html.split("<");// < 기준으로 문장 쪼개서 단어로 배열만들기

        for(int i=0; i<checkBig.length;i++){
            String [] checkMid = checkBig[i].split(">");
            for(int j=0; j<checkMid.length; j++){
                String [] checkSmall = checkMid[j].split(" ");
                for(int k=0; k<checkSmall.length; k++){


                    if(checkSmall[k].equals("html")){
                        htmlTagNum++;
                    }

                }

            }

        }

        if((htmlTagNum&2)!=0){
            setHypothesis(true);
        }
    }



}
