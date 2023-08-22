package com.dfordespair.dnddiscordbot.entities.item_entities;

import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Potion extends Item {
    public Potion(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, description, isMagic, weight, storeInventoryItems);
    }

    public Potion(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, isMagic, weight, storeInventoryItems);
    }

    public Potion(String name, String description, boolean isMagic, double weight) {
        super(name, description, isMagic, weight);
    }

    public Potion(String name, boolean isMagic, double weight) {
        super(name, isMagic, weight);
    }

    public Potion() {
    }

    public String toString() {
        return "Potions{} " + super.toString();
    }
}