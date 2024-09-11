package com.accenture.api.rest.user;

import com.accenture.http.response.HttpResponse;
import com.accenture.http.service.HttpService;
import com.accenture.models.User;
import com.accenture.contrats.persistance.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<HttpResponse> findAllPaginate(
            @RequestParam(name = "search") String search,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size
    ){
        return HttpService.responseSuccess(Map.of("data", userService.userPaginate(search, page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpResponse> findById(@PathVariable(name = "id") Long id){
        if (userService.findById(id) == null){
            return HttpService.responseNotFound();
        }
        return HttpService.responseSuccess(Map.of("data", userService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<HttpResponse> create(@RequestBody User user){
        userService.save(user);
        return HttpService.responseOkSuccess();
    }
}
