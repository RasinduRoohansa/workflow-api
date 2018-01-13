package com.spsolutions.grand.resources.master;

import com.spsolutions.grand.domain.QuestionSingleOption;
import com.spsolutions.grand.domain.master.QuestionType;
import com.spsolutions.grand.domain.question.QuestionItem;
import com.spsolutions.grand.service.master.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stelan Briyan
 * @since 2017-12-01
 */
@RestController
@RequestMapping(value = "/question/")
public class QuestionAPI {

    @Autowired
    private QuestionService questionService;

    @GetMapping("findQuestionType")
    public List<QuestionType> findQuestionType() {
        return this.questionService.findQuestionType();
    }

    @PostMapping("createQuestionItem")
    public void createQuestionItem(@RequestBody QuestionItem questionItem) {
        this.questionService.createQuestionItem(questionItem);
    }

    @GetMapping("findQuestionTypeByTemplateId/{templateId}")
    public List<QuestionItem> findQuestionTypeByTemplateId(@PathVariable("templateId") Long templateId) {
        return this.questionService.findQuestionTypeByTemplateId(templateId);
    }

    @PostMapping("saveQuestion")
    public void saveQuestion(@RequestBody QuestionItem questionItem) {
        this.questionService.saveQuestion(questionItem);
    }

    @PostMapping("tagQuestionToOption")
    public QuestionSingleOption tagQuestionToOption(@RequestBody QuestionSingleOption singleOption) {
        return this.questionService.tagQuestionToOption(singleOption);
    }

    @GetMapping("findSingleOptionByItemId/{id}")
    public List<QuestionSingleOption> findSingleOptionByItemId(@PathVariable("id") Long id) {
        return this.questionService.findSingleOptionByItemId(id);
    }

    /**
     * find sub question for options by main item id
     *
     * @param id
     * @return
     */
    @GetMapping("findSubQuestionForOptions/{id}")
    public List<QuestionItem> findSubQuestionForOptions(@PathVariable("id") Long id) {
        return this.questionService.findSubQuestionForOptions(id);
    }

    @GetMapping("deactivateSubQuestionByOption/{id}")
    public void deactivateSubQuestionByOption(@PathVariable("id") Long id) {
        this.questionService.deactivateSubQuestionByOption(id);
    }

    @GetMapping("findQuestionById/{id}")
    public QuestionItem findQuestionById(@PathVariable("id") Long id) {
        return this.questionService.findQuestionById(id);
    }
}
