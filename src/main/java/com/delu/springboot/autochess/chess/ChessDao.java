package com.delu.springboot.autochess.chess;
import com.delu.springboot.autochess.chess.dto.ChessDaoBaseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
* 描述：棋子模型
* @author delu
* @date 2019/04/07
*/
@Mapper
public interface ChessDao {
    @SelectProvider(type = ChessSqlBuilder.class, method = "insert")
    void insert(Chess chess);

    @SelectProvider(type = ChessSqlBuilder.class, method = "findList")
    List<Chess> findList(ChessDaoBaseDto chessDaoBaseDto);

    @SelectProvider(type = ChessSqlBuilder.class, method = "update")
    void update(Chess chess);
}