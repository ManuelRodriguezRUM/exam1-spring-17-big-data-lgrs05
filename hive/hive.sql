# You sql follows
create table schools(region string, district string, city string, id string, name string, schoolType string, collegeBoardId string) row format delimited fields terminated by ',';

load data inpath 'hdfs://....' into table schools;

create table students(region string, district string, schoolId string, schoolName string, schoolType string, gender string, id string) row format delimited fields terminated by ',';

load data inpath 'hdfs://....' into table students;

select count(*), region from schools group by region;

select count(*), city from schools group by city;

select count(*), sc.id, sc.name from schools, students where s.schoolId = sc.id group by sc.id;

select s.region, s.district, s.schoolId, s.schoolName, s.schoolType, s.gender, s.id from schools as sc, students as s where s.schoolId = sc.id and (sc.city = 'Ponce' or sc.city = 'Cabo Rojo');

select count(*), region from students group by region;

select count(*), sc.city from students as s, schools as sc where s.schoolId = sc.id group by city;


