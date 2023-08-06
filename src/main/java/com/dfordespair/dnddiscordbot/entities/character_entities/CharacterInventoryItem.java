package com.dfordespair.dnddiscordbot.entities.character_entities;


import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import jakarta.persistence.*;

@Entity
public class CharacterInventoryItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "inventory_id",
            nullable = false
    )
    private CharacterInventory inventory;
    @ManyToOne
    @JoinColumn(
            name = "item_id",
            nullable = false
    )
    private Item item;
    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    public CharacterInventoryItem(CharacterInventory inventory, Item item, Integer quantity) {
        this.inventory = inventory;
        this.item = item;
        this.quantity = quantity;
    }

    public CharacterInventoryItem() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CharacterInventory getInventory() {
        return this.inventory;
    }

    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        Long var10000 = this.id;
        return "CharacterInventoryItem{id=" + var10000 + ", inventory=" + String.valueOf(this.inventory) + ", item=" + String.valueOf(this.item) + ", quantity=" + this.quantity + "}";
    }
}