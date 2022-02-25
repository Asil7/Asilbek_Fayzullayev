package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Asilbek Fayzullayev 25.02.2022 9:06
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {
    private Integer id;
    private String fullName;
    private String userName;
    private String password;
    private String email;

}
