let shipment_count = 0;
shipment(function () {
	var myHeaders = new Headers();
	var requestOptions = {
		  method: 'GET',
		  headers: myHeaders,
		  redirect: 'follow'
	};
	fetch("http://13.127.240.194:8082/shipments", requestOptions)
	//fetch("http://localhost:8082/shipments", requestOptions)
	  .then(response => response.text())
	  .then(data => {
	  		const array = JSON.parse(data);
            // if array not empty 
            if (array.length != 0) {
                for(const i of array) {
                    const { 
                    	shipmentNumber,routeDetails,device,pONumber,nDCNumber,serialNumberOfGoods,containerNumber,goods,deliveryDate,deliveryNumber,batchId,shipmentDescription;
                    } = i;
                    const table_row = document.createElement('tr');
                    const field1 = document.createElement('td');
                    field1.innerHTML = shipmentNumber;

                    const field2 = document.createElement('td');
                    field2.innerHTML = routeDetails;

                    const field3 = document.createElement('td');
                    field3.innerHTML = device;

                    const field4 = document.createElement('td');
                    field4.innerHTML = pONumber;

                    const field5 = document.createElement('td');
                    field6.innerHTML = nDCNumber;
                    
                    const field6 = document.createElement('td');
                    field6.innerHTML = serialNumberOfGoods;

                    const field7 = document.createElement('td');
                    field7.innerHTML = containerNumber;

                    const field8 = document.createElement('td');
                    field8.innerHTML = goods;

                    const field9 = document.createElement('td');
                    field9.innerHTML = deliveryDate;

                    const field10 = document.createElement('td');
                    field10.innerHTML = deliveryNumber;
                    
                    const field11 = document.createElement('td');
                    field11.innerHTML = batchId;

                    const field12 = document.createElement('td');
                    field12.innerHTML = shipmentDescription;
                    
                    table_row.appendChild(field1);
                    table_row.appendChild(field2);
                    table_row.appendChild(field3);
                    table_row.appendChild(field4);
                    table_row.appendChild(field5);
                    table_row.appendChild(field6);
                    table_row.appendChild(field7);
                    table_row.appendChild(field8);
                    table_row.appendChild(field9);
                    table_row.appendChild(field10);
                    table_row.appendChild(field11);
                    table_row.appendChild(field12);
                    document.getElementById("table").appendChild(table_row);
                }
                shipment_count++;
            }
        });
}, 5000);


