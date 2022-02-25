package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Asilbek Fayzullayev 25.02.2022 8:58
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private int id;
    private String name;
    private String description;
    private User author;

}
