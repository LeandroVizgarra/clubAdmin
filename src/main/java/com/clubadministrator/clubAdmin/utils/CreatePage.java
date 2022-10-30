package com.clubadministrator.clubAdmin.utils;

import org.springframework.data.domain.Page;

import java.util.List;

public class CreatePage {
    private final FinalPage finalPage;

    public CreatePage(){
        this.finalPage = new FinalPage();
    }

    public void loadList(List<?> list){
        this.finalPage.setContent(list);
    }
    public CreatePage paginateResult(Page page){
        this.finalPage.setTotalResult(page.getTotalElements());
        return this;
    }
    public FinalPage build(){
        return this.finalPage;
    }
}
