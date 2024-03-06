## Bonus message

```json
{
  "bonusType": "WelcomeBonus",
  "bonusCode": "WELCOME2023",
  "bonusAmount": "100",
  "bonusCurrency": "USD",
  "extraDetails": {
    "extraDetails1": "First deposit bonus",
    "extraDetails2": "Valid until 31/12/2023",
    "extraDetails3": "Applies to new users only"
  }
}
```



### Run Just Kafka services
```bash
docker-compose -f docker-compose.kafka.yml up -d
```

Kafka can be accessed at `localhost:9092`, also available via the Kafka UI at http://localhost:8080/.
