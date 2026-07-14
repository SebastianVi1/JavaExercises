package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnore
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
