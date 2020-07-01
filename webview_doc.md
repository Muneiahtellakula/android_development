# Android App with WebView

* The WebView class is an extension of Android's View class that allows you to display web pages as a part of your activity layout. It does not include any features of a fully developed web browser, such as navigation controls or an address bar. All that WebView does, by default, is show a web page.

* A common scenario in which using WebView is helpful is when you want to provide information in your app that you might need to update, such as an end-user agreement or a user guide. Within your Android app, you can create an Activity that contains a WebView, then use that to display your document that's hosted online.

* Another scenario in which WebView can help is if your app provides data to the user that always requires an Internet connection to retrieve data, such as email. In this case, you might find that it's easier to build a WebView in your Android app that shows a web page with all the user data, rather than performing a network request, then parsing the data and rendering it in an Android layout. Instead, you can design a web page that's tailored for Android devices and then implement a WebView in your Android app that loads the web page

### Adding a WebView to your app

**To add a WebView to your app, you can either include the <WebView> element in your activity layout, or set the entire Activity window as a WebView in onCreate().**

* Adding a WebView in the activity layout
* To add a WebViewto your app in the layout, add the following code to your activity's layout XML file:
