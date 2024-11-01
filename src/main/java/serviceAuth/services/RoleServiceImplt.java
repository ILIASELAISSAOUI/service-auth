package serviceAuth.services;

import org.springframework.stereotype.Service;
import serviceAuth.dtos.AppRoleDTO;
import serviceAuth.entities.AppRole;
import serviceAuth.mapper.Mapper;
import serviceAuth.repos.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImplt implements RoleService {

    private final RoleRepository roleRepository;
    private Mapper mapper;

    public RoleServiceImplt(RoleRepository roleRepository, Mapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AppRoleDTO> getRoles() {
        List<AppRole> roles= roleRepository.findAll();
        List<AppRoleDTO> roleDTOs= roles.stream().map(role->mapper.fromAppRole(role)).collect(Collectors.toList());
        return roleDTOs;
    }
}
