package com.repo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repo.models.Tag;


public interface TagRepository extends JpaRepository<Tag, Long> {
  List<Tag> findTagsByTutorialsId(Long tutorialId);
}
