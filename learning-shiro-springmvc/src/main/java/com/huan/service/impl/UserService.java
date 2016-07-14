package com.huan.service.impl;

import com.huan.mapper.TUserMapper;
import com.huan.model.TRole;
import com.huan.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ptmind on 2016/7/15.
 */
@Service
public class UserService {

    @Autowired
    private TUserMapper tUserMapper;


    public TUser findByName(String loginName) {
        return tUserMapper.findByName(loginName);
    }

    public Set<String> getRolesName() {
        List<TRole> roles = getRoleList();
        Set<String> set = new HashSet<String>();
        for (TRole role : roles) {
            set.add(role.getRolename());
        }
        return set;
    }

    public List<TRole> getRoleList() {

        return roleList;
    }

}
