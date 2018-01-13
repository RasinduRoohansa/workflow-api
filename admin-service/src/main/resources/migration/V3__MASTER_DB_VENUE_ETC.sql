ALTER TABLE USER ADD COLUMN IS_ADMIN BIT;
ALTER TABLE USER ADD COLUMN IS_REGISTERED BIT;

ALTER TABLE USER ALTER  COLUMN IS_ADMIN SET DEFAULT 0;
ALTER TABLE USER ALTER COLUMN IS_REGISTERED SET DEFAULT 0;

CREATE TABLE MASTER_VENUE_SPACE (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) DEFAULT NULL,
  DESCRIPTION VARCHAR(255) DEFAULT NULL,
  MAX_CAPACITY INT DEFAULT 0,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FK_MASTER_VENUE BIGINT(20),
  PRIMARY KEY (ID),
  CONSTRAINT FOREIGN KEY (FK_MASTER_VENUE) REFERENCES MASTER_VENUE (ID)
);

CREATE TABLE MASTER_ITINERARY_CATEGORY (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  CATEGORY_NAME VARCHAR(255) DEFAULT NULL,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
);

CREATE TABLE MASTER_ITEM (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  ITEM_NAME VARCHAR(255) DEFAULT NULL,
  DESCRIPTION VARCHAR(255) DEFAULT NULL,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FK_ITEM_CATEGORY BIGINT(20),
  PRIMARY KEY (ID),
  CONSTRAINT FOREIGN KEY (FK_ITEM_CATEGORY) REFERENCES MASTER_ITINERARY_CATEGORY (ID)
);

CREATE TABLE MASTER_SUPPLIER (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  SUPPLIER_NAME VARCHAR(255) DEFAULT NULL,
  CODE VARCHAR(255) DEFAULT NULL,
  COMPANY_NAME VARCHAR(255) DEFAULT NULL,
  STREET_ONE VARCHAR(255) DEFAULT NULL,
  STREET_TWO VARCHAR(255) DEFAULT NULL,
  CITY VARCHAR(255) DEFAULT NULL,
  COUNTRY VARCHAR(255) DEFAULT NULL,
  TELEPHONE_ONE VARCHAR(20) DEFAULT NULL,
  TELEPHONE_TWO VARCHAR(20) DEFAULT NULL,
  FAX VARCHAR(20) DEFAULT NULL,
  EMAIL VARCHAR(255) DEFAULT NULL,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
);