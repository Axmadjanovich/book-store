package dao;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
    @NonNull
    private Integer id;
    @NonNull
    private String nameUz;      
    private String nameRu;
    private Double cost;
    private Integer authorId;
    private Integer pageCount;
    private String genre;
    private Date publishedDate;
    private Integer publisherId;
}
