package com.dfordespair.dnddiscordbot.entities.item_entities;


import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(
        strategy = InheritanceType.JOINED
)
public abstract class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String name;
    @Column
    private String description;
    @Column(
            name = "is_magic",
            nullable = false
    )
    private boolean isMagic;
    @Column(
            nullable = false
    )
    private double weight;
    @OneToMany(
            mappedBy = "item"
    )
    private Set<StoreInventoryItem> storeInventoryItems = new HashSet();

    public Item(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        this.name = name;
        this.description = description;
        this.isMagic = isMagic;
        this.weight = weight;
        this.storeInventoryItems = storeInventoryItems;
    }

    public Item(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        this.name = name;
        this.isMagic = isMagic;
        this.weight = weight;
        this.storeInventoryItems = storeInventoryItems;
    }

    public Item(String name, String description, boolean isMagic, double weight) {
        this.name = name;
        this.description = description;
        this.isMagic = isMagic;
        this.weight = weight;
    }

    public Item(String name, boolean isMagic, double weight) {
        this.name = name;
        this.isMagic = isMagic;
        this.weight = weight;
    }

    public Item() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMagic() {
        return this.isMagic;
    }

    public void setMagic(boolean magic) {
        this.isMagic = magic;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Set<StoreInventoryItem> getStoreInventoryItems() {
        return this.storeInventoryItems;
    }

    public void setStoreInventoryItems(Set<StoreInventoryItem> storeInventoryItems) {
        this.storeInventoryItems = storeInventoryItems;
    }

    public String toString() {
        return "Item {\n    id=" + this.id + ",\n    name='" + this.name + "',\n    description='" + this.description + "',\n    isMagic=" + this.isMagic + ",\n    weight=" + this.weight + "\n}";
    }
}