package serviceAuth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class AppUserDTO {
    private long id;
    private String username;
    private String password;
    private List<AppRoleDTO> roles;
}
