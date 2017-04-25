package com.apress.spring.controller;

import com.apress.spring.entity.Journal;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by HeroDishonest on 26.04.2017.
 */
@RestController
public class JournalController {

    private static List<Journal> entries = new ArrayList<Journal>();

    static {
        try {
            entries.add(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot", "01/01/2016"));
            entries.add(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project", "01/02/2016"));
            entries.add(new Journal("Spring Boot Reading", "Read more about Spring Boot", "02/01/2016"));
            entries.add(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/journal/all")
    public List<Journal> getAll() throws ParseException{
        return entries;
    }
    @RequestMapping("/journal/findBy/title/{title}")
    public List<Journal> findByTitleContains(@PathVariable String title) throws
            ParseException{
        return entries
                .stream()
                .filter(entry -> entry.getTitle().toLowerCase().contains(title.
                        toLowerCase()))
                .collect(Collectors.toList());
    }
    @RequestMapping(value="/journal",method = RequestMethod.POST )
    public Journal add(@RequestBody Journal entry){
        entries.add(entry);
        return entry;
    }
}