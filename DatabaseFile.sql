CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    rg VARCHAR(9) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR(200) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    telefone VARCHAR(11) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    rg VARCHAR(9) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR(200) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    telefone VARCHAR(11) NOT NULL,
    job_title ENUM('SELLER','HR','MECHANIC','MANAGER'),
    access_level INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE vehicle (
    vehicle_id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(60) NOT NULL,
    color VARCHAR(40) NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    year_of_production YEAR NOT NULL,
    mileage INT NOT NULL,
    status ENUM('AVAILABLE','RENTED','MAINTENANCE')
) ENGINE=InnoDB;

CREATE TABLE contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    date_of_collect DATE NOT NULL,
    date_of_return DATE,
    rental_value DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_contract_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer(customer_id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_contract_employee
        FOREIGN KEY (employee_id)
        REFERENCES employee(employee_id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_contract_vehicle
        FOREIGN KEY (vehicle_id)
        REFERENCES vehicle(vehicle_id)
        ON DELETE RESTRICT
) ENGINE=InnoDB;


INSERT INTO customer
(name, cpf, rg, date_of_birth, address, cep, email, telefone)
VALUES
('Lucas Andrade', '12345678901', '123456789', '1995-03-12', 'Rua das Flores, 120', '44380000', 'lucas.andrade@email.com', '71991234567'),

('Mariana Souza', '23456789012', '234567890', '1992-07-25', 'Avenida Central, 455', '44380111', 'mariana.souza@email.com', '71992345678'),

('Carlos Lima', '34567890123', '345678901', '1988-11-02', 'Rua Bela Vista, 89', '44380222', 'carlos.lima@email.com', '71993456789'),

('Fernanda Alves', '45678901234', '456789012', '1999-01-18', 'Travessa do Sol, 33', '44380333', 'fernanda.alves@email.com', '71994567890'),

('Rafael Mendes', '56789012345', '567890123', '1990-09-09', 'Rua Primavera, 200', '44380444', 'rafael.mendes@email.com', '71995678901'),

('Juliana Rocha', '67890123456', '678901234', '1996-05-30', 'Rua Horizonte Azul, 77', '44380555', 'juliana.rocha@email.com', '71996789012'),

('Thiago Martins', '78901234567', '789012345', '1985-12-14', 'Avenida Brasil, 1500', '44380666', 'thiago.martins@email.com', '71997890123'),

('Patricia Gomes', '89012345678', '890123456', '1993-08-21', 'Rua das Acacias, 410', '44380777', 'patricia.gomes@email.com', '71998901234'),

('Eduardo Santana', '90123456789', '901234567', '1987-04-05', 'Rua do Comercio, 56', '44380888', 'eduardo.santana@email.com', '71999012345'),

('Camila Nunes', '11223344556', '112233445', '1998-10-27', 'Rua Nova Esperanca, 98', '44380999', 'camila.nunes@email.com', '71990123456');




INSERT INTO employee
(name, cpf, rg, date_of_birth, address, cep, email, telefone, job_title, access_level)
VALUES
('Joao Silva','11111111111','111111111','1980-01-10','Rua 1, 10','44381000','joao@email.com','71991111111','MANAGER',3),
('Ana Costa','22222222222','222222222','1985-02-15','Rua 2, 20','44381111','ana@email.com','71992222222','HR',2),
('Bruno Lima','33333333333','333333333','1990-03-20','Rua 3, 30','44381222','bruno@email.com','71993333333','SELLER',1),
('Carla Mendes','44444444444','444444444','1992-04-25','Rua 4, 40','44381333','carla@email.com','71994444444','SELLER',1),
('Diego Rocha','55555555555','555555555','1988-05-18','Rua 5, 50','44381444','diego@email.com','71995555555','MECHANIC',1),
('Elaine Souza','66666666666','666666666','1991-06-22','Rua 6, 60','44381555','elaine@email.com','71996666666','SELLER',1),
('Fabio Alves','77777777777','777777777','1983-07-30','Rua 7, 70','44381666','fabio@email.com','71997777777','MECHANIC',1),
('Gabriela Santos','88888888888','888888888','1994-08-11','Rua 8, 80','44381777','gabriela@email.com','71998888888','HR',2),
('Henrique Martins','99999999999','999999999','1986-09-09','Rua 9, 90','44381888','henrique@email.com','71999999999','SELLER',1),
('Isabela Gomes','10101010101','101010101','1993-10-14','Rua 10, 100','44381999','isabela@email.com','71990000000','SELLER',1);



INSERT INTO vehicle
(model, color, value, year_of_production, mileage, status)
VALUES
('Onix','Preto',55000.00,2020,45000,'RENTED'),
('HB20','Branco',60000.00,2021,30000,'RENTED'),
('Corolla','Prata',120000.00,2019,60000,'AVAILABLE'),
('Civic','Preto',110000.00,2018,70000,'AVAILABLE'),
('Argo','Vermelho',58000.00,2022,20000,'RENTED'),
('Gol','Cinza',45000.00,2017,80000,'AVAILABLE'),
('Tracker','Azul',130000.00,2023,10000,'RENTED'),
('Compass','Preto',150000.00,2022,15000,'AVAILABLE'),
('Kwid','Branco',40000.00,2021,35000,'RENTED'),
('Renegade','Verde',140000.00,2020,40000,'AVAILABLE');




INSERT INTO contracts
(customer_id, employee_id, vehicle_id, date_of_collect, date_of_return, rental_value)
VALUES
(1,3,1,'2026-02-01','2026-02-10',1500.00),
(2,4,2,'2026-02-05','2026-02-12',1600.00),
(3,6,5,'2026-02-08','2026-02-15',1400.00),
(4,9,7,'2026-02-10','2026-02-18',2200.00),
(5,3,9,'2026-02-12','2026-02-20',1200.00),
(6,4,1,'2026-03-01','2026-03-07',1300.00),
(7,6,2,'2026-03-05','2026-03-11',1500.00),
(8,9,5,'2026-03-10','2026-03-18',1700.00),
(9,3,7,'2026-03-12','2026-03-20',2100.00),
(10,4,9,'2026-03-15','2026-03-22',1250.00);

CREATE VIEW vw_contracts_details AS
SELECT
    c.contract_id,
    cust.name AS customer_name,
    emp.name AS employee_name,
    v.model AS vehicle_name,
    c.date_of_collect
FROM contracts c
JOIN customer cust ON c.customer_id = cust.customer_id
JOIN employee emp ON c.employee_id = emp.employee_id
JOIN vehicle v ON c.vehicle_id = v.vehicle_id;