show databases;
create database mapping1;
commit; 

use mapping1;
show tables;


select * from wallet_account;
select * from address;
select * from Customer;
select * from Order_details;



INSERT INTO customer (id, name) VALUES
(1, 'Customer 1'),
(2, 'Customer 2'),
(3, 'Customer 3'),
(4, 'Customer 4'),
(5, 'Customer 5'),
(6, 'Customer 6'),
(7, 'Customer 7'),
(8, 'Customer 8'),
(9, 'Customer 9'),
(10, 'Customer 10');
commit;
INSERT INTO address (id, street, city, customer_id) VALUES
(101, 'Street 1', 'Pune', 1),
(102, 'Street 2', 'Mumbai', 2),
(103, 'Street 3', 'Delhi', 3),
(104, 'Street 4', 'Bangalore', 4),
(105, 'Street 5', 'Chennai', 5),
(106, 'Street 6', 'Hyderabad', 6),
(107, 'Street 7', 'Kolkata', 7),
(108, 'Street 8', 'Ahmedabad', 8),
(109, 'Street 9', 'Jaipur', 9),
(110, 'Street 10', 'Nagpur', 10);

select * from wallet_account;
INSERT INTO wallet_account (accountID, pan, balance, status, kyc_Done, customer_id) VALUES
(5001, 'PAN0001', 1000, 'ACTIVE', true, 1),
(5002, 'PAN0002', 2000, 'ACTIVE', true, 2),
(5003, 'PAN0003', 3000, 'ACTIVE', true, 3),
(5004, 'PAN0004', 4000, 'ACTIVE', true, 4),
(5005, 'PAN0005', 5000, 'ACTIVE', true, 5),
(5006, 'PAN0006', 6000, 'ACTIVE', true, 6),
(5007, 'PAN0007', 7000, 'ACTIVE', true, 7),
(5008, 'PAN0008', 8000, 'ACTIVE', true, 8),
(5009, 'PAN0009', 9000, 'ACTIVE', true, 9),
(5010, 'PAN0010', 10000, 'ACTIVE', true, 10);

