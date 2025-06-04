package com.example.rest01.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.example.rest01.dto.MemberDto;

@Repository
public class MemberRepository {

    private List<MemberDto> list = new ArrayList<>();

    public MemberRepository() {
        MemberDto member1 = new MemberDto();
        member1.setName("Ann");
        member1.setEmail("Ann@green.com");
        member1.setOrganization("GREEN");

        MemberDto member2 = new MemberDto();
        member2.setName("Bnn");
        member2.setEmail("Bnn@green.com");
        member2.setOrganization("GREEN");

        MemberDto member3 = new MemberDto();
        member3.setName("Cnn");
        member3.setEmail("Cnn@green.com");
        member3.setOrganization("GREEN");

        list.add(member1);
        list.add(member2);
        list.add(member3);
    }

    public List<MemberDto> getList() {
        return new ArrayList<>(list);
    }

    public boolean addMember(MemberDto member) {
        return list.add(member);
    }

    public List<MemberDto> findAll() {
        return new ArrayList<>(list);
    }

    public Optional<MemberDto> findByName(String name) {
        return list.stream()
                   .filter(m -> m.getName().equalsIgnoreCase(name))
                   .findFirst();
    }

    public boolean existsByEmail(String email) {
        return list.stream()
                   .anyMatch(m -> m.getEmail().equalsIgnoreCase(email));
    }

}