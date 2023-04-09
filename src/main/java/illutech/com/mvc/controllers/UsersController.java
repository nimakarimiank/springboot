package illutech.com.mvc.controllers;


import illutech.com.database.dao.entities.Users;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@ResponseBody
//Above together results in:
@RestController
public class UsersController {
//Tutorial
        //    GET http://localhost:8090/GetUser
        //path variable

        @GetMapping("/GetUser/{id}/{name}")
        public Users getName(@PathVariable int id,
                             @PathVariable String name)
        {
            return new Users(id,name);
        }

        //Get http://localhost:8090/GetUsersQueryParam?id=value&name=value
        //request param or query param
        @GetMapping("/GetUsersQueryParam")
        public Users GetUsersQueryParam(@RequestParam("id") int id,
                                        @RequestParam("name") String name){
            return new Users(id,name);
        }


        //    GET http://localhost:8090/GetAllUsers
        @GetMapping("/GetAllUsers")
        public List<Users> getAllUsers(){
            List<Users> users = new ArrayList<Users>();
            users.add(new Users(12,"mohsen"));
            users.add(new Users(156,"elahe"));
            users.add(new Users(19651,"shirin"));
            users.add(new Users(951623,"yalda"));
            return users;
        }



        //    POST http://localhost:8090/SetUser
        @PostMapping("/SetUser")
        public void setName(/*model??view??*/){
        }

// /End of Tutorial
}
