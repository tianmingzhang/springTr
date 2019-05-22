package com.smart.testScan;

import com.smart.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JsonExercise {

    @RequestMapping(value = "/handle41")
    public ResponseEntity<User> handle41( HttpEntity<User> body) {
        System.out.println(body);
        User user = body.getBody();
        user.setPassword("11111");
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/handle11")
    public String handle11(
            @RequestParam(value = "userName", required = false) String userName) {
        System.out.println(userName);
        return "success";
    }
}
