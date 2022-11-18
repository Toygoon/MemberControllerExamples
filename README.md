# YUServletExemplified

### DDL
- article
```
CREATE TABLE article
  (
     article_no INT auto_increment PRIMARY KEY,
     writer     INT NOT NULL REFERENCES member(id),
     title      VARCHAR(255) NOT NULL,
     regdate    DATETIME NOT NULL,
     moddate    DATETIME,
     read_cnt   INT
  ); 
```

- article_content
```
CREATE TABLE article_content
  (
     article_no INT PRIMARY KEY REFERENCES article(article_no),
     content    TEXT
  ); 
```

### DML
```
INSERT INTO spring4fs.`member` (id, email, password, name, regdate) VALUES(16, 'lee94@chosun.com', '2345', '이순신', '1950-01-01 00:00:00');
INSERT INTO spring4fs.`member` (id, email, password, name, regdate) VALUES(17, 'kim@shila.com', '9999', '김춘추', '2013-04-15 00:00:00');
INSERT INTO spring4fs.`member` (id, email, password, name, regdate) VALUES(18, 'cyy@chosun.com', '7878', '정약용', '2002-10-09 00:00:00');
INSERT INTO spring4fs.`member` (id, email, password, name, regdate) VALUES(19, 'jang@chosun.gov', '7878', '장영실', '1988-07-07 00:00:00');
```

```
INSERT INTO spring4fs.article (article_no, writer, title, regdate, moddate, read_cnt) VALUES(1, 1, '한산섬', '2022-09-20 10:49:29', '2022-11-18 14:40:14', 21);
INSERT INTO spring4fs.article (article_no, writer, title, regdate, moddate, read_cnt) VALUES(2, 4, '측우기', '2022-09-20 10:50:18', '2022-09-20 10:50:18', 12);
INSERT INTO spring4fs.article (article_no, writer, title, regdate, moddate, read_cnt) VALUES(3, 2, '전자정부 프레임워크란?', '2022-09-21 15:18:30', '2022-09-22 13:16:10', 12);
```
