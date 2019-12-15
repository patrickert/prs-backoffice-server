# PRS Backoffice Server

## Description

Spring boot based API to serve as backend for PRS backoffice and dashboard.

## API docs

### `/records`

`GET /`
* Response
```
{
  [
    {
      "id": string,
      "timestamp": string,
      "plate": string,
      "url": string,
      "camera": number
    }, ... 
  ]
}
```

### `/cameras`

`GET /`
* Response
```
[
  {
    "id": number,
    "name": string,
    "code": string,
    "lat": number,
    "long": number
  }, ...
]
```

`GET /{cameraId}`
* Response 200
```
  {
    "id": number,
    "name": string,
    "code": string,
    "lat": number,
    "long": number
  }
```

* Response 404

`POST /`
* Request body
```
  {
    "name": string,
    "code": string,
    "lat": number,
    "long": number
  }
```
* Response 
```
  {
    "id": number,
    "name": string,
    "code": string,
    "lat": number,
    "long": number
  }
```

`PUT /`
* Request body
```
  {
    "id": number,
    "name": string,
    "code": string,
    "lat": number,
    "long": number
  }
```
* Response 204
* Response 404

`DELETE /{cameraId}` 
* Response 204
* Response 404

### `/lists`

`GET /`
* Response
```
[
  {
    "id": number,
    "name": string,
    "action": string,
    "metadata": string,
    "list": string[]
  }, ...
]
```

`GET /{listId}`
* Response 200
```
  {
    "id": number,
    "name": string,
    "action": string,
    "metadata": string,
    "list": string[]
  }
```

* Response 404

`POST /`
* Request body
```
  {
    "name": string,
    "action": string,
    "metadata": string,
    "list": string[]
  }
```
* Response 
```
  {
    "id": number,
    "name": string,
    "action": string,
    "metadata": string,
    "list": string[]
  }
```

`PUT /`
* Request body
```
  {
    "id": number,
    "name": string,
    "action": string,
    "metadata": string,
    "list": string[]
  }
```
* Response 204
* Response 404

`DELETE /{listId}` 
* Response 204
* Response 404

## Run

### First time
```bash
$ docker-compose up -d
```


### Stop
```bash
$ docker stop prs-server
$ docker stop mongo-prs
```

### Next time
```bash
$ docker start mongo-prs
$ docker start prs-server
```

### To add data to Mongo

```bash
$ docker exec -it mongo-prs mongo
> db.logs.insert({"timestamp": string, "plate": string, "url": string, "camera": number})
```

