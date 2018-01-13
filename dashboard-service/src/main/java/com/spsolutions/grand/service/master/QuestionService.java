package com.spsolutions.grand.service.master;

import com.spsolutions.grand.domain.QuestionSingleOption;
import com.spsolutions.grand.domain.master.QuestionType;
import com.spsolutions.grand.domain.question.QuestionItem;
import com.spsolutions.grand.mappers.master.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stelan Briyan
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionType> findQuestionType() {
        return this.questionMapper.findQuestionType();
    }

    public void createQuestionItem(QuestionItem questionItem) {
        questionItem.setMain(true);
        this.questionMapper.createQuestionItem(questionItem);
    }

    public List<QuestionItem> findQuestionTypeByTemplateId(Long templateId) {
        return this.questionMapper.findQuestionTypeByTemplateId(templateId);
    }

    public void saveQuestion(QuestionItem questionItem) {
        QuestionType type = questionItem.getType();
        this.questionMapper.updateQuestionItem(questionItem);

        if ("QN3".equals(type.getCode()) || "QN4".equals(type.getCode())) {
            List<QuestionSingleOption> options = questionItem.getOptionList();

            this.questionMapper.deactivateSingleOption(questionItem.getId());
            options.stream().forEach(option -> {
                option.setFkOptionItem(questionItem.getId());
                option.setCreatedBy(questionItem.getCreatedBy());

                if (option.getId() == null) {
                    this.questionMapper.saveQuestionSingleOption(option);
                } else {
                    this.questionMapper.updateQuestionSingleOption(option);
                }
            });
        }
    }

    public List<QuestionSingleOption> findSingleOptionByItemId(Long id) {
        return this.questionMapper.findSingleOptionByItemId(id);
    }

    public QuestionSingleOption tagQuestionToOption(QuestionSingleOption singleOption) {
        QuestionItem questionItem = singleOption.getQuestionItem();
        questionItem.setMain(false);
        this.questionMapper.createQuestionItem(questionItem);

        singleOption.setFkSubQuestionItem(questionItem.getId());
        this.questionMapper.tagQuestionToOption(singleOption.getId(), questionItem.getId());
        return singleOption;
    }

    public List<QuestionItem> findSubQuestionForOptions(Long id) {
        return this.questionMapper.findSubQuestionForOptions(id);
    }

    public void deactivateSubQuestionByOption(Long id) {
        this.questionMapper.deactivateSubQuestionByOption(id);
    }

    public QuestionItem findQuestionById(Long id) {
        return this.questionMapper.findQuestionById(id);
    }
}
