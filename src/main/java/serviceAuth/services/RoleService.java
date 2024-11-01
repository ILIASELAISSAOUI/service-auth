package serviceAuth.services;

import serviceAuth.dtos.AppRoleDTO;
import serviceAuth.entities.AppRole;

import java.util.List;

public interface RoleService {
    public List<AppRoleDTO> getRoles();
}
