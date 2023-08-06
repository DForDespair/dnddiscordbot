package com.dfordespair.dnddiscordbot.entities.character_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DiscordAccount {
    @Id
    public Long id;
    @Column
    public String username;
    @Column
    public String discriminator;
    @OneToMany(
            mappedBy = "discordAccount"
    )
    public Set<PlayerCharacter> playerCharactersSet = new HashSet();

    public DiscordAccount(String username, String discriminator, Set<PlayerCharacter> playerCharactersSet) {
        this.username = username;
        this.discriminator = discriminator;
        this.playerCharactersSet = playerCharactersSet;
    }

    public DiscordAccount() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiscriminator() {
        return this.discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Set<PlayerCharacter> getPlayerCharactersSet() {
        return this.playerCharactersSet;
    }

    public void setPlayerCharactersSet(Set<PlayerCharacter> playerCharactersSet) {
        this.playerCharactersSet = playerCharactersSet;
    }

    public void addPlayerCharacter(String firstName, String lastName, String characterClass, BigInteger xp) {
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setLastName(lastName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setXp(xp);
        playerCharacterToAdd.setDiscordAccount(this);
        this.playerCharactersSet.add(playerCharacterToAdd);
    }

    public void addPlayerCharacter(String firstName, String characterClass, BigInteger xp) {
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setXp(xp);
        playerCharacterToAdd.setDiscordAccount(this);
        this.playerCharactersSet.add(playerCharacterToAdd);
    }

    public void addPlayerCharacter(String firstName, String characterClass) {
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setDiscordAccount(this);
        this.playerCharactersSet.add(playerCharacterToAdd);
    }

    public String toString() {
        Long var10000 = this.id;
        return "DiscordAccount{id=" + var10000 + ", username='" + this.username + "', discriminator='" + this.discriminator + "', playerCharactersSet=" + String.valueOf(this.playerCharactersSet) + "}";
    }
}