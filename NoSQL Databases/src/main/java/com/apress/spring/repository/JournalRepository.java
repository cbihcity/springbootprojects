package com.apress.spring.repository;

import com.apress.spring.domain.Journal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ihhe0417 on 4/26/2017.
 */
public interface JournalRepository extends MongoRepository<Journal, String> {
    public List<Journal> findByTitleLike(String word);
}
