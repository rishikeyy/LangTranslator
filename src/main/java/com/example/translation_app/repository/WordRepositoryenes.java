package com.example.translation_app.repository;

import com.example.translation_app.RepoEntityenes;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface  WordRepositoryenes extends CrudRepository<RepoEntityenes,String>{

}
