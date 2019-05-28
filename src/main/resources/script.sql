
CREATE SEQUENCE  personal_finance_category_id_seq;
CREATE SEQUENCE  personal_finance_transaction_id_seq;

CREATE TABLE personal_finance_category (
	id int4 PRIMARY KEY NOT NULL DEFAULT nextval('personal_finance_category_id_seq'::regclass),
	name varchar(255) NULL,
	color_code varchar(255) NULL,
	created_date date NOT NULL,
	updated_date date NOT NULL
)

CREATE TABLE personal_finance_transaction (
	id int4 PRIMARY KEY NOT NULL DEFAULT nextval('personal_finance_transaction_id_seq'::regclass),
	description varchar(255) NULL,
	amount int4 NULL,
	purchased_date date NULL,
	trnasaction_type int4 NULL,
	categeory_id int4 NULL,
	created_date date NOT NULL,
	updated_date date NOT NULL,
	CONSTRAINT personal_finance_category_f1 FOREIGN KEY (categeory_id) REFERENCES personal_finance_category(id)
)