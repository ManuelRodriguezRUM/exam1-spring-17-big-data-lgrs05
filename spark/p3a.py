#Code here

import csv
studentsFile = sc.textFile("hdfs://..../studentsPR.csv")
studentsData = studentsFile.map(lambda line: line.split(','))
data = studentsData.filter(lambda x: x[5]=='F').filter(lambda x: x[2]=='71381')
