CREATE TABLE QUESTION_TYPE (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(255) DEFAULT NULL,
  ICON VARCHAR(255) DEFAULT NULL,
  CODE VARCHAR(255) DEFAULT NULL,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  PRIMARY KEY (ID)
);

CREATE TABLE QUESTION_TEMPLATE_ITEM (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  FK_QUESTION_TYPE BIGINT(20),
  FK_QUESTION_TEMPLATE BIGINT(20),
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  IS_MAIN BIT(1) DEFAULT 1,
  ITEM_ORDER INT DEFAULT 0,
  QUESTION VARCHAR(255) DEFAULT NULL,
  CONSTRAINT FOREIGN KEY (FK_QUESTION_TYPE) REFERENCES QUESTION_TYPE (ID),
  CONSTRAINT FOREIGN KEY (FK_QUESTION_TEMPLATE) REFERENCES MASTER_QUESTION_TEMPLATE (ID),
  PRIMARY KEY (ID)
);

CREATE TABLE QUESTION_SINGLE_OPTION (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  FK_QUESTION_ITEM BIGINT(20),
  FK_QUESTION_SUB_ITEM BIGINT(20),
  NAME VARCHAR(255) DEFAULT NULL,
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT FOREIGN KEY (FK_QUESTION_ITEM) REFERENCES QUESTION_TEMPLATE_ITEM (ID),
  CONSTRAINT FOREIGN KEY (FK_QUESTION_SUB_ITEM) REFERENCES QUESTION_TEMPLATE_ITEM (ID),
  PRIMARY KEY (ID)
);

CREATE TABLE QUOTE_ENQUIRY_WALKTHROUGH (
  ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  FK_QUOTE_ENQUIRY BIGINT(20),
  FK_QUESTION_TEMPLATE BIGINT(20),
  IS_ACTIVATED BIT(1) DEFAULT NULL,
  IS_CURRENT BIT(1) DEFAULT NULL,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT FOREIGN KEY (FK_QUOTE_ENQUIRY) REFERENCES QUOTE_ENQUIRY (ID),
  CONSTRAINT FOREIGN KEY (FK_QUESTION_TEMPLATE) REFERENCES MASTER_QUESTION_TEMPLATE (ID),
  PRIMARY KEY (ID)
);