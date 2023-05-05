## Netter
Netter makes it easy for you to invoke api calls  and listen for all the possible responses for any standard rest api call using retrofit.Netter allows you to handle successful responses (2xx response codes, non empty response bodies)
,Server errors codes (non 2xx status code) and connectivity errors (a request that didn't result in a response). You don't have to explicitly  design and build wrapper classes such as `Resource` or `Result`,you just wrap your expected response in the `ApiCallResult<Pojo>` and you are set.

### Gradle Setup

Add the dependency below into your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.Carlosokumu:Netter:v0.1.1"
}
```

## Usage

```kotlin

  //Api Service Class
interface CurrencyApi {
    @GET("latest")
    suspend fun getCurrency(@Query("symbols") symbols: String, @Query("base") base: String): Currency

}

//Repository
override suspend fun fetchCurrencies(symbols: String, base: String): ApiCallResult<Currency> =
        safeApiCall(ioDispatcher) {
            return@safeApiCall currencyApi.getCurrency(symbols, base)
        }
        
//ViewModel      
fun fetchCurrencies() = viewModelScope.launch {
        when (val result = mainRepository.fetchCurrencies(symbols = getSymbols(), base = "USD")) {
            is ApiCallResult.ApiCallError -> {
                //Handle  connectivity errors.
            }
            is ApiCallResult.Success -> {
                //Handle success responses

            }
            is ApiCallResult.ServerError -> {
               //Handle Server errors
            }
        }
    }
  ```
    
    

 ##  Sample App
This sample app displays a list of   popular currencies from  [Fixer Api](https://api.apilayer.com/fixer/)  setting the Us dollar as the base currency.

**Screenshots**

Dark mode | Light Mode 
--- | --- |
<img src="https://github.com/Carlosokumu/Netter/blob/master/shots/dark.png" height="400" width="200"/> | <img src="https://github.com/Carlosokumu/Netter/blob/master/shots/light.png" height="400" width="200"/>

## Technologies used
  [Kotlin](https://kotlinlang.org/) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.
  
  [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
  
  [Compose](https://developer.android.com/jetpack/compose) - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
  
 [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
 
 [Retrofit](https://square.github.io/retrofit/)  -  Retrofit is a REST client for Java/ Kotlin and Android by Square inc under Apache 2.0 license. Its a simple network library that is used for network transactions
   
 [Hilt-Dagger](https://developer.android.com/training/dependency-injection/hilt-android) -A dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.

[Jetpack](https://developer.android.com/jetpack)
     *[Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
     *[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.


