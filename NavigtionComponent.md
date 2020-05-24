## NAVIGATION COMPONENT
### Introducing Navigation Component
* Navigation around an app ,by which i mean moving from one screen to another is an absolutely fundamental part of Android Development 
* Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content      within your app. 
* Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer. 
* The Navigation component also ensures a consistent and predictable user experience by adhering to an established
## What is a navigation Component ?
**“ A Navigation component is a collection of libraries ,a plugin and tooling for unifying and simplifying android navigation ”**
### Navigation Component Benefits
* Simplified setup for common navigation pattern
* Handling fragment transactions.
* Handling Up and Back actions correctly by default.
* Providing standardized resources for animations and transitions.
* Implementing and handling deep linking.
* Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal additional work.
* Safe Args - a Gradle plugin that provides type safety when navigating and passing data between destinations.
* ViewModel support - you can scope a ViewModel to a navigation graph to share UI-related data between the graph's destinations.
* Navigation Graph Support for 
    * Fragments
    * Activities
    * Can also be extended to work with custom destination
### Navigation Component parts
  * The Navigation component consists of three key parts that are:
    * Navigation graph
    * NavHost
    * NavController
  * As you navigate through your app, you tell the NavController that you want to navigate either along a specific path in your navigation graph or directly to a specific destination. The NavController then shows the appropriate destination in the NavHost.
 * **Navigation graph(New Resources):** An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app
 * **NavHost(layout):** An empty container that displays destinations from your navigation graph. The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.
 * **NavController(fragment):** An object that manages app navigation within a NavHost.   The NavController orchestrates the swapping of destination content in the NavHost as users move throughout your app

  
 ## Let we go for Practical simple and easy example
  <img src="https://github.com/Muneiahtellakula/kotlin-ref/blob/master/MyNavComponentDemo/nav.gif" width="250" height="350" />
  
 ### Get Started with the Navigation Component
 
    * This topic shows you how to set up and work with the Navigation component. For a high level overview of the Navigation component, see the Navigation overview
    * To include Navigation support in your project, 
    
 #### Step1 :Create empty android studio prject 
   
 #### Step 2:Add the following dependencies to your app's build.gradle file:(app level)
   ``` Xml 
    //For navigation components 

apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-android-extensions'
//For navigation components
apply plugin: "androidx.navigation.safeargs.kotlin"
android {
    compileSdkVersion 29
    buildToolsVersion "29.0.3"
    defaultConfig {
        applicationId "com.muneiah.mynavcomponentdemo"
        minSdkVersion 21
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.core:core-ktx:1.2.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    def nav_version = "2.3.0-alpha05"
    //For navigation components
   // Kotlin
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
}
```
#### Step 3:Add the following dependencies to your app's build.gradle file:(project level ) 
``` build.gradle(project level)
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.3.61'
    repositories {
        google()
        jcenter()
        
    }

    dependencies {
        classpath 'com.android.tools.build:gradle:3.6.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        def nav_version = "2.3.0-alpha05"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```
#### Step 4:Design Xml layout file
  * activity_main.xml
  ``` xml
  
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
<!--Here added the below attributes for navigation
        NavHostFragment
        navGraph
-->
    <fragment
        android:id="@+id/fragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="androidx.navigation.fragment.NavHostFragment"
        app:navGraph="@navigation/navigation_graph"
        app:defaultNavHost="true"
            />

</LinearLayout>

  
  ```
  #### Step 5:navigation_graph design
  * A navigation graph is a new resource type that defines all the possible paths a user can take through an app. 
  * It shows visually all the destinations that can be reached from a given destination. Android Studio displays the graph in its Navigation Editor. Here's part of the starting navigation graph you'll create for your app:
  * Right click on res directory then new android resourses then click dropdown selectnavigation :res/navigation/ 
  
  <img src="https://github.com/Muneiahtellakula/kotlin-ref/blob/master/MyNavComponentDemo/graph.jpg?raw=true"/>
  
   
  <img src="https://github.com/Muneiahtellakula/kotlin-ref/blob/master/MyNavComponentDemo/final_navi_graph_dessti.jpg?raw=true"/>
  
  #### Step 6:Create three blank fragments(both xml and kotlin)
 
 * Right click on Java first package then new/fragment/fragment_blank
 
 #### fragment_first.xml
 
 ``` xml 
 <?xml version="1.0" encoding="utf-8"?>
  
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorPrimary"
    tools:context=".OneFragment">

</FrameLayout>  
  ```
  #### note:Same as remaing two fragments design 
  
  ** Create a new fragemt naming as Home_fragement for constant 
  ** home_fragemt.xml **
  ``` xml
  
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HomeFragment">

    <!-- TODO: Update blank fragment layout -->
    <Button
        android:background="@color/colorPrimary"
        android:id="@+id/frst"
        android:text="first"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        />

    <Button
        android:id="@+id/scnd"
        android:text="Second"
        android:background="@color/colorAccent"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        />

    <Button
        android:id="@+id/trd"
        android:text="Third"
        android:background="@android:color/holo_red_dark"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        />

</LinearLayout>

```
 Navigation Graph Design follows 

