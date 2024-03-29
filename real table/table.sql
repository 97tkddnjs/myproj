SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `GRADE_CODE`;
DROP TABLE IF EXISTS `CLASS_CODE`;
DROP TABLE IF EXISTS `CLASS_MEMBER`;
DROP TABLE IF EXISTS `RESTRICT_MEMBER`;
DROP TABLE IF EXISTS `BOARD_TYPE`;
DROP TABLE IF EXISTS `CATEGORY_TYPE`;
DROP TABLE IF EXISTS `BOARD_DETAIL`;
DROP TABLE IF EXISTS `COMMENTS`;
DROP TABLE IF EXISTS `BOARD_CATEGORY_TYPE`;
DROP TABLE IF EXISTS `MEMBER_CLASS`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `GRADE_CODE` (
    `GRADE_ID` INTEGER auto_increment NOT NULL,
    `GRADE_TYPE` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`GRADE_ID`),
    UNIQUE (`GRADE_TYPE`)
);

CREATE TABLE `CLASS_CODE` (
    `CLASS_ID` INTEGER auto_increment NOT NULL,
    `CLASS_NM` VARCHAR(100) NOT NULL,
    `CLASS_YMD` VARCHAR(6) NOT NULL,
    PRIMARY KEY (`CLASS_ID`)
);

CREATE TABLE `CLASS_MEMBER` (
    `MEMBER_ID` VARCHAR(10) NOT NULL,
    `EMAIL` VARCHAR(100) NOT NULL,
    `PASSWORD` VARCHAR(100) NOT NULL,
    `MEMBER_NM` VARCHAR(100) NOT NULL,
    `PHONE_NUM` VARCHAR(200),
    `PARTY` VARCHAR(100),
    `GRADE_ID` INTEGER NOT NULL,
    `REG_DT` DATE NOT NULL,
    PRIMARY KEY (`MEMBER_ID`),
    UNIQUE (`EMAIL`)
);

CREATE TABLE `RESTRICT_MEMBER` (
    `RESTRICT_ID` INTEGER auto_increment NOT NULL,
    `MEMBER_ID` VARCHAR(10) NOT NULL,
    `RESTRICT_SHOW` Boolean NOT NULL,
    PRIMARY KEY (`RESTRICT_ID`)
);

CREATE TABLE `BOARD_TYPE` (
    `BOARD_ID` INTEGER auto_increment NOT NULL,
    `BOARD_NM` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`BOARD_ID`)
);

CREATE TABLE `CATEGORY_TYPE` (
    `CATEGORY_ID` INTEGER auto_increment NOT NULL,
    `CATEGORY_NM` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`CATEGORY_ID`)
);

CREATE TABLE `BOARD_DETAIL` (
    `BD_ID` INTEGER auto_increment NOT NULL,
    `TITLE` VARCHAR(200) NOT NULL,
    `MEMBER_ID` VARCHAR(10) NOT NULL,
    `CONTENTS` VARCHAR(4000),
    `BD_DT` DATE NOT NULL,
    `FILE_PATH` VARCHAR(200),
    `BC_TYPE` INTEGER NOT NULL,
    `BD_SHOW` BOOLEAN NOT NULL,
    PRIMARY KEY (`BD_ID`)
);

CREATE TABLE `COMMENTS` (
    `COM_ID` INTEGER auto_increment NOT NULL,
    `COMMENTS` VARCHAR(200) NOT NULL,
    `COM_DT` DATE NOT NULL,
    `BD_ID` INTEGER NOT NULL,
    `COM_SHOW` BOOLEAN,
    `MEMBER_ID` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`COM_ID`)
);

CREATE TABLE `BOARD_CATEGORY_TYPE` (
    `BC_TYPE` INTEGER auto_increment NOT NULL,
    `CATEGORY_ID` INTEGER NOT NULL,
    `BOARD_ID` INTEGER NOT NULL,
    `CLASS_ID` INTEGER NOT NULL,
    `BC_SHOW` BOOLEAN,
    PRIMARY KEY (`BC_TYPE`)
);

CREATE TABLE `MEMBER_CLASS` (
    `MEM_CLS_ID` INTEGER auto_increment NOT NULL,
    `MEMBER_ID` VARCHAR(10) NOT NULL,
    `CLASS_ID` INTEGER NOT NULL,
    PRIMARY KEY (`MEM_CLS_ID`)
);

ALTER TABLE `CLASS_MEMBER` ADD FOREIGN KEY (`GRADE_ID`) REFERENCES `GRADE_CODE`(`GRADE_ID`);
ALTER TABLE `RESTRICT_MEMBER` ADD FOREIGN KEY (`MEMBER_ID`) REFERENCES `CLASS_MEMBER`(`MEMBER_ID`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`MEMBER_ID`) REFERENCES `CLASS_MEMBER`(`MEMBER_ID`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`BC_TYPE`) REFERENCES `BOARD_CATEGORY_TYPE`(`BC_TYPE`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`MEMBER_ID`) REFERENCES `CLASS_MEMBER`(`MEMBER_ID`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`BD_ID`) REFERENCES `BOARD_DETAIL`(`BD_ID`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`CLASS_ID`) REFERENCES `CLASS_CODE`(`CLASS_ID`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`BOARD_ID`) REFERENCES `BOARD_TYPE`(`BOARD_ID`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`CATEGORY_ID`) REFERENCES `CATEGORY_TYPE`(`CATEGORY_ID`);
ALTER TABLE `MEMBER_CLASS` ADD FOREIGN KEY (`CLASS_ID`) REFERENCES `CLASS_CODE`(`CLASS_ID`);
ALTER TABLE `MEMBER_CLASS` ADD FOREIGN KEY (`MEMBER_ID`) REFERENCES `CLASS_MEMBER`(`MEMBER_ID`);