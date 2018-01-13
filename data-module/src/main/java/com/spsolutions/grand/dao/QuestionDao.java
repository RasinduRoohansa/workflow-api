package com.spsolutions.grand.dao;

import com.spsolutions.grand.domain.QuestionSingleOption;
import com.spsolutions.grand.domain.question.QuestionItem;

import java.util.List;

public class QuestionDao {
    private String createdBy;
    private QuestionItem questionItem;
    private List<QuestionSingleOption> optionList;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<QuestionSingleOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<QuestionSingleOption> optionList) {
        this.optionList = optionList;
    }

    public QuestionItem getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(QuestionItem questionItem) {
        this.questionItem = questionItem;
    }
}
