package com.dfordespair.dnddiscordbot.repositories.item_repositories;

import com.dfordespair.dnddiscordbot.entities.item_entities.Armour;
import com.dfordespair.dnddiscordbot.entities.item_entities.ArmourType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArmourRepository extends ItemBaseRepository<Armour> {

    // Find by name
    List<Armour> findByNameContainingIgnoreCase(String name);

    // Find by ArmourType
    List<Armour> findByArmourType(ArmourType armourType);

    // Find by minimum strength requirement
    List<Armour> findByMinStrengthScore(int strengthScore);
    List<Armour> findByMinStrengthScoreGreaterThan(int strengthScore);
    List<Armour> findByMinStrengthScoreLessThan(int strengthScore);

    // Find by stealth disadvantage
    List<Armour> findByDisadvantageStealth(boolean disadvantage);

    // Find with base AC above or below a certain value
    List<Armour> findByBaseACGreaterThan(int acValue);
    List<Armour> findByBaseACLessThan(int acValue);


}
