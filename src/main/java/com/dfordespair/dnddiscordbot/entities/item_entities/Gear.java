package com.dfordespair.dnddiscordbot.entities.item_entities;

import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(
        name = "gear"
)
public class Gear extends Item {
    public Gear(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, description, isMagic, weight, storeInventoryItems);
    }

    public Gear(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, isMagic, weight, storeInventoryItems);
    }

    public Gear(String name, String description, boolean isMagic, double weight) {
        super(name, description, isMagic, weight);
    }

    public Gear(String name, boolean isMagic, double weight) {
        super(name, isMagic, weight);
    }

    public Gear() {
    }

    public String toString() {
        return "Gear{} " + super.toString();
    }
}