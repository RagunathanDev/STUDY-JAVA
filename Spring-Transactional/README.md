## Request
```
{
    "passengerInfo":{
        "name":"ragu",
        "email":"ragu@gmail.com",
        "source":"trichy",
        "destination":"chennai",
        "travelDate":"14-12-2021",
        "pickUpTime":"5.00 PM",
        "arrivalTime":"6.00 PM",
        "fare":"2400.00"
    },
    "paymentInfo":{
        "accountNo":"acc1",
        "cardType":"Debit"
    }
}

```

## Response

```
{
    "status": "Success",
    "totalfare": "2400.0",
    "pnrNo": "15",
    "passengerInfo": {
        "name": "ragu",
        "email": "ragu@gmail.com",
        "source": "trichy",
        "destination": "chennai",
        "travelDate": "14-12-2021",
        "pickUpTime": "5.00 PM",
        "arrivalTime": "6.00 PM",
        "fare": 2400,
        "pid": 7
    }
}

```