#Reame file

#User Registration

1.  http://localhost:50000/api/v1/auth/register 
{
  "email": "mahad@sheridancollege.ca",
  "password": "1234"
}


# post data
1. http://localhost:50000/api/v1/reviews/
{
    "id": 1,
    "rating": 5,
    "comment": "Amazing food! The service was excellent and the ambiance was great.",
    "user": {
        "id": 1,
        "email": "user@gmail.com"
    },
    "restaurant": {
        "id": 2,
        "name": "The Gourmet Spot"
    }
}

2. http://localhost:50000/api/v1/restaurants

{
    "id": 2,
    "name": "The Gourmet Spot",
    "location": "123 Main Street, New York, NY",
    "cuisineType": "Italian",
    "rating": 4.8,
    "owner": {
        "id": 1,
        "email": "owner@gmail.com"
    }
}


