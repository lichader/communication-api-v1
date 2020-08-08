Create deployment in k8s

```
kubectl create deployment communication-api-v1-deployment --image=lichader/communication-api-v1
```

Run a troubleshooting shell

```
kubectl run my-shell --rm -i --tty --image ubuntu -- bash
```

Expose a rs

```
kubectl expose rs commsapi-7d9dd99864 --port=8081 --target-port=8081
```

Scale up 

```
kubectl scale --replicas=3 deployment commsapi
```