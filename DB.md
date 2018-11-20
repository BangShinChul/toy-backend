## DB 구조도

<br> 

```
> use bangshinchul # database 선택

> desc userinfo; # userinfo 테이블 구조 확인

+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| user_id       | varchar(16) | NO   | PRI | NULL    |       |
| user_password | varchar(32) | NO   |     | NULL    |       |
| user_email    | varchar(32) | NO   |     | NULL    |       |
| user_name     | varchar(15) | NO   |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+

```