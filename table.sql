-- 현재 권장하지는 않는 형태임 utf8 <- utf8mb3

-- create database myprojv1 default character set utf8 collate utf8_general_ci;

-- MSQL을 이용하여 작성함


SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `GRADE`;
DROP TABLE IF EXISTS `GROUP`;
DROP TABLE IF EXISTS `member`;
DROP TABLE IF EXISTS `RESTRICT`;
DROP TABLE IF EXISTS `BOARD_TYPE`;
DROP TABLE IF EXISTS `CATEGORY_TYPE`;
DROP TABLE IF EXISTS `BOARD_DETAIL`;
DROP TABLE IF EXISTS `COMMENTS`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `GRADE` (
    `grade_id` INTEGER auto_increment NOT NULL,
    `grade_type` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`grade_id`),
    UNIQUE (`grade_type`)
);

CREATE TABLE `GROUP` (
    `group_id` INTEGER auto_increment NOT NULL,
    `group_type` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`group_id`)
);

CREATE TABLE `member` (
    `member_id` INTEGER auto_increment NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `member_name` VARCHAR(100) NOT NULL,
    `Column1` INTEGER NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `party` VARCHAR(100) NOT NULL,
    `allias` VARCHAR(100) NOT NULL,
    `grade_id` INTEGER NOT NULL,
    `groupt_id` INTEGER NOT NULL,
    PRIMARY KEY (`member_id`, `email`)
);

CREATE TABLE `RESTRICT` (
    `restrict_id` INTEGER auto_increment NOT NULL,
    `member_id` INTEGER NOT NULL,
    PRIMARY KEY (`restrict_id`)
);

CREATE TABLE `BOARD_TYPE` (
    `board_tid` INTEGER auto_increment NOT NULL,
    `board_tname` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`board_tid`)
);

CREATE TABLE `CATEGORY_TYPE` (
    `category_tid` INTEGER auto_increment NOT NULL,
    `category_tname` VARCHAR(100) NOT NULL,
    `board_tid` INTEGER NOT NULL,
    `group_id` INTEGER NOT NULL,
    PRIMARY KEY (`category_tid`)
);

CREATE TABLE `BOARD_DETAIL` (
    `bd_id` INTEGER auto_increment NOT NULL,
    `title` VARCHAR(200) NOT NULL,
    `email` VARCHAR(300) NOT NULL,
    `contents` VARCHAR(1000) NOT NULL,
    `write_date` TIMESTAMP NOT NULL,
    `file_path` VARCHAR(200) NOT NULL,
    `board_tid` INTEGER NOT NULL,
    `category_tid` INTEGER NOT NULL,
    `member_id` INTEGER NOT NULL,
    PRIMARY KEY (`bd_id`)
);

CREATE TABLE `COMMENTS` (
    `com_id` INTEGER auto_increment NOT NULL,
    `comment` VARCHAR(200) NOT NULL,
    `write_date` TIMESTAMP NOT NULL,
    `bd_id` INTEGER NOT NULL,
    `comm_id` INTEGER NOT NULL,
     PRIMARY KEY (`com_id`)
);

ALTER TABLE `member` ADD FOREIGN KEY (`grade_id`) REFERENCES `GRADE`(`grade_id`);
ALTER TABLE `member` ADD FOREIGN KEY (`groupt_id`) REFERENCES `GROUP`(`group_id`);
ALTER TABLE `RESTRICT` ADD FOREIGN KEY (`member_id`) REFERENCES `member`(`member_id`);
ALTER TABLE `CATEGORY_TYPE` ADD FOREIGN KEY (`group_id`) REFERENCES `GROUP`(`group_id`);
ALTER TABLE `CATEGORY_TYPE` ADD FOREIGN KEY (`board_tid`) REFERENCES `BOARD_TYPE`(`board_tid`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`member_id`, `email`) REFERENCES `member`(`member_id`,`email`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`board_tid`) REFERENCES `BOARD_TYPE`(`board_tid`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`category_tid`) REFERENCES `CATEGORY_TYPE`(`category_tid`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`bd_id`) REFERENCES `BOARD_DETAIL`(`bd_id`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`comm_id`) REFERENCES `COMMENTS`(`com_id`);