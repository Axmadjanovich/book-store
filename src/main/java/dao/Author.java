package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
}
