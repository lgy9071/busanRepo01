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

    //READ - 특정 조건으로 사용자 조회
    public List<User> findUsersByAge(Integer minAge){
        try{
            TypedQuery<User> query = em.createQuery(
                    "SELECT u FROM User u WHERE u.age >= :minAge", User.class //:minAge = String? 방식
            );

            query.setParameter("minAge", minAge);

            List<User> users = query.getResultList();
            System.out.println(minAge + "세 이상의 사용자 수 : " + users.size());
            return users;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //DELETE - 사용자 삭제
    public void deleteUser(Long id){
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 시작 준비

        try{
            tx.begin(); // 트랜잭션 시작

            User user = em.find(User.class, id); // ID로 사용자 조회
            if(user != null){
                em.remove(user);      // 엔티티 삭제
                tx.commit();          // 성공 시 커밋
                System.out.println("사용자 삭제 완료 : " + user);
            }else{
                tx.rollback();        // 찾지 못하면 롤백
                System.out.println("삭제할 사용자를 찾을 수 없습니다!");
            }

        }catch (Exception e){
            tx.rollback();            // 예외 발생 시 롤백
            e.printStackTrace();
        }
    }

    //UPDATE - 준영속 엔티티 병합
//    public void mergeUser(){
//        EntityTransaction tx = em.getTransaction();
//        try{
//            tx.begin();
//            User user = new User("test-user", "test@green.com", 100); //dto > entity
//            em.persist(user); //엔티티를 영속 상태로 만들어 줌.
//            em.clear();
//            System.out.println(em.contains((user))); // false
//            User managedUser = em.merge(user);
//            System.out.println(em.contains((managedUser))); //true
//
//            tx.commit();
//            System.out.println("Merged.." + managedUser);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            tx.rollback();
//        }
//    }

    public void mergeUser(){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();

            User user  = em.find(User.class, 1L);
            System.out.println(1 + ") " + em.contains(user)); //ture
            em.clear(); //엔티티를 포함한 모든 정보 clear > 영속이 활성화 안되게 '준영속 상태'

            System.out.println(2 + ") " + em.contains(user)); //false
            User managedUser = em.merge(user);
            System.out.println(3 + ") " + em.contains(managedUser)); //ture 준영속 상태에 있다가 다시 영속 상태가 된 것

            tx.commit();
            System.out.println("Merged.." + managedUser);
            em.detach(managedUser);

            System.out.println(4 + ") " + em.contains(managedUser)); //false

        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
    }



}
