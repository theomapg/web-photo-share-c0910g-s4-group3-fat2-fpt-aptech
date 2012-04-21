CREATE DATABASE DBphotoshare
USE  DBphotoshare

CREATE TABLE Acount(
emailID nvarchar(200) primary key,
passwords nvarchar(200),
gender nvarchar(10),
birthday datetime,
fullname nvarchar(200),
[status] bit,
AcountDate datetime,
roleid int not null
)

CREATE TABLE Roles(
roleid int identity(1,1) primary key,
roleName nvarchar(50)
)

CREATE TABLE Album(
AlbumID int identity(1,1) primary key,
AlbumName nvarchar(500),
AlbumDate datetime,
AlbumQuantity int,
AlbumStatus nvarchar(20),
emailID nvarchar(200) not null
)
CREATE TABLE Category(
CategoryID int identity(1,1) primary key,
CategoryName nvarchar(200)
)

CREATE TABLE ImageUploaded(
ImageID int identity(1,1) primary key,
ImageName nvarchar(200),
ImageDescription nvarchar(500),
ImageSize float,
ImagePath nvarchar(200),
ImageDate datetime,
ImageStatus bit,
AlbumID int not null,
CategoryID int not null
)

--Alter table ImageUploaded Add  ImageStatus varchar(50)
CREATE TABLE Comments(
CommentID int identity(1,1) primary key,
CommentTitle nvarchar(500),
Comment nvarchar(max),
ImageID int not null,
CommentDate datetime
)
CREATE TABLE FeedBack(
FeedBackID int identity(1,1) primary key,
FeedBackTitle nvarchar(500),
FeedBack nvarchar(max),
FeedBackDate datetime,
email nvarchar(200)
)
CREATE TABLE FAQ(
FaqID int identity(1,1) primary key,
FaqQuestion nvarchar(max),
FaqAnswer nvarchar(max)
)
ALTER TABLE Acount ADD CONSTRAINT Fk_Acount_roldeid  FOREIGN KEY(roleid) REFERENCES Roles(roleid)
ALTER TABLE Album ADD CONSTRAINT FK_Album_emailID FOREIGN KEY(emailID) REFERENCES Acount(emailID)
ALTER TABLE ImageUploaded ADD CONSTRAINT FK_ImageUploaded_AlbumID FOREIGN KEY(AlbumID) REFERENCES Album(AlbumID)
ALTER TABLE Comments ADD CONSTRAINT FK_Comments_ImageID FOREIGN KEY(ImageID) REFERENCES ImageUploaded(ImageID)
ALTER TABLE ImageUploaded ADD CONSTRAINT FK_Category_CategoryID FOREIGN KEY(CategoryID) REFERENCES Category(CategoryID)