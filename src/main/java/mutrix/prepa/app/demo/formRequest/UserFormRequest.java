package mutrix.prepa.app.demo.formRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import mutrix.prepa.app.demo.entities.Rules;
import mutrix.prepa.app.demo.entities.Users;
import mutrix.prepa.app.demo.formRequest.Validators.ExistDatabase;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFormRequest {

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotBlank(message = "L'adresse email est obligatoire")
    @Email(message = "Adresse email invalide")
    private String email;

    @NotBlank(message = "Le mot de passe est obligatoire")
    private String password;

    @NotBlank(message = "Le code firebase est obligatoire")
    private String firebaseUid;

    @NotBlank(message = "Le numero de telephone est obligatoire")
    private String phone;

    private MultipartFile photo;

    @ExistDatabase(entity = Rules.class, message = "Aucun role trouve avec cet id", required = false)
    private Long ruleId;

    public Users getUser(){
        return new Users(
                name,
                firebaseUid,
                email,
                password,
                phone
        );
    }


}
