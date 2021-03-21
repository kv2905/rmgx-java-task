# rmgx-java-task
The RMgX Java Task for an internship.

## Tech stack
Java version - 11 <br>
Spring Boot version - 2.4.4 <br>
In-memory DB - H2 <br>
Lombok - to remove boilerplate code <br>
Build tool - Maven

## Endpoints Exposed - Asset
###/assets/
Method: GET
- Lists all the assets in our database

Response
```json
[
  {
    "assetId": 1,
    "assetName": "laptop",
    "purchasedDate": "2020-07-21",
    "conditionNotes": "Working fine",
    "assignmentStatus": "ASSIGNED",
    "category": {
      "cid": 1,
      "categoryName": "electronics",
      "description": "electronics description"
    }
  },
  {
    "assetId": 3,
    "assetName": "chair",
    "purchasedDate": "2020-07-21",
    "conditionNotes": "Ok",
    "assignmentStatus": "ASSIGNED",
    "category": {
      "cid": 2,
      "categoryName": "furniture",
      "description": "furniture description"
    }
  },
  {
    "assetId": 4,
    "assetName": "desk",
    "purchasedDate": "2018-03-21",
    "conditionNotes": "One leg Broken",
    "assignmentStatus": "RECOVERED",
    "category": {
      "cid": 2,
      "categoryName": "furniture",
      "description": "furniture description"
    }
  }
]
```

###/assets/1
Method: GET
- To fetch an asset by id

Response
```json
{
    "assetId": 1,
    "assetName": "laptop",
    "purchasedDate": "2020-07-21",
    "conditionNotes": "Working fine",
    "assignmentStatus": "ASSIGNED",
    "category": {
        "cid": 1,
        "categoryName": "electronics",
        "description": "electronics description"
    }
}
```

###/assets/search?name="laptop"
Method: GET
- To fetch assets by name

Parameters: name
- name of the assets

Response
```json
{
    "assetId": 1,
    "assetName": "laptop",
    "purchasedDate": "2020-07-21",
    "conditionNotes": "Working fine",
    "assignmentStatus": "ASSIGNED",
    "category": {
        "cid": 1,
        "categoryName": "electronics",
        "description": "electronics description"
    }
}
```


###/assets/add
Method: POST
- Create a new asset with assignment status as unassigned

Request
```json
{
    "assetName": "mouse",
    "purchasedDate": "2020-07-21",
    "conditionNotes": "Working fine",
    "category": {
        "cid": 1,
        "categoryName": "electronics",
        "description": "electronics description"
    }
}
```

###/assets/update
Method: PUT
- Update an existing asset

Request
```json
{
    "assetId": 4,
    "assetName": "new desk",
    "purchasedDate": "2018-03-21",
    "conditionNotes": "One leg Broken",
    "assignmentStatus": "RECOVERED",
    "category": {
        "cid": 2,
        "categoryName": "furniture",
        "description": "furniture description"
    }
}
```
###/assets/assign/1?assignmentStatus=ASSIGNED
Method: PUT
- To update the assignment status of an asset

Response

Updated successfully

###/assets/delete/1

Method: DELETE
- To delete an asset with given ID

Response

Can't be Deleted! The asset is assigned!



## Endpoints Exposed - Category

###/categories/

Method: GET
- To fetch all the categories

Response
```json
{
    "_embedded": {
        "categories": [
            {
                "categoryName": "electronics",
                "description": "electronics description",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/categories/1"
                    },
                    "category": {
                        "href": "http://localhost:8080/categories/1"
                    },
                    "assets": {
                        "href": "http://localhost:8080/categories/1/assets"
                    }
                }
            },
            {
                "categoryName": "furniture",
                "description": "furniture description",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/categories/2"
                    },
                    "category": {
                        "href": "http://localhost:8080/categories/2"
                    },
                    "assets": {
                        "href": "http://localhost:8080/categories/2/assets"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/categories"
        },
        "profile": {
            "href": "http://localhost:8080/profile/categories"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 2,
        "totalPages": 1,
        "number": 0
    }
}
```

###/categories/1
Method: GET
- To fetch category by ID

Response
```json
{
    "cid": 1,
    "categoryName": "electronics",
    "description": "electronics description"
}
```

###/categories/add
Method: POST
- To add new category

Request
```json
{
  "categoryName": "lights",
  "description": "lights description"
}
```

###/categories/update
Method: PUT
- To update a category

Request
```json
{
  "cid": 1,
  "categoryName": "electronics",
  "description": "electronics description updated"
}
```