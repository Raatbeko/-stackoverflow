package com.itacademy.stackoverflow.entity;

import com.itacademy.stackoverflow.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleEntity extends BaseEntity {
    @Column(name = "name_role", unique = true, nullable = false)
    @Enumerated(value = EnumType.STRING)
    Role role;
}
