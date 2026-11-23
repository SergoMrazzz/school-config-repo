# Centralna konfiguracja systemu szkolnego

Repozytorium zawiera pliki konfiguracyjne dla wariantu **System Szkolny**
realizowanego w ramach przedmiotu „Systemy rozproszone – Wdrożenie Centralnej
Konfiguracji w Spring Cloud”.

Pliki zapisane w formacie YAML mogą być udostępniane usługom przez Spring Cloud
Config Server. `application.yml` zawiera ustawienia wspólne dla aplikacji,
a pozostałe pliki przechowują ustawienia właściwe dla usług. Nazwy plików
odpowiadają nazwom aplikacji klienckich, np. `student-service.yml` dla
`student-service`.

## Pliki konfiguracyjne

- `application.yml` – nazwa szkoły i rok szkolny.
- `student-service.yml` – minimalny wiek ucznia i maksymalna liczebność klasy.
- `grade-service.yml` – minimalna ocena zaliczająca i waga egzaminu.
- `schedule-service.yml` – czas trwania lekcji i przerwy.
- `attendance-service.yml` – minimalna frekwencja i limit spóźnień.
- `fee-service.yml` – cena obiadu, opłata za zajęcia dodatkowe i waluta.

Właściwości są zapisane hierarchicznie pod wspólnym prefiksem `school`.
