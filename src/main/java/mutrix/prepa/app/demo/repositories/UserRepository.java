package mutrix.prepa.app.demo.repositories;

import mutrix.prepa.app.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByFirebaseUid(String uid);

    Optional<Users> findByPhone(String phone);

    Optional<Users> findByEmailOrFirebaseUidOrPhone(String email, String firebaseUid, String phoneNumber);
//    Optional<Users> findByEmailAndFirebaseUidAndPhone(String email, String firebaseUid, String phoneNumber);
//    Optional<Users> findByEmailAndPhone(String email, String phoneNumber);
//    Optional<Users> findByFirebaseUidAndPhone(String firebaseUid, String phoneNumber);
//    Optional<Users> findByEmailAndFirebaseUid(String email, String firebaseUid);
}

