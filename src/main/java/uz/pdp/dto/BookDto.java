package uz.pdp.dto;

//Asilbek Fayzullayev 25.02.2022 9:08

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int id;
    private String name;
    private String description;
    private String  price;
}