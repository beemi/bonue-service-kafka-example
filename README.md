## Bonus message

```json
{
  "bonusType": "WelcomeBonus",
  "bonusCode": "WELCOME2023",
  "bonusStatus": "ACTIVE",
  "bonusAmount": "200",
  "bonusCurrency": "USD",
  "createdAt": "2023-01-01T00:00:00Z",
  "lastModifiedTime": "2023-02-01T00:00:00Z",
  "extraDetails": {
    "extraDetails1": "First deposit bonus",
    "extraDetails2": "Valid until 31/12/2023",
    "extraDetails3": "Applies to new users only"
  }
}
```

### Run Just Kafka services
delete orphan docker containers
```Bash
docker-compose down --remove-orphans
```


```bash
docker-compose -f docker-compose.kafka.yml up -d
```

Kafka can be accessed at `localhost:9092`, also available via the Kafka UI at http://localhost:8080/.
