package serviceAuth.web;


import org.springframework.web.bind.annotation.*;
import serviceAuth.dtos.AppRoleDTO;
import serviceAuth.dtos.AppUserDTO;
import serviceAuth.services.RoleService;
import serviceAuth.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AppController {

    private final UserService userService;
    private final RoleService roleService;

    AppController(UserService userService, RoleService roleService){
        this.userService=userService;
        this.roleService=roleService;
    }

    @PostMapping
    public AppUserDTO addUser(@RequestBody AppUserDTO user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/roles")
    public List<AppRoleDTO> getRoles() {
        return this.roleService.getRoles();
    }
}
