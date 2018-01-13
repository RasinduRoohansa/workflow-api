package com.spsolutions.grand.mappers.event;

import com.spsolutions.grand.dao.QuoteAnswer;
import com.spsolutions.grand.domain.enquiry.Walkthrough;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WalkthroughMapper {

    Walkthrough findWalkthroughByEnquiryId(Long id);

    void mapEnquiryWalkthroughTemplate(Walkthrough walkthrough);

    void saveQuestionAnswer(QuoteAnswer answer);

    void updateFkWalkThroughId(@Param("fkWalkThrough") Long fkWalkThrough,
                               @Param("enquiryId") Long enquiryId);

    List<QuoteAnswer> findQuestionAnswer(Long fkWalkThrough);
}
