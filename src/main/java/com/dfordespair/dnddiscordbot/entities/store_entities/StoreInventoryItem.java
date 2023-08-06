package com.dfordespair.dnddiscordbot.entities.store_entities;


import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import jakarta.persistence.*;

@Entity
public class StoreInventoryItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "store_inventory_id",
            nullable = false
    )
    private StoreInventory storeInventory;
    @ManyToOne
    @JoinColumn(
            name = "item_id",
            nullable = false
    )
    private Item item;
    @Column
    private int price;
    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            name = "currency"
    )
    private GameCurrency gameCurrency;

    public StoreInventoryItem() {
    }

    public StoreInventoryItem(StoreInventory storeInventory, Item item, int price, GameCurrency gameCurrency) {
        this.storeInventory = storeInventory;
        this.item = item;
        this.price = price;
        this.gameCurrency = gameCurrency;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreInventory getStoreInventory() {
        return this.storeInventory;
    }

    public void setStoreInventory(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public GameCurrency getGameCurrency() {
        return this.gameCurrency;
    }

    public void setGameCurrency(GameCurrency gameCurrency) {
        this.gameCurrency = gameCurrency;
    }

    public String toString() {
        Long var10000 = this.id;
        return "StoreInventoryItem{id=" + var10000 + ", storeInventory=" + String.valueOf(this.storeInventory) + ", item=" + String.valueOf(this.item) + ", price=" + this.price + ", gameCurrency=" + String.valueOf(this.gameCurrency) + "}";
    }
}