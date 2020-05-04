# Shopping-microservice
Shopping Microservice includes Eureka Server Discovery, Hystrix, Thymeleaf, Swagger, Outh2 for Github

Frontend Microservice - 6164
Application will start at http://localhost:6164


For Testing Fucntionality on Postman:-
ProductMicroservice - 6162

Get All Products
Get Mapping
http://localhost:6162/products/getAllProducts

Get Product By Id
Get Mapping
http://localhost:6162/products/{productId}

Get Product By Category
Get Mapping
http://localhost:6162/products//category/{category}


CartMicroservice - 6163

Get Cart By Id
Get Mapping
http://localhost:6163/cart/{cartId}

Delete Product from Cart
PostMapping
http://localhost:6163/cart/{cartId}/{productId}

Add Product to Cart
PostMapping
http://localhost:6163/cart/{cartId}
