package mutrix.prepa.app.demo.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mutrix.prepa.app.demo.entities.Users;
import mutrix.prepa.app.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServices {

      private UserRepository userRepository;

   public Users loadUser(String firebaseUid, String email, String phone){
        if(firebaseUid != null && email != null && phone != null) {
            return userRepository.findByEmailOrFirebaseUidOrPhone(email, firebaseUid, phone).orElseThrow(()->new RuntimeException("User not found"));
        } else {
            if (firebaseUid != null) {
                return userRepository.findByFirebaseUid(firebaseUid).orElseThrow(() -> new RuntimeException("User not found"));
            }
            if (email != null) {
                return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
            }
            if (phone != null) {
                return userRepository.findByPhone(phone).orElseThrow(() -> new RuntimeException("User not found"));
            }
        }
        return null;
    }
    public  Users saveUser(Users user){
        return this.userRepository.save(user);
    }

    public Users findById(Long id){
        return this.userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

//    public Users updateUser(){}
}

