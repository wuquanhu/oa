package org.java.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        Map map = userService.userLogin(principal);
        if(map==null){
            return  null;
        }
        String roleid = map.get("roleid").toString();
        List<Map> menus = userService.userMenu(roleid);
        map.put("menus",menus);
        String pwd= (String) map.get("pwd");
        String salt="kids";
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(map,pwd, ByteSource.Util.bytes(salt),"myRealm");

        return info;
    }
}
