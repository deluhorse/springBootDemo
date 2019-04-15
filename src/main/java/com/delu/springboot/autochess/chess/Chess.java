package com.delu.springboot.autochess.chess;
import java.util.Date;
/**
* 描述：棋子模型
* @author delu
* @date 2019/04/07
*/
public class Chess {

    /**
    *棋子id
    */
    private String chessId = "";

    /**
    *棋子头图
    */
    private String headImg = "";

    /**
    *棋子名称
    */
    private String chessName = "";

    private int cost = 0;

    /**
    *棋子背景描述
    */
    private String detail = "";

    /**
    *种族
    */
    private String race = "";

    /**
    *职业
    */
    private String occupation = "";

    /**
    *基础护甲
    */
    private String armor = "";

    /**
    *生命值
    */
    private String health = "";

    /**
    *生命回复
    */
    private String healthRegen = "";

    /**
    *魔法抗性
    */
    private String magicRes = "";

    /**
    *魔法值
    */
    private String mana = "";

    /**
    *魔法回复
    */
    private String manaRegen = "";

    /**
    *技能伤害
    */
    private String spellDmg = "";

    /**
    *攻击频率
    */
    private String attSec = "";

    /**
    *移速加成
    */
    private String moveSpAmp = "";

    /**
    *攻击力
    */
    private String damage = "";

    /**
     * 平均dps
     */
    private String avgDps = "";

    public String getAvgDps() {
        return avgDps;
    }

    public void setAvgDps(String avgDps) {
        this.avgDps = avgDps;
    }

    /**
    *创建时间
    */

    private Date createTime = new Date();

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getChessId() {
        return this.chessId;
    }

    public void setChessId(String chessId) {
        this.chessId = chessId;
    }

    public String getHeadImg() {
        return this.headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getChessName() {
        return this.chessName;
    }

    public void setChessName(String chessName) {
        this.chessName = chessName;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getArmor() {
        return this.armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getHealth() {
        return this.health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getHealthRegen() {
        return this.healthRegen;
    }

    public void setHealthRegen(String healthRegen) {
        this.healthRegen = healthRegen;
    }

    public String getMagicRes() {
        return this.magicRes;
    }

    public void setMagicRes(String magicRes) {
        this.magicRes = magicRes;
    }

    public String getMana() {
        return this.mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getManaRegen() {
        return this.manaRegen;
    }

    public void setManaRegen(String manaRegen) {
        this.manaRegen = manaRegen;
    }

    public String getSpellDmg() {
        return this.spellDmg;
    }

    public void setSpellDmg(String spellDmg) {
        this.spellDmg = spellDmg;
    }

    public String getAttSec() {
        return this.attSec;
    }

    public void setAttSec(String attSec) {
        this.attSec = attSec;
    }

    public String getMoveSpAmp() {
        return this.moveSpAmp;
    }

    public void setMoveSpAmp(String moveSpAmp) {
        this.moveSpAmp = moveSpAmp;
    }

    public String getDamage() {
        return this.damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}