-- 코드를 입력하세요

-- 리뷰를 가장 많이 작성한 사람이 여러명일 경우 고려해준 쿼리
# select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d')
# from member_profile m, rest_review r
# where m.member_id = r.member_id 
# and m.member_id in (select r.member_id
#                     from rest_review r
#                     group by r.member_id
#                     having count(*) = (
#                         select max(cnt)
#                         from (select member_id, count(*) cnt
#                             from rest_review
#                             group by member_id) as reviewCounts
#                     ))
# order by review_date, review_text

-- in을 exists로 대체
# select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d')
# from member_profile m, rest_review r
# where m.member_id = r.member_id 
# and exists (select 1
#             from rest_review r
#             where r.member_id = m.member_id
#             group by r.member_id
#             having count(*) = (
#                 select max(cnt)
#                 from (select member_id, count(*) cnt
#                     from rest_review
#                     group by member_id) as reviewCounts
#             ))
# order by review_date, review_text

-- 최대 개수 구하는 새로운 방식
select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d')
from member_profile m, rest_review r
where m.member_id = r.member_id 
and m.member_id in (select r.member_id
                    from rest_review r
                    group by r.member_id
                    having count(*) = (
                        select count(*)
                        from rest_review
                        group by member_id
                        order by count(*) desc
                        limit 1
                    ))
order by review_date, review_text