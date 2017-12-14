package com.NGEmobi.dao;

import com.NGEmobi.model.Strategy;
import java.util.List;

public interface StrategyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Strategy record);

    Strategy selectByPrimaryKey(Integer id);

    Strategy selectByStatus(Integer status);

    List<Strategy> selectAll();

    int updateByPrimaryKey(Strategy record);
}