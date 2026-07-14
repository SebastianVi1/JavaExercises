package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Episode {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

}
