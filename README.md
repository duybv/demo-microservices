# demo-microservices
# install rabbitmq on ubuntu
sudo apt-get update
sudo apt-get upgrade
sudo apt-get install erlang
sudo apt-get install rabbitmq-server

sudo systemctl enable rabbitmq-server
sudo systemctl start rabbitmq-server
sudo systemctl status rabbitmq-serv
sudo rabbitmq-plugins enable rabbitmq_management

sudo rabbitmqctl add_user admin admin
sudo rabbitmqctl set_user_tags admin administrator
sudo rabbitmqctl set_permissions -p / admin ".*" ".*" ".*"
