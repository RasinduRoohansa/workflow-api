package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.common.CommonDomain;

public class QuoteAnswer extends CommonDomain {
    private Long fkQuoteEnquiryWalkthrough;
    private Long fkQuestionTemplateItem;
    private String answer;
    private String answerHeadline;
    private Long fkQuestionSingleOption;

    private String icon;
    private String code;
    private String question;
    private String optionAnswer;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionAnswer() {
        return optionAnswer;
    }

    public void setOptionAnswer(String optionAnswer) {
        this.optionAnswer = optionAnswer;
    }

    public Long getFkQuoteEnquiryWalkthrough() {
        return fkQuoteEnquiryWalkthrough;
    }

    public void setFkQuoteEnquiryWalkthrough(Long fkQuoteEnquiryWalkthrough) {
        this.fkQuoteEnquiryWalkthrough = fkQuoteEnquiryWalkthrough;
    }

    public Long getFkQuestionTemplateItem() {
        return fkQuestionTemplateItem;
    }

    public void setFkQuestionTemplateItem(Long fkQuestionTemplateItem) {
        this.fkQuestionTemplateItem = fkQuestionTemplateItem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswerHeadline() {
        return answerHeadline;
    }

    public void setAnswerHeadline(String answerHeadline) {
        this.answerHeadline = answerHeadline;
    }

    public Long getFkQuestionSingleOption() {
        return fkQuestionSingleOption;
    }

    public void setFkQuestionSingleOption(Long fkQuestionSingleOption) {
        this.fkQuestionSingleOption = fkQuestionSingleOption;
    }
}
