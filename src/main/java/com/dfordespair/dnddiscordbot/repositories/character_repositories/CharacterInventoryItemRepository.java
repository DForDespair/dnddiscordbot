package com.dfordespair.dnddiscordbot.repositories.character_repositories;

import com.dfordespair.dnddiscordbot.entities.character_entities.CharacterInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryItemRepository extends JpaRepository<CharacterInventoryItem, Long> {

}
