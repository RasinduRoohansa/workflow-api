package com.spsolutions.grand.resources.event;

import com.spsolutions.grand.dao.EnquiryClientStory;
import com.spsolutions.grand.dao.QuoteAnswer;
import com.spsolutions.grand.domain.enquiry.Walkthrough;
import com.spsolutions.grand.domain.question.QuestionItem;
import com.spsolutions.grand.service.event.WalkthroughService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stelan Briyan
 */
@RestController
@RequestMapping(value = "/walk-through/")
public class WalkthroughAPI {

    @Autowired
    private WalkthroughService walkthroughService;

    @PostMapping("mapEnquiryWalkthroughTemplate")
    public void mapEnquiryWalkthroughTemplate(@RequestBody Walkthrough walkthrough) {
        this.walkthroughService.mapEnquiryWalkthroughTemplate(walkthrough);
    }

    @GetMapping("findWalkthroughByEnquiryId/{id}")
    public Walkthrough findWalkthroughByEnquiryId(@PathVariable("id") Long id) {
        return this.walkthroughService.findWalkthroughByEnquiryId(id);
    }

    @GetMapping("findQuestionIdByTemplateId/{id}")
    public List<QuestionItem> findQuestionIdByTemplateId(@PathVariable("id") Long id) {
        return this.walkthroughService.findQuestionIdByTemplateId(id);
    }

    @GetMapping("findSubQuestionItemByOptionId/{id}")
    public QuestionItem findSubQuestionItemByOptionId(@PathVariable("id") Long id) {
        return this.walkthroughService.findSubQuestionItemByOptionId(id);
    }

    @PostMapping("saveQuestionAnswer")
    public void saveQuestionAnswer(@RequestBody QuoteAnswer answer) {
        this.walkthroughService.saveQuestionAnswer(answer);
    }

    @PostMapping("saveClientStory")
    public void saveClientStory(@RequestBody EnquiryClientStory clientStory) {
        this.walkthroughService.saveClientStory(clientStory);
    }

    @GetMapping("findClientStory/{id}")
    public Map<String, String> findClientStory(@PathVariable("id") Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("clientStory", this.walkthroughService.findClientStory(id));
        return response;
    }

    @GetMapping("findQuestionAnswer/{fkWalkThrough}")
    public List<QuoteAnswer> findQuestionAnswer(@PathVariable("fkWalkThrough") Long fkWalkThrough) {
        return this.walkthroughService.findQuestionAnswer(fkWalkThrough);
    }
}
