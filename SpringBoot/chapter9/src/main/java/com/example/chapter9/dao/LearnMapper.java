package com.example.chapter9.dao;


import com.example.chapter9.domain.LearnResouce;
import com.example.chapter9.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface LearnMapper {
    @Insert("INSERT INTO learn_resource(author, title, url) VALUES (#{author}, #{title}, #{url})")
    int add(LearnResouce learnResouce);

    @Update("UPDATE learn_resource SET author=#{author}, title=#{title}, url=#{url} where id = #{id}")
    int update(LearnResouce learnResouce);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResouceByParams")
    List<LearnResouce> queryLearnResouceList(Map<String, Object> params);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);


    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(property = "author", column = "author", javaType = String.class),
            @Result(property = "title", column = "title", javaType = String.class)
    })
    LearnResouce queryLearnResouceById(@Param("id") Long id);


    class LearnSqlBuilder{
        public String queryLearnResouceByParams(final Map<String, Object> params){
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT * FROM learn_resource WHERE 1=1 ");
            if(!StringUtil.isNull((String)params.get("author"))){
                sql.append(" AND author LIKE '%").append((String)params.get("author")).append("%'");
            }

            if(!StringUtil.isNull((String)params.get("title"))){
                sql.append(" AND title LIKE '%").append((String)params.get("title")).append("%'");
            }

            System.out.println("查询sql=="+sql.toString());
            return sql.toString();

        }

        public String deleteByids(@Param("ids") final String[] ids){
            StringBuffer sql =new StringBuffer();
            sql.append("DELETE FROM learn_resource WHERE id in(");
            for (int i=0;i<ids.length;i++){
                if(i==ids.length-1){
                    sql.append(ids[i]);
                }else{
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }
    }

}
