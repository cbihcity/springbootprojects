package com.apress.spring.RestController;

import com.apress.spring.domain.Journal;
import com.apress.spring.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ihhe0417 on 5/3/2017.
 */
@RestController
public class JournalRest {

    @Autowired
    JournalService service;

    @RequestMapping(name = "/info")
    public List<Journal> showJournal() {
            List<Journal> list = new ArrayList<>();
            list = service.findAll();
        return list;
    }
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }
}
