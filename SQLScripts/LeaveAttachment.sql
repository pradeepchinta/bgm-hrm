CREATE TABLE LeaveAttachment (
    id INT(10) NOT NULL AUTO_INCREMENT,
    leaveTransactionId INT(10),
    description VARCHAR(50),
    fileLocation VARCHAR(150),
    isDeleted CHAR(1),
    PRIMARY KEY (id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;