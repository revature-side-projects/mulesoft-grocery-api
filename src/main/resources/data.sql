INSERT INTO customer (customer_id, customer_name) VALUES (
    '844c5cdf-414b-4d25-82ad-133c07cd489d',
    'Tammy Escritt'
), (
    '2d033560-2172-4839-b7c0-ef2334d72f4b',
    'Niles Gaynes'
), (
    '2dbb7526-8d74-413c-a2fe-740e569e49c5',
    'Mick Brundell'
), (
    '6403dcd4-472a-4877-b85d-444f4c1d6640',
    'Silvain Genney'
);

INSERT INTO product (product_id, product_name, price) VALUES (
    'd026461e-2635-4e42-9823-f54945474fa1',
    'Bread - Ciabatta Buns',
    10.46
), (
    '2c500979-06b1-415e-a850-880245cb2c39',
    'Tuna - Canned, Flaked, Light',
    12.34
), (
    '98d10fce-6f44-4a66-a0f9-8f35cd06db37',
    'Pastry - Banana Muffin - Mini',
    3.80
);

INSERT INTO transactions (payment_txn_id, payment_type, payment_txn_success, customer_id) VALUES (
    '446bd280-cd90-49ad-8a3e-b3c413bd4f9a',
    'mastercard',
    true,
    '844c5cdf-414b-4d25-82ad-133c07cd489d'
), (
    '581bdc9c-0dd9-4db6-a39f-3b5bb0a57b0c',
    null,
    false,
    '6403dcd4-472a-4877-b85d-444f4c1d6640'
);

INSERT INTO orders (order_id, product_id, qty, datetime, store_id, txn_id) VALUES (
    '628d2c2dfc13ae30e40010b1',
    'd026461e-2635-4e42-9823-f54945474fa1',
    6,
    CURRENT_DATE,
    3,
    '446bd280-cd90-49ad-8a3e-b3c413bd4f9a'
), (
    '628d2c2dfc13ae30e40010bf',
    '2c500979-06b1-415e-a850-880245cb2c39',
    3,
    CURRENT_DATE,
    2,
    '446bd280-cd90-49ad-8a3e-b3c413bd4f9a'
), (
    '628d2c2dfc13ae30e4001097',
    '98d10fce-6f44-4a66-a0f9-8f35cd06db37',
    3,
    CURRENT_DATE,
    3,
    '581bdc9c-0dd9-4db6-a39f-3b5bb0a57b0c'
);