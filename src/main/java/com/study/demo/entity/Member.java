package com.study.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert //save할 때 null 값을 배제하고 insert
@DynamicUpdate
@Table(name="member")
@Entity
public class Member extends BaseEntity {

    //아이디
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //이름
    @NotNull
    @Column(name="user_name")
    private String userName;

    //닉네임
    @NotNull
    @Column(name="nick_name", unique = true)
    private String nickName;

    //나이
    @NotNull
    @Column(name="age")
    private Integer age;

    //프로필 이미지
    @Column(name="profile_image")
    private String profileImage;
}