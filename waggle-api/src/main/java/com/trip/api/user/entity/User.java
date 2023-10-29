package com.trip.api.user.entity;

import com.trip.api.common.entity.BaseTimeEntity;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE member SET is_active=true WHERE id=?")
@Where(clause = "is_active = false")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotBlank
    private String nickname;

    @NotNull
    private String role;

    private boolean isActive;
}
