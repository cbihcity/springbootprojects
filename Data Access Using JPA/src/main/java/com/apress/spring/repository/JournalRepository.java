package com.apress.spring.repository;

import com.apress.spring.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by ihhe0417 on 4/26/2017.
 */
public interface JournalRepository extends CrudRepository<Journal, Long> {
    List<Journal> findByCreatedAfter(Date date);

    @Transactional
    void deleteJournalByTitleContains(String title);

    @Query("select j from Journal j where j.title like %?1%")
    List<Journal> findByCustomQuery(String word);
}