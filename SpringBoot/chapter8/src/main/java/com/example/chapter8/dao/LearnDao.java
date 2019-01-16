package com.example.chapter8.dao;

import com.example.chapter8.domain.LearnResouce;
import com.example.chapter8.tools.Page;

import java.util.Map;

public interface LearnDao {
    int add(LearnResouce learnResouce);
    int update(LearnResouce learnResouce);
    int deleteByIds(String ids);
    LearnResouce queryLearnResouceById(Long id);
    Page queryLearnResouceList(Map<String,Object> params);
}

