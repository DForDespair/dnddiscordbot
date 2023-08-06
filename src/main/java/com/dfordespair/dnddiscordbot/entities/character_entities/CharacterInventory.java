package com.dfordespair.dnddiscordbot.entities.character_entities;

import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CharacterInventory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    public Long id;
    @OneToMany(
            mappedBy = "inventory"
    )
    public Set<CharacterInventoryItem> items = new HashSet();
    @OneToOne
    public PlayerCharacter character;

    public CharacterInventory(Set<CharacterInventoryItem> items, PlayerCharacter character) {
        this.items = items;
        this.character = character;
    }

    public CharacterInventory() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CharacterInventoryItem> getItems() {
        return this.items;
    }

    public void setItems(Set<CharacterInventoryItem> items) {
        this.items = items;
    }

    public PlayerCharacter getCharacter() {
        return this.character;
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public void addInventoryItem(Item item, Integer quantity) {
        CharacterInventoryItem itemToAdd = new CharacterInventoryItem();
        itemToAdd.setItem(item);
        itemToAdd.setQuantity(quantity);
        itemToAdd.setInventory(this);
        this.items.add(itemToAdd);
    }

    public String toString() {
        Long var10000 = this.id;
        return "CharacterInventory{id=" + var10000 + ", items=" + String.valueOf(this.items) + ", character=" + String.valueOf(this.character) + "}";
    }
}

