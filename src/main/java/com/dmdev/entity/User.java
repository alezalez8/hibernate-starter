package com.dmdev.entity;

import com.dmdev.converter.BirthdayConverter;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;


@Data   // генерит сеттеры, геттеры,хэшкоды, тустринг и т.д.
@NoArgsConstructor
@AllArgsConstructor
@Builder // создание красиво сущностей
@Entity
@Table(name = "users", schema = "public")
@TypeDef(name = "dmdev", typeClass = JsonBinaryType.class)
public class User {

    @Id
    private String username;
    private String firstname;
    private String lastname;

    // @Convert(converter = BirthdayConverter.class)
    @Column(name = "birth_date")
    private Birthday birthDate;
    //private LocalDate birthDate;


    //@Type(type = "com.vladmihalcea.hibernate.type.json.JsonBinaryType" )
    //@Type(type = "jsonb")
    @Type(type = "dmdev")
    private String info;
    // private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

}
