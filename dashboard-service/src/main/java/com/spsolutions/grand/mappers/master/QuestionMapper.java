package com.spsolutions.grand.mappers.master;

import com.spsolutions.grand.dao.QuestionDao;
import com.spsolutions.grand.domain.QuestionSingleOption;
import com.spsolutions.grand.domain.master.QuestionType;
import com.spsolutions.grand.domain.question.QuestionItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {
    List<QuestionType> findQuestionType();

    void createQuestionItem(QuestionItem questionItem);

    List<QuestionItem> findQuestionTypeByTemplateId(Long templateId);

    void saveQuestion(QuestionDao questionDao);

    void updateQuestionItem(QuestionItem questionItem);

    void saveQuestionSingleOption(QuestionSingleOption option);

    void updateQuestionSingleOption(QuestionSingleOption option);

    List<QuestionSingleOption> findSingleOptionByItemId(Long id);

    void deactivateSingleOption(Long id);

    void tagQuestionToOption(@Param("id") Long id,
                             @Param("questionItemId") Long questionItemId);

    List<QuestionItem> findSubQuestionForOptions(Long id);

    void deactivateSubQuestionByOption(Long id);

    QuestionItem findQuestionById(Long id);

    List<QuestionItem> findMainQuestionIdByTemplateId(Long id);

    QuestionItem findSubQuestionItemByOptionId(Long id);
}
