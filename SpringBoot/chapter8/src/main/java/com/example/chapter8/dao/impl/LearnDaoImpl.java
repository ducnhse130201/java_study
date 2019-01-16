package com.example.chapter8.dao.impl;

import com.example.chapter8.dao.LearnDao;
import com.example.chapter8.domain.LearnResouce;
import com.example.chapter8.tools.Page;
import com.example.chapter8.tools.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LearnDaoImpl implements LearnDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(LearnResouce learnResouce){
        return jdbcTemplate.update("INSERT INTO learn_resource(author, title, url) VALUES (?, ?, ?)",
                learnResouce.getAuthor(), learnResouce.getTitle(), learnResouce.getUrl());
    }

    @Override
    public int update(LearnResouce learnResouce){
        return jdbcTemplate.update("UPDATE learn_resource SET author = ?, title = ?, url = ? WHERE id = ?",
                new Object[]{learnResouce.getAuthor(), learnResouce.getTitle(), learnResouce.getUrl(), learnResouce.getId()});
    }

    @Override
    public int deleteByIds(String ids){
        return jdbcTemplate.update("DELETE FROM learn_resource WHERE id IN (" + ids + ")");
    }

    @Override
    public LearnResouce queryLearnResouceById(Long id){
        List<LearnResouce> list = jdbcTemplate.query("SELECT * FROM learn_resource WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper(LearnResouce.class));
        if(null != list && list.size() > 0){
            LearnResouce learnResouce = list.get(0);
            return learnResouce;
        }else {
            return null;
        }
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM learn_resource");
        if(!StringUtil.isNull((String)params.get("author"))){
            sql.append(" WHERE author LIKE '%").append((String)params.get("author"))
                    .append("%'");
        }
        if(!StringUtil.isNull((String)params.get("title"))){
            sql.append(" WHERE title LIKE '%").append((String)params.get("title"))
                    .append("%'");
        }

        System.out.println(sql);

        Page page = new Page(sql.toString(), Integer.parseInt(params.get("page").toString()),
                Integer.parseInt(params.get("rows").toString()), jdbcTemplate);

        return page;


    }




}
