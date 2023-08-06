package com.dfordespair.dnddiscordbot.entities.character_entities;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class PlayerCharacter extends Person {
    @Column(
            name = "character_class"
    )
    public String characterClass;
    @Column
    public BigInteger xp;
    @Column
    public Integer level;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "discord_account_id",
            foreignKey = @ForeignKey(
                    name = "fk_discord_account"
            )
    )
    public DiscordAccount discordAccount;

    public PlayerCharacter(String firstName, String lastName, String characterClass, BigInteger xp, DiscordAccount discordAccount) {
        super(firstName, lastName);
        this.xp = BigInteger.ZERO;
        this.characterClass = characterClass;
        this.xp = xp;
        this.discordAccount = discordAccount;
    }

    public PlayerCharacter(String firstName, String characterClass, BigInteger xp, DiscordAccount discordAccount) {
        super(firstName);
        this.xp = BigInteger.ZERO;
        this.characterClass = characterClass;
        this.xp = xp;
        this.discordAccount = discordAccount;
    }

    public PlayerCharacter(String characterClass, BigInteger xp, DiscordAccount discordAccount) {
        this.xp = BigInteger.ZERO;
        this.characterClass = characterClass;
        this.xp = xp;
        this.discordAccount = discordAccount;
    }

    public PlayerCharacter(String characterClass, DiscordAccount discordAccount) {
        this.xp = BigInteger.ZERO;
        this.characterClass = characterClass;
        this.discordAccount = discordAccount;
    }

    public PlayerCharacter() {
        this.xp = BigInteger.ZERO;
    }

    @PrePersist
    @PreUpdate
    private void calculateLevel() {
        CharacterLevel characterLevel = CharacterLevel.assignLevelToXP(this.xp);
        this.level = characterLevel.ordinal() + 1;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public BigInteger getXp() {
        return this.xp;
    }

    public void setXp(BigInteger xp) {
        this.xp = xp;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public DiscordAccount getDiscordAccount() {
        return this.discordAccount;
    }

    public void setDiscordAccount(DiscordAccount discordAccount) {
        this.discordAccount = discordAccount;
    }
}
