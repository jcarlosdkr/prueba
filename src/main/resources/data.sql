INSERT INTO tbl_accounts 
    (account, balance, owner, fecha) 
    VALUES 
    (123456789, 45450, 7612333392, {ts '2012-04-21 12:37:22.14526'}),
    (987654321, 52465, 7612333458, {ts '2012-04-21 18:25:43.51125'}),
    (13456658, 32442, 761233785, {ts '2012-04-23 08:09:11.51111'});


INSERT INTO tbl_transfers
    (from_account, to_account, amount, date_at)
    VALUES
    (123456789, 987654321, 17600.30, {ts '2022-07-10 18:47:52.12458'}),
    (987654321, 13456658, 928.21, {ts '2022-08-10 09:14:22.12458'}),
    (13456658, 123456789, 10928.32, {ts '2022-09-10 12:53:11.12458'});