package com.dfordespair.dnddiscordbot.repositories.character_repositories;

import com.dfordespair.dnddiscordbot.entities.character_entities.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, Long> {

    Optional<PlayerCharacter> findPlayerCharacterByFirstNameAndLastName(String firstName, String lastName);

    

}
