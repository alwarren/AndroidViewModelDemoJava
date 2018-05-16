### Android View Model Component Java Example

A simple Android project that demonstrates the ViewModel component from Android Architecture
Components. It was originally written in Kotlin but has been refactored using pure Java.

The following log output was produced by:
1. Starting the application
2. Rotating the device
3. Entering text in the dialog
4. Rotating the device

```
04-16 14:19:50.013 18038-18038/demo.java.vm D/MainActivity: ---> onCreate()
04-16 14:19:50.276 18038-18038/demo.java.vm D/Hello: ---> Setting data in the Hello model
04-16 14:19:50.276 18038-18038/demo.java.vm D/MainActivity: ---> Updating UI from the ViewModel
    ---> onResume()
04-16 14:20:30.286 18038-18038/demo.java.vm D/MainActivity: ---> onCreate()
04-16 14:20:30.298 18038-18038/demo.java.vm D/MainActivity: ---> Updating UI from the ViewModel
    ---> onResume()
04-16 14:20:52.743 18038-18038/demo.java.vm D/MainActivity: ---> Sending Dialog result to the ViewModel
04-16 14:20:52.743 18038-18038/demo.java.vm D/HelloViewModel: ---> Updating the ViewModel with Hi There!
04-16 14:20:52.743 18038-18038/demo.java.vm D/Hello: ---> Setting data in the Hello model
04-16 14:20:52.744 18038-18038/demo.java.vm D/MainActivity: ---> Updating UI from the ViewModel
04-16 14:21:25.302 18038-18038/demo.java.vm D/MainActivity: ---> onCreate()
04-16 14:21:25.320 18038-18038/demo.java.vm D/MainActivity: ---> Updating UI from the ViewModel
04-16 14:21:25.326 18038-18038/demo.java.vm D/MainActivity: ---> onResume()
```

Notice that when the device is rotated, as indicated by calls to onCreate and
onResume, the only thing that happens is the UI gets updated from the ViewModel. The ViewModel
does not retrieve data from the model.

This is typically what we want with expensive data operations. We only want to retrieve data 
when we explicitly ask for it. The data should not be recreated on every device rotation.

See comments in the code for further explanations.
