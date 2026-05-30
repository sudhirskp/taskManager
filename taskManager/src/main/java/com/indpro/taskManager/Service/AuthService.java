package com.indpro.taskManager.Service;


import com.indpro.taskManager.DTO.Login;
import com.indpro.taskManager.DTO.Register;
import com.indpro.taskManager.Entity.User;
import com.indpro.taskManager.Repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepository;

    public String register(Register request) {

        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            return "Email already exists";
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "Registered Successfully";
    }

    public User login(Login request){

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid Password");
        }

        return user;
    }
}
