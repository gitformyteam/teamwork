package cn.jon.crm.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import cn.jon.crm.core.entity.User;


public interface IUserService {
	 public List<User> query(Map<String, Object> param);

	    @Cacheable(value = "userCache", key = "#id")
	    public User findById(long id);

	    @CachePut(value = "userCache", key="#result.id")
	    public User saveUser(User user);

	    //ע��key������Ҫһ�£���Ҫһ����long��һ��object or string
	    @CacheEvict(value = "userCache", key = "#id")
	    public void deleteUser(long id);

	    public User updateUser(User user);
}
