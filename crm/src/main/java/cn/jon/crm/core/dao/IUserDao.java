package cn.jon.crm.core.dao;

import java.util.List;
import java.util.Map;

import cn.jon.crm.core.entity.User;


public interface IUserDao {
    public List<User> query(Map<String, Object> param);

    public int saveUser(Map<String, Object> param);

    public void deleteUser(Map<String, Object> param);

    public int updateUser(User user);
}
