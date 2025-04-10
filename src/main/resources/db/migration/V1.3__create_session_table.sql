
-- // create concour session table

CREATE TABLE Sessions (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        description TEXT,
        start_date DATETIME NOT NULL,
        end_date DATETIME NOT NULL,
        status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
        photo_url VARCHAR(255),
        price DECIMAL(10, 2) NOT NULL,
        concours_id BIGINT NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        FOREIGN KEY (concours_id) REFERENCES Concours(id) ON DELETE CASCADE ON UPDATE CASCADE
);