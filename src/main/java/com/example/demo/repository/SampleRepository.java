package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Sample;

public interface SampleRepository extends MongoRepository<Sample,String> {
}
