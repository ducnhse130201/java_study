package com.example.chapter11.dao;

import com.example.chapter11.domain.LearnResource;
import com.example.chapter11.util.MyMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface LearnResourceMapper extends MyMapper<LearnResource> {
    List<LearnResource> queryLearnResouceList(Map<String,Object> map);
}