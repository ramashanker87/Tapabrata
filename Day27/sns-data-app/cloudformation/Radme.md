## Create Docker image
```Bash
    docker build -t parking-app .
```
## Create ECR for parking 

```Bash
    aws cloudformation deploy --template-file 1-parking-ecr-template.yml --stack-name rama-parking-ecr-repo 
```
### Login to ECR (for Docker):

```Bash
    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com
```
### Tag Image with ECR Repository URL:
```Bash
    docker tag parking-app:latest 975050323630.dkr.ecr.us-east-1.amazonaws.com/rama-parking-app:latest
```
### Push images:
```Bash
    docker push 975050323630.dkr.ecr.us-east-1.amazonaws.com/rama-parking-app
```
### Create VPC Networking(Created only once)
```Bash
    aws cloudformation deploy --template-file 2-vpc-networking.yml --stack-name vpc-network
```
### Create Load Balancer and integrate with VPC
```Bash
    aws cloudformation deploy --template-file 3-1-load-balancer.yml --stack-name rama-load-balancer
```
### Create Security Group
```Bash
    aws cloudformation deploy --template-file 3-2-security-groups.yml --stack-name rama-security-group
```
## Create SNS Topic with sqs subscriber
```Bash
    aws cloudformation deploy --template-file 4-create-sns-sqs-subscribe.yml --stack-name rama-sns-sqs-topic
```
## Create ECS Cluster infra
```Bash
    aws cloudformation deploy --template-file 5-ecs-cluster.yml --stack-name rama-ecs-parking-cluster --capabilities CAPABILITY_NAMED_IAM 
```
## Create ECS Service and Task infra
```Bash
    aws cloudformation deploy --template-file 6-ecs-service-task.yml  --stack-name rama-ecs-service-task-parking --capabilities CAPABILITY_NAMED_IAM 
```
## Start Parking
```Bash
    curl --location 'http://MicroserviceALB-423438268.us-east-1.elb.amazonaws.com/start/parking' \
    --header 'sessionid: sessionid-1' \
    --header 'Content-Type: application/json' \
    --data '{
    "carRegNo": "car1",
    "parkingNo":"park1",
    "parkingStatus":"start"
    }
    '
```