package com.rupeeroute.Auth.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User
{
    @Id
    private String username;
    private String password;
    @NonNull
    private String email;
    private String role;
    private String status;

}
