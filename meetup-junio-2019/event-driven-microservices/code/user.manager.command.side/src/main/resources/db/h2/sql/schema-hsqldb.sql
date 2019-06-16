-------------------------------------------------------------------------------------------------------------------
--                                                TABLES
-------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE ENUMERATION_TYPE
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE ENUMERATION_TYPE (
  				ENUM_TYPE_ID VARCHAR(20) NOT NULL, 
				PARENT_TYPE_ID VARCHAR(20),
				DESCRIPTION VARCHAR(255),				
  CONSTRAINT ENUM_TYPE_PK PRIMARY KEY (ENUM_TYPE_ID),
  CONSTRAINT ENUM_TYPE_PAR FOREIGN KEY (PARENT_TYPE_ID)
			REFERENCES ENUMERATION_TYPE (ENUM_TYPE_ID));
   
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE ENUMERATION
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE ENUMERATION (
  				ENUM_ID VARCHAR(20) NOT NULL, 
				ENUM_TYPE_ID VARCHAR(20),
				ENUM_CODE VARCHAR(60),
				SEQUENCE_ID VARCHAR(20),				
				DESCRIPTION VARCHAR(255),
  CONSTRAINT ENUM_ID_PK PRIMARY KEY (ENUM_ID),
  CONSTRAINT ENUM_TO_TYPE FOREIGN KEY (ENUM_TYPE_ID)
			REFERENCES ENUMERATION_TYPE (ENUM_TYPE_ID));
			
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE STATUS_TYPE
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE STATUS_TYPE (
  				STATUS_TYPE_ID VARCHAR(20) NOT NULL, 
				PARENT_TYPE_ID VARCHAR(20),
				DESCRIPTION VARCHAR(255),				
  CONSTRAINT STATUS_TYPE_PK PRIMARY KEY (STATUS_TYPE_ID),
  CONSTRAINT STATUS_TYPE_PAR FOREIGN KEY (PARENT_TYPE_ID)
			REFERENCES STATUS_TYPE (STATUS_TYPE_ID));
			
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE STATUS_ITEM
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE STATUS_ITEM (
  				STATUS_ID VARCHAR(20) NOT NULL, 
				STATUS_TYPE_ID VARCHAR(20),
				STATUS_CODE VARCHAR(60),
				SEQUENCE_ID VARCHAR(20),				
				DESCRIPTION VARCHAR(255),
  CONSTRAINT STATUS_ITEM_PK PRIMARY KEY (STATUS_ID),
  CONSTRAINT STATUS_TO_TYPE FOREIGN KEY (STATUS_TYPE_ID)
			REFERENCES STATUS_TYPE (STATUS_TYPE_ID));

-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE PERSON
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE PERSON (
  				PARTY_ID BIGINT NOT NULL,
				RUN VARCHAR(9), 
				SALUTATION VARCHAR(100), 
				FIRST_NAME VARCHAR(100) NOT NULL, 
				MIDDLE_NAME VARCHAR(100),
				LAST_NAME VARCHAR(100),
				PERSONAL_TITLE VARCHAR(100),
				SUFFIX VARCHAR(100),
				NICK_NAME_LOCAL VARCHAR(100),				
				FIRST_NAME_LOCAL VARCHAR(100),
				MIDDLE_NAME_LOCAL VARCHAR(100),
				LAST_NAME_LOCAL VARCHAR(100),
				OTHER_LOCAL VARCHAR(100),
				GENDER VARCHAR(1),
				BIRTH_DATE TIMESTAMP,
				MARITAL_STATUS VARCHAR(1),
				SOCIAL_SECURITY_NUMBER VARCHAR(255),
				PASSPORT_NUMBER VARCHAR(255),
				PASSPORT_EXPIRE_DATE TIMESTAMP,
				TOTAL_YEARS_WORK_EXPERIENCE DOUBLE,
				COMMENTS VARCHAR(255),
				EMPLOYMENT_STATUS_ENUM_ID VARCHAR(20),				
				RESIDENCE_STATUS_ENUM_ID VARCHAR(100),
				YEARS_WITH_EMPLOYER NUMERIC(20,0),
				MONTHS_WITH_EMPLOYER NUMERIC(20,0),
				CARD_ID VARCHAR(60),				
  CONSTRAINT PERSON_PK PRIMARY KEY (PARTY_ID));
  
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE PARTY_GROUP
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE PARTY_GROUP (
  				PARTY_ID BIGINT NOT NULL, 
				RUT VARCHAR(9), 
				GROUP_NAME VARCHAR(100), 
				GROUP_NAME_LOCAL VARCHAR(100), 
				OFFICE_SITE_NAME VARCHAR(100), 
				ANNUAL_REVENUE NUMERIC(18,2),
				NUM_EMPLOYEES NUMERIC(20,0),
				COMMENTS VARCHAR(255),
				LOGO_IMAGE_URL VARCHAR(255),
  CONSTRAINT PARTY_GROUP_PK PRIMARY KEY (PARTY_ID));
  --
  