select * from productName;
INSERT INTO product_details 
(id, price, weight, product_Name, description, manufacturer, in_Stock, active) VALUES
(201, 100, 1.0, 'Product 1', 'Desc 1', 'BrandA', true, true),
(202, 200, 1.1, 'Product 2', 'Desc 2', 'BrandA', true, true),
(203, 300, 1.2, 'Product 3', 'Desc 3', 'BrandA', true, true),
(204, 400, 1.3, 'Product 4', 'Desc 4', 'BrandA', true, true),
(205, 500, 1.4, 'Product 5', 'Desc 5', 'BrandA', true, true),
(206, 600, 1.5, 'Product 6', 'Desc 6', 'BrandB', true, true),
(207, 700, 1.6, 'Product 7', 'Desc 7', 'BrandB', true, true),
(208, 800, 1.7, 'Product 8', 'Desc 8', 'BrandB', true, true),
(209, 900, 1.8, 'Product 9', 'Desc 9', 'BrandB', true, true),
(210, 1000, 1.9, 'Product 10', 'Desc 10', 'BrandB', true, true),
(211, 1100, 2.0, 'Product 11', 'Desc 11', 'BrandC', true, true),
(212, 1200, 2.1, 'Product 12', 'Desc 12', 'BrandC', true, true),
(213, 1300, 2.2, 'Product 13', 'Desc 13', 'BrandC', true, true),
(214, 1400, 2.3, 'Product 14', 'Desc 14', 'BrandC', true, true),
(215, 1500, 2.4, 'Product 15', 'Desc 15', 'BrandC', true, true),
(216, 1600, 2.5, 'Product 16', 'Desc 16', 'BrandD', true, true),
(217, 1700, 2.6, 'Product 17', 'Desc 17', 'BrandD', true, true),
(218, 1800, 2.7, 'Product 18', 'Desc 18', 'BrandD', true, true),
(219, 1900, 2.8, 'Product 19', 'Desc 19', 'BrandD', true, true),
(220, 2000, 2.9, 'Product 20', 'Desc 20', 'BrandD', true, true),
(221, 2100, 3.0, 'Product 21', 'Desc 21', 'BrandE', true, true),
(222, 2200, 3.1, 'Product 22', 'Desc 22', 'BrandE', true, true),
(223, 2300, 3.2, 'Product 23', 'Desc 23', 'BrandE', true, true),
(224, 2400, 3.3, 'Product 24', 'Desc 24', 'BrandE', true, true),
(225, 2500, 3.4, 'Product 25', 'Desc 25', 'BrandE', true, true),
(226, 2600, 3.5, 'Product 26', 'Desc 26', 'BrandF', true, true),
(227, 2700, 3.6, 'Product 27', 'Desc 27', 'BrandF', true, true),
(228, 2800, 3.7, 'Product 28', 'Desc 28', 'BrandF', true, true),
(229, 2900, 3.8, 'Product 29', 'Desc 29', 'BrandF', true, true),
(230, 3000, 3.9, 'Product 30', 'Desc 30', 'BrandF', true, true),
(231, 3100, 4.0, 'Product 31', 'Desc 31', 'BrandG', true, true),
(232, 3200, 4.1, 'Product 32', 'Desc 32', 'BrandG', true, true),
(233, 3300, 4.2, 'Product 33', 'Desc 33', 'BrandG', true, true),
(234, 3400, 4.3, 'Product 34', 'Desc 34', 'BrandG', true, true),
(235, 3500, 4.4, 'Product 35', 'Desc 35', 'BrandG', true, true),
(236, 3600, 4.5, 'Product 36', 'Desc 36', 'BrandH', true, true),
(237, 3700, 4.6, 'Product 37', 'Desc 37', 'BrandH', true, true),
(238, 3800, 4.7, 'Product 38', 'Desc 38', 'BrandH', true, true),
(239, 3900, 4.8, 'Product 39', 'Desc 39', 'BrandH', true, true),
(240, 4000, 4.9, 'Product 40', 'Desc 40', 'BrandH', true, true),
(241, 4100, 5.0, 'Product 41', 'Desc 41', 'BrandI', true, true),
(242, 4200, 5.1, 'Product 42', 'Desc 42', 'BrandI', true, true),
(243, 4300, 5.2, 'Product 43', 'Desc 43', 'BrandI', true, true),
(244, 4400, 5.3, 'Product 44', 'Desc 44', 'BrandI', true, true),
(245, 4500, 5.4, 'Product 45', 'Desc 45', 'BrandI', true, true),
(246, 4600, 5.5, 'Product 46', 'Desc 46', 'BrandJ', true, true),
(247, 4700, 5.6, 'Product 47', 'Desc 47', 'BrandJ', true, true),
(248, 4800, 5.7, 'Product 48', 'Desc 48', 'BrandJ', true, true),
(249, 4900, 5.8, 'Product 49', 'Desc 49', 'BrandJ', true, true),
(250, 5000, 5.9, 'Product 50', 'Desc 50', 'BrandJ', true, true);

INSERT INTO order_details (id, product_Name, order_Date, customer_id) VALUES
(301, 'Order 1', '2025-01-01', 1),
(302, 'Order 2', '2025-01-02', 2),
(303, 'Order 3', '2025-01-03', 3),
(304, 'Order 4', '2025-01-04', 4),
(305, 'Order 5', '2025-01-05', 5),
(306, 'Order 6', '2025-01-06', 6),
(307, 'Order 7', '2025-01-07', 7),
(308, 'Order 8', '2025-01-08', 8),
(309, 'Order 9', '2025-01-09', 9),
(310, 'Order 10', '2025-01-10', 10),
(311, 'Order 11', '2025-01-11', 1),
(312, 'Order 12', '2025-01-12', 2),
(313, 'Order 13', '2025-01-13', 3),
(314, 'Order 14', '2025-01-14', 4),
(315, 'Order 15', '2025-01-15', 5),
(316, 'Order 16', '2025-01-16', 6),
(317, 'Order 17', '2025-01-17', 7),
(318, 'Order 18', '2025-01-18', 8),
(319, 'Order 19', '2025-01-19', 9),
(320, 'Order 20', '2025-01-20', 10);

select * from customer;

truncate product_order ;
truncate order_details;
truncate wallet_account;
truncate address;
delete from customer where 1=1;

;

INSERT INTO customer (id, name) VALUES
(1,'Customer 1'),(2,'Customer 2'),(3,'Customer 3'),(4,'Customer 4'),(5,'Customer 5'),
(6,'Customer 6'),(7,'Customer 7'),(8,'Customer 8'),(9,'Customer 9'),(10,'Customer 10');
