package com.example.translation_app;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyDTO {
    public String textSource;
    public String sourceLangCode;
    public String targetLangCode;
    public String format;
    public String alternatives;
    public String api_key;

}