-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE PARTY_TYPE
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE PARTY_TYPE (
  				PARTY_TYPE_ID VARCHAR(20) NOT NULL, 
				PARENT_TYPE_ID VARCHAR(20), 
				DESCRIPTION VARCHAR(255), 				
  CONSTRAINT PARTY_TYPE_PK PRIMARY KEY (PARTY_TYPE_ID),
  CONSTRAINT PARTY_TYPE_PAR FOREIGN KEY (PARENT_TYPE_ID)
			REFERENCES PARTY_TYPE (PARTY_TYPE_ID));
  --

-------------------------------------------------------------------------------------------------------------------
-- SCHEMA FOR TABLE PARTY 
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE  PARTY (
				PARTY_ID BIGINT NOT NULL, 				
				PARTY_TYPE_ID VARCHAR(20),  				
				EXTERNAL_ID VARCHAR(20), 
				DESCRIPTION VARCHAR(255), 
				STATUS_ID VARCHAR(20) NOT NULL, 
				CREATED_DATE TIMESTAMP NOT NULL, 
				CREATED_BY_USER_LOGIN VARCHAR(255) NOT NULL,
				LAST_MODIFIED_DATE TIMESTAMP, 
				LAST_MODIFIED_BY_USER_LOGIN VARCHAR(255), 				
	CONSTRAINT PARTY_PK PRIMARY KEY ("PARTY_ID"),
    -- CONSTRAINT PERSON_PARTY_FK FOREIGN KEY (PARTY_ID)
			-- REFERENCES PERSON (PARTY_ID),
	-- CONSTRAINT PARTY_GRP_PARTY_FK FOREIGN KEY (PARTY_ID)
			-- REFERENCES PARTY_GROUP (PARTY_ID)); 
	CONSTRAINT PARTY_PTY_TYP_FK FOREIGN KEY (PARTY_TYPE_ID)
			REFERENCES PARTY_TYPE (PARTY_TYPE_ID)); 			
   --
   -- COMMENT ON COLUMN PARTY.PAATTY_ID IS 'Party identifier';	

-----------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE ROLE_TYPE
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE ROLE_TYPE (
  				ROLE_TYPE_ID VARCHAR(20) NOT NULL, 
				PARENT_TYPE_ID VARCHAR(20),
				DESCRIPTION VARCHAR(255),
  CONSTRAINT ROLE_TYPE_PK PRIMARY KEY (ROLE_TYPE_ID),
  CONSTRAINT ROLE_TYPE_PAR FOREIGN KEY (PARENT_TYPE_ID)
			REFERENCES ROLE_TYPE (ROLE_TYPE_ID));
  --
  -- COMMENT ON COLUMN PARTY_GROUP.PARTY_ID IS 'Person Identifier';     


-------------------------------------------------------------------------------------------------------------------
--  SCHEMA FOR TABLE PARTY_ROLE
-------------------------------------------------------------------------------------------------------------------
  CREATE TABLE PARTY_ROLE (
  				PARTY_ID BIGINT NOT NULL, 
				ROLE_TYPE_ID VARCHAR(20) NOT NULL,
				DESCRIPTION VARCHAR(255),
  CONSTRAINT PARTY_ROLE_PK PRIMARY KEY (PARTY_ID, ROLE_TYPE_ID));
  --
  -- COMMENT ON COLUMN PARTY_GROUP.PARTY_ID IS 'Person Identifier';

-------------------------------------------------------------------------------------------------------------------
--  SECUENCE FOR TABLE PARTY
-------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE PARTY_ID_SEQ;
