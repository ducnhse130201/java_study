package com.example.chapter11.service;

import com.example.chapter11.model.LeanQueryLeanListReq;

import com.example.chapter11.domain.LearnResource;
import com.example.chapter11.util.Page;

import java.util.List;

public interface LearnService extends IService<LearnResource> {
    List<LearnResource> queryLearnResouceList(Page<LeanQueryLeanListReq> page);
    void deleteBatch(Long[] ids);


}
