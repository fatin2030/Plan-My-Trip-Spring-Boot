INSERT INTO role ( role_name)
VALUES
    ( 'ADMIN'),
    ('USER'),
    ( 'MANAGER'),
    ( 'SUPERVISOR'),
    ('EMPLOYEE')
ON CONFLICT (role_name) DO NOTHING;