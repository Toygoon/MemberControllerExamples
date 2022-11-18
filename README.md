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
INSERT INTO spring4fs.`member` (email, password, name, regdate) VALUES('lee94@chosun.com', '2345', '이순신', '1950-01-01 00:00:00');
INSERT INTO spring4fs.`member` (email, password, name, regdate) VALUES('kim@shila.com', '9999', '김춘추', '2013-04-15 00:00:00');
INSERT INTO spring4fs.`member` (email, password, name, regdate) VALUES('cyy@chosun.com', '7878', '정약용', '2002-10-09 00:00:00');
INSERT INTO spring4fs.`member` (email, password, name, regdate) VALUES('jang@chosun.gov', '7878', '장영실', '1988-07-07 00:00:00');
```

```
INSERT INTO spring4fs.article (writer, title, regdate, moddate, read_cnt) VALUES((SELECT id FROM member WHERE name='이순신'), '한산섬', '2022-09-20 10:49:29', '2022-11-18 14:40:14', 21);
INSERT INTO spring4fs.article (writer, title, regdate, moddate, read_cnt) VALUES((SELECT id FROM member WHERE name='장영실'), '측우기', '2022-09-20 10:50:18', '2022-09-20 10:50:18', 12);
INSERT INTO spring4fs.article (writer, title, regdate, moddate, read_cnt) VALUES((SELECT id FROM member WHERE name='김춘추'), '전자정부 프레임워크란?', '2022-09-21 15:18:30', '2022-09-22 13:16:10', 12);
```
