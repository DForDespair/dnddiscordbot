package com.dfordespair.dnddiscordbot.repositories.character_repositories;

import com.dfordespair.dnddiscordbot.entities.character_entities.DiscordAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscordAccountRepository extends JpaRepository<DiscordAccount, Long> {


}
