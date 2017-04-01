#Code here
import csv
schoolsFile = sc.textFile("hdfs://..../escuelasPR.csv")
schoolsData = studentsFile.map(lambda line: line.split(','))
data = studentsData.filter(lambda x: x[2]=='Ponce' or x[2] == 'Cabo Rojo' or x[2] == 'Dorado')
