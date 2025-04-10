package mutrix.prepa.app.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Users {

    public Users(String name, String firebaseUid, String email, String password, String phone) {
        this.name = name;
        this.firebaseUid = firebaseUid;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

     @Column(name = "firebase_uid", nullable = false)
        private String firebaseUid;

    @Column(name = "email", nullable = false, unique = true)
    private  String email;

    @Column(name ="phone", nullable = false)
    private  String phone;

    @Column(name ="password", nullable = false)
    private  String password;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "rule_id", nullable = false)
    private Rules role;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Abonnements> abonnements;

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
