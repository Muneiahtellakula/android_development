## Android Services
    * What are Android Services?
    * Android- Services Life cycle
    * Android- Services Methods
#### What are Android Services?
* Service is basically a process. Android service is a component that runs in the background in order to perform long-running operations without interacting with the user and it works even if the application is destroyed. Another application component can start a service and it continues to run in the background even if you switch to another application.

* Additionally, a component can bind itself to a service in order to interact with it and also perform interprocess communication. 

    * Note: The android.app.Service is a subclass of ContextWrapper class and Android service is not a thread or separate process.
#### Android- Services Life cycle
**Android Services life cycle can have two forms of services. The lifecycle of a service follows two different paths, namely:**

* Started
* Bound
* Started

**A service is started when an application component calls startService() method. Once started, a service can run in the background indefinitely, even if the component which is responsible for the start is destroyed. It is stopped by using the stopService() method. The service can also stop itself by calling the stopSelf() method.**

**Bound**

* A service is bound when an application component binds to it by calling bindService(). Bound service offers a client-server interface that allows components to interact with the service, send requests and, get results. It processes across inter-process communication (IPC). The client can unbind the service by calling the unbindService() method.

<img src="https://raw.githubusercontent.com/Muneiahtellakula/android_development/master/android_services_started_bound_services_life_cycle.png">

**let’s discuss the different methods under the service class.**

**There are a few methods using which you can easily perform operations on any application. Some of them are:**

Method	| Description
---|---
onStartCommand() |	This method is called when any other component, like say an activity, requests the service to be started, by calling startService().It is your responsibility to stop the service when the corresponding work is done by using stopSelf() or stopService() methods.
onBind() | 	Calls this method when another component wants to bind with the service by calling bindService().To implement this, you must provide an interface that clients use in order to communicate with the service. It returns an IBinder object. If you don’t want to allow binding, then return null.
onUnbind()	| The system calls this method when all clients are disconnected from a particular interface published by the service.
onRebind()	| Calls this method when new clients are connected to the service after it had previously been notified that all are disconnected in onUnbind(Intent).
onCreate()	| The system calls this method when the service is created first using onStartCommand() or onBind(). It is required to perform a one-time set-up.
onDestroy()	| This method is called when the service is no longer used and is being destroyed. Your service should implement this in order to clean up any resources such as threads, registered listeners, receivers, etc.
