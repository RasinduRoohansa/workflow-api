package com.spsolutions.grand.domain.question;

import com.spsolutions.grand.domain.QuestionSingleOption;
import com.spsolutions.grand.domain.common.CommonDomain;
import com.spsolutions.grand.domain.master.QuestionType;

import java.util.List;

public class QuestionItem extends CommonDomain {
    private Long fkQuestionType;
    private Long fkTemplate;
    private QuestionType type;
    private String question;
    private String subQuestionName;
    private boolean main;
    private List<QuestionSingleOption> optionList;

    public String getSubQuestionName() {
        return subQuestionName;
    }

    public void setSubQuestionName(String subQuestionName) {
        this.subQuestionName = subQuestionName;
    }

    public List<QuestionSingleOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<QuestionSingleOption> optionList) {
        this.optionList = optionList;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getFkQuestionType() {
        return fkQuestionType;
    }

    public void setFkQuestionType(Long fkQuestionType) {
        this.fkQuestionType = fkQuestionType;
    }

    public Long getFkTemplate() {
        return fkTemplate;
    }

    public void setFkTemplate(Long fkTemplate) {
        this.fkTemplate = fkTemplate;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }
}
