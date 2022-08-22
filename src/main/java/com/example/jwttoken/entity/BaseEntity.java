package com.example.jwttoken.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedDate
    public LocalDateTime createAt;
    @LastModifiedDate
    public LocalDateTime updateAt;
    public LocalDateTime deleteAt;
}
