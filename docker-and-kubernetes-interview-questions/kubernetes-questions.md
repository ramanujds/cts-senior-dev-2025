

### Kubernetes Questions

1. **What is Kubernetes and its main purpose?**  
   *Hint:* Orchestration platform for containerized applications; automates deployment, scaling, and management.

2. **Explain a Kubernetes Pod.**  
   *Hint:* Smallest deployable unit in Kubernetes; can contain one or more containers.

3. **Difference between ReplicaSet and Deployment?**  
   *Hint:* ReplicaSet ensures desired pod count; Deployment adds version control and rollout features.

4. **What is a Kubernetes Service and why is it needed?**  
   *Hint:* Abstracts a set of pods, enabling stable networking regardless of pod restarts.

5. **Difference between ClusterIP, NodePort, and LoadBalancer services?**  
   *Hint:* ClusterIP (internal), NodePort (external via node port), LoadBalancer (external via cloud LB).

6. **What are ConfigMaps and Secrets?**  
   *Hint:* ConfigMaps store non-sensitive configs; Secrets store sensitive data (base64 encoded).

7. **Explain the role of kubelet.**  
   *Hint:* Agent that runs on each node, manages pods, communicates with API server.

8. **What is a Namespace in Kubernetes and why use it?**  
   *Hint:* Logical cluster segmentation for resource scoping and isolation.

9. **How to roll back a deployment in Kubernetes?**  
   *Hint:* Use `kubectl rollout undo deployment <name>`.

10. **Difference between StatefulSet and Deployment?**  
    *Hint:* StatefulSet maintains sticky identity and storage for pods; Deployment is stateless.


- **How do you troubleshoot a Kubernetes Pod stuck in CrashLoopBackOff?**  
  *Hint:* Check pod logs, describe pod with `kubectl describe`, and look for missing configurations or dependencies.

- **What is a Persistent Volume (PV) and Persistent Volume Claim (PVC)?**  
  *Hint:* PV is a piece of storage in the cluster; PVC is a request for storage by a user.

- **How do you scale a deployment in Kubernetes?**  
  *Hint:* Use `kubectl scale deployment <name> --replicas=N`.

- **What are liveness and readiness probes?**  
  *Hint:* Liveness probe checks if the container is alive; readiness probe checks if it can accept traffic.

- **How do you implement blue-green deployment in Kubernetes?**  
  *Hint:* Deploy two environments (blue/green) and switch traffic using Services once new version passes health checks.

- **What is a DaemonSet? Give a use case.**  
  *Hint:* Ensures a pod runs on all nodes; example: logging or monitoring agents.

- **How would you handle resource exhaustion in a Kubernetes cluster?**  
  *Hint:* Use monitoring tools to identify resource hogs, adjust resource limits/requests, and scale cluster or reduce workload as needed.

- **How do you use ConfigMaps and Secrets in a Deployment?**  
  *Hint:* Mount as environment variables or volumes in pod spec.

- **What are common challenges in Kubernetes deployments?**  
  *Hint:* Image pull errors, resource limits, misconfigured service or ingress, RBAC misconfigurations.

- **How do you monitor and log applications in Kubernetes?**  
  *Hint:* Use tools like Prometheus and Grafana for monitoring; Fluentd or ELK stack for centralized logging.


### Scenario-Based & Troubleshooting Questions

- **A container is consuming excessive memory and crashing others. What is your approach?**  
  *Hint:* Monitor using `docker stats`, and set resource limits for containers.

- **Multiple services in the cluster are failing at once. What do you check first?**  
  *Hint:* Investigate cluster-wide issues: node health, resource limits, logs, network, kube-apiserver status.

- **How would you migrate a container to a new Docker host?**  
  *Hint:* Use `docker export`/`import` or rebuild the image from the Dockerfile on the new host.

- **A pod is successfully running but cannot reach an external database. Explain how you’d debug.**  
  *Hint:* Check network policies, service endpoints, DNS resolution, and firewall rules.

- **You need to perform a rollback to a previous Kubernetes deployment version. What do you do?**  
  *Hint:* Use `kubectl rollout undo deployment <name>`.

- **Kubernetes Pod is running but not serving traffic, what do you check?**  
  *Hint:* Readiness probe, service selector, endpoints, and application logs.

- **How would you handle storing sensitive environment variables needed by containers?**  
  *Hint:* Use Kubernetes Secrets, not plain ConfigMaps or hardcoded values.
