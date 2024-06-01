# What hilt injection

simplifies the process of dependency injection by providing a standard way to do
it, reducing boilerplate code and making your application more maintainable and testable.

## Key component hilt injection

- @HiltAndroidApp This annotation is used in your application class to generate the required
  components and initialize the Dagger Hilt setup
- @AndroidEntryPoint
  Used on Android classes like Activities, Fragments, Services, etc., to enable injection within
  these components.
- @ViewModelInject
  Hilt simplifies ViewModel injection by providing annotations to inject dependencies directly into
  ViewModels
- @Inject
  inject dependencies into class
- @Module and @InstallIn
  service dependencies which will inject by hilt