package com.spsolutions.grand.domain.master;

import com.spsolutions.grand.domain.common.CommonDomain;

public class ItineraryCategory extends CommonDomain{
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
