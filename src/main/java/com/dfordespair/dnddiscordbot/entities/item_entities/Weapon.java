package com.dfordespair.dnddiscordbot.entities.item_entities;

import com.dfordespair.dnddiscordbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(
        name = "weapon"
)
@PrimaryKeyJoinColumn(
        name = "item_id"
)
public class Weapon extends Item {
    @Enumerated(EnumType.STRING)
    @Column(
            name = "damage_type"
    )
    private DamageType damageType;
    @ElementCollection(
            targetClass = Properties.class
    )
    @CollectionTable(
            name = "weapon_properties",
            joinColumns = {@JoinColumn(
                    name = "weapon_id"
            )}
    )
    @Enumerated(EnumType.STRING)
    @Column(
            name = "property"
    )
    private Set<Properties> property;

    public Weapon(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, DamageType damageType, Set<Properties> property) {
        super(name, description, isMagic, weight, storeInventoryItems);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, DamageType damageType, Set<Properties> property) {
        super(name, isMagic, weight, storeInventoryItems);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon(String name, String description, boolean isMagic, double weight, DamageType damageType, Set<Properties> property) {
        super(name, description, isMagic, weight);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon(String name, boolean isMagic, double weight, DamageType damageType, Set<Properties> property) {
        super(name, isMagic, weight);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon() {
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Set<Properties> getProperty() {
        return this.property;
    }

    public void setProperty(Set<Properties> property) {
        this.property = property;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Weapon {\n    id=" + var10000 + ",\n    name='" + this.getName() + "',\n    description='" + this.getDescription() + "',\n    isMagic=" + this.isMagic() + ",\n    weight=" + this.getWeight() + ",\n    damageType=" + String.valueOf(this.damageType) + ",\n    property=" + String.valueOf(this.property) + "\n}";
    }
}