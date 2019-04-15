package com.delu.springboot.auto_chess.tools;

import com.delu.springboot.autochess.chess.Chess;
import com.delu.springboot.autochess.chess.ChessDao;
import com.delu.springboot.autochess.chess.dto.ChessDaoBaseDto;
import com.delu.springboot.autochess.tools.JsoupUtils;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delu on 2019-04-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JsoupUtilsTest {

    private JsoupUtils jsoupUtils = new JsoupUtils();

    @Autowired
    private ChessDao chessDao;

    @Test
    public void test() {

//        Chess chess = jsoupUtils.getChessFromUrl("https://dota2-zh.gamepedia.com/%E4%BC%90%E6%9C%A8%E6%9C%BA");
//
//        chessDao.insert(chess);

        List<Chess> chessList = chessDao.findList(new ChessDaoBaseDto());

        jsoupUtils.getOccupationFromFile("/apps/web/autochess/auto_chess.html", chessList);

        for (Chess chess: chessList){
            chessDao.update(chess);
        }
    }

    @Test
    public void test1(){
        String str = "上古巨神\n" +
                "不朽屍王\n" +
                "主宰\n" +
                "亞巴頓\n" +
                "伐木機\n" +
                "修補匠\n" +
                "傑奇洛\n" +
                "先知\n" +
                "光之守衛\n" +
                "克林克茲\n" +
                "全能騎士\n" +
                "冥界亞龍\n" +
                "冥魂大帝\n" +
                "剃刀\n" +
                "劇毒術士\n" +
                "力丸\n" +
                "半人馬戰行者\n" +
                "卓爾遊俠\n" +
                "司夜刺客\n" +
                "哈斯卡\n" +
                "噬魂鬼\n" +
                "大地之靈\n" +
                "天怒法師\n" +
                "天涯墨客\n" +
                "天穹守望者\n" +
                "娜迦海妖\n" +
                "孽主\n" +
                "宙斯\n" +
                "寒冬飛龍\n" +
                "小小\n" +
                "工程師\n" +
                "巨牙海民\n" +
                "巨魔戰將\n" +
                "巫妖\n" +
                "巫醫\n" +
                "帕克\n" +
                "帕吉\n" +
                "帕格納\n" +
                "干擾者\n" +
                "幻影刺客\n" +
                "幻影長矛手\n" +
                "幽鬼\n" +
                "影魔\n" +
                "復仇之魂\n" +
                "德魯伊\n" +
                "恐怖利刃\n" +
                "戴澤\n" +
                "拉席克\n" +
                "拉比克\n" +
                "撼地者\n" +
                "敵法師\n" +
                "斧王\n" +
                "斯拉克\n" +
                "斯拉達\n" +
                "斯溫\n" +
                "昆卡\n" +
                "暗夜魔王\n" +
                "暗影惡魔\n" +
                "暗影薩滿\n" +
                "末日使者\n" +
                "樹精衛士\n" +
                "死亡先知\n" +
                "歿境神蝕者\n" +
                "水晶室女\n" +
                "沉默術士\n" +
                "沙王\n" +
                "混沌騎士\n" +
                "潮汐獵人\n" +
                "灰燼之靈\n" +
                "熊戰士\n" +
                "狙擊手\n" +
                "狼人\n" +
                "獸王\n" +
                "瑪爾斯\n" +
                "痛苦女王\n" +
                "瘟疫法師\n" +
                "發條技師\n" +
                "矮人直升機\n" +
                "石鱗劍士\n" +
                "祈求者\n" +
                "神諭者\n" +
                "禍亂之源\n" +
                "米拉娜\n" +
                "米波\n" +
                "維薩吉\n" +
                "美杜莎\n" +
                "聖堂刺客\n" +
                "育母蜘蛛\n" +
                "艾歐\n" +
                "莉娜\n" +
                "萊恩\n" +
                "虛空假面\n" +
                "蝙蝠騎士\n" +
                "血魔\n" +
                "術士\n" +
                "裂魂人\n" +
                "謎團\n" +
                "變體精靈\n" +
                "賞金獵人\n" +
                "軍團指揮官\n" +
                "遠古冰魄\n" +
                "邪影芳靈\n" +
                "酒仙\n" +
                "鋼背獸\n" +
                "鍊金術士\n" +
                "露娜\n" +
                "風暴之靈\n" +
                "風行者\n" +
                "食人魔魔法師\n" +
                "馬格納斯\n" +
                "魅惑魔女\n" +
                "鳳凰\n" +
                "黑暗賢者\n" +
                "齊天大聖\n" +
                "龍騎士";
        String[] strArray = str.split("\n");
        List<Chess> chessList = new ArrayList<>();
        for(String tempStr: strArray){

            tempStr = ZhConverterUtil.convertToSimple(tempStr);

            System.out.println(tempStr);
            Chess chess = jsoupUtils.getChessFromUrl("https://dota2-zh.gamepedia.com/" + tempStr);

            chessList.add(chess);
        }

        chessList = jsoupUtils.getOccupationFromFile("/apps/web/autochess/auto_chess.html", chessList);

        for (Chess chess: chessList){
            try {
                System.out.println(chess.getChessName());
                chessDao.insert(chess);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}