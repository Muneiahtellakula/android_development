# Android Images and ClickableImages 

* For an Android app, user interaction typically involves tapping, typing, using gestures, or talking. The Android framework provides corresponding user interface (UI) elements such as buttons, clickable images, menus, keyboards, text entry fields, and a microphone.

* When designing an interactive app, make sure your app is intuitive; that is, your app should perform as your users expect it to perform. For example, when you rent a car, you expect the steering wheel, gear shift, headlights, and indicators to be in a certain place. Another example is that when you first enter a room, you expect the light switch to be in a certain place. Similarly, when a user starts an app, the user expects buttons and images to be clickable. Don't violate established expectations, or you'll make it harder for your users to use your app.

* Note: Android users expect UI elements to act in certain ways, so it's important that your app be consistent with other Android apps. To satisfy your users, create a layout that gives users predictable choices.

#### Designing buttons

* People like to press buttons. Show someone a big red button with a message that says "Do not press" and the person will probably press the button, just for the pleasure of pressing a big red button. (That the button is forbidden is also a factor.)

* You use the Button class to make a button for an Android app. Buttons can have the following design:

  * Text only, as shown on the left side of the figure below.
  * Icon only, as shown in the center of the figure below.
  * Both text and an icon, as shown on the right side of the figure below
  <img src="https://github.com/Muneiahtellakula/android_development/blob/master/btn.png?raw=true">
* When the user touches or clicks a button, the button performs an action. The button's text or icon should provide a hint about what that action will be. (Buttons are sometimes called "push-buttons" in Android documentation.)

* A button is usually a rectangle or rounded rectangle with a descriptive caption or icon in its center. Android Button elements follow the guidelines in the Android Material Design specification. (You learn more about Material Design in another lesson.)

* Android offers several types of Button elements, including raised buttons and flat buttons as shown in the figure below. Each button has three states: normal, disabled, and pressed.

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/btn_apper.png?raw=true">

**In the figure above:**

  1. Raised button in three states: normal, disabled, and pressed
  2. Flat button in three states: normal, disabled, and pressed

**Creating a raised button with an icon and text**

* While a Button usually displays text that tells the user what the action is, a raised Button can also display an icon along with text.


**Choosing an icon**

**To choose images of a standard icon that are resized for different displays, follow these steps:**

  1. Expand app > res in the Project > Android pane, and right-click (or Command-click) the drawable folder.
  2. Choose New > Image Asset. The Configure Image Asset dialog appears.
  
  
