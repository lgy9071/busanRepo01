package com.example.demo2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_member2")
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더를 쓰려고 noargs allargs 추가

public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_id;

    @Column(length = 50, unique = true, nullable = false)
    @Size(min = 3, max = 50)
    @NotBlank // notblank 쌤이 안 적으신거
    private String username;

    @Column(length = 20, nullable = false)
    @Size(min = 4, max = 20)
    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @Column(length = 13)
    @Size(max = 13, message = "전화번호는 최대 13자리까지 입력 가능합니다.")
    @Pattern(regexp = "^(010|011|016|017|018|019)-\\d{3,4}-\\d{4}$", message = "전화번호 형식이 올바르지 않습니다.(예 : 010-1234-5678)")
    private String phone;
}