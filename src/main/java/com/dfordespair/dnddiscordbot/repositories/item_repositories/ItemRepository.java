package com.dfordespair.dnddiscordbot.repositories.item_repositories;

import com.dfordespair.dnddiscordbot.entities.item_entities.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends ItemBaseRepository<Item> {


}
