package dto;

import lombok.Data;
import lombok.ToString;

@Data
public class BookDTO {
    private Integer id;
    private String name;
    private String author;
    private Double cost;
    private String genre;

    public String toString(){
        return String.format("%d-kitob: \nNomi: %s \nNarxi: %.2f \nJanri: %s \nMuallif: %s", id, name, cost, genre, author);
    }
}
