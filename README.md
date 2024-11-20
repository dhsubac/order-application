1. eventstorming

2. 분산트랜잭션 - saga

![image](https://github.com/user-attachments/assets/ac303429-a6d8-4923-b98f-23bc45ee02d6)
![image](https://github.com/user-attachments/assets/7258ab57-ece9-4201-866c-c90de2bd717d)
![image](https://github.com/user-attachments/assets/ee969215-8028-4ab6-a3df-93e0e0450bf4)
1번 메뉴 재고 77개
![image](https://github.com/user-attachments/assets/ea40885e-6a51-4981-a00e-f063d7e41e1d)
1번 메뉴 7개 주문
![image](https://github.com/user-attachments/assets/464fb5b0-dc38-427e-9159-5b1879077d5f)
1번 메뉴 재고 70개
![image](https://github.com/user-attachments/assets/4e70d3ee-e700-495f-bbcc-72b0c0d84ced)
취소 진행
![image](https://github.com/user-attachments/assets/18194571-3096-4ed0-b0e5-b7bbc472a3ea)
재고 복구 과정 확인


4. 보상처리 - compensation
5. 단일 진입점 - gateway
6. 분산 데이터 프로젝션 - cgrs

7. 

# 

## Model
www.msaez.io/#/188553504/storming/order-application

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- order
- counter
- coupon
- delivery


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- order
```
 http :8088/orders id="id" customerId="customerId" menuId="menuId" price="price" 
```
- counter
```
 http :8088/inventories id="id" menuId="menuId" qty="qty" 
```
- coupon
```
```
- delivery
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

