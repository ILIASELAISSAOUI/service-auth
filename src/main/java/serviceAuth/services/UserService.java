package serviceAuth.services;

import serviceAuth.dtos.AppUserDTO;
import serviceAuth.entities.AppUser;

import java.util.List;

public interface UserService {

    public AppUserDTO createUser(AppUserDTO user) ;
    public List<AppUserDTO> getAllUsers() ;
//    public AppUserDTO updateUser(AppUser user) ;
//    public void deleteUser(Long id) ;
}
