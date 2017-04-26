package com.apress.spring.service;

import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihhe0417 on 4/26/2017.
 */
@Service
public class JournalService {

    private static final Logger log = LoggerFactory.getLogger(JournalService.class);

    @Autowired
    JournalRepository repo;
    public void insertData() throws ParseException {
        log.info("### > Inserting Data...");
        repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
        repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
        repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
        repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
        log.info("> Done.");
    }

    public List<Journal> findAll(){
        List<Journal> list = new ArrayList<>();
        repo.findAll().forEach(journal -> list.add(journal));
        return list;
    }

    public void deleteCustomJournal(String title){
        repo.deleteJournalByTitleContains(title);
    }

    public List<Journal> findByCustomQuery(String word){
        return repo.findByCustomQuery(word);
    }
}
