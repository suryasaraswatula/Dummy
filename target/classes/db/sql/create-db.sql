--DROP TABLE users IF EXISTS;

CREATE TABLE users (
  id         INTEGER PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50)
);

create table company(
	companyId INTEGER PRIMARY KEY,
	companyName VARCHAR(50),
	companyLocation VARCHAR(50),
	companyShares INTEGER,
	companySharePrice INTEGER
)
