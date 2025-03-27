package com.example.translation_app;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "enes")
public class RepoEntityenes {


        @Id
        public String source;  // 'source' is the primary key

        public String target;


}
