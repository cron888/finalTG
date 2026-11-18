-- Sample users
INSERT INTO user_entity (id, username, first_name, last_name) VALUES (1, 'ivanov', 'Иван', 'Иванов');
INSERT INTO user_entity (id, username, first_name, last_name) VALUES (2, 'petrova', 'Петр', 'Петров');
INSERT INTO user_entity (id, username, first_name, last_name) VALUES (3, 'sidorova', 'Мария', 'Сидорова');

-- Sample products
INSERT INTO product_entity (id, name, description, category, price) VALUES (1, 'Ноутбук Pro', 'Мощный ноутбук для работы', 'electronics', 89990);
INSERT INTO product_entity (id, name, description, category, price) VALUES (2, 'Смартфон X', 'Последний смартфон', 'electronics', 59990);
INSERT INTO product_entity (id, name, description, category, price) VALUES (3, 'Книга по Java', 'Изучение Java 17', 'books', 1290);
INSERT INTO product_entity (id, name, description, category, price) VALUES (4, 'Наушники Bass', 'Беспроводные наушники', 'electronics', 7990);
INSERT INTO product_entity (id, name, description, category, price) VALUES (5, 'Учебник по Spring', 'Spring Boot в примерах', 'books', 2490);

-- Sample recommendation rules
INSERT INTO recommendation_rule (id, name, description, rule_type, condition, is_active, priority) VALUES (1, 'Electronics Fan', 'Рекомендует электронику для любителей техники', 'CATEGORY_MATCH', '{"categories": ["electronics"]}', true, 10);
INSERT INTO recommendation_rule (id, name, description, rule_type, condition, is_active, priority) VALUES (2, 'Book Lover', 'Рекомендует книги для читателей', 'CATEGORY_MATCH', '{"categories": ["books"]}', true, 5);
INSERT INTO recommendation_rule (id, name, description, rule_type, condition, is_active, priority) VALUES (3, 'Premium Products', 'Рекомендует дорогие товары', 'PRICE_RANGE', '{"minPrice": 50000}', true, 1);
