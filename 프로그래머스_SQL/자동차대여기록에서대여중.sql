select car_id,
if(exists(select car_id 
          from car_rental_company_rental_history r2
          where r1.car_id = r2.car_id and '2022-10-16' between r2.start_date and r2.end_date), '대여중', '대여 가능') as availability
from car_rental_company_rental_history r1
group by car_id
order by car_id desc 