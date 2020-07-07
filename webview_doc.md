# Android App with WebView

* The WebView class is an extension of Android's View class that allows you to display web pages as a part of your activity layout. It does not include any features of a fully developed web browser, such as navigation controls or an address bar. All that WebView does, by default, is show a web page.

* A common scenario in which using WebView is helpful is when you want to provide information in your app that you might need to update, such as an end-user agreement or a user guide. Within your Android app, you can create an Activity that contains a WebView, then use that to display your document that's hosted online.

* Another scenario in which WebView can help is if your app provides data to the user that always requires an Internet connection to retrieve data, such as email. In this case, you might find that it's easier to build a WebView in your Android app that shows a web page with all the user data, rather than performing a network request, then parsing the data and rendering it in an Android layout. Instead, you can design a web page that's tailored for Android devices and then implement a WebView in your Android app that loads the web page

### Adding a WebView to your app

**To add a WebView to your app, you can either include the <WebView> element in your activity layout, or set the entire Activity window as a WebView in onCreate().**

**Adding a WebView in the activity layout**

**To add a WebViewto your app in the layout, add the following code to your activity's layout XML file:**
```
<WebView
    android:id="@+id/webview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
/>
```
#### To load a web page in the WebView, use loadUrl(). For example:

```
WebView myWebView = (WebView) findViewById(R.id.webview);
myWebView.loadUrl("http://www.example.com");

```
**Before this works, however, your app must have access to the Internet. To get internet access, request the INTERNET permission in your manifest file.**

* For example:
```
<manifest ... >
      <uses-permission android:name="android.permission.INTERNET" />
        ...
 </manifest>       
 ```
 
 #### That's all you need for a basic WebView that displays a web page. Additionally, you can customize your WebViewby modifying the following:
 
 * Enabling fullscreen support with WebChromeClient. This class is also called when a WebView needs permission to alter the host app's UI, such as creating or closing windows and sending JavaScript dialogs to the user. To learn more about debugging in this context, read Debugging Web Apps.
 
 * Handling events that impact content rendering, such as errors on form submissions or navigation with WebViewClient. You can also use this subclass to intercept URL loading.
 
 * Enabling JavaScript by modifying WebSettings.
 
 * Using JavaScript to access Android framework objects that you have injected into a WebView.
 
 ### Using JavaScript in WebView
 
 *  If the web page you plan to load in your WebView uses JavaScript, you must enable JavaScript for your WebView. Once JavaScript is enabled, you can also create interfaces between your app code and your JavaScript code.
 
 #### Enabling JavaScript
 
* JavaScript is disabled in a WebView by default. You can enable it through the WebSettings attached to your WebView.You can retrieve WebSettings with getSettings(), then enable JavaScript with setJavaScriptEnabled().

```
WebView myWebView = (WebView) findViewById(R.id.webview);
WebSettings webSettings = myWebView.getSettings();
webSettings.setJavaScriptEnabled(true);

```

### Steps to Create a simple app on Android WebView 


**Step 1:Enable the Internet Permissions 

**AndroidManifest.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.muneiah.androidwebview">
    <!--Step 1-->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".MainActivity"
            android:screenOrientation="portrait">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>


```
**Step 2:** At design file design the userinterface components EditText,Button,And WebView 

**activity_main.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">
    <!--Step 2-->
    <LinearLayout
        android:id="@+id/layout_liner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:weightSum="2">

        <EditText
            android:id="@+id/et_input"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:layout_weight="1"
            android:hint="Enter the Url"
            android:inputType="textUri" />

        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:layout_weight="1"
            android:background="@android:color/white"
            android:onClick="showWebPage"
            android:text="Search"
            android:textColor="@color/colorPrimary" />
    </LinearLayout>

    <WebView
        android:id="@+id/webview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp"
        android:background="@android:color/white" />

</LinearLayout>


```

**Step -3:** Create new menu directory and new menu resourse file name as options_menu

**options_menu.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/action_Home"
        android:icon="@drawable/ic_home_black_24dp"
        android:orderInCategory="100"
        android:title="action_bookmark"
        app:showAsAction="always" />

</menu>

```


