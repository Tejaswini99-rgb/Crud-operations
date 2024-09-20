package com.example.location.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.location.model.Git;
@Repository
public interface Gitrepo extends JpaRepository<Git, Integer> {

}
