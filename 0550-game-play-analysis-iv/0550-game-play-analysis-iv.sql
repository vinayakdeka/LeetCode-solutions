# Write your MySQL query statement below


SELECT
    ROUND(
        AVG(
            CASE
                WHEN a.event_date IS NOT NULL THEN 1
                ELSE 0
            END
        ),
        2
    ) AS fraction

FROM (
    SELECT
        player_id,
        MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) f

LEFT JOIN Activity a
    ON f.player_id = a.player_id
    AND DATEDIFF(a.event_date, f.first_login) = 1;
