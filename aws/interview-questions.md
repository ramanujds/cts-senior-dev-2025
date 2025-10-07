## **1. IAM (Identity & Access Management)**


1. **What is IAM in AWS and why is it used?**
   → To manage access to AWS resources securely using users, groups, roles, and policies.

2. **Difference between IAM user and IAM role.**
   → Users are for long-term credentials; roles are for temporary access (assumed by users or services).

3. **What are IAM policies and their types?**
   → JSON documents defining permissions. Types: Managed (AWS or Customer) and Inline policies.

4. **What is the principle of least privilege?**
   → Grant only the minimum permissions required to perform a task.

5. **What’s the difference between AWS Managed Policy and Customer Managed Policy?**
   → AWS managed = maintained by AWS; Customer managed = you define them yourself for flexibility.

6. **What is a trust policy vs permission policy?**
   → Trust policy defines *who* can assume a role; permission policy defines *what* the role can do.

7. **Scenario:**
   Your EC2 instance needs access to S3. Should you use access keys or IAM role? Why?
   → IAM Role, because it provides temporary credentials and eliminates manual key management.

8. **How do you allow cross-account access in AWS?**
   → By creating a role in Account B and adding a trust policy that allows Account A to assume it.



## **2. EC2**


1. **What is EC2 and what are its main features?**
   → Resizable compute capacity in the cloud with options for OS, storage, networking, scaling, etc.

2. **Difference between On-Demand, Reserved, and Spot Instances.**

3. **What’s an AMI (Amazon Machine Image)?**

4. **How do you connect to an EC2 instance securely?**

5. **What are Security Groups and NACLs?**
   → SG = instance-level firewall (stateful), NACL = subnet-level (stateless).

6. **Scenario:**
   You can ping your EC2 instance but can’t SSH into it. What could be wrong?
   → Check inbound rules, key pair, or network ACL blocking port 22.

7. **What is an EC2 Instance Role and why use it?**

8. **Explain EBS vs Instance Store.**

9. **How does Auto Scaling work with Load Balancer?**

10. **What’s the difference between EC2 placement groups — Cluster, Spread, Partition?**


## **3. S3**

1. **What is S3 and what are its storage classes?**

2. **What is an S3 bucket and object?**

3. **What are bucket policies and ACLs?**

4. **Explain S3 Versioning and its benefits.**

5. **What’s the difference between SSE-S3, SSE-KMS, and SSE-C (Encryption types)?**

6. **How does S3 Cross-Region Replication (CRR) work?**

7. **Scenario:**
   Your S3 bucket shows `Access Denied` even after attaching S3FullAccess to the user. Why?
   → Bucket policy may explicitly deny access or Block Public Access is turned on.

8. **What’s the difference between S3 Standard and S3 Glacier Deep Archive?**


## **4. VPC**

1. **What is a VPC in AWS?**

2. **What are subnets and their types?**

3. **What’s the difference between Public and Private subnets?**

4. **What is an Internet Gateway?**

5. **Explain Route Table in VPC.**

6. **What’s a NAT Gateway and how is it different from Internet Gateway?**

7. **Scenario:**
   You can SSH into public subnet EC2 but not private subnet EC2. How do you fix it?
   → Use a bastion host or NAT gateway for outbound access.

8. **Explain VPC Peering and its limitations.**

9. **What is AWS Transit Gateway?**

10. **Explain how you can connect on-premises data center to AWS (VPN, Direct Connect).**

---

## **5. AWS Lambda & Serverless**


1. **What is AWS Lambda and how is it billed?**
   → Charged by number of requests and compute time (GB-seconds).

2. **What are Lambda triggers and destinations?**

3. **What’s the maximum timeout for a Lambda function?**

4. **How do you give a Lambda access to S3 or DynamoDB?**
   → By attaching an IAM execution role with appropriate permissions.

5. **Explain cold start in Lambda.**

6. **Scenario:**
   Your Lambda function is timing out when accessing an RDS in private subnet. Why?
   → Lambda needs VPC configuration + NAT gateway for outbound access.

---

## **6. RDS**

1. **What is RDS and what databases does it support?**

2. **Difference between RDS and Aurora.**

3. **How do Multi-AZ and Read Replica differ?**

4. **Scenario:**
   Your RDS instance is slow. What metrics would you check?
   → CPUUtilization, ReadIOPS, WriteIOPS, DBConnections, FreeableMemory, etc.

5. **Can you access RDS from the Internet? How?**

6. **How does automatic backup and snapshot differ in RDS?**


## **7. Load Balancing & Scaling**

1. **What are types of Elastic Load Balancers (ELB)?**

2. **Difference between Application Load Balancer and Network Load Balancer.**

3. **What is Auto Scaling Group (ASG)?**

4. **How does health check work in ALB?**

5. **Scenario:**
   Your ALB shows unhealthy instances. What could be wrong?
   → Wrong target group port, health check path misconfigured, app not responding with 200.


## **8. Monitoring, Logging, and Security**

1. **What is CloudWatch used for?**
2. **Difference between CloudWatch and CloudTrail.**
3. **How does AWS Config help in auditing?**
4. **What is GuardDuty?**
5. **How do you enable centralized logging for all accounts?**



## **9. For Solution Architects**

1. **Design a fault-tolerant web app using EC2, RDS, and S3.**
2. **How would you make a system multi-region?**
3. **Your web app needs static hosting + API backend + DB. Which AWS services would you use?**
   → S3 + CloudFront + API Gateway + Lambda + DynamoDB.
4. **How would you handle user authentication for a mobile app?**
   → Use Amazon Cognito for identity and token-based auth.
5. **You have millions of IoT devices sending data every second. How do you handle ingestion?**
   → Use Kinesis Data Streams or Firehose + Lambda + S3.


