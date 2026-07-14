package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    private int id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;

}
