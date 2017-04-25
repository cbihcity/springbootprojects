package com.example.repository;

/**
 * Created by HeroDishonest on 22.04.2017.
 */
import com.example.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
