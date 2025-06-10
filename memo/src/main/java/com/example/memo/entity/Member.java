package com.example.memo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더를 쓰려고 noargs allargs 추가

public class Member extends Base {

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