package com.socialmedia.pub.entity;

import com.socialmedia.pub.exception.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.socialmedia.pub.entity.Permission.*;
import static com.socialmedia.pub.exception.StatusCodes.ENTITY_NOT_FOUND;

@Slf4j
@RequiredArgsConstructor
public enum RoleEnum {
    USER(
            Set.of(
                    USER_REMOVE,
                    USER_CREATE,
                    USER_LIKE,
                    USER_UPDATE
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public static RoleEnum getRoleByName(String roleName) {
        RoleEnum role;
        try {
            log.info("Checking if such role exists, role = {}", roleName);
            role = RoleEnum.valueOf(roleName.toUpperCase());
            log.info("Yep, there is role called {}", role);
        } catch (Exception e) {
            log.error("No such role with name {} found", roleName);
            throw new EntityNotFoundException(ENTITY_NOT_FOUND.name(), "Role is not found, requested role = " + roleName);
        }
        return role;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
