package com.example.pbl3.Method;

import com.example.pbl3.RuleSet.BackSlash;
import com.example.pbl3.RuleSet.Bitly;
import com.example.pbl3.RuleSet.ContainDigits;
import com.example.pbl3.RuleSet.Dot;
import com.example.pbl3.RuleSet.EvalMethod;
import com.example.pbl3.RuleSet.HiddenTag;
import com.example.pbl3.RuleSet.IframeTag;
import com.example.pbl3.RuleSet.LengthOfDoc;
import com.example.pbl3.RuleSet.LengthOfURL;
import com.example.pbl3.RuleSet.NumOfLines;
import com.example.pbl3.RuleSet.SuspiciousWords;
import com.example.pbl3.RuleSet.TLD;
import com.example.pbl3.RuleSet.UnequalHtmlTag;
import com.example.pbl3.RuleSet.UrlKorean;
import com.example.pbl3.RuleSet.WindowOpenMethod;
import com.example.pbl3.RuleSet.aTag;

public class EvidenceAc {

    private BackSlash backSlash;
    private Bitly bitly;
    private Dot dot;
    private EvalMethod evalMethod;
    private LengthOfDoc lengthOfDoc;
    private LengthOfURL lengthOfURL;
    private NumOfLines numOfLines;
    private SuspiciousWords suspiciousWords;
    private TLD tld;
    private WindowOpenMethod windowOpenMethod;
    private UrlKorean urlKorean;
    private ContainDigits containDigits;
    private aTag atag;
    private IframeTag iframeTag;
    private HiddenTag hiddenTag;
    private UnequalHtmlTag unequalHtmlTag;

    public EvidenceAc(String url,String html) {

        backSlash = new BackSlash(url);
        bitly = new Bitly(url);
        dot=new Dot(url);
        evalMethod = new EvalMethod(html);
        lengthOfDoc = new LengthOfDoc(html);
        lengthOfURL = new LengthOfURL(url);
        numOfLines = new NumOfLines(html);
        suspiciousWords = new SuspiciousWords(html);
        tld = new TLD(url);
        windowOpenMethod = new WindowOpenMethod(html);
        urlKorean = new UrlKorean(url);
        containDigits = new ContainDigits(url);
        atag = new aTag(html);
        iframeTag= new IframeTag(html);
        hiddenTag = new HiddenTag(html);
        unequalHtmlTag = new UnequalHtmlTag(html);

        backSlash.rule();
        bitly.rule();
        dot.rule();
        evalMethod.rule();
        lengthOfDoc.rule();
        lengthOfURL.rule();
        numOfLines.rule();
        suspiciousWords.rule();
        tld.rule();
        windowOpenMethod.rule();
//        urlKorean.rule();
        containDigits.rule();
        atag.rule();
        iframeTag.rule();
        hiddenTag.rule();
        unequalHtmlTag.rule();
    }

    public boolean upperAuthority(){
        if(backSlash.isHypothesis() && lengthOfURL.isHypothesis()){
            if(dot.isHypothesis()){
                //상위 권한 탈취 가능성
                return true;
            }
        }
        return false;
    }

    public boolean ChinaTld(){
        if(tld.isCn_hypothesis()){
            // 중국에 위치한 TLD
            return true;
        }
        return false;
    }

    public boolean RussiaTld(){
        if(tld.isRu_hypothesis()){
            // 러시아에 위치한 TLD
            return true;
        }
        return false;
    }

    public boolean javaExe(){
        if(evalMethod.isHypothesis()||windowOpenMethod.isHypothesis()){
            //위험한 java script 실행 가능성
            return true;
        }
        return false;
    }

    public boolean fastPage(){
        if(numOfLines.isHypothesis()&&suspiciousWords.isHypothesis()){
            //빠르게 만들어진 피싱 페이지
            return true;
        }
        return false;
    }

    public boolean urlKor(){
        if(urlKorean.isHypothesis()){
            //url 에 한글이 들어가있는 경우
            return true;
        }
        return false;
    }

    // 룰체인 보민 추가
    public boolean SmishingUrl(){
        if(bitly.isHypothesis()&&suspiciousWords.isHypothesis()){
            // 단축 url + '택배' 단어
            return true;
        }
        return false;
    }

    public boolean IPUrl(){
        if(dot.isHypothesis()&&containDigits.isHypothesis()){
            // IP주소가 URL에 존재하는 경우
            return true;

        }
        return false;
    }

    public boolean linkPossibility(){
        if(atag.isHypothesis()&&iframeTag.isHypothesis()){
            // iframe안에 a태그를 통한 링크 존재하는 경우
            return  true;
        }
        return false;
    }

    public boolean tagExist(){
        if(iframeTag.isHypothesis()&&hiddenTag.isHypothesis()&&unequalHtmlTag.isHypothesis()){
            // 의심스러운 태그들이 포착된 경우
            return true;
        }
        return false;
    }
}

