package cn.jon.crm.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jon.crm.core.dao.IUserDao;
import cn.jon.crm.core.entity.User;
import cn.jon.crm.core.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;

	public List<User> query(Map<String, Object> param) {
		return userDao.query(param);
	}

	public User findById(long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		List<User> users = this.query(param);
		return users.size() > 0 ? users.get(0) : null;
	}

	public User saveUser(User user) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", user.getUname());
		param.put("address", user.getAddress());
		userDao.saveUser(param);
		user.setId((Long) param.get("id"));
		return user;
	}

	public void deleteUser(long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		userDao.deleteUser(param);
	}

	public User updateUser(User user) {
		userDao.updateUser(user);
		return user;
	}
}
