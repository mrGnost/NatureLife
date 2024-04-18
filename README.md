# Keep Active!
Keep Active! - is a game aiming to motivate people keep more active lifestyle and spend more time in nature.

The player will be obtaining points for taking strolls, running and spending time in parks and forests, while losing them for remaining inactive.

## Project tech-stack
* Architecture
  * MVVM
  * Clean Architecture
* Tech-stack
  * [Kotlin](https://kotlinlang.org/)
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Flow](https://developer.android.com/kotlin/flow) - reactive data receiving with database updates
  * [Jetpack](https://developer.android.com/jetpack)
    * [Fragment](https://developer.android.com/jetpack/androidx/releases/fragment) - multiple, independent screens that are hosted within an Activity
    * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify observers about data updates
    * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - event handling based on lifecycle
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - MVVM ViewModel component for UI-related data storage and management
    * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - navigation within an Activity with a graph
    * [Android KTX](https://developer.android.com/kotlin/ktx) - Kotlin extensions
    * [Room](https://developer.android.com/jetpack/androidx/releases/room) - local data storage
    * [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - getting links to the UI elements
  * [Dagger 2](https://dagger.dev/) - dependency injection
  * [Retrofit](https://square.github.io/retrofit/) - interaction with server
  * [WorkManager](https://developer.android.com/reference/androidx/work/WorkManager) - continuous background work
  * Testing
    * [JUnit5](https://junit.org/junit5/) - unit testing
    * [Espresso](https://developer.android.com/training/testing/espresso) - UI testing
* UI
  * [Material Design 3](https://m3.material.io/)
