package com.dfordespair.dnddiscordbot.entities.store_entities;

import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "store_inventory"
)
public class StoreInventory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.TABLE
    )
    private Long id;
    @OneToOne
    @JoinColumn(
            name = "store_id"
    )
    private Store stores;
    @OneToMany(
            mappedBy = "storeInventory"
    )
    private Set<StoreInventoryItem> storeInventoryItems = new HashSet();

    public StoreInventory(Store stores, Set<StoreInventoryItem> storeInventoryItems) {
        this.stores = stores;
        this.storeInventoryItems = storeInventoryItems;
    }

    public StoreInventory() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStores() {
        return this.stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }

    public Set<StoreInventoryItem> getStoreInventoryItems() {
        return this.storeInventoryItems;
    }

    public void setStoreInventoryItems(Set<StoreInventoryItem> storeInventoryItems) {
        this.storeInventoryItems = storeInventoryItems;
    }

    public void addStoreInventoryItem(Item item, int price, GameCurrency currency) {
        StoreInventoryItem storeInventoryItemToAdd = new StoreInventoryItem();
        storeInventoryItemToAdd.setItem(item);
        storeInventoryItemToAdd.setPrice(price);
        storeInventoryItemToAdd.setGameCurrency(currency);
        this.storeInventoryItems.add(storeInventoryItemToAdd);
    }

    public String toString() {
        Long var10000 = this.id;
        return "StoreInventory{id=" + var10000 + ", stores=" + String.valueOf(this.stores) + ", storeInventoryItems=" + String.valueOf(this.storeInventoryItems) + "}";
    }
}
