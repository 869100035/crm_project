package com.hwua.realm;

import com.hwua.pojo.Permission;
import com.hwua.pojo.Role;
import com.hwua.pojo.User;
import com.hwua.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<String> rolesName = new ArrayList<>();
        for (Role role:user.getList()){
            rolesName.add(role.getRoleName());
            List<Permission> permissions = role.getList();
            List<String> permissionsNames = new ArrayList<>();
            for (Permission permission:permissions){
                permissionsNames.add(permission.getPermissionName());
            }
            authorizationInfo.addStringPermissions(permissionsNames);
        }
        authorizationInfo.addRoles(rolesName);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = null;
        try {
            user = userService.findUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user==null){
            throw new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),salt,super.getName());
        return authenticationInfo;
    }
}
