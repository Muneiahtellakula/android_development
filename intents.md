# Activities and intents

#### Introduction

In this, you learn about the Activity class, the major building block of your app's user interface (UI). You also learn about using an Intent to communicate from one activity to another.


### About activities
* An activity represents a single screen in your app with an interface the user can interact with. For example, an email app might have one activity that shows a list of new emails, another activity to compose an email, and another activity for reading individual messages. Your app is probably a collection of activities that you create yourself, or that you reuse from other apps.

* Although the activities in your app work with each other to form a cohesive user experience, each activity is independent of the others. This enables your app to start an activity in another app, and it enables other apps to start activities in your app (if your app allows this). For example, a messaging app could start an activity in a camera app to take a picture, then start an activity in an email app to let the user share the picture in email. 


#### Creating an Activity
#### To implement an Activity in your app, do the following:**

**Create an Activity Java class.**

* Implement a basic UI for the Activity in an XML layout file.
* Declare the new Activity in the AndroidManifest.xml file.
* When you create a new project for your app, or add a new Activity to your app by choosing File > New > Activity, the template automatically performs the steps listed above.


#### Create the Activity
* When you create a new project in Android Studio and choose the Backwards Compatibility (AppCompat) option, the MainActivity is, by default, a subclass of the AppCompatActivity class. The AppCompatActivity class lets you use up-to-date Android app features such as the app bar and Material Design, while still enabling your app to be compatible with devices running older versions of Android.

* Here is a skeleton subclass of AppCompatActivity:

```
public class MainActivity extends AppCompatActivity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
   }
}
```

* The first task for you in your Activity subclass is to implement the standard Activity lifecycle callback methods (such as onCreate()) to handle the state changes for your Activity. These state changes include things such as when the Activity is created, stopped, resumed, or destroyed. You learn more about the Activity lifecycle and lifecycle callbacks in a different chapter.

* The one required callback your app must implement is the onCreate() method. The system calls this method when it creates your Activity, and all the essential components of your Activity should be initialized here. Most importantly, the onCreate() method calls setContentView() to create the primary layout for the Activity.

* You typically define the UI for your Activity in one or more XML layout files. When the setContentView() method is called with the path to a layout file, the system creates all the initial views from the specified layout and adds them to your Activity. This is often referred to as inflating the layout.

* You may often also want to implement the onPause() method in your Activity. The system calls this method as the first indication that the user is leaving your Activity (though it does not always mean that the Activity is being destroyed). This is usually where you should commit any changes that should be persisted beyond the current user session (because the user might not come back). You learn more about onPause() and all the other lifecycle callbacks in a later chapter.

* In addition to lifecycle callbacks, you may also implement methods in your Activity to handle other behavior such as user input or button clicks.


#### Implement the activity's UI
* The UI for an activity is provided by a hierarchy of View elements, which controls a particular space within the activity window and can respond to user interaction.

* The most common way to define a UI using View elements is with an XML layout file stored as part of your app's resources. Defining your layout in XML enables you to maintain the design of your UI separately from the source code that defines the activity behavior.

* You can also create new View elements directly in your activity code by inserting new View objects into a ViewGroup, and then passing the root ViewGroup to setContentView(). After your layout has been inflated—regardless of its source—you can add more View elements anywhere in the View hierarchy.


**Declare the Activity in AndroidManifest.xml**
* Each Activity in your app must be declared in the AndroidManifest.xml file with the <activity> element, inside the <application> section. When you create a new project or add a new Activity to your project in Android Studio, the AndroidManifest.xml file is created or updated to include skeleton declarations for each Activity. Here's the declaration for MainActivity:

```
<activity android:name=".MainActivity" >
   <intent-filter>
      <action android:name="android.intent.action.MAIN" />
      <category android:name="android.intent.category.LAUNCHER" />
   </intent-filter>
</activity>
```

* The <activity> element includes a number of attributes to define properties of the Activity such as its label, icon, or theme. The only required attribute is android:name, which specifies the class name for the Activity (such as MainActivity). See the <activity> element reference for more information on Activity declarations.

* The <activity> element can also include declarations for Intent filters. The Intent filters specify the kind of Intent your Activity will accept.
```
<intent-filter>
   <action android:name="android.intent.action.MAIN" />
   <category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
  ```
* Intent filters must include at least one <action> element, and can also include a <category> and optional <data>. The MainActivity for your app needs an Intent filter that defines the "main" action and the "launcher" category so that the system can launch your app. Android Studio creates this Intent filter for the MainActivity in your project.

* The <action> element specifies that this is the "main" entry point to the app. The <category> element specifies that this Activity should be listed in the system's app launcher (to allow users to launch this Activity).

* Each Activity in your app can also declare Intent filters, but only your MainActivity should include the "main" action. You learn more about how to use an implicit Intent and Intent filters in a later section.


#### Add another Activity to your project
* The MainActivity for your app and its associated layout file is supplied by an Activity template in Android Studio such as Empty Activity or Basic Activity. You can add a new Activity to your project by choosing File > New > Activity. Choose the Activity template you want to use, or open the Gallery to see all the available templates.

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/activity-gallery.png" height="400" width="600">

- When you choose an Activity template, you see the same set of screens for creating the new activity that you did when you created the project. Android Studio provides three things for each new activity in your app:

* A Java file for the new Activity with a skeleton class definition and onCreate() method. The new Activity, like MainActivity, is a subclass of AppCompatActivity.
* An XML file containing the layout for the new activity. Note that the setContentView() method in the Activity class inflates this new layout.
* An additional <activity> element in the AndroidManifest.xml file that specifies the new activity. The second Activity definition does not include any Intent filters. If you plan to use this activity only within your app (and not enable that activity to be started by any other app), you do not need to add filters


# What are intents?
[-] Android application components can connect to other Android applications. This connection is based on a task description represented by an Intent object.

* Intents are asynchronous messages which allow application components to request functionality from other Android components. Intents allow you to interact with components from the same applications as well as with components contributed by other applications. For example, an activity can start an external activity for taking a picture.

* Intents are objects of the android.content.Intent type. Your code can send them to the Android system defining the components you are targeting. For example, via the startActivity() method you can define that the intent should be used to start an activity.
