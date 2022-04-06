package dao;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    private Integer id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String phoneNumber;
    private Double account;
    @NonNull
    private String password;
    @NonNull
    private String username;
}