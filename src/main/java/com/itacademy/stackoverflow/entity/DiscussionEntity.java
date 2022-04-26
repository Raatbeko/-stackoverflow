package com.itacademy.stackoverflow.entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "discussion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscussionEntity extends BaseEntity{
    @Column(name = "discussion")
    String discussion;

}
