docker run -d
--name rabbit-server
-p 5672:5672
-p 15672:15672
-e RABBITMQ_DEFAULT_PASS=guest
-e RABBITMQ_DEFAULT_USER=guest
rabbitmq:3.13-management
