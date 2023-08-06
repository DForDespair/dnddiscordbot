package com.dfordespair.dnddiscordbot.entities.item_entities;

import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Tools extends Item {
    public Tools(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, description, isMagic, weight, storeInventoryItems);
    }

    public Tools(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, isMagic, weight, storeInventoryItems);
    }

    public Tools(String name, String description, boolean isMagic, double weight) {
        super(name, description, isMagic, weight);
    }

    public Tools(String name, boolean isMagic, double weight) {
        super(name, isMagic, weight);
    }

    public Tools() {
    }

    public String toString() {
        return "Tools{} " + super.toString();
    }
}
