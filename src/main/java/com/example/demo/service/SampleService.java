package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sample;
import com.example.demo.repository.SampleRepository;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public void addPerson(Sample person){
    	sampleRepository.save(person);
    }

    public Sample getPerson(String id){
        return sampleRepository.findOne(id);
    }
}