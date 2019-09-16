package org.java.service.impl;

import org.java.dao.UserinfoMapper;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Map userLogin(String principal) {
        List<Map> list = userinfoMapper.userBylog(principal);
        if (list.isEmpty()){
            return null;//用户名不存在
        }else{
            return list.get(0);//返回对应的信息
        }
    }

    @Override
    public List<Map> userMenu(String roleid) {
        return userinfoMapper.userMenu(roleid);
    }
}
