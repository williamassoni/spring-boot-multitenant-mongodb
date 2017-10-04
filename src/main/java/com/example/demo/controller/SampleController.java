package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Sample;
import com.example.demo.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(method = RequestMethod.GET)
    public void createCollection(){
        Sample sampleCollection = new Sample();
        sampleService.addPerson(sampleCollection);
    }
}