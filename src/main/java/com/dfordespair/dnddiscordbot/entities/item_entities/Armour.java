package com.dfordespair.dnddiscordbot.entities.item_entities;


import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(
        name = "armour"
)
@PrimaryKeyJoinColumn(
        name = "item_id"
)
public class Armour extends Item {

    @Column(name = "base_ac")
    private int baseAc;

    @Column(name = "max_dex_mod")
    private Integer maxDexMod;

    @Enumerated(EnumType.STRING)
    @Column(name = "armour_modifier_type")
    private ArmourModifierType armourModifierType;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "armour_type",
            nullable = false
    )
    private ArmourType armourType;


    @Column(name = "min_strength_score")
    private int minStrengthScore = 0;

    @Column(name = "disadvantage_stealth")
    private boolean disadvantageStealth = false;

    private int fixedBonus;

    public int calculateEffectiveAC(int dexModifier) {
        int effectiveAC = baseAc;

        if (armourModifierType == ArmourModifierType.DEX) {
            if (maxDexMod != null) {
                effectiveAC += Math.min(dexModifier, maxDexMod);
            } else {
                effectiveAC += dexModifier;
            }
        } else if (armourModifierType == ArmourModifierType.FIXED) {
            effectiveAC += fixedBonus;
        }

        return effectiveAC;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder(name);

        description.append(" (Base AC: ").append(baseAC);

        if (armourModifierType == ArmourModifierType.DEX) {
            if (maxDexMod != null) {
                description.append(" + Dex (Max ").append(maxDexMod).append(")");
            } else {
                description.append(" + Dex");
            }
        } else if (armourModifierType == ArmourModifierType.FIXED) {
             description.append(" + ").append(fixedBonus);
        }

        if (disadvantageStealth) {
            description.append(", Disadvantage on Stealth");
        }

        if (minStrengthScore > 0) {
            description.append(", Min Strength: ").append(minStrengthScore);
        }

        description.append(")");

        return description.toString();
    }

    public Armour(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, int baseAc, ArmourModifierType armourModifierType, ArmourType armourType) {
        super(name, description, isMagic, weight, storeInventoryItems);
        this.baseAc = baseAc;
        this.armourModifierType = armourModifierType;
        this.armourType = armourType;
    }

    public Armour(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, int baseAc, ArmourModifierType armourModifierType, ArmourType armourType) {
        super(name, isMagic, weight, storeInventoryItems);
        this.baseAc = baseAc;
        this.armourModifierType = armourModifierType;
        this.armourType = armourType;
    }

    public Armour(String name, String description, boolean isMagic, double weight, int baseAc, ArmourModifierType armourModifierType, ArmourType armourType) {
        super(name, description, isMagic, weight);
        this.baseAc = baseAc;
        this.armourModifierType = armourModifierType;
        this.armourType = armourType;
    }

    public Armour(String name, boolean isMagic, double weight, int baseAc, ArmourModifierType armourModifierType, ArmourType armourType) {
        super(name, isMagic, weight);
        this.baseAc = baseAc;
        this.armourModifierType = armourModifierType;
        this.armourType = armourType;
    }

    public Armour(int baseAc, ArmourModifierType armourModifierType, ArmourType armourType) {
        this.baseAc = baseAc;
        this.armourModifierType = armourModifierType;
        this.armourType = armourType;
    }

    public Armour() {
    }

    public int getBaseAc() {
        return baseAc;
    }

    public void setBaseAc(int baseAc) {
        this.baseAc = baseAc;
    }

    public Integer getMaxDexMod() {
        return maxDexMod;
    }

    public void setMaxDexMod(Integer maxDexMod) {
        this.maxDexMod = maxDexMod;
    }

    public ArmourModifierType getArmourModifierType() {
        return armourModifierType;
    }

    public void setArmourModifierType(ArmourModifierType armourModifierType) {
        this.armourModifierType = armourModifierType;
    }

    public ArmourType getArmourType() {
        return armourType;
    }

    public void setArmourType(ArmourType armourType) {
        this.armourType = armourType;
    }

    public int getMinStrengthScore() {
        return minStrengthScore;
    }

    public void setMinStrengthScore(int minStrengthScore) {
        this.minStrengthScore = minStrengthScore;
    }

    public boolean isDisadvantageStealth() {
        return disadvantageStealth;
    }

    public void setDisadvantageStealth(boolean disadvantageStealth) {
        this.disadvantageStealth = disadvantageStealth;
    }

    public int getFixedBonus() {
        return fixedBonus;
    }

    public void setFixedBonus(int fixedBonus) {
        this.fixedBonus = fixedBonus;
    }

    @Override
    public String toString() {
        return "Armour{" +
                "baseAc=" + baseAc +
                ", maxDexMod=" + maxDexMod +
                ", armourModifierType=" + armourModifierType +
                ", armourType=" + armourType +
                ", minStrengthScore=" + minStrengthScore +
                ", disadvantageStealth=" + disadvantageStealth +
                ", fixedBonus=" + fixedBonus +
                "} " + super.toString();
    }
}
