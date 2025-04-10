package mutrix.prepa.app.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mutrix.prepa.app.demo.entities.Rules;
import mutrix.prepa.app.demo.entities.Users;
import mutrix.prepa.app.demo.formRequest.UserFormRequest;
import mutrix.prepa.app.demo.formRequest.Validators.FilesValidator;
import mutrix.prepa.app.demo.services.RulesService;
import mutrix.prepa.app.demo.services.UserServices;
import mutrix.prepa.app.demo.shared.AppResponse;

import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Users", description = "Users API")
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@NoArgsConstructor
public class UsersController {
   private  UserServices userServices;
   private   RulesService rulesService;

   @Operation(summary = "Register a new user")
   @PostMapping("/register")
   public ResponseEntity<?> register(@RequestBody(required = true) @Valid UserFormRequest request) {
       try {
           FilesValidator.validateImage(request.getPhoto());
           final Long ruleId = request.getRuleId();
           final Rules rules = rulesService.findById((Long) Objects.requireNonNullElse(ruleId,1));
           final Users users = request.getUser();
           users.setRole(rules);
           final Users saveResponse=  userServices.saveUser(users);
           return AppResponse.ok(saveResponse, 201);
       } catch (Exception e) {
           return AppResponse.trash(e.getMessage(), 400);
       }
   }

}


