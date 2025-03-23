# Country City Explorer App
## Building a Country & City Explorer App using REST API, Clean Architecture & MVI 

Explorer App is an Android application that allows users to browse countries, states, and cities interactively. The app follows Clean Architecture principles and utilizes Jetpack Compose for UI development. It includes features such as dark mode support, seamless navigation, and efficient API handling with Coroutines and Flow.

## Features

- Country List Screen: Displays a list of countries fetched from an API.
- State List Screen: Shows states for a selected country.
- City List Screen: Displays cities within a selected state.
- Navigation: Implements seamless navigation between screens.
- Dark Mode Support: Users can toggle between light and dark themes using MaterialTheme.
- Clean Architecture: Divided into Data, Domain, and Presentation layers.
- API Handling: Uses Retrofit for network requests.
- State Management: Implements StateFlow and LiveData for efficient data handling.

## Technologies Used

- Kotlin
- Jetpack Compose
- Material3
- Retrofit
- Coroutines & Flow
-Navigation Component


## API

https://countriesnow.space/api/v0.1/


## API Endpoints

- GET /countries - Fetches a list of countries

- GET /countries/{country_code}/states - Fetches states for a selected country

- GET /countries/{country_code}/states/{state_code}/cities - Fetches cities for a selected state
