package com.clubadministrator.clubAdmin.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FinalPage {

    private List<?> content = new ArrayList<>();
    private Long totalResult;

}
