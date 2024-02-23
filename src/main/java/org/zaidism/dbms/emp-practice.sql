Practice here: https://www.sql-practice.com/

Find 3rd highest salary from the table

SELECT salary FROM employee ORDER BY salary DESC LIMIT 2,1


----------------------------------------------------------------------------------------------------
-- Fetch ALL the employee name and their department name they belong to.

 // inner join or join

Select e.emp_name, d.dept_name FROM employee e JOIN department d ON e.dept_id = d.dept_id;

this query will only fetch the list of employee whose dept id are matching in both the table as per ON condition not all the employee
------------------------------------------------------------------------------------------------------------------
//left join

select e. emp_name, d. dept_name from employee e left join department d on e. dept_id = d.dept_id;

-- left join = inner join + any additional records in the left table.
------------------------------------------------------------------------------------------------------------------
//right join

select e. emp_name, d. dept_name from employee e left join department d on e. dept_id = d.dept_id;

-- right join = inner join + any additional records in the right table.
------------------------------------------------------------------------------------------------------------------
// data from all using all of 3 joins
Fetch details of ALL emp, their manager, their department and the projects they work on.

select e. emp_name, d. dept_name, m. manager_name, p.project_name from employee e
left join department d on e. dept_id = d. dept_id
inner join manager m on m. manager_id = e. manager_id
left join projects p on p. team_member_id = e.emp_id;
------------------------------------------------------------------------------------------------------------------
