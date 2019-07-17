package com.yarusprog.wic.repository;

import com.yarusprog.wic.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("imageRepository")
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
}
