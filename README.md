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

* Technologies used
    * [Kotlin](https://kotlinlang.org/) - Kotlin is a programming language that can run on JVM. Google has announced Kotlin as one of its officially supported programming languages in Android Studio; and the Android community is migrating at a pace from Java to Kotlin.


