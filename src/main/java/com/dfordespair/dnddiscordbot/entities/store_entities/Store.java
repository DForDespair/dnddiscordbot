package com.dfordespair.dnddiscordbot.entities.store_entities;


import jakarta.persistence.*;

@Entity
@Table(
        name = "store"
)
public class Store {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    @Column(
            nullable = false
    )
    private String name;
    @Column
    private String city;
    @OneToOne(
            mappedBy = "stores",
            cascade = {CascadeType.ALL}
    )
    private StoreInventory storeInventory;

    public Store(String name, String city, StoreInventory storeInventory) {
        this.name = name;
        this.city = city;
        this.storeInventory = storeInventory;
    }

    public Store() {
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

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StoreInventory getStoreInventory() {
        return this.storeInventory;
    }

    public void setStoreInventory(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    public String toString() {
        Long var10000 = this.id;
        return "Store{id=" + var10000 + ", name='" + this.name + "', city='" + this.city + "', storeInventory=" + String.valueOf(this.storeInventory) + "}";
    }
}