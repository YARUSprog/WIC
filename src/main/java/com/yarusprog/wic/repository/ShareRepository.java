package com.yarusprog.wic.repository;

import com.yarusprog.wic.model.ShareModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("shareRepository")
public interface ShareRepository extends JpaRepository<ShareModel, Long> {
}
