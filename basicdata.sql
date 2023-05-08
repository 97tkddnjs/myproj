INSERT INTO `GRADE`(`grade_type`) VALUES ('ADMIN');
INSERT INTO `GRADE`(`grade_type`) VALUES ('USER');

INSERT INTO `GROUP`(`group_type`) VALUES ('ALL');
INSERT INTO `GROUP`(`group_type`) VALUES ('BASIC');


-- 체크해보고 insert admin
 insert into MEMBER(
            `email`         ,
            `password`      ,
            `member_name`   ,
            `address`       ,
            `party`         ,
            `allias`        ,
            `grade_id`      ,
            `group_id`
        )
        values (
                   'test@a.com'         ,
                   '1234'      ,
                   'lsw'   ,
                   ''       ,
                   ''         ,
                   'lsw'        ,
                   1                ,
                   1
               )