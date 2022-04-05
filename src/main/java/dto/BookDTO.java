package dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookDTO {
    private Integer id;
    private String name;
    private String author;
    private Double cost;
    private String genre;
}
