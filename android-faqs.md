* Android: Difference between Parcelable and Serializable?[Ref Link](https://stackoverflow.com/questions/3323074/android-difference-between-parcelable-and-serializable)
    * **Serializable**

      * Serializable is a markable interface or we can call as an empty interface. It doesn’t have any pre-implemented methods. Serializable is going to convert an object to byte stream. So the user can pass the data between one activity to another activity. The main advantage of serializable is the creation and passing data is very easy but it is a slow process compare to parcelable.

   * **Parcelable**

     * Parcel able is faster than serializable. Parcel able is going to convert object to byte stream and pass the data between two activities. Writing parcel able code is little bit complex compare to serialization. It doesn’t create more temp objects while passing the data between two activities.

﻿

* How to pass data from one fragment to another [For Ref click here](https://www.journaldev.com/14207/android-passing-data-between-fragments)
    
``` java
 FragmentC fragment = new  FragmentC();
    final Bundle bundle = new Bundle();
    bundle.putString("position", "http://www.facebook.com");            
    fragment.setArguments(bundle);}
});
```
* How to stop asynctask thread in android?[Ref Link](https://developer.android.com/reference/android/os/AsyncTask)
```JAVA


//declare your asyncTask in your activity:

private YourAsyncTask mTask;
//instantiate it like this:

mTask = new YourAsyncTask().execute();
//kill/cancel it like this:

mTask.cancel(true);
//public final boolean cancel (boolean mayInterruptIfRunning)
//Attempts to cancel execution of this task. This attempt will fail if the task has already completed, already been cancelled, or could not be cancelled for some other reason. //If successful, and this task has not started when cancel is called, this task should never run. If the task has already started, then the mayInterruptIfRunning parameter //determines whether the thread executing this task should be interrupted in an attempt to stop the task.

//Calling this method will result in onCancelled(java.lang.Object) being invoked on the UI thread after doInBackground(java.lang.Object[]) returns. Calling this method guarantees //that onPostExecute(Object) is never subsequently invoked, even if cancel returns false, but onPostExecute(Result) has not yet run. To finish the task as early as possible, check //isCancelled() periodically from doInBackground(java.lang.Object[]).

//This only requests cancellation. It never waits for a running background task to terminate, even if mayInterruptIfRunning is true.*\
```
* What is Executor in asynctask
```JAVA
//An Executor that executes tasks one at a time in serial order. This serialization is global to a particular process.

//An Executor that can be used to execute tasks in parallel.
```

* AsyncTask execute() or executeOnExecutor() ?[Ref Link](https://stackoverflow.com/questions/29937556/asynctask-execute-or-executeonexecutor)
```Java
//How does .execute execute tasks by default (in serial or in parallel).

//Before API level 11: parallel.

//API level 11 and up: serial.

//which should be used for new SDKs >16 (executeOnExecuter ?)

//Depends on your requirements. Use execute() if you're happy with the default executor. Use an explicit executor if you're not.


// .execute() - this function schedules the task on a queue for a single background thread. Means that if you are calling two AsyncTasks and using .execute() method to call them, //they will execute in a queue(first then second).

//.executeOnExecutor() - If you want parallel execution of both AsyncTasks, you can use this method for execution of AsyncTask. Means both asyncTasks will execute simultaneously.

//In simple words: .execute() method creates a single thread for execution of asyncTasks, and .executeOnExecuter() method creates separate thread for each ayncTask.

//.execute executes tasks by default in serial order.

//EDITED: If you want to use executeOnExecutor() you can use this code:

//if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
 //    task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
 //else
     task.execute();
//Before HONEYCOMB execute() method run AsynkTask in parallel.

```
