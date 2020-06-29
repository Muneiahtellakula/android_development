
<img src="https://github.com/Muneiahtellakula/android_development/blob/master/sen.jpg?raw=true">

## Sensors in Android:-

1. Introduction to Sensors

* In Android devices, there are various built-in sensors that can be used to measure a device’s orientation, its motion, and various other kinds of environmental conditions. In general, there are two types of sensors in Android devices:
* Hardware sensors: Hardware-based sensors are physical components built into a handset or tablet device. They derive their data by directly measuring specific environmental properties, such as acceleration, geomagnetic field strength, or angular change.
* Software sensors: Software-based sensors are not physical devices, although they mimic hardware-based sensors. Software-based sensors derive their data from one or more of the hardware-based sensors and are sometimes called virtual sensors or synthetic sensors. The linear acceleration sensor and the gravity sensor are examples of software-based sensors.
* It is pretty much possible for an android device to have a different number of sensors, i.e it’s not necessary that all the devices must have all the sensors. Also, it’s possible for a particular device may have more than one sensor of the same type but with different configurations and capabilities.
* To express data values or to collect data, the sensors in Android devices use a 3-axis coordinate system i.e. you will be having X, Y, and Z-axis. The following figure depicts the position of various axis used in sensors.

<img src="https://github.com/Muneiahtellakula/android_development/blob/master/sensdir.jpg?raw=true">
 

**Coordinate system (relative to a device) that’s used by the Sensor API.**
2. Types of Sensors

**Environment sensors-** These help in identifying environmental properties like temperature, pressure, humidity, etc. Some of the examples of environmental sensors include thermometers, barometers, etc.
**Motion sensors-** These sensors are responsible for measuring or identifying the shakes and tilts of your Android devices. These sensors measure the rotational forces along three axes. Gravity sensors and accelerometers are two examples of motion sensors.
**Position sensors-** Position sensors are useful for determining a device’s physical position in the world’s frame of reference. For example, you can use the geomagnetic field sensor in combination with the accelerometer to determine a device’s position relative to the magnetic north pole. Magnetometers and proximity sensors are two examples of position sensors.

* Photometer is used to sense and control the brightness. Besides, there are sensors for pressure, humidity, and temperature.
* For movements, Accelerometer is used to detect shakes/tilt gestures.
* Proximity Sensors are used to detect how close the object is to the device. It’s commonly present in Call Applications. As you bring the phone close to the ear, the screen goes black, thanks to this sensor. Though the maximum range of proximity is 5 cms.
* Gyroscope is used to measure rotation/spin. Gravity sensors are used to measure the force of gravity.
* Magneto Meter is used to get the device position.
* Pedometer is used to detect the number of steps the user takes.
 


3. Android Sensor API Framework

* Android’s Sensor API provides many classes and interfaces. The most important classes and interfaces are as follows:

**SensorManager:** This class is used to access various sensors present in the device.
**Sensor:** This class is used to create an instance of a specific sensor you want to use.
**SensorEvent:** This class is used to find the details of sensor events.
**SensorEventListener:** This is used to receive notifications from the SensorManager whenever there’s new sensor data or any change in its values.

* You can use these sensor-related APIs to:
* Find the sensors that are active and present on a device and determine their capabilities.
* Monitor various sensor events to collect data and use them accordingly.

### Implementing Sensors in Android
1. Identify Device Sensors

* First, we need to identify the sensors that are present on a given device by getting a reference to the sensor service.To do so, create an instance of the SensorManager class by calling the getSystemService() method and passing in the SENSOR_SERVICE argument:
* Next, you can get a listing of every sensor on a device by calling the getSensorList() method and using the TYPE_ALL constant.
* If you want to list all of the sensors of a given type, you could use another constant instead of TYPE_ALL, such as TYPE_GYROSCOPE, TYPE_LINEAR_ACCELERATION, or TYPE_GRAVITY. You can also determine whether a specific type of sensor exists on a device by using the getDefaultSensor() method and passing in the type constant for a specific sensor.
* Apart from finding the list of available sensors, we can also check the capability of a particular sensor; i.e. we can check the resolution, power, range, etc. of a particular sensor.

