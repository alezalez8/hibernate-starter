package com.dmdev.entity;


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
@Table(name = "my_family", schema = "public")
public class MyFamily {

    @Id
    private String id;

    private String department;

    private String position;

    @Column(name = "hair_date")
    private LocalDate hairDate;

    @Enumerated(EnumType.STRING)
    private MaleFemale sex;

}
