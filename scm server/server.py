import socket
import json

from random import randint
import time
s = socket.socket()
print("Socket Created")
s.bind(('',9000))
s.listen(3)
print("waiting for connections")
c, addr = s.accept()
data =[{
"Device_Id":1156053040,
"Battery_Level":8.67,
 "First_Sensor_temperature":21.4 ,
 "Route_From":"Dubai",
 "Route_To":"Louisville"
},
{
 "Device_Id":1156053076,
 "Battery_Level":3.52,
 "First_Sensor_temperature":12.4 ,
 "Route_From":"Hyderabad",
 "Route_To":"USA"
 },
{
 "Device_Id":1156053077,
 "Battery_Level":4.57,
 "First_Sensor_temperature":17.8 ,
 "Route_From":"Banglore",
 "Route_To":"Louisville"
},
{
 "Device_Id":1156053061,
 "Battery_Level":8.52,
 "First_Sensor_temperature":16.4 ,
 "Route_From":"Chennai",
 "Route_To":"Louisville"
 },
{
 "Device_Id":1156053011,
 "Battery_Level":9.50,
 "First_Sensor_temperature":10.9 ,
 "Route_From":"Europe",
 "Route_To":"USA"
},
{
 "Device_Id":1156053072,
 "Battery_Level":3.52,
 "First_Sensor_temperature":19.8 ,
 "Route_From":"Canada",
 "Route_To":"Louisville"
 },
{
 "Device_Id":1156053091,
 "Battery_Level":2.57,
 "First_Sensor_temperature":30.3 ,
 "Route_From":"Tirupati",
 "Route_To":"USA"
},
{
 "Device_Id":1156053176,
 "Battery_Level":7.56,
 "First_Sensor_temperature":19.1 ,
 "Route_From":"Bangalore",
 "Route_To":"Louisville"
 }]
while True:
    try:
        print("connected with", addr)
        userdata = (json.dumps(data)+"\n").encode('utf-8')
        print(userdata)
        c.send(userdata)
        time.sleep(100)
    except Exception as e:
        print(e)
        c.close()