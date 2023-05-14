CREATE TABLE "Member" (
                          "id"	int		NOT NULL,
                          "userId"	varchar(100)		NOT NULL,
                          "password"	varchar(100)		NOT NULL,
                          "nickname"	varchar(20)		NOT NULL,
                          "status"	varchar(1)	DEFAULT 'a'	NOT NULL,
                          "createdAt"	timestamp	DEFAULT CURRENT_TIMESTAMP	NULL,
                          "updatedAt"	timestamp	DEFAULT CURRENT_TIMESTAMP NULL
);