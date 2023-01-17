# azure-relativity
Simple Spring Web Application

URL: https://relativity-proj-sledzp.azurewebsites.net/dashboard

Uproszczony schemat wykorzystanych komponentów:
![alt app diagram](https://github.com/patryk0504/azure-relativity/blob/master/azure-app-diagram.png)

Wykorzystane narzedzia:
- autoryzacja z wykorzystaniem Azure AD + customowy formularz rejestracji (sign-up workflow)
- github actions CI/CD z uruchamianymi testami + customowy plikiem deploymentu
- alert (na mail grupy) -> /error endpoint
- Azure CosmosDB
- Azure Function -> /function
- App Insights - dzialaja, mozna przegladać komponenty aplikacji (problem z integracją z CosmosDB)