<img src="https://github.com/Muneiahtellakula/kotlin-ref/blob/master/MyNavComponentDemo/graph.jpg"/>


* After that add the desinations at design of navigation_graph .Its, better to go for design because it is simple

<img src="https://github.com/Muneiahtellakula/kotlin-ref/blob/master/MyNavComponentDemo/final_navi_graph_dessti.jpg"/>

#### navigation_graph.xml file

``` xml
 <?xml version="1.0" encoding="utf-8"?>
 <navigation
     xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:app="http://schemas.android.com/apk/res-auto"
     xmlns:tools="http://schemas.android.com/tools"
     android:id="@+id/navigation_graph"
     app:startDestination="@id/homeFragment">
     <fragment
         android:id="@+id/homeFragment"
         android:name="com.muneiah.mynavcomponentdemo.HomeFragment"
         android:label="fragment_home"
         tools:layout="@layout/fragment_home" >
         <action
             android:id="@+id/action_homeFragment_to_oneFragment"
             app:destination="@id/oneFragment" />
         <action
             android:id="@+id/action_homeFragment_to_twoFragment"
             app:destination="@id/twoFragment" />
         <action
             android:id="@+id/action_homeFragment_to_threeFragment"
             app:destination="@id/threeFragment" />
     </fragment>
     <fragment
         android:id="@+id/oneFragment"
         android:name="com.muneiah.mynavcomponentdemo.OneFragment"
         android:label="fragment_one"
         tools:layout="@layout/fragment_one" />
     <fragment
         android:id="@+id/twoFragment"
         android:name="com.muneiah.mynavcomponentdemo.TwoFragment"
         android:label="fragment_two"
         tools:layout="@layout/fragment_two" />
     <fragment
         android:id="@+id/threeFragment"
         android:name="com.muneiah.mynavcomponentdemo.ThreeFragment"
         android:label="fragment_three"
         tools:layout="@layout/fragment_three" />
 </navigation>

```


 #### Step 8:At Home_Fragemt.kt connct the three buttons id's then set onClick event listner 
 
 #### First_fragment.kt
 ``` Kotlin
      package com.muneiah.mynavcomponentdemo

     import android.os.Bundle
     import androidx.fragment.app.Fragment
     import android.view.LayoutInflater
     import android.view.View
     import android.view.ViewGroup

     /**
      * A simple [Fragment] subclass.
      */
     class OneFragment : Fragment() {

         override fun onCreateView(
             inflater: LayoutInflater, container: ViewGroup?,
             savedInstanceState: Bundle?
         ): View? {
             // Inflate the layout for this fragment
             return inflater.inflate(R.layout.fragment_one, container, false)
         }

        }
  ``` 
  
  #### MainActivity.kt file 
  
  ``` kotlin
  package com.muneiah.mynavcomponentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

  
  ```
  #### Home_Fragment **
  ``` kotlin
  package com.muneiah.mynavcomponentdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home,container,false)
            val  ob=view.findViewById<Button>(R.id.frst)
            val  tb=view.findViewById<Button>(R.id.scnd)
            val  ttb=view.findViewById<Button>(R.id.trd)
        ob.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_oneFragment)
        }
        tb.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_twoFragment)
        }
        ttb.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_threeFragment)
        }
        return view
    }

}
```
  #### Step 9:Run your application
  
  #                Thank you.....!
