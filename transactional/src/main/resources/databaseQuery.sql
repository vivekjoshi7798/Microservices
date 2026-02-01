use bandb;
show databases;
commit;
show tables;

desc accounts;
select * from accounts;
INSERT INTO accounts (
    account_holder_name, account_number, account_type, balance,
    branch_code, created_at, currency, ifsc_code,
    kyc_completed, status, updated_at
) VALUES
('Anjali Verma', '1f3d9a20-6b11-4c9c-8a2b-5f4e9c12a111', 'CURRENT', 12500.00, 'BR002', NOW(6), 'INR', 'HDFC0005678', b'1', 'ACTIVE', NOW(6)),
('Vikram Singh', '7b2e4c91-0f33-4c1a-9f7e-88ad21bc2222', 'SALARY', 30000.50, 'BR003', NOW(6), 'INR', 'ICIC0003344', b'1', 'ACTIVE', NOW(6)),
('Priya Nair', '2c9fa0d2-55ab-4f4f-8e1a-9c7bd9ef3333', 'SAVINGS', 8500.00, 'BR004', NOW(6), 'INR', 'AXIS0007788', b'0', 'INACTIVE', NOW(6)),
('User 1',  'acc-0001-uuid', 'SAVINGS', 1000.00, 'BR001', NOW(6), 'INR', 'SBIN0000001', b'1', 'ACTIVE', NOW(6)),
('User 2',  'acc-0002-uuid', 'CURRENT', 2000.00, 'BR002', NOW(6), 'INR', 'SBIN0000002', b'1', 'ACTIVE', NOW(6)),
('User 3',  'acc-0003-uuid', 'SALARY', 3000.00, 'BR003', NOW(6), 'INR', 'SBIN0000003', b'0', 'INACTIVE', NOW(6)),
('User 4',  'acc-0004-uuid', 'SAVINGS', 4000.00, 'BR004', NOW(6), 'INR', 'SBIN0000004', b'1', 'ACTIVE', NOW(6)),
('User 5',  'acc-0005-uuid', 'CURRENT', 5000.00, 'BR005', NOW(6), 'INR', 'SBIN0000005', b'1', 'ACTIVE', NOW(6)),
('User 6',  'acc-0006-uuid', 'SALARY', 6000.00, 'BR006', NOW(6), 'INR', 'SBIN0000006', b'0', 'ACTIVE', NOW(6)),
('User 7',  'acc-0007-uuid', 'SAVINGS', 7000.00, 'BR007', NOW(6), 'INR', 'SBIN0000007', b'1', 'ACTIVE', NOW(6)),
('User 8',  'acc-0008-uuid', 'CURRENT', 8000.00, 'BR008', NOW(6), 'INR', 'SBIN0000008', b'1', 'ACTIVE', NOW(6)),
('User 9',  'acc-0009-uuid', 'SALARY', 9000.00, 'BR009', NOW(6), 'INR', 'SBIN0000009', b'0', 'INACTIVE', NOW(6)),
('User 10', 'acc-0010-uuid', 'SAVINGS', 10000.00, 'BR010', NOW(6), 'INR', 'SBIN0000010', b'1', 'ACTIVE', NOW(6)),

('User 11', 'acc-0011-uuid', 'CURRENT', 11000.00, 'BR011', NOW(6), 'INR', 'SBIN0000011', b'1', 'ACTIVE', NOW(6)),
('User 12', 'acc-0012-uuid', 'SALARY', 12000.00, 'BR012', NOW(6), 'INR', 'SBIN0000012', b'0', 'ACTIVE', NOW(6)),
('User 13', 'acc-0013-uuid', 'SAVINGS', 13000.00, 'BR013', NOW(6), 'INR', 'SBIN0000013', b'1', 'ACTIVE', NOW(6)),
('User 14', 'acc-0014-uuid', 'CURRENT', 14000.00, 'BR014', NOW(6), 'INR', 'SBIN0000014', b'1', 'ACTIVE', NOW(6)),
('User 15', 'acc-0015-uuid', 'SALARY', 15000.00, 'BR015', NOW(6), 'INR', 'SBIN0000015', b'0', 'INACTIVE', NOW(6)),
('User 16', 'acc-0016-uuid', 'SAVINGS', 16000.00, 'BR016', NOW(6), 'INR', 'SBIN0000016', b'1', 'ACTIVE', NOW(6)),
('User 17', 'acc-0017-uuid', 'CURRENT', 17000.00, 'BR017', NOW(6), 'INR', 'SBIN0000017', b'1', 'ACTIVE', NOW(6)),
('User 18', 'acc-0018-uuid', 'SALARY', 18000.00, 'BR018', NOW(6), 'INR', 'SBIN0000018', b'0', 'ACTIVE', NOW(6)),
('User 19', 'acc-0019-uuid', 'SAVINGS', 19000.00, 'BR019', NOW(6), 'INR', 'SBIN0000019', b'1', 'ACTIVE', NOW(6)),
('User 20', 'acc-0020-uuid', 'CURRENT', 20000.00, 'BR020', NOW(6), 'INR', 'SBIN0000020', b'1', 'ACTIVE', NOW(6)),

