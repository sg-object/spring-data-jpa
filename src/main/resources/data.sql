INSERT INTO GROUP_CODE (group_code, group_name, create_date) values 
	('A_GROUP', 'A 그룹', NOW()) ,
	('B_GROUP', 'B 그룹', NOW()) ,
	('C_GROUP', 'C 그룹', NOW());

INSERT INTO CODE (code, code_name, create_date) values 
	('A_CODE_01', 'A 그룹의 코드 01', NOW()) ,
	('B_CODE_02', 'B 그룹의 코드 02', NOW()) ,
	('C_CODE_03', 'C 그룹의 코드 03', NOW()) ,
	('A_CODE_02', 'A 그룹의 코드 02', NOW()) ,
	('A_CODE_03', 'A 그룹의 코드 03', NOW()) ,
	('B_CODE_07', 'B 그룹의 코드 07', NOW()) ,
	('C_CODE_05', 'C 그룹의 코드 05', NOW());

INSERT INTO CODE_RELATION (group_code, code, create_date) values 
	('A_GROUP', 'A_CODE_01', NOW()) ,
	('B_GROUP', 'B_CODE_02', NOW()) ,
	('C_GROUP', 'C_CODE_03', NOW()) ,
	('A_GROUP', 'A_CODE_02', NOW()) ,
	('A_GROUP', 'A_CODE_03', NOW()) ,
	('B_GROUP', 'B_CODE_07', NOW()) ,
	('C_GROUP', 'C_CODE_05', NOW());