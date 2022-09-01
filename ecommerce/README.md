# Week2-2
## Ecommerce Project
### How to test this?


1. [Install Docker Compose](https://docs.docker.com/compose/install/)
2. Open docker desktop
3. Clone this repository
4. Move to folder of project (location contain file docker-compose.yml)
5. Open terminal then run all containers with `docker-compose -f docker-compose.yml up --build`
6. Verify in Datadog that your container picks up the docker and logs of project
7. Open favorite brower and test APIs (project running on port 8080)

### How to access mysql database running in docker container ?
#### 1. open terminal and run `docker exec -ti mysql-springboot-container mysql -u root -p` then enter password is `Abc@123456789`
![image](https://user-images.githubusercontent.com/104447131/187961267-5cb05116-7d60-4a94-98f3-ff6bbbb9927b.png)
#### 2. type `use ecommerce` then query normaly
![image](https://user-images.githubusercontent.com/104447131/187961589-476275e9-811a-4479-9299-3f77530c93a5.png)



#### Get Product has price < 500
##### Patern - localhost:8080/product/find-product/{condition}/{price}
##### GET - localhost:8080/product/find-product/less_than/500
```json
{
    "status": "OK",
    "message": "Successfully",
    "object": [
        {
            "productId": 1,
            "nameProduct": "T-shirt",
            "productType": "SH",
            "size": "M",
            "quantity": 100,
            "price": 300
        },
        {
            "productId": 2,
            "nameProduct": "T-shirt",
            "productType": "SH",
            "size": "S",
            "quantity": 100,
            "price": 300
        },
        {
            "productId": 3,
            "nameProduct": "T-shirt",
            "productType": "SH",
            "size": "L",
            "quantity": 100,
            "price": 300
        },
        {
            "productId": 10,
            "nameProduct": "Short",
            "productType": "TS",
            "size": "31",
            "quantity": 100,
            "price": 250
        }
    ]
}
```
#### Get Product has price = 500
##### Patern - localhost:8080/product/find-product/{condition}/{price}
##### GET - localhost:8080/product/find-product/equal/500
```json
{
    "status": "OK",
    "message": "Successfully",
    "object": [
        {
            "productId": 4,
            "nameProduct": "Shirt",
            "productType": "SH",
            "size": "M",
            "quantity": 100,
            "price": 500
        },
        {
            "productId": 5,
            "nameProduct": "Shirt",
            "productType": "SH",
            "size": "S",
            "quantity": 100,
            "price": 500
        },
        {
            "productId": 6,
            "nameProduct": "Shirt",
            "productType": "SH",
            "size": "L",
            "quantity": 100,
            "price": 500
        },
        {
            "productId": 7,
            "nameProduct": "Kaki pant",
            "productType": "TS",
            "size": "29",
            "quantity": 100,
            "price": 500
        }
    ]
}
```
#### Get Product has price > 500
##### Patern - localhost:8080/product/find-product/{condition}/{price}
##### GET - localhost:8080/product/find-product/greater_than/500
```json{
    "status": "OK",
    "message": "Successfully",
    "object": [
        {
            "productId": 8,
            "nameProduct": "Kaki",
            "productType": "TS",
            "size": "28",
            "quantity": 100,
            "price": 550
        },
        {
            "productId": 9,
            "nameProduct": "Jean",
            "productType": "TS",
            "size": "30",
            "quantity": 100,
            "price": 700
        }
    ]
}
```
#### Add item into cart of Customer
##### Patern - localhost:8080/cart/insertProduct/{customerId}
##### POST - localhost:8080/cart/insertProduct/2
###### REQUEST
```json
[
    {
    "productId":5,
    "quantity" :20
    },
    {
            "productId":6,
            "quantity" :30    
    }
]
```
##### REPONSE
```json
{
    "status": "Ok",
    "message": "Successfully",
    "object": [
        {
            "productId": 5,
            "quantity": 20
        },
        {
            "productId": 6,
            "quantity": 30
        }
    ]
}
```
#### Update item in cart of Customer
##### Patern - localhost:8080/cart/insertProduct/{customerId}
##### POST - localhost:8080/cart/insertProduct/2
###### Before update
![image](https://user-images.githubusercontent.com/104447131/187951438-f34b26f5-2194-4aa1-9358-d50beca16b40.png)
###### RESPONSE
```json
[
    {
    "productId":5,
    "quantity" :50
    },
    {
            "productId":6,
            "quantity" :50    
    }
]
```
Add 50 with productid = 5 and 50 with productId = 6
##### After update
![image](https://user-images.githubusercontent.com/104447131/187952228-9268cb97-78b0-49fc-b654-9a22140c5ae3.png)
#### Get item in Cart of Customer 
##### Patern - localhost:8080/cart/getCartItem?customerId={customerId}&nameProduct={nameProduct}&offset={offset}&limit={limit}
##### GET - localhost:8080/cart/getCartItem?customerId=2&nameProduct=Shirt&offset=0&limit=3
## List item in a CART of another Customer
![image](https://user-images.githubusercontent.com/104447131/187953543-e3ef4175-b535-45cc-8b9b-b59a4ded6cca.png)
## Get item with offset = 0, limit = 3, nameproduct = Shirt, customerId = 2
####RESPONSE
```json
{
    "status": "OK",
    "message": "Successfully",
    "object": [
        {
            "cartItemId": 1,
            "cartId": 1,
            "productId": 5,
            "quantityWished": 70,
            "dateAdded": "2022-09-01",
            "totalAmount": 35000
        },
        {
            "cartItemId": 2,
            "cartId": 1,
            "productId": 6,
            "quantityWished": 80,
            "dateAdded": "2022-09-01",
            "totalAmount": 40000
        },
        {
            "cartItemId": 3,
            "cartId": 1,
            "productId": 2,
            "quantityWished": 50,
            "dateAdded": "2022-09-01",
            "totalAmount": 15000
        }
    ]
}
```





