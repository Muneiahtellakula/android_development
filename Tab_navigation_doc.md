## Tab Navigation


* Here we will see how to use another of the design library components, the TabLayout, which can be combined with the ViewPager class to create a tab based interface within an Android activity.
#### An Introduction to the ViewPager
* Although not part of the design support library, the ViewPager is a useful companion class when used in conjunction with the TabLayout component to implement a tabbed user interface. The primary role of the ViewPager is to allow the user to flip through different pages of information where each page is most typically represented by a layout fragment. The fragments that are associated with the ViewPager are managed by an instance of the FragmentPagerAdapter class.

* At a minimum the pager adapter assigned to a ViewPager must implement two methods. The first, named getCount(), must return the total number of page fragments available to be displayed to the user. The second method, getItem(), is passed a page number and must return the corresponding fragment object ready to be presented to the user.

#### An Overview of the TabLayout Component

* TabLayout is one of the components introduced as part of material design and is included in the design support library. The purpose of the TabLayout is to present the user with a row of tabs which can be selected to display different pages to the user. 
* The tabs can be fixed or scrollable, whereby the user can swipe left or right to view more tabs than will currently fit on the display. 
* The information displayed on a tab can be text-based, an image or a combination of text and images.like below fig:

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/navbar.JPG">



### Creating the TabLayoutDemo Project

1. Create a new project in Android Studio, entering TabLayoutDemo into the Application name field and package as the Company Domain setting before clicking on the Next button.

2. On the form factors screen, enable the Phone and Tablet option and set the minimum SDK setting to API 14: Android 4.0 (IceCreamSandwich).
3. Continue through the configuration screens requesting the creation of a **Empty Activity** named **TabLayoutDemoActivity** with a corresponding layout file named activity_tab_layout_demo. Click on the Finish button to initiate the project creation process.

4. Once the project has been created, load the content_tab_layout_demo.xml file into the Layout Editor tool, select “Hello World” TextView object, and then delete it.
5. Add the balow dependancy at build.gradle(app:Module)
```
    implementation 'com.android.support:design:28.0.0'

```
#### Creating the First Fragment
* Each of the tabs on the TabLayout will display a different fragment when selected. Create the first of these fragments by right-clicking on the app -> java -> your package entry in the Project tool window and selecting the New -> Fragment -> Fragment (Blank) option. In the resulting dialog, enter Tab1Fragment into the Fragment Name: field and fragment_tab1 into the Fragment Layout Name: field. Enable the Create layout XML? option and disable both the Include fragment factory methods? and **Uncheck Include interface callbacks?** options before clicking on the Finish button to create the new fragment:Follow fig:

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/frg_1.JPG">

**The files like below**

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/pjt_structre.JPG">


