# Trending Github repos
App(sample project) that displays Github most starred repos, the app will fetch JSON data directly from the Github API.

# Used libraries
Retrofit - standard library, which allows communication with HTTP client api. It using for fetching data from Github.
Paging - Google's Jetpack library, which implementing pagination. Load data from network requests on each page by tracking user's scroll event.
Coroutines - Kotlin approach to make code asynchronous.
Koin - DI library, fully Kotlin friendly, one of the way to implement dependency injection(IoC). We can use Hilt, Dagger or any other, but Koin is simple in use. Also provides easy work with viewmodels.

# Architecture approaches
MVVM - pattern for presentation layer
Clean Architecture to separate business logic, helpful to scale project and easy to test later.