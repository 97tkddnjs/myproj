SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `GRADE`;
DROP TABLE IF EXISTS `GROUP`;
DROP TABLE IF EXISTS `member`;
DROP TABLE IF EXISTS `RESTRICT`;
DROP TABLE IF EXISTS `BOARD_TYPE`;
DROP TABLE IF EXISTS `CATEGORY_TYPE`;
DROP TABLE IF EXISTS `BOARD_DETAIL`;
DROP TABLE IF EXISTS `COMMENTS`;
DROP TABLE IF EXISTS `BOARD_CATEGORY_TYPE`;
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
    `address` VARCHAR(200),
    `party` VARCHAR(100),
    `allias` VARCHAR(100) NOT NULL,
    `grade_id` INTEGER NOT NULL,
    `group_id` INTEGER NOT NULL,
    PRIMARY KEY (`member_id`),
    UNIQUE (`email`, `allias`)
);

CREATE TABLE `RESTRICT` (
    `restrict_id` auto_increment INTEGER NOT NULL,
    `member_id` INTEGER NOT NULL,
    `email` INTEGER NOT NULL,
    PRIMARY KEY (`restrict_id`)
);

CREATE TABLE `BOARD_TYPE` (
    `board_tid` auto_increment INTEGER NOT NULL,
    `board_tname` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`board_tid`)
);

CREATE TABLE `CATEGORY_TYPE` (
    `category_tid` auto_increment INTEGER NOT NULL,
    `category_tname` VARCHAR(100) NOT NULL,
    `board_tid` INTEGER NOT NULL,
    `group_id` INTEGER NOT NULL,
    PRIMARY KEY (`category_tid`)
);

CREATE TABLE `BOARD_DETAIL` (
    `bd_id` INTEGER auto_increment NOT NULL,
    `title` VARCHAR(200) NOT NULL,
    `email` VARCHAR(300) NOT NULL,
    `contents` VARCHAR(1000),
    `write_date` TIMESTAMP NOT NULL,
    `file_path` VARCHAR(200),
    `PK_BC_TYPE` INTEGER NOT NULL,
    `category_tid` INTEGER NOT NULL,
    `member_id` INTEGER NOT NULL,
    `BD_SHOW` BOOLEAN,
    PRIMARY KEY (`bd_id`)
);

CREATE TABLE `COMMENTS` (
    `com_id` INTEGER auto_increment NOT NULL,
    `comment` VARCHAR(200) NOT NULL,
    `write_date` TIMESTAMP NOT NULL,
    `bd_id` INTEGER NOT NULL,
    `comm_id` INTEGER NOT NULL,
    `COM_SHOW` BOOLEAN,
    `member_id` INTEGER NOT NULL,
    `email` INTEGER NOT NULL,
    `COMM_SHOW` INTEGER NOT NULL,
    PRIMARY KEY (`com_id`)
);

CREATE TABLE `BOARD_CATEGORY_TYPE` (
    `PK_BC_TYPE` auto_increment INTEGER NOT NULL,
    `cartegory_tid` INTEGER NOT NULL,
    `board_tid` INTEGER NOT NULL,
    `group_id` INTEGER NOT NULL,
    `BC_SHOW` BOOLEAN,
    PRIMARY KEY (`PK_BC_TYPE`)
);

ALTER TABLE `member` ADD FOREIGN KEY (`grade_id`) REFERENCES `GRADE`(`grade_id`);
ALTER TABLE `member` ADD FOREIGN KEY (`group_id`) REFERENCES `GROUP`(`group_id`);
ALTER TABLE `RESTRICT` ADD FOREIGN KEY (`member_id`) REFERENCES `member`(`member_id`);
ALTER TABLE `RESTRICT` ADD FOREIGN KEY (`email`) REFERENCES `member`(`email`);
ALTER TABLE `CATEGORY_TYPE` ADD FOREIGN KEY (`group_id`) REFERENCES `GROUP`(`group_id`);
ALTER TABLE `CATEGORY_TYPE` ADD FOREIGN KEY (`board_tid`) REFERENCES `BOARD_TYPE`(`board_tid`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`member_id`) REFERENCES `member`(`member_id`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`category_tid`) REFERENCES `CATEGORY_TYPE`(`category_tid`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`PK_BC_TYPE`) REFERENCES `BOARD_CATEGORY_TYPE`(`PK_BC_TYPE`);
ALTER TABLE `BOARD_DETAIL` ADD FOREIGN KEY (`email`) REFERENCES `member`(`email`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`bd_id`) REFERENCES `BOARD_DETAIL`(`bd_id`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`member_id`) REFERENCES `member`(`member_id`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`comm_id`) REFERENCES `COMMENTS`(`com_id`);
ALTER TABLE `COMMENTS` ADD FOREIGN KEY (`email`) REFERENCES `member`(`email`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`group_id`) REFERENCES `GROUP`(`group_id`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`board_tid`) REFERENCES `BOARD_TYPE`(`board_tid`);
ALTER TABLE `BOARD_CATEGORY_TYPE` ADD FOREIGN KEY (`cartegory_tid`) REFERENCES `CATEGORY_TYPE`(`category_tid`);