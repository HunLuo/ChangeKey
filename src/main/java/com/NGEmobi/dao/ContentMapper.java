package com.NGEmobi.dao;

import com.NGEmobi.model.Content;
import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Content record);

    Content selectByPrimaryKey(Integer id);

    Content selectByAppName(String appName);

    List<Content> selectAll();

    int updateByPrimaryKey(Content record);

    int updateByAppName(Content record);


}