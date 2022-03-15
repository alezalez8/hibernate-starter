package com.dmdev.entity;

import com.dmdev.converter.BirthdayConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data   // генерит сеттеры, геттеры,хэшкоды, тустринг и т.д.
@NoArgsConstructor
@AllArgsConstructor
@Builder // создание красиво сущностей
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    private String username;
    private String firstname;
    private String lastname;

   // @Convert(converter = BirthdayConverter.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    //private LocalDate birthDate;


   // private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

}
