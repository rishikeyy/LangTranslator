package com.example.translation_app.service;

import com.example.translation_app.LibreTranslateResponseDTO;
import com.example.translation_app.RepoEntityenes;
import com.example.translation_app.RequestBodyDTO;
import com.example.translation_app.repository.WordRepositoryenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

import java.util.Objects;
import java.util.Optional;

@Service
public class TranslationService {

    @Value("${libretranslate.url}")
    private String libreTranslateUrl;
    @Autowired
    RestClient restClient;  // field injection
    @Autowired
    WordRepositoryenes wordRepositoryenes;

    @Cacheable(value = "Lang", key = "#requestBodyDTO.textSource")
    Optional<RepoEntityenes> enesDB(RequestBodyDTO requestBodyDTO){
       // String key=requestBodyDTO.textSource;

       return wordRepositoryenes.findById(requestBodyDTO.textSource);
    }

    @CachePut(value = "Lang", key = "#repoEntityenesDTO")
    void RepoSave(String source, String target){
        RepoEntityenes repoEntityenesDTO=new RepoEntityenes() ;
        repoEntityenesDTO.source=source;
        repoEntityenesDTO.target=target;//use here result.alternatives[0] coz result.translatedText is not returning unique values
        wordRepositoryenes.save(repoEntityenesDTO); //put repoentityenesDTO object to this repo
    }
    public ResponseEntity<String> getTranslation(RequestBodyDTO requestBody) {
        ResponseEntity<String>finalResponse=new ResponseEntity<>(HttpStatus.OK);



        //check in DB
            //check for en to es
        if(Objects.equals(requestBody.sourceLangCode, "en") && Objects.equals(requestBody.targetLangCode, "es")){
            Optional<RepoEntityenes> chck=enesDB(requestBody);
            if(chck.isPresent()) {
                System.out.println(chck.get());
                finalResponse= new ResponseEntity<String>(chck.get().target, HttpStatus.OK);
              //  return chck.get().toString();

            }

            //else call Translate API and insert in DB
            else{
                LibreTranslateResponseDTO result = restClient.post()
                        .uri(libreTranslateUrl+"/translate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(requestBody)
                        .retrieve()
                        .body(LibreTranslateResponseDTO.class);//convert response to entity


               // System.out.println(result);
                //Tailor repoentity using request attribute("source") and result attribute("translatedText")


                RepoSave(requestBody.textSource,result.translatedText);

                finalResponse= new ResponseEntity<String>(result.translatedText, HttpStatus.OK);

            }
        }



    return finalResponse;

    }
}
