package com.example.chapter8.service;

import com.example.chapter8.domain.LearnResouce;
import com.example.chapter8.tools.Page;

import java.util.Map;

public interface LearnService {

    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    Page queryLearnResouceList(Map<String, Object> params);


}
