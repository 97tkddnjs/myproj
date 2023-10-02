INSERT INTO `GRADE_CODE`(`grade_type`) VALUES ('ADMIN');
INSERT INTO `GRADE_CODE`(`grade_type`) VALUES ('USER');



-- 체크해보고 insert admin
 insert into MEMBER(

            `member_id`     ,
            `email`         ,
            `password`      ,
            `member_nm`   ,
            `phone_num`       ,
            `party`         ,
            `grade_id`     ,
            `reg_dt`
        )
        values (
                    `admin` ,
                   'test@a.com'         ,
                   '1234'      ,
                   'lsw'   ,
                   '010'       ,
                   'admin'         ,
                   1                ,
                   sysdate()
               );
insert into `board_type`(`board_nm`) values('공지사항');