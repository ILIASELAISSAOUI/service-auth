package serviceAuth.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import serviceAuth.dtos.AppRoleDTO;
import serviceAuth.dtos.AppUserDTO;
import serviceAuth.entities.AppRole;
import serviceAuth.entities.AppUser;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Mapper {

    public AppRoleDTO fromAppRole(AppRole appRole){
        AppRoleDTO appRoleDTO = new AppRoleDTO();
        BeanUtils.copyProperties(appRole,appRoleDTO);
        return appRoleDTO;
    }
    public AppRole fromAppRoleDTO(AppRoleDTO appRoleDTO){
        AppRole appRole = new AppRole();
        BeanUtils.copyProperties(appRoleDTO,appRole);
        return appRole;
    }
    public AppUserDTO fromAppUser(AppUser appUser){
        AppUserDTO appUserDTO = new AppUserDTO();
        BeanUtils.copyProperties(appUser,appUserDTO);
        List<AppRoleDTO>roles=appUser.getRoles().stream().map(role->fromAppRole(role)).collect(Collectors.toList());
        appUserDTO.setRoles(roles);
        return appUserDTO;
    }

    public AppUser fromAppUserDTO(AppUserDTO appUserDTO){
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDTO,appUser,"id");
        List<AppRole>roles=appUserDTO.getRoles().stream().map(role->fromAppRoleDTO(role)).collect(Collectors.toList());
        appUser.setRoles(roles);
        return appUser;
    }
}
