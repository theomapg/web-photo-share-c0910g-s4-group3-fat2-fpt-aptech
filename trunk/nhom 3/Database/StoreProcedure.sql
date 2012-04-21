USE DBphotoshare
--login
CREATE PROCEDURE SP_LOGIN
@emailID nvarchar(200),
@passwords nvarchar(200),
@roldeID int
AS
	SELECT * FROM dbo.Acount WHERE emailID=@emailID and passwords=@passwords and roldeid=@roldeID

--register
CREATE PROCEDURE SP_REGISTER
@emailID nvarchar(200),
@passwords nvarchar(200),
@gender bit,
@birthday datetime,
@fullname nvarchar(200),
@roleid int
AS
	INSERT INTO dbo.Acount VALUES(@emailID,@passwords,@gender,@birthday,@fullname,@status,GETDATE(),@roleid)
	
	
----Update acount infomation
CREATE PROCEDURE SP_UPDATE_ACOUNT
@emailID nvarchar(200),
@gender bit,
@birthday datetime,
@fullname nvarchar(200),
AS
	UPDATE  dbo.Acount SET gender= @gender,birthday
	= @birthday,fullname=@fullname WHERE emailID=@emailID
	
---Change password
CREATE PROCEDURE SP_CHANGEPASS
@emailID nvarchar(200),
@passwords nvarchar(200)
AS
	UPDATE Acount SET passwords=@passwords WHERE emailID=@emailID
---UPDATE STATUS ACOUNT

CREATE PROCEDURE SP_CHANGEPASS
@emailID nvarchar(200),
@status bit
AS
	UPDATE Acount SET [status]=@status WHERE emailID=@emailID
	
----CREATE ALBUM
CREATE PROCEDURE SP_CREATE_ALBUM
@AlbumName nvarchar(500),
@AlbumQuantity int,
@AlbumStatus bit,
@emailID nvarchar(200)
AS
	INSERT INTO Album VALUES(@AlbumName,GETDATE(),@AlbumQuantity,@AlbumStatus,@emailID)
	
---UPDLOAD IMAGE
CREATE PROC SP_UPLOAD_IMAGE
@ImageName nvarchar(200),
@cateID int,
@albumID int,
@ImageDescription nvarchar(500),
@linkImage nvarchar(100),
@ImageSize float,
@ImagePath nvarchar(200),
@status bit
AS
	INSERT INTO ImageUploaded(ImageName,ImageDescription,ImageSize,ImagePath,ImageDate,ImageStatus,AlbumID,CategoryID) VALUES(@ImageName,@ImageDescription,@ImageSize,@ImagePath,GETDATE(),@status,@albumID,@cateID)
	
---CREATE FAQ
CREATE PROC SP_CREATE_FAQ
@FaqQuestion NVARCHAR(MAX),
@FaqAnswer NVARCHAR(MAX)
AS
	INSERT INTO dbo.FAQ VALUES(@FaqQuestion,@FaqAnswer)
	
---UPDATE FAQ
CREATE PROC SP_UPDATE_FAQ
@FaqID INT,
@FaqQuestion NVARCHAR(MAX),
@FaqAnswer NVARCHAR(MAX)
AS
	UPDATE dbo.FAQ SET FaqQuestion=@FaqQuestion,FaqAnswer=@FaqAnswer WHERE FaqID=@FaqID
	
----CREATE FEEDBACK
CREATE PROC SP_CREATE_FEEDBACK
@FeedBackTittle nvarchar(500),
@FeedBack nvarchar(max),
@email nvarchar(200)
AS
	INSERT INTO dbo.FeedBack VALUES(@FeedBackTittle,@FeedBack,1,GETDATE(),@email)
--CREATE CATEGORY
CREATE PROC SP_CREATE_CATEGORY
@CategoryName NVARCHAR(200)
AS
	INSERT INTO dbo.Category VALUES(@CategoryName)
---CREATE COMMENT
CREATE PROC SP_CREATE_COMMENT
@CommentTitle NVARCHAR(500),
@Comment NVARCHAR(MAX),
@ImageID int,
@emailID nvarchar(200),
AS	
	INSERT INTO dbo.Comments VALUES(@CommentTitle,@Comment,@ImageID,GETDATE(),@emailID)

----count ACOUNT registed
CREATE PROC SP_COUNT_ACCOUNT
AS
	SELECT COUNT(*) FROM dbo.Acount
---COUNT ACCOUNT REGISTED TODAY
CREATE PROC SP_COUNT_ACOUNT_TODAY
AS
	SELECT COUNT(*) FROM dbo.Acount WHERE AcountDate=GETDATE()

--COUNT IMAGE UPLOADED
CREATE PROC SP_COUNT_IMAGE
@emailID NVARCHAR(200)
AS
	SELECT COUNT(*) FROM dbo.ImageUploaded JOIN dbo.Album 
	ON dbo.ImageUploaded.AlbumID=dbo.Album.AlbumID 
	JOIN dbo.Acount ON dbo.Album.emailID=dbo.Acount.emailID
	WHERE dbo.Acount.emailID=@emailID
	
--	