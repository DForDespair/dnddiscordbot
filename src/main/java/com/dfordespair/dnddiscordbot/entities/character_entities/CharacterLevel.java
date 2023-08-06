package com.dfordespair.dnddiscordbot.entities.character_entities;


import java.math.BigInteger;

public enum CharacterLevel {
    LEVEL_1(0),
    LEVEL_2(300),
    LEVEL_3(900),
    LEVEL_4(2700),
    LEVEL_5(6500),
    LEVEL_6(14000),
    LEVEL_7(23000),
    LEVEL_8(34000),
    LEVEL_9(48000),
    LEVEL_10(64000),
    LEVEL_11(85000),
    LEVEL_12(100000),
    LEVEL_13(120000),
    LEVEL_14(140000),
    LEVEL_15(165000),
    LEVEL_16(195000),
    LEVEL_17(225000),
    LEVEL_18(265000),
    LEVEL_19(305000),
    LEVEL_20(355000);

    private final int xpThreshold;

    private CharacterLevel(int xpThreshold) {
        this.xpThreshold = xpThreshold;
    }

    public static CharacterLevel assignLevelToXP(BigInteger xp) {
        int xpValue = xp.intValue();
        CharacterLevel[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            CharacterLevel level = var2[var4];
            if (xpValue < level.xpThreshold) {
                return level;
            }
        }

        return LEVEL_20;
    }

    public String toString() {
        int var10000 = this.xpThreshold;
        return "CharacterLevel{xpThreshold=" + var10000 + "} " + super.toString();
    }
}