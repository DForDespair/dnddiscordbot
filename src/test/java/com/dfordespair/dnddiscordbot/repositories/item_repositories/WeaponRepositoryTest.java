package com.dfordespair.dnddiscordbot.repositories.item_repositories;

import com.dfordespair.dnddiscordbot.entities.item_entities.DamageType;
import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import com.dfordespair.dnddiscordbot.entities.item_entities.Properties;
import com.dfordespair.dnddiscordbot.entities.item_entities.Weapon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
class WeaponRepositoryTest {

    @Autowired
    private WeaponRepository underTest;





    @Test
    public void testFindByName() {
        //Given
        Set<Properties> weaponProperties = new HashSet<>();
        weaponProperties.add(Properties.FINESSE);
        Weapon weaponToBeSaved = new Weapon("Sword", "A sharp sword", false, 10, DamageType.PIERCING, weaponProperties);
        //When
        underTest.save(weaponToBeSaved);
        Optional<Weapon> foundWeapon = underTest.findByName("Sword");
        // That
        Assertions.assertThat(foundWeapon).isPresent();
        assertEquals(weaponToBeSaved.getName(), foundWeapon.get().getName());
    }
    @Test
    void itShouldGetAllMagicalWeaponsByDamageType() {
        // Given
        Set<Properties> weaponProperties = new HashSet<>();
        weaponProperties.add(Properties.FINESSE);
        Weapon magicalWeapon1 = new Weapon("Sword1", "A sharp magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon magicalWeapon2 = new Weapon("Sword2", "Another magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon magicalWeapon3 = new Weapon("Sword3", "Another magical sword", true, 10, DamageType.SLASHING, weaponProperties);
        Weapon nonMagicalWeapon1 = new Weapon("Sword4", "Another magical sword", false, 10, DamageType.PIERCING, weaponProperties);
        List<Weapon> weapons = Arrays.asList(magicalWeapon1, magicalWeapon2, magicalWeapon3, nonMagicalWeapon1);
        underTest.saveAll(weapons);
        // When

        List<Weapon> foundWeapons = underTest.getAllMagicalWeaponsByDamageType(DamageType.PIERCING);
        // Then

        Assertions.assertThat(foundWeapons).isNotEmpty();
        Assertions.assertThat(foundWeapons).containsExactlyInAnyOrder(magicalWeapon1, magicalWeapon2);
    }

    @Test
    void itShouldGetAllNonMagicalWeaponsByDamageType() {
        // Given
        Set<Properties> weaponProperties = new HashSet<>();
        weaponProperties.add(Properties.FINESSE);
        Weapon magicalWeapon1 = new Weapon("Sword1", "A sharp magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon magicalWeapon2 = new Weapon("Sword2", "Another magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon1 = new Weapon("Sword3", "Another magical sword", false, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon2 = new Weapon("Sword4", "Another magical sword", false, 10, DamageType.SLASHING, weaponProperties);
        List<Weapon> weapons = Arrays.asList(magicalWeapon1, magicalWeapon2, nonMagicalWeapon1, nonMagicalWeapon2);
        underTest.saveAll(weapons);
        // When

        List<Weapon> foundWeapons = underTest.getAllNonMagicalWeaponsByDamageType(DamageType.PIERCING);
        // Then

        Assertions.assertThat(foundWeapons).isNotEmpty();
        Assertions.assertThat(foundWeapons).containsExactlyInAnyOrder(nonMagicalWeapon1);

    }

    @Test
    void itShouldGetAllMagicalWeaponsByProperty() {
        // Given
        Set<Properties> weaponProperties = new HashSet<>();
        weaponProperties.add(Properties.FINESSE);
        Weapon magicalWeapon1 = new Weapon("Sword1", "A sharp magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon magicalWeapon2 = new Weapon("Sword2", "Another magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon1 = new Weapon("Sword3", "Another magical sword", false, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon2 = new Weapon("Sword4", "Another magical sword", false, 10, DamageType.SLASHING, weaponProperties);
        List<Weapon> weapons = Arrays.asList(magicalWeapon1, magicalWeapon2, nonMagicalWeapon1, nonMagicalWeapon2);
        underTest.saveAll(weapons);
        // When

        List<Weapon> foundWeaponsWithHeavy = underTest.getAllMagicalWeaponsByProperty(Properties.HEAVY);

        List<Weapon> foundWeaponsWithFinesse= underTest.getAllMagicalWeaponsByProperty(Properties.FINESSE);
        // Then

        Assertions.assertThat(foundWeaponsWithHeavy).isEmpty();
        Assertions.assertThat(foundWeaponsWithHeavy).containsExactlyInAnyOrder();

        Assertions.assertThat(foundWeaponsWithFinesse).isNotEmpty();
        Assertions.assertThat(foundWeaponsWithFinesse).containsExactlyInAnyOrder(magicalWeapon1, magicalWeapon2);




    }

    @Test
    void itShouldGetAllNonMagicalWeaponsByProperty() {
        Set<Properties> weaponProperties = new HashSet<>();
        weaponProperties.add(Properties.FINESSE);
        Weapon magicalWeapon1 = new Weapon("Sword1", "A sharp magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon magicalWeapon2 = new Weapon("Sword2", "Another magical sword", true, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon1 = new Weapon("Sword3", "Another magical sword", false, 10, DamageType.PIERCING, weaponProperties);
        Weapon nonMagicalWeapon2 = new Weapon("Sword4", "Another magical sword", false, 10, DamageType.SLASHING, weaponProperties);
        List<Weapon> weapons = Arrays.asList(magicalWeapon1, magicalWeapon2, nonMagicalWeapon1, nonMagicalWeapon2);
        underTest.saveAll(weapons);
        // When

        List<Weapon> foundWeaponsWithHeavy = underTest.getAllNonMagicalWeaponsByProperty(Properties.HEAVY);

        List<Weapon> foundWeaponsWithFinesse = underTest.getAllNonMagicalWeaponsByProperty(Properties.FINESSE);
        // Then

        Assertions.assertThat(foundWeaponsWithHeavy).isEmpty();
        Assertions.assertThat(foundWeaponsWithHeavy).containsExactlyInAnyOrder();

        Assertions.assertThat(foundWeaponsWithFinesse).isNotEmpty();
        Assertions.assertThat(foundWeaponsWithFinesse).containsExactlyInAnyOrder(nonMagicalWeapon1, nonMagicalWeapon2);

    }
}