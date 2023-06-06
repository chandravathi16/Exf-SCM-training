let data_count = 0;
deviceData(function () {
	var myHeaders = new Headers();
	var requestOptions = {
		  method: 'GET',
		  headers: myHeaders,
		  redirect: 'follow'
	};
	fetch("http://13.127.240.194:8082/getData", requestOptions)
	//fetch("http://localhost:8082/getData", requestOptions)
	  .then(response => response.text())
	  .then(data => {
	  		const array = JSON.parse(data);
            //console.log(array)
            // if array not empty 
            if (array.length != 0) {
                for(const i of array) {
                    const { 
                    	Device_Id, Battery_Level, First_Sensor_temperature, Route_From, Route_To 
                    } = i;
                    const table_row = document.createElement('tr');
                    const field1 = document.createElement('td');
                    field1.innerHTML = Device_Id;

                    const field2 = document.createElement('td');
                    field2.innerHTML = Battery_Level;

                    const field3 = document.createElement('td');
                    field3.innerHTML = First_Sensor_temperature;

                    const field4 = document.createElement('td');
                    field4.innerHTML = Route_From;

                    const field5 = document.createElement('td');
                    field5.innerHTML = Route_To;

                    table_row.appendChild(field1);
                    table_row.appendChild(field2);
                    table_row.appendChild(field3);
                    table_row.appendChild(field4);
                    table_row.appendChild(field5);
                    document.getElementById("table").appendChild(table_row);
                }
                data_count++;
            }
        });
}, 5000);


