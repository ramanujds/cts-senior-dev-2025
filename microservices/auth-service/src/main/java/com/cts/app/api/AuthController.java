package com.cts.app.api;

import com.cts.app.dto.AuthRequestDto;
import com.cts.app.dto.AuthResponseDto;
import com.cts.app.dto.UserDto;
import com.cts.app.model.UserEntity;
import com.cts.app.repository.UserRepository;
import com.cts.app.security.JwtUtil;
import com.cts.app.security.UserDetailsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:5173"})
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private UserRepository userRepo;




    public AuthController(UserRepository userRepo, PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }



    @PostMapping
    public AuthResponseDto createUser(@RequestBody UserDto userDto){
        UserEntity user = new UserEntity();
        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(userDto.role());
        var savedUser = userRepo.save(user);
        return new AuthResponseDto("User Created",savedUser.getUsername(),"");

    }

    @PostMapping("/authenticate")
    public AuthResponseDto authenticateUser(@RequestBody AuthRequestDto credentials, HttpServletRequest request){
        log.info(credentials.toString());
        UserDetails user = userDetailsService.loadUserByUsername(credentials.username());

        if(passwordEncoder.matches(credentials.password(),user.getPassword())){

           String token = jwtUtil.generateTokenFromUsername(user.getUsername());

            return new AuthResponseDto("Authenticated",user.getUsername(),token);
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid Credentials");

    }




    // Login


}
