package jp.co.hundsun.config.shiroconfig;

import jp.co.hundsun.entity.User;
import jp.co.hundsun.service.UserMapperImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapperImpl userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object username = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(getRoles(username.toString()));
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if(token==null){
            return null;
        }
        String username = token.getUsername();
        User currentUser = userService.selectUserByUserCode(username);
        if (currentUser == null) {
            // user is not exist
            throw new UnknownAccountException();
        }

        //盐值，此处使用用户名作为盐
        ByteSource salt = ByteSource.Util.bytes(currentUser.getUserCode());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(currentUser.getUserCode(), currentUser.getUserPswd(), salt, getName());
        return authenticationInfo;
    }


    /**
     * 模拟查询数据库，获取用户角色列表
     *
     * @param username
     * @return
     */
    private Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("user");
        roles.add("admin");
        return roles;
    }

}
