package com.pc.myblog.repository;

import com.pc.myblog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Integer> {
}
