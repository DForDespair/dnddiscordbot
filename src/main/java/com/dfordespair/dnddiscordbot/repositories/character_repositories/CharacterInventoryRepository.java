package com.dfordespair.dnddiscordbot.repositories.character_repositories;

import com.dfordespair.dnddiscordbot.entities.character_entities.CharacterInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryRepository extends JpaRepository<CharacterInventory, Long> {

}
