package com.dailycodework.dreamshops.repositories;

import com.dailycodework.dreamshops.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
