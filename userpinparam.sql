CREATE TABLE [dbo].[tblHDUsers] (
  [nHelpDeskID] [int] IDENTITY (1, 1) NOT NULL,
  [nUserType] [tinyint] NULL,
  [sUserName] [varchar] (50) NULL,
  [sPassword] [varchar] (100) NULL,
  [sName] [varchar] (100) NULL,
  [sMobileNo] [varchar] (15) NULL,
  [sEmail] [varchar] (50) NULL,
  [sRole] [varchar] (50) NULL,
  [nStatus] [tinyint] NULL,
  [dtCreated] [datetime] NULL,
  [dtLastLogin] [datetime] NULL,
  [nFailCount] [tinyint] NULL,
  CONSTRAINT [PK_tblHDUsers]
  PRIMARY KEY CLUSTERED
  (
    [nHelpDeskID] ASC
  )
  WITH (PAD_INDEX = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF, DATA_COMPRESSION = NONE)
  ON [PRIMARY]
) ON [PRIMARY];
GO

/***save hduser***/
alter PROCEDURE [dbo].[SP_VTMS_HDUsers]
(
@pin_sParam					VARCHAR(3),
@pin_nHelpDeskID		    INT,
@pin_nUserType			tinyint,
@pin_sUserName			varchar (50),
@pin_sPassword          varchar (100),
@pin_sName		     varchar (100),
@pin_sMobileNo			varchar (15),
@pin_sEmail		      varchar (50),
@pin_sRole		      varchar (50),
@pin_nStatus			tinyint,
@pin_dtCreated		      datetime,
@pin_dtLastLogin	      datetime,
@pin_nFailCount			tinyint

)
AS
BEGIN
	
	
	IF @pin_sParam = 'SV'  
BEGIN  
 	INSERT INTO	tblHDUsers (nUserType, sUserName, sPassword , sName,sMobileNo,sEmail,sRole,nStatus,dtCreated,dtLastLogin,nFailCount)
	VALUES (@pin_nUserType, @pin_sUserName, @pin_sPassword   , @pin_sName,@pin_sMobileNo,@pin_sEmail,@pin_sRole,@pin_nStatus,@pin_dtCreated,@pin_dtLastLogin,@pin_nFailCount)
		/*VALUES(5,2,'fdfoo','123ggd','poorna','9888854544','pp@gmial.com','job',1,'2008/11/26 10:23:44.000','2008/11/20 10:23:44.000',5)*/
END


END

/*** Retrieve***/
IF @pin_sParam = 'RT'
BEGIN
	SELECT	nHelpDeskID, nUserType, sUserName, sPassword , sName,sMobileNo,sEmail,sRole,nStatus,dtCreated,dtLastLogin,nFailCount
	FROM	tblHDUsers
	WHERE	sUserName = @pin_sUserName
	/**ORDER BY sDistrictName ASC**/
	
END

/*** Update***/
IF @pin_sParam = 'UP'
BEGIN
	UPDATE	tblHDUsers
	SET		nUserType = @pin_nUserType, sUserName = @pin_sUserName, sPassword = @pin_sPassword, sName = @pin_sName,sMobileNo=@pin_sMobileNo
	WHERE	 sUserName = @pin_sUserName
END
/*** Delete***/
IF @pin_sParam = 'DL'
BEGIN
	DELETE	
	FROM	tblHDUsers
	WHERE	sUserName = @pin_sUserName
END



DECLARE @RC int
DECLARE @pin_sParam varchar (3) 
DECLARE @pin_nHelpDeskID int 
DECLARE @pin_nUserType tinyint 
DECLARE @pin_sUserName varchar (50) 
DECLARE @pin_sPassword varchar (100) 
DECLARE @pin_sName varchar (100) 
DECLARE @pin_sMobileNo varchar (15) 
DECLARE @pin_sEmail varchar (50) 
DECLARE @pin_sRole varchar (50) 
DECLARE @pin_nStatus tinyint 
DECLARE @pin_dtCreated datetime 
DECLARE @pin_dtLastLogin datetime 
DECLARE @pin_nFailCount tinyint 

-- TODO: Set parameter values here.

EXECUTE @RC = [dbo].[SP_VTMS_HDUsers]
 @pin_sParam ='SV',
 @pin_nHelpDeskID=1,
   @pin_nUserType=102,
  @pin_sUserName='admin',
  @pin_sPassword='admin',
  @pin_sName='poorna',
  @pin_sMobileNo='9888854544',
  @pin_sEmail='pp@gmial.com',
  @pin_sRole='job',
  @pin_nStatus=101,
  @pin_dtCreated='2008-11-26 10:23:44.000',
  @pin_dtLastLogin='2008-11-20 10:23:44.000',
  @pin_nFailCount=5
GO
