package uz.pdp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Asilbek Fayzullayev 25.02.2022 9:07

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorDto {
    private Integer id;
    private String fullName;
    private String userName;
    private String email;
    private String password;

}
