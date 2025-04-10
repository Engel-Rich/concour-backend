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

@Table (name = "Matieres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matieres {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "bg_color", nullable = false)
    private String bgColor;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @Column(name = "is_active", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActiveStatus isActive;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cours> cours;

    @PostPersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
