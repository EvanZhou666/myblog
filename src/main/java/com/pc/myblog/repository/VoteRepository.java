package com.pc.myblog.repository;

import com.pc.myblog.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Integer> {

}
