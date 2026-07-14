package org.sebas.rickAndMortyApi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true) //ignore if we delete any property
public class Character {

    private int id;
    private String name;
    private String status; // corrected spelling
    private String species;
    private String type;
    private String gender;
    private Object origin;
    private Object location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
