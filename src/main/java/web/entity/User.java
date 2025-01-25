package web.entity;


import lombok.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only letters")
    @Column
    private String name;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only letters")
    @Column
    private String lastName;
}
