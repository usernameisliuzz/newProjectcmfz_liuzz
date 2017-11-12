package com.baizhi.liuzz.realm;

import com.baizhi.liuzz.dao.RoleDAO;
import com.baizhi.liuzz.entity.User;
import com.baizhi.liuzz.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public class AuthenByAccountRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleDAO roleDAO;
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获得用户的账号信息
        String account = (String) Token.getPrincipal();
        User user = userService.landing(account);
        if(user == null){
            return null;
        }else {
            request.getSession().setAttribute("user",user);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()), "AuthenByAccountRealm");
            return info;
        }
    }

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获得账号
        String  account = (String) principalCollection.getPrimaryPrincipal();
        //通过账户获得角色信息
        List<String> roles = roleDAO.selectRole(account);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        return info;
    }
}
