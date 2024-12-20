eventstorming
--------------
![image](https://github.com/user-attachments/assets/af981cec-e871-4e92-a27f-ffb5f63139d4)   
order application(ex 커피 어플)

Pipeline 구조   
--------------
![image](https://github.com/user-attachments/assets/23c471c2-c69e-406b-be0c-cadf0dfb4f7b)    


분산트랜잭션 - saga & 보상처리 - compensation
--------------
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


분산 데이터 프로젝션 - CQRS
--------------
![image](https://github.com/user-attachments/assets/8e38458a-8e6f-4ddf-a8ca-a34409bd2b4f)   



컨테이너 자동확장 - HPA
--------------
![image](https://github.com/user-attachments/assets/c4ff2f77-a33e-4606-bf90-aaa796794ed7)
![image](https://github.com/user-attachments/assets/328ad850-3c72-427e-96b8-429019b686c0)

![image](https://github.com/user-attachments/assets/15848ca4-8678-4926-a704-e6e3567d9ab0)

오토스케일 된 것 확인 가능

configMap
--------------
![image](https://github.com/user-attachments/assets/77a30eba-5353-41f3-8798-1b836c270a3c)

configMap 객체 생성

PVC
--------------

![image](https://github.com/user-attachments/assets/f81696a1-5d5c-42f2-a144-e6a209012d89)   

emptyDir Volume 생성   
![image](https://github.com/user-attachments/assets/a3ebbf86-233c-4aec-8eee-6e627a898d06)   

![image](https://github.com/user-attachments/assets/89432993-a9bc-4419-b685-3ebc0ccc1863)   

PVC 생성   

![image](https://github.com/user-attachments/assets/aa77ea68-bd6b-4247-bdf5-e4b08d0a3a84)   

1번 컨테이너 리소스 생성 -> 2번 컨테이너에서 리소스 확인   

liveness probe(셀프 힐링/무정지배포)
--------------
![image](https://github.com/user-attachments/assets/0ae48233-38fe-4ee8-ae9d-fa21994b747b)   

liveness probe 설정   

![image](https://github.com/user-attachments/assets/c06f6e0d-2389-475e-9cdd-5a656796ea07)   

pod killing 후 restart 확인   

service mesh
--------------
istio   
![image](https://github.com/user-attachments/assets/ca5b3d02-2ae9-4e24-abb3-7563f28be679)   

![image](https://github.com/user-attachments/assets/abf79484-6172-404f-85d9-b9ca4f63f690)   

sidecar inject 추가   

loggeration with LOKI stack   
--------------
![image](https://github.com/user-attachments/assets/6c3b1412-c297-4805-b488-933284ab0440)    
PLG 스택 사용하도록 loki-stack-values.yaml 수정   
grafana 실행 후 접속   
![image](https://github.com/user-attachments/assets/53feec97-0a78-4eac-861e-a407d58f94ae)   
Loki datasource 확인   

![image](https://github.com/user-attachments/assets/506188ca-f6a5-4973-a2fa-5d6c8237850e)   
log 확인 가능   

Cloud 배포 - 컨테이너 운영
---------------
azure devops 사용   
CI   
![image](https://github.com/user-attachments/assets/506e879c-2c0c-4f00-a7c3-ce74f97f940c)   
![image](https://github.com/user-attachments/assets/0a2a444b-fde5-408d-a37a-3eb8326da53f)   

CD   
![image](https://github.com/user-attachments/assets/1885fb2d-d47d-4501-a202-ce3574c9e8b4)   


![image](https://github.com/user-attachments/assets/8513548d-8d68-4876-b0ac-803036fc1fda)   
새로운 pod가 배포되었음이 확인됨.





  



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

