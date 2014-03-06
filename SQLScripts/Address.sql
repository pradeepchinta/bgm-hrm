CREATE TABLE Address (
    id INT(10) NOT NULL AUTO_INCREMENT,
    line1 VARCHAR(100),
    line2 VARCHAR(100),
    line3 VARCHAR(100),
    city VARCHAR(40),
    state VARCHAR(40),
    country VARCHAR(40),
    postcode VARCHAR(10),
    isDeleted CHAR(1),
    PRIMARY KEY (id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;