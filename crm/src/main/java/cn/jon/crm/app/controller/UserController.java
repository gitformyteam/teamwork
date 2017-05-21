package cn.jon.crm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.jon.crm.core.entity.User;
import cn.jon.crm.core.service.IUserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private IUserService userService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        User user = userService.findById(id);
        if (user == null)
        {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
    }
}
