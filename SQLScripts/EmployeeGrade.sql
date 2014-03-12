CREATE TABLE EmployeeGrade (
    id INT(10) NOT NULL AUTO_INCREMENT,
    name VARCHAR(20),
    description VARCHAR(50),
    isDeleted CHAR(1),
    PRIMARY KEY (id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;