// when joined table used
select c1_0.id,c1_0.name from category c1_0 where c1_0.id=?

//Eager fetch
select c1_0.id,c1_0.name,p1_0.category_id,p1_0.id,p1_0.description,p1_0.image,p1_0.price,p1_0.title
from category c1_0
left join product p1_0 on c1_0.id=p1_0.category_id
where c1_0.id=?

//Lazy fetch
// it didn't' get products associated with the category
select c1_0.id,c1_0.name from category c1_0 where c1_0.id=?

//findall product with currency in rupee
 select p1_0.id,c1_0.id,c1_0.name,p1_0.description,p1_0.image,p2_0.id,p2_0.currency,p2_0.price,p1_0.title
 from product p1_0
    left join category c1_0 on c1_0.id=p1_0.category
    left join price p2_0 on p2_0.id=p1_0.price_id where p1_0.id=?
