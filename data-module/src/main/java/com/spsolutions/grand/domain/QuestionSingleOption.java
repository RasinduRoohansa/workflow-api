package com.spsolutions.grand.domain;

import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.question.QuestionItem;

public class QuestionSingleOption extends CommonDomain {
    private Long fkOptionItem;
    private String name;
    private String optionText;
    private Long fkSubQuestionItem;
    private QuestionItem questionItem;



    public QuestionItem getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(QuestionItem questionItem) {
        this.questionItem = questionItem;
    }

    public Long getFkOptionItem() {
        return fkOptionItem;
    }

    public Long getFkSubQuestionItem() {
        return fkSubQuestionItem;
    }

    public void setFkSubQuestionItem(Long fkSubQuestionItem) {
        this.fkSubQuestionItem = fkSubQuestionItem;
    }

    public void setFkOptionItem(Long fkOptionItem) {
        this.fkOptionItem = fkOptionItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }
}
