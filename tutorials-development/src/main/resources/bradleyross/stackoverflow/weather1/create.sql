-- In MySQL 
-- show full columns from weather
-- show index from weather
-- will show the details of the weather table
--
CREATE TABLE IF NOT EXISTS WEATHER (
ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
R_TIME TIME NOT NULL COMMENT 'Time of day for measurement',
R_DATE DATE NOT NULL COMMENT 'Date of measurement',
R_VALUE MEDIUMINT(9) NOT NULL COMMENT 'Temperature',
R_LABEL CHAR(3),
R_LOCATION CHAR(128), 
INDEX I1  (R_DATE, R_TIME) 
)
