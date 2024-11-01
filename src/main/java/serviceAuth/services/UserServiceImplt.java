package serviceAuth.services;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import serviceAuth.dtos.AppUserDTO;
import serviceAuth.entities.AppRole;
import serviceAuth.entities.AppUser;
import serviceAuth.mapper.Mapper;
import serviceAuth.repos.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplt implements UserService {

    private Mapper mapper;
    private UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public UserServiceImplt(UserRepository userRepository, Mapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public AppUserDTO createUser(AppUserDTO user) {
        AppUser newUser = mapper.fromAppUserDTO(user);
        System.out.println(passwordEncoder().encode(user.getPassword()));
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        List<AppRole> roles =user.getRoles().stream()
                        .map(role->mapper.fromAppRoleDTO(role))
                        .collect(Collectors.toList());
        newUser.setRoles(roles);
        userRepository.save(newUser);
        return mapper.fromAppUser(newUser);
    }


    public List<AppUserDTO> getAllUsers() {
        List<AppUser> users = userRepository.findAll();
        List<AppUserDTO> userDTOS=users.stream()
                        .map(user->mapper.fromAppUser(user))
                        .collect(Collectors.toList());
        return userDTOS;
    }

//    public AppUserDTO updateUser(AppUser user) {
//        return userRepository.save(user);
//    }

//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
}