2. Register a SensorEventListener

* This is used to receive notifications from the SensorManager when there’s new sensor data.
* The SensorEventListener interface has two callback methods:
* onAccuracyChanged(): This is called when there is a change in the accuracy of the measurement of the sensor. It returns the Sensor object that has changed and the new accuracy status, some of them are:-
  * SENSOR_STATUS_ACCURACY_LOW: Reports data with low accuracy; therefore, calibration with the environment is needed.
  * SENSOR_STATUS_ACCURACY_MEDIUM: Reports data with an average level of accuracy; calibration with the environment may improve the readings.
  * SENSOR_STATUS_ACCURACY_HIGH: Reports the data with maximum accuracy.
  * SENSOR_STATUS_UNRELIABLE: The values returned by this sensor cannot be trusted; calibration is needed or the environment doesn’t allow readings.
  * SENSOR_STATUS_NO_CONTACT: The values returned by this sensor cannot be trusted because the sensor had no contact with what it was measuring (for example, the heart rate monitor is not in contact with the user).
2. onSensorChanged(): This is called when new sensor data is available. This method will provide you with a SensorEvent object that contains new/changed sensor data.
```
    @Override
    public void onSensorChanged(SensorEvent event) {
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
```

* **Note:** It’s also important to register and unregister the SensorEventListener in the onResume() and onPause() callback methods. As a best practice, you should always disable sensors you don't need, especially when your activity is paused. Failing to do so can drain the battery in just a few hours because some sensors have substantial power requirements and can use up battery power quickly. The system will not disable sensors automatically when the screen turns off.
**Conclusion**
 * Android sensors (both hardware- and software-based) and their types that are present in Android devices.
* We used the Android Sensor API to determine the sensors present in the Android device. And finally, we saw how to use SensorEventListener to handle new sensor data.
* Always remember to unregister the listener when not in use to avoid power and memory issues. Also, sensor data may change anytime, so don’t block the onSensorChanged() method. 

**AndroidManifest.xml**
```

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.sensors">
<uses-feature android:name="android.hardware.sensor.accelerometer" android:required="true"/>
    <uses-feature android:name="android.hardware.Sensor.gyroscope" android:required="true"/>
    <uses-feature android:name="android.hardware.sensor.proximity" android:required="true"/>
    <uses-feature android:name="android.hardware.Sensor.accelerometer" android:required="true"/>
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
**acivity_mai.xm**

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```
**MainActiviy.java**

```

package com.example.sensors;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
SensorManager sensorManager;
Sensor asen,gsen,psen;
SensorEventListener asenlist,gsenlist,psenlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        asen=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gsen=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        asenlist=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
           if(sensorEvent.values[2]>0.5f){
               getWindow().getDecorView().setBackgroundColor(Color.RED);
           }
           else if(sensorEvent.values[2] <-0.5f){
               getWindow().getDecorView().setBackgroundColor(Color.GREEN);
           }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        gsenlist=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[2]>0.5f){
                    getWindow().getDecorView().setBackgroundColor(Color.MAGENTA);
                }
                else if(sensorEvent.values[2] <-0.5f){
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(asenlist,asen,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(gsenlist,gsen,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(asenlist,asen);
        sensorManager.unregisterListener(gsenlist,gsen);
    }
}


```

### SENSORS API

**ManifestFile.xml**
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.sensorsapi">

    <uses-permission android:name="android.permission.CAMERA" />

    <uses-permission android:name="android.permission.FLASHLIGHT"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

