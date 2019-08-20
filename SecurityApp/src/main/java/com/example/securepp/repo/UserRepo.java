
  package com.example.securepp.repo;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import com.example.securepp.model.User;
  
  public interface UserRepo extends JpaRepository<User, Long> {
  
  User findByUsername(String Username);
  
  
  }
  
  
  
 