## Android REST webservice example with Retrofit

---
A simple example of a webservice object that communicates back to the Activity after completing it's request. The example shows how google gson and retrofit can automatically support asynchronous requests using the retrofit ```Callback<T>``` interface, automati serialization/deserialization to json with a GSON adapter, and notificaton to the Activity via EventBus.

####libraries used: 

1. [Retrofit](http://github.com/square/retrofit) - REST webservices
2. [google GSON](http://www.google.com/needs-url) - Serialization/Deserialization of service responses
3. [android eventbus](http://www.eventbus.com/needs-url) Communication between webservice manager & activity
4. [dagger](http://www.dagger.com/needs-url) Dependency injection framework
