# SamplePOC

This project involves building a “proof of concept” app which consumes a REST service and displays photos with headings and descriptions.

The project target Android version 7.1(V25)

Prerequisites :
1.Android Studio should be required to run this code.
2.Required Android SDK tools V27.
3.Need Internet to donwload the code and Run the application successfully.

Installing :
1. Clone the project or download the project.Open this project using Android studio IDE.
2. Syn the project, the dependency libraries will be synced.
3. Once the build is successful, run the project on the device or emulator.

Design & third party libraries used:

1. This poc is implemented using MVVM Architecture.As per requirements we need to handle configuration changes.VM are persistent across configuration changes.So I choose to use MVVM.
2. Retrofit library for networking calls.
3. RecyclerView to display the list of items returned from rest api.
4. Glide library to load the images and caching.
5. Butterknife library for binding views.To remove boiler plate of code.
6. Dagger2 is used for dependency Injection.
7. GSON library for parsing JSON Response.
8. LiveData is used in this project.


List of files included :

1. MainActivity.java is the starting activity when we launch the application.
2. FactsRecyclerviewAdpater.java is the RecyclerviewAdapter.
3. FactsViewModel.java is the ViewModel all logic is written here, where the client will sent the requestto server , getting response and processing the reponse.
4. Constants.java is the file that contains constants.
5. FactsAPIService.java is the APIService interface.
6. FactsModel.java and FactsResponse.java is the model classes.
7. ApiModule.java and AppModule.java, ApiComponent.java are the classes to do dependency injection.
8. NetworkUtils.java to check the network connection.


This poc is implemented by ARUN BABU PATHAKOTA, if any questions please contact me.


