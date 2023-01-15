# azure-relativity
Simple Spring Web Application

URL: https://relativity-proj-sledzp.azurewebsites.net/dashboard

Wykorzystane narzedzia:
- autoryzacja z wykorzystaniem Azure AD + customowy formularz rejestracji (sign-up workflow)
- github actions CI/CD z uruchamianymi testami + customowy plikiem deploymentu
- alert (na mail grupy) -> /error endpoint
- Azure CosmosDB
- Azure Function -> /function
- App Insights - dzialaja, mozna przegladać komponenty aplikacji (problem z integracją z CosmosDB)
