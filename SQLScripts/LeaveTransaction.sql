CREATE TABLE LeaveTransaction (
    id INT(10) NOT NULL AUTO_INCREMENT,
    applicationDate DATE,
    startDate DATE,
    endDate DATE,
    numberOfHours INT(3),
    numberOfDays INT(3),
    reason VARCHAR(100),
    leaveTypeId INT(10),
    employeeId INT(10),
    isApproved CHAR(1),
    isCancelled CHAR(1),
    isDeleted CHAR(1),
    PRIMARY KEY (id)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;