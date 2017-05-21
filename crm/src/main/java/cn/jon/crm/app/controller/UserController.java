package cn.jon.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.jon.crm.core.entity.User;
import cn.jon.crm.core.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
    public User getUserById(@PathVariable Long id)
    {
        User user = userService.findById(id);
        return user;
    }
}
