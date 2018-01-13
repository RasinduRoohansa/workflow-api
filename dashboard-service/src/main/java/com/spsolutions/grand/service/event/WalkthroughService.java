package com.spsolutions.grand.service.event;

import com.spsolutions.grand.constant.LoggerConstants;
import com.spsolutions.grand.dao.EnquiryClientStory;
import com.spsolutions.grand.dao.QuoteAnswer;
import com.spsolutions.grand.domain.enquiry.Walkthrough;
import com.spsolutions.grand.domain.question.QuestionItem;
import com.spsolutions.grand.mappers.event.EventMapper;
import com.spsolutions.grand.mappers.event.WalkthroughMapper;
import com.spsolutions.grand.mappers.master.QuestionMapper;
import com.spsolutions.grand.service.activitylog.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkthroughService {

    @Autowired
    private WalkthroughMapper walkthroughMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private ActivityLogService logService;

    public Walkthrough findWalkthroughByEnquiryId(Long id) {
        return this.walkthroughMapper.findWalkthroughByEnquiryId(id);
    }

    public void mapEnquiryWalkthroughTemplate(Walkthrough walkthrough) {
        this.walkthroughMapper.mapEnquiryWalkthroughTemplate(walkthrough);
        this.walkthroughMapper.updateFkWalkThroughId(walkthrough.getId(), walkthrough.getFkQuoteEnquiry());

        this.logService.createActLog(LoggerConstants.CREATE,
                LoggerConstants.LOG_5.getType(), walkthrough.getCreatedBy(), walkthrough.getFkQuoteEnquiry());
    }

    public List<QuestionItem> findQuestionIdByTemplateId(Long id) {
        List<QuestionItem> itemList = this.questionMapper.findMainQuestionIdByTemplateId(id);

        return itemList;
    }

    public QuestionItem findSubQuestionItemByOptionId(Long id) {
        return this.questionMapper.findSubQuestionItemByOptionId(id);
    }

    public void saveQuestionAnswer(QuoteAnswer answer) {
        this.walkthroughMapper.saveQuestionAnswer(answer);
    }

    public void saveClientStory(EnquiryClientStory clientStory) {
        this.eventMapper.saveClientStory(clientStory);
    }

    public String findClientStory(Long id) {
        return this.eventMapper.findClientStory(id);
    }

    public List<QuoteAnswer> findQuestionAnswer(Long fkWalkThrough) {
        return this.walkthroughMapper.findQuestionAnswer(fkWalkThrough);
    }
}
