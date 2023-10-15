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