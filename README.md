# Sparta Feed Consumer test
A Jesús Arévalo implementation


### Feature:
- REST API Load Batch implementation
- Access to total records loaded via REST endpoint
- Swagger documentation



### Setting up the spring project


The project is composed by two parts, the <b>client</b> and the <b>server</b>:

This client will perform two tasks: it will work as the feed that will send the data to the API and after feeding the server, it will request some data from the API.

The server consists of two parts, it has defined the two endpoints a POST method called 'load', that will receive the data from the client provided, and a GET method called 'total', that will be the method that the client will use to request the total of readings sent by provider.

### Some awesome notes :green_book::pencil2:

- The client will connect to http://localhost:8080 to find the API.
- We are not using a database to store the data, just doing it in memory.

### Message format :postbox:

```
message LoadBatch {
    int64 numberOfRecords;
    repeated Record records;
}

message Record {
    int64 recordIndex;
    int64 timestamp;
    String city;
    int32 numberBytesSensorData;  # Number of bytes used in following sensorData section
    SensorCollection sensorsData;
    int64 crc32SensorsData; # crc32 of all bytes present in the sensorData section
}

message String {
    int32 numberOfBytes; 
    byte[] bytesInUtf8; 
}

message SensorCollection {
    int32 numberOfSensors;
    repeated Sensor sensors;
}

message Sensor {
    String id;
    int32 measure;
}
```

### Message format (JSON Contract):scroll:

```json
// Batch
{
  "numberOfRecords": "Long",
  "records" : [
    {
      "recordIndex": "Long",
      "timestamp": "Long",
      "city": "String",
      "numberBytesSensorData": "integer", // Number of bytes used in following sensorData section
      "SensorCollection": {
        "numberOfSensors": "integer",
        "sensors" : [
          {
            "id": "String",
            "measure": "integer"
          }
        ]
      },
      "crc32SensorsData": "Long" // crc32 of all bytes present in the sensorData section
    }
  ]
}
```

#### [SERVER] Commands :computer:
- `mvn clean`: clean the generated build dir
- `mvn test`: run all the tests
- `mvn spring-boot:run`: download the dependencies & run the application

#### [CLIENT] Commands :outbox_tray:
- `java -jar client/sparta-client.jar`:run client

#### Swagger
http://localhost:8080/swagger-ui.html

#### Author
Make with 🔥 by Jesús Arévalo :technologist:
