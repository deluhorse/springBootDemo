package com.delu.springboot.autochess.chess;

import com.delu.springboot.autochess.chess.dto.ChessDaoBaseDto;
import com.delu.springboot.autochess.tools.CommonUtils;
import com.delu.springboot.autochess.tools.SqlUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * 描述：棋子模型
 *
 * @author delu
 * @date 2019/04/07
 */
public class ChessSqlBuilder {
    public static String insert(Chess chess) {

        return new SQL() {{

            INSERT_INTO("tbl_ch_chess");
            INTO_COLUMNS(
                    "chess_id",
                    "head_img",
                    "chess_name",
                    "detail",
                    "race",
                    "occupation",
                    "armor",
                    "health",
                    "health_regen",
                    "magic_res",
                    "mana",
                    "mana_regen",
                    "spell_dmg",
                    "att_sec",
                    "move_sp_amp",
                    "damage",
                    "avg_dps"
            );
            INTO_VALUES(
                    SqlUtils.formatField(chess.getChessId()),
                    SqlUtils.formatField(chess.getHeadImg()),
                    SqlUtils.formatField(chess.getChessName()),
                    SqlUtils.formatField(chess.getDetail()),
                    SqlUtils.formatField(chess.getRace()),
                    SqlUtils.formatField(chess.getOccupation()),
                    SqlUtils.formatField(chess.getArmor()),
                    SqlUtils.formatField(chess.getHealth()),
                    SqlUtils.formatField(chess.getHealthRegen()),
                    SqlUtils.formatField(chess.getMagicRes()),
                    SqlUtils.formatField(chess.getMana()),
                    SqlUtils.formatField(chess.getManaRegen()),
                    SqlUtils.formatField(chess.getSpellDmg()),
                    SqlUtils.formatField(chess.getAttSec()),
                    SqlUtils.formatField(chess.getMoveSpAmp()),
                    SqlUtils.formatField(chess.getDamage()),
                    SqlUtils.formatField(chess.getAvgDps())
                    );
        }}.toString();
    }

    public static String findList(ChessDaoBaseDto chessDaoBaseDto){

        return new SQL(){{
            SELECT(
                    "chess_id",
                    "head_img",
                    "chess_name",
                    "detail",
                    "race",
                    "occupation",
                    "armor",
                    "health",
                    "health_regen",
                    "magic_res",
                    "mana",
                    "mana_regen",
                    "spell_dmg",
                    "att_sec",
                    "move_sp_amp",
                    "damage",
                    "avg_dps");
            FROM("tbl_ch_chess");
        }}.toString();
    }

    public static String update(Chess chess){

        return new SQL(){{

            UPDATE("tbl_ch_chess");

            SET("race = " + SqlUtils.formatField(chess.getRace()),
                    "occupation = " + SqlUtils.formatField(chess.getOccupation()),
                    "armor = " + SqlUtils.formatField(chess.getArmor()),
                    "health = " + SqlUtils.formatField(chess.getHealth()),
                    "cost = " + SqlUtils.formatField(chess.getCost()),
                    "magic_res = " + SqlUtils.formatField(chess.getMagicRes()),
                    "att_sec = " + SqlUtils.formatField(chess.getAttSec()),
                    "damage = " + SqlUtils.formatField(chess.getDamage()),
                    "avg_dps = " + SqlUtils.formatField(chess.getAvgDps()),
                    "detail = " + SqlUtils.formatField(chess.getDetail().replace("\n", "")));

            WHERE(" chess_id = " + SqlUtils.formatField(chess.getChessId()));

        }}.toString();
    }
}