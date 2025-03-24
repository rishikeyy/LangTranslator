package com.example.translation_app;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyDTO {
    @JsonProperty("q")
    public String textSource;
    @JsonProperty("source")
    public String sourceLangCode;
    @JsonProperty("target")
    public String targetLangCode;
    @JsonProperty("format")
    public String format;
    @JsonProperty("alternatives")
    public String alternatives;
    @JsonProperty("api_key")
    public String api_key;

}
