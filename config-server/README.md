# Serwer centralnej konfiguracji

Aplikacja udostępnia konfiguracje usług systemu szkolnego za pomocą Spring
Cloud Config Server. Pliki konfiguracyjne są pobierane z repozytorium Git:

`https://github.com/SergoMrazzz/school-config-repo`

Serwer działa na porcie `8888`. Podczas uruchamiania klonuje repozytorium, a
etykietą domyślną jest gałąź `main`.

## Wymagania

- Java 21
- Dostęp do Internetu podczas pierwszego uruchomienia (pobranie Maven i
  sklonowanie repozytorium konfiguracji)

Maven Wrapper pobierze wskazaną wersję Maven przy pierwszym użyciu.

## Budowanie

W katalogu `config-server` uruchom w Windows:

```powershell
.\mvnw.cmd clean package
```

## Uruchamianie

```powershell
.\mvnw.cmd spring-boot:run
```

Po uruchomieniu konfiguracje usług są dostępne m.in. pod adresami:

- <http://localhost:8888/attendance-service/default>
- <http://localhost:8888/grade-service/default>

W odpowiedziach znajdują się właściwości z plików usług oraz wspólne
właściwości z `application.yml` w repozytorium konfiguracji.
