-- Drop table

-- DROP TABLE cdi.unwanted_legal;

CREATE TABLE cdi.unwanted_legal (
	id int4 NOT NULL DEFAULT nextval('cdi.unwonted_legal_id_seq'::regclass), -- Идентификатор записи организации
	all_name varchar NOT NULL, -- Все названия организации
	actual_date date NULL, -- Дата документа о включении в список
	list_id varchar NULL, -- Номер документа о включении в список
	changedate date NULL DEFAULT CURRENT_DATE -- Дата создания записи в MDS
);
COMMENT ON TABLE cdi.unwanted_legal IS 'Таблица нежелательных организаций';

-- Column comments

COMMENT ON COLUMN cdi.unwanted_legal.id IS 'Идентификатор записи организации';
COMMENT ON COLUMN cdi.unwanted_legal.all_name IS 'Все названия организации';
COMMENT ON COLUMN cdi.unwanted_legal.actual_date IS 'Дата документа о включении в список';
COMMENT ON COLUMN cdi.unwanted_legal.list_id IS 'Номер документа о включении в список';
COMMENT ON COLUMN cdi.unwanted_legal.changedate IS 'Дата создания записи в MDS';
