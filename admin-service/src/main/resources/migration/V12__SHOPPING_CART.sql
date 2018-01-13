INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Short Answer', 'short_text', 'QN1', b'1');
INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Paragraph', 'format_line_spacing', 'QN2', b'1');
INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Single Choice', 'radio_button_checked', 'QN3', b'1');
INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Multiple Choice', 'check_box', 'QN4', b'0');
INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Dropdown', 'arrow_drop_down_circle', 'QN5', b'0');
INSERT INTO QUESTION_TYPE (NAME, ICON, CODE, IS_ACTIVATED) VALUES ('Package', 'shopping_cart', 'QN6', b'0');

CREATE TABLE QUOTE_ANSWER(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	FK_QTE_ENQ_WLKTHRGH BIGINT(20),
	FK_QSTIN_TMPLT_ITM BIGINT(20),
	ANSWER VARCHAR(2000),
	ANSWER_HEADLINE VARCHAR(255),
	FK_QSTIN_SNGL_OPTIN BIGINT(20),
	CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FOREIGN KEY (FK_QTE_ENQ_WLKTHRGH) REFERENCES QUOTE_ENQUIRY_WALKTHROUGH (ID),
	CONSTRAINT FOREIGN KEY (FK_QSTIN_TMPLT_ITM) REFERENCES QUESTION_TEMPLATE_ITEM (ID),
	CONSTRAINT FOREIGN KEY (FK_QSTIN_SNGL_OPTIN) REFERENCES QUESTION_SINGLE_OPTION (ID),
	PRIMARY KEY (ID)
);

CREATE TABLE QUOTE_PACKAGES(
	ID BIGINT(20) NOT NULL AUTO_INCREMENT,
	FK_MASTER_PACKAGE BIGINT(20),
	FK_QTE_ENQ_WLKTHRGH BIGINT(20),
	TOTAL_COST DECIMAL(18,2) DEFAULT 0,
	TAX_RATE DECIMAL(10,2) DEFAULT 0,
	MARKUP DECIMAL(10,2) DEFAULT 0,
	IS_ACTIVATED BIT(1) DEFAULT NULL,
	CREATED_BY VARCHAR(255) DEFAULT NULL,
	CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT FOREIGN KEY (FK_MASTER_PACKAGE) REFERENCES MASTER_PACKAGE (ID),
	CONSTRAINT FOREIGN KEY (FK_QTE_ENQ_WLKTHRGH) REFERENCES QUOTE_ENQUIRY_WALKTHROUGH (ID),
	PRIMARY KEY (ID)
);