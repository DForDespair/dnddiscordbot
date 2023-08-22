package com.dfordespair.dnddiscordbot.repositories.item_repositories;

import com.dfordespair.dnddiscordbot.entities.item_entities.DamageType;
import com.dfordespair.dnddiscordbot.entities.item_entities.Properties;
import com.dfordespair.dnddiscordbot.entities.item_entities.Weapon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface WeaponRepository extends ItemBaseRepository<Weapon>{

    @Query("SELECT w FROM Weapon w WHERE w.damageType = :damageType AND w.isMagic = true")
    List<Weapon> getAllMagicalWeaponsByDamageType(@Param("damageType") DamageType damageType);

    @Query("SELECT w FROM Weapon w WHERE w.damageType = :damageType AND w.isMagic = false")
    List<Weapon> getAllNonMagicalWeaponsByDamageType(@Param("damageType") DamageType damageType);

    @Query("SELECT w FROM Weapon w JOIN w.property p  WHERE p = :property AND w.isMagic = true")
    List<Weapon> getAllMagicalWeaponsByProperty(@Param("property") Properties property);

    @Query("SELECT w FROM Weapon w JOIN w.property p  WHERE p = :property AND w.isMagic = false")
    List<Weapon> getAllNonMagicalWeaponsByProperty(@Param("property") Properties property);



}
