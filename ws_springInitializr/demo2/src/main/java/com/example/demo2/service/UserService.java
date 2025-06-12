package com.example.demo2.service;

import com.example.demo2.entity.User;
import jakarta.persistence.*;

import java.util.List;


public class UserService {

    private EntityManagerFactory emf;

    private EntityManager em;

    public UserService(){
        emf = Persistence.createEntityManagerFactory("myPU"); //persistence 영속성 contest
        em = emf.createEntityManager();
    }

    // CREATE - 새로운 자료 저장
    public void createUser(String username, String email, Integer age){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin(); //트랜잭션 시작
            User user = new User(username, email, age);
            em.persist(user); // entity를 영속 상태로 만들어 줌.
            tx.commit(); //트랜잭션 끝

            System.out.println("사용자 생성 성공 : " + user);
        }catch(Exception e){
            tx.rollback(); //트랜잭션 > all or nothing
            System.out.println("사용자 생성 실패 : " + e.getMessage());
        }
    }

    //READ - 사용자 조회(PK 사용)
    public User findUserById(Long id){
        try{
            User user = em.find(User.class, id); //id를 넣어주면 user entity의 객체가 나온다!

            if(user != null){
                System.out.println("Success find user : " + user);
            }else{
                System.out.println("ID " + id + "is not exist!");
            }
            return user;
        }catch(Exception e){
            System.out.println("Fail find user : " + e.getMessage());
            return null;
        }
    }

    //READ - 모든 사용자 조회
    public List<User> findAllUsers(){
        try{
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            List<User> users = query.getResultList();
            System.out.println("All Users cout : " + users.size());
            return users;

        }catch (Exception e){
            System.out.println("fail...." + e.getMessage());
            return null;
        }
    }

    //UPDATE - 사용자 정보 수정
    public void updateUser(Long id, String newEmail){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            User user = em.find(User.class, id);

            if(user != null){
                user.setEmail(newEmail);

                tx.commit();
                System.out.println("Success : " + user);
            }else{
                tx.rollback();
                System.out.println("None!!");
            }
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }

}
