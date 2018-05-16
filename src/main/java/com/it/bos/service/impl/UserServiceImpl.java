package com.it.bos.service.impl;/**
 * Created by Think on 2018/5/7.
 */

import com.it.bos.dao.TUserMapper;
import com.it.bos.pojo.TUser;
import com.it.bos.pojo.TUserExample;
import com.it.bos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户service
 * @Author Think
 * @Date 2018/5/7 4:13
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private TUserMapper tUserMapper;
    
    /**  
     * 
     * @Description 根据用户名密码查询用户
     * @date 2018/5/7 4:18  
     * @param [username, password]  
     * @return com.it.bos.pojo.T_user  
     */
    public TUser userLoginByUsernameAndPassword(String username, String password) {
        TUser tUser = tUserMapper.selectByUsernameAndPassword(username, password);
        if (tUser!=null){
            return tUser;
        }

        return null;
    }

    /**  
     * 
     * @Description 用户名异步校验
     * @date 2018/5/7 18:58  
     * @param [username]  
     * @return com.it.bos.pojo.TUser  
     */
    @Override
    public TUser findByUsername(String username) {
        TUserExample tUserExample = new TUserExample();
        TUserExample.Criteria criteria = tUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TUser> tUsers = tUserMapper.selectByExample(tUserExample);
        if(tUsers!=null && tUsers.size()>0){
            return tUsers.get(0);
        }
        return null;
    }
}
