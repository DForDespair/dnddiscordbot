package com.dfordespair.dnddiscordbot.entities.store_entities;

import com.dfordespair.dnddiscordbot.exceptions.ConversionException;

public enum GameCurrency {
    GOLD(100),
    SILVER(10),
    COPPER(1);

    private final int factor;

    private GameCurrency(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return this.factor;
    }

    public int convert(int amount, GameCurrency targetCurrency) throws ConversionException {
        int effectiveFactor = amount * this.factor / targetCurrency.factor;
        if (effectiveFactor * targetCurrency.factor != amount * this.factor) {
            throw new ConversionException("Conversion would result in a fractional amount");
        } else {
            return effectiveFactor;
        }
    }
}