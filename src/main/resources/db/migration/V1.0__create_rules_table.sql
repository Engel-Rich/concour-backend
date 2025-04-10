-- Mysql script to create the rules table
CREATE TABLE Rules (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rule_name VARCHAR(255) NOT NULL,
    rule_description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- insert user rules
INSERT INTO Rules (rule_name, rule_description) VALUES
('ROLE_USER', 'User role with basic access'),
('ROLE_ADMIN', 'Admin role with elevated privileges'),
('ROLE_SUPER_ADMIN', 'Super admin role with full access');
-- insert user rules