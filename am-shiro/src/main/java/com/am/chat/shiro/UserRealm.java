package com.am.chat.shiro;

import com.am.chat.model.Permission;
import com.am.chat.model.Role;
import com.am.chat.model.User;
import com.am.chat.mybatis.mapper.PermissionMapper;
import com.am.chat.mybatis.mapper.RoleMapper;
import com.am.chat.mybatis.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangpeng12 on 2016/12/23.
 */
@Service("myRealm")
public class UserRealm extends AuthorizingRealm{
    @Autowired
    public UserMapper userDao;
    @Autowired
    public RoleMapper roleDao;
    @Autowired
    public PermissionMapper permissionDao;

    /**
     * 获取授权信息
     * PrincipalCollection是一个身份集合
     * 因为我们现在就一个Realm
     * 所以直接调用getPrimaryPrincipal得到之前传入的用户名即可
     * @param principalCollection
     * @return
     */
    @Override
    @Transactional
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库查是否有此对象
        User user = userDao.findByName(loginName);
        if (user != null) {
            SecurityUtils.getSubject().getSession().setAttribute("loginUer",user);
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            List<Role> roleList = roleDao.findByUserName(loginName);
           Set<String> roleStringList = new HashSet<>();
            for (Role role : roleList) {
                roleStringList.add(role.getRolename());
            }
            info.setRoles(roleStringList);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            for (Role role : roleList) {
                List<Permission> permissionList = permissionDao.getByRoleId(role.getId());
                List<String> permissionStringList = new ArrayList<>();
                for (Permission permission : permissionList) {
                    permissionStringList.add(permission.getPermessionString());
                }
                info.addStringPermissions(permissionStringList);
            }
            return info;
        }
        return null;
    }

    /**
     * 获取身份验证相关信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        User user = userDao.findByName(token.getUsername());
        if (user != null) {
            //若存在，将此用户存放到登录认证info中
            SecurityUtils.getSubject().getSession().setAttribute("loginUser",user);

            return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());

        }
        return null;
    }
}
