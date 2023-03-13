Backend:

- Customer
- Seller

Customer:

- Search food by geo location
- Simple Authentication
- Add items to the cart
- R option only
- When an order is placed seller should be notified

Seller:

- Confirming Seller
- CRUD options for an item
- NOTIFIATION upon the process at hand

Entities:

- Item
  . Food Name
  . Price
  . Description
  . Images
  . tags
  . RestaurantId

- User
  . Name
  . Email
  . Password
  . Address
  . Phone Number

- Address
  . Street
  . House no.
  . City/Village
  . PostalCode
  . District
  . State
  . Country
  . Lattitude
  . Longitude

-Seller
. Name
. Email
. Password
. Address
. Phone Number
. RestaurantId

- Restaurant
  . Name
  . Address
  . Contact Detail
  . SellerId

- Order
  . ItemId
  . Quantity
  . TotalCost
  . UserId
  . Status:enum
  . TimeStamp

API Required:

- Seller Api:
  . CRUD Items
  . Order

- Global Api:
  . Register User for Buyer/Seller

- Buyer Api:
  . Order

Actual APIs
/
/login
/restaurant
/register
/cart
/orders

    /addrestaurant
    /seller/dashboard
    /seller/orders