**acivit_main.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="5dp"
    tools:context=".MainActivity">

    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Shake Sensor"
        android:textSize="25sp"
        android:textColor="#3F51B5"
        android:id="@+id/shake"/>

    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Touch Sensor"
        android:textSize="25sp"
        android:textColor="#3F51B5"
        android:id="@+id/touch"
        android:layout_marginTop="10dp"/>

    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Light Sensor"
        android:textSize="25sp"
        android:textColor="#3F51B5"
        android:id="@+id/light"
        android:layout_marginTop="10dp"/>
    <Switch
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Flip Sensor"
        android:textSize="25sp"
        android:textColor="#3F51B5"
        android:id="@+id/flip"
        android:layout_marginTop="10dp"/>



    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="No Sensor Detected"
        android:textSize="30sp"
        android:layout_marginTop="10dp"
        android:textColor="#FFFFFF"
        android:background="#673AB7"
        android:gravity="center"
        android:id="@+id/sensor"
        />

</LinearLayout>



```
**MainAcitivy.jav**

```

package com.example.sensorsapi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Camera;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nisrulz.sensey.FlipDetector;
import com.github.nisrulz.sensey.LightDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;

public class MainActivity extends AppCompatActivity {

    Switch s1,s2,s3,s4;
    TextView tv;
    public static Camera cam = null;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = findViewById(R.id.shake);
        s2 = findViewById(R.id.touch);
        s3 = findViewById(R.id.light);
        s4 = findViewById(R.id.flip);

        tv =findViewById(R.id.sensor);
        Sensey.getInstance().init(MainActivity.this);

        final FlipDetector.FlipListener flipListener=new FlipDetector.FlipListener() {
            @Override
            public void onFaceDown() {
                tv.setText("Face Down");
            }

            @Override
            public void onFaceUp() {
                tv.setText("Face Up");
            }
        };

        s4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Sensey.getInstance().startFlipDetection(flipListener);
                }else {
                    Sensey.getInstance().stopFlipDetection(flipListener);
                }
            }
        });




        final LightDetector.LightListener lightListener=new LightDetector.LightListener() {
            @Override
            public void onDark() {
                tv.setText("It Is Dark");
            }
            @Override
            public void onLight() {
                tv.setText("It Is Light");
            }
        };

        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Sensey.getInstance().startLightDetection(lightListener);
                }else {
                    Sensey.getInstance().stopLightDetection(lightListener);
                }
            }
        });


        final ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                tv.setText("Shake Sensor Detected");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = null;
                    try {
                        cameraId = camManager.getCameraIdList()[0];
                        camManager.setTorchMode(cameraId, true);   //Turn ON
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onShakeStopped() {
                tv.setText("Shake Sensor Stopped");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    CameraManager camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    String cameraId = null;
                    try {
                        cameraId = camManager.getCameraIdList()[0];
                        camManager.setTorchMode(cameraId, false);   //Turn OFF
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        };



        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Sensey.getInstance().startShakeDetection(shakeListener);
                }else {
                    Sensey.getInstance().stopShakeDetection(shakeListener);
                }
            }
        });

        // Touch Type Sensor Implementation

        final TouchTypeDetector.TouchTypListener touchTypListener =new TouchTypeDetector.TouchTypListener() {
            @Override
            public void onDoubleTap() {
                tv.setText("Double Tap Detected");
            }

            @Override
            public void onLongPress() {
                tv.setText("Long Press Detected");
            }

            @Override
            public void onScroll(int i) {
                tv.setText("Scroll Detected");
            }

            @Override
            public void onSingleTap() {
                tv.setText("Single Tap Detected");
            }

            @Override
            public void onSwipe(int i) {
                tv.setText("Swipe Detected");
            }

            @Override
            public void onThreeFingerSingleTap() {
                tv.setText("Three Fingers Tap Detected");
            }

            @Override
            public void onTwoFingerSingleTap() {
                tv.setText("Two Fingers Tap Detected");
            }
        };



        // Touch Sensor Click Event

        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Sensey.getInstance().startTouchTypeDetection(MainActivity.this,touchTypListener);
                }else {
                    Sensey.getInstance().stopTouchTypeDetection();
                }
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Sensey.getInstance().setupDispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sensey.getInstance().stop();
    }
}

```
