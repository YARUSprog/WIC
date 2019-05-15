package com.yarusprog.wic.repository;

import com.yarusprog.wic.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<ItemModel, Long> {
}
