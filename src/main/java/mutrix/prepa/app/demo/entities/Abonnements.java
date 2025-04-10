package mutrix.prepa.app.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mutrix.prepa.app.demo.enums.ActiveStatus;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Abonnements")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Abonnements {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_debut", nullable = false, unique = true)
    private LocalDateTime startDate;

    @Column(name = "date_fin", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "date_activation", nullable = false)
    private LocalDateTime activationDate;

     @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "codes_count", nullable = false)
    private Integer codesCount;

    @Column (name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    ActiveStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @OneToMany(mappedBy = "abonnement", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Codes> codes;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Sessions sessions;

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
