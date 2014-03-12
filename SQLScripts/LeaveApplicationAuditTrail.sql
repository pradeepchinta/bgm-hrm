CREATE TABLE LeaveApplicationAuditTrail (
    id INT(10) NOT NULL AUTO_INCREMENT,
    leaveTransactionId INT(10),
    actionDate DATE,
    description VARCHAR(50),
    actorEmployeeId INT(10),
    isDeleted CHAR(1),
    PRIMARY KEY (id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;