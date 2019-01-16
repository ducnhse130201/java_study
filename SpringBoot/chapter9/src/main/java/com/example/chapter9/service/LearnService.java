package com.example.chapter9.service;

import com.example.chapter9.domain.LearnResouce;
import com.example.chapter9.tools.Page;

import java.util.List;
import java.util.Map;

public interface LearnService {

    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String[] ids);
    LearnResouce queryLearnResouceById(Long learnResouce);
    List queryLearnResouceList(Map<String, Object> params);


}
