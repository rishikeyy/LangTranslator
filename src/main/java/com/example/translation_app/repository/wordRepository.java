package com.example.translation_app.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface  wordRepository extends CrudRepository<Word,String>{

}
