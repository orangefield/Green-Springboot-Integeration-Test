from pymysql import connect, cursors
import requests


# mysql 연결
conn = connect(host="localhost", user="green", password="green1234",
               db="greendb", charset="utf8")

# 커서 획득
cursor = conn.cursor(cursors.DictCursor)

# 공공데이터 다운로드
response = requests.get(
    "http://openAPI.seoul.go.kr:8088/70504f7878776a6432376c64574a4a/json/RealtimeCityAir/1/25/")

datas = response.json()["RealtimeCityAir"]["row"]

# DB에 데이터 INSERT
# print(datas)
insert_sql = "INSERT INTO seoul(MSRDT, MSRRGN_NM, MSRSTE_NM, PM10, PM25, O3, NO2, CO, SO2, IDEX_NM, IDEX_MVL, ARPLT_MAIN) VALUES(%(MSRDT)s, %(MSRRGN_NM)s, %(MSRSTE_NM)s, %(PM10)s, %(PM25)s, %(O3)s, %(NO2)s, %(CO)s, %(SO2)s, %(IDEX_NM)s, %(IDEX_MVL)s, %(ARPLT_MAIN)s);"
cursor.executemany(insert_sql, datas)
conn.commit()