('User 21', 'acc-0021-uuid', 'SALARY', 21000.00, 'BR021', NOW(6), 'INR', 'SBIN0000021', b'0', 'INACTIVE', NOW(6)),
('User 22', 'acc-0022-uuid', 'SAVINGS', 22000.00, 'BR022', NOW(6), 'INR', 'SBIN0000022', b'1', 'ACTIVE', NOW(6)),
('User 23', 'acc-0023-uuid', 'CURRENT', 23000.00, 'BR023', NOW(6), 'INR', 'SBIN0000023', b'1', 'ACTIVE', NOW(6)),
('User 24', 'acc-0024-uuid', 'SALARY', 24000.00, 'BR024', NOW(6), 'INR', 'SBIN0000024', b'0', 'ACTIVE', NOW(6)),
('User 25', 'acc-0025-uuid', 'SAVINGS', 25000.00, 'BR025', NOW(6), 'INR', 'SBIN0000025', b'1', 'ACTIVE', NOW(6)),
('User 26', 'acc-0026-uuid', 'CURRENT', 26000.00, 'BR026', NOW(6), 'INR', 'SBIN0000026', b'1', 'ACTIVE', NOW(6)),
('User 27', 'acc-0027-uuid', 'SALARY', 27000.00, 'BR027', NOW(6), 'INR', 'SBIN0000027', b'0', 'INACTIVE', NOW(6)),
('User 28', 'acc-0028-uuid', 'SAVINGS', 28000.00, 'BR028', NOW(6), 'INR', 'SBIN0000028', b'1', 'ACTIVE', NOW(6)),
('User 29', 'acc-0029-uuid', 'CURRENT', 29000.00, 'BR029', NOW(6), 'INR', 'SBIN0000029', b'1', 'ACTIVE', NOW(6)),
('User 30', 'acc-0030-uuid', 'SALARY', 30000.00, 'BR030', NOW(6), 'INR', 'SBIN0000030', b'0', 'ACTIVE', NOW(6)),


('User 91', 'acc-0091-uuid', 'SAVINGS', 91000.00, 'BR091', NOW(6), 'INR', 'SBIN0000091', b'1', 'ACTIVE', NOW(6)),
('User 92', 'acc-0092-uuid', 'CURRENT', 92000.00, 'BR092', NOW(6), 'INR', 'SBIN0000092', b'1', 'ACTIVE', NOW(6)),
('User 93', 'acc-0093-uuid', 'SALARY', 93000.00, 'BR093', NOW(6), 'INR', 'SBIN0000093', b'0', 'INACTIVE', NOW(6)),
('User 94', 'acc-0094-uuid', 'SAVINGS', 94000.00, 'BR094', NOW(6), 'INR', 'SBIN0000094', b'1', 'ACTIVE', NOW(6)),
('User 95', 'acc-0095-uuid', 'CURRENT', 95000.00, 'BR095', NOW(6), 'INR', 'SBIN0000095', b'1', 'ACTIVE', NOW(6)),
('User 96', 'acc-0096-uuid', 'SALARY', 96000.00, 'BR096', NOW(6), 'INR', 'SBIN0000096', b'0', 'ACTIVE', NOW(6)),
('User 97', 'acc-0097-uuid', 'SAVINGS', 97000.00, 'BR097', NOW(6), 'INR', 'SBIN0000097', b'1', 'ACTIVE', NOW(6)),
('User 98', 'acc-0098-uuid', 'CURRENT', 98000.00, 'BR098', NOW(6), 'INR', 'SBIN0000098', b'1', 'ACTIVE', NOW(6)),
('User 99', 'acc-0099-uuid', 'SALARY', 99000.00, 'BR099', NOW(6), 'INR', 'SBIN0000099', b'0', 'INACTIVE', NOW(6)),
('User 100','acc-0100-uuid', 'SAVINGS',100000.00,'BR100', NOW(6), 'INR', 'SBIN0000100', b'1', 'ACTIVE', NOW(6));


commit;