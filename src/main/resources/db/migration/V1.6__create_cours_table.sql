-- Create Cours table

CREATE TABLE Cours (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    video_url VARCHAR(255),
    bg_color VARCHAR(7) DEFAULT '#FFFFFF',
    photo_url VARCHAR(255),
    is_active ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
    matiere_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (matiere_id) REFERENCES Matieres(id) ON DELETE CASCADE ON UPDATE CASCADE
);