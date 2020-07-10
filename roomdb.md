# Android DataBase  

**Introduction**

**Data persistence is one of the basic requirements of most applications. SQLite, an open-source library is a means of persisting data for Android applications. The implementation of SQLite requires lots of boilerplate code, however.This has drawbacks:**
* Syntax errors in queries
* No compile time error detection (Time consuming)
* Parsing is required to convert data to Plain Old Java Objects (POJO) objects

**These issues are quite common in Q&A forums, which is likely why popular No-SQL databases like Realm, GreenDAO and Room came along. Room is a persistent library that abstract away the most of the SQLite code using annotations.**

**In This aims to cover:**

* Storage options for Android
* SQL vs. No-SQL
* Room Library basics
* Using the Room Library to build a app

#### Introduction to Android storage mechanisms
**Core data storage mechanisms**

1. Key-Value pairs : SharedPreferences, An android framework API, which stores key-values pairs in an XML file under protected file system.
  * Data stored via SharedPreference can only be accessed within the app.
  * Can only store boolean, int, long, String and Set of String.
2. Internal and External storage : Applications can store text or CSV files, images, videos in phone memory or inside public directories(kitkat or above) under SD card storage.
  * To access phone or external storage, Applications requires to implement Requesting Permissions Model for marshmallow and above.
  * Repeatedly accessing physical hard drive space slows down the application.
  * Applications can access all directories under external storage on API's below KitKat.
  * Accessible to other applications, No protection.
3. SQLite : SQLite is a light-weight relational database, embedded into the Android OS. The database schema is mapped to tables and integrity constraints.
  * Runtime memory consumption is merely 250 kbytes.
  * Supported data types are INTEGER, REAL (decimals), TEXT, BLOB (mostly used to store images but don't do it) and null.
4. NoSQL : NoSQL simply means Objects or Documents. Instead of storing the data in tabular form, The data is stored in POJO form, which is extremely suitable for semi-structured or un-structured data when there is no fixed schema.

#### SQL vs NoSQL

Features	| SQL	| No-SQL
---|---|---
Data Stored|	In Tabular form (RDBMS)|	POJO objects or Documents
Data Manipulation	|via DML,DDL	|via provided API's
Structure|	RDBMS|	key-value pairs
Schema	|Fixed schema|	dynamic, records can be added on the fly
Scalable	|RDBMS	|key-value pairs
Android Support	|SQLite	|Room(semi-sql), GreenDAO, Realm

### Room Basics
**The Room library acts as an abstract layer for underlying SQLite database. Thus, Room annotations are used:**
  * To Database and Entities where entities are POJO classes representing table structures.
  * To specify operation for retrieval, updation and deletion.
  * To add constraints, such as foreign keys.
  * Support for LiveData.
**There are 3 major components in Room**
1. **Entity :** A class annotated with the @Entity annotation is mapped to a table in database. Every entity is persisted in its own table and every field in class represents the column name.
    * tableName attribute is used to define the name of the table
    * Every entity class must have at-least one Primary Key field, annotated with @PrimaryKey
    * Fields in entity class can be annotated with @ColumnInfo(name = “name_of_column”) annotation to give specific column names
2. **DAO :** Data Access Object is either be an interface or an abstract class annotated with @Doa annotation, containing all the methods to define the operations to be performed on data. The methods can be annotated with

    * @Query to retrieve data from database
    * @Insert to insert data into database
    * @Delete to delete data from database
    * @Update to update data in database
 
 **The result of SQLite queries are composed into cursor object, DAO methods abstract the conversion of cursor to Entity objects and vice-versa.**

3. Database : Database is a container for tables. An abstract class annotated with @Database annotation is used to create a database with given name along with database version.

   * version = intValueForDBVersion is used to define the database version
   * entities = {EntityClassOne.class, ....} is used to define list of entities for database
  
### For Adding Dependancys :

**At build.gradle file(app:module)
```
android{
     compileOptions {
        sourceCompatibility = 1.8
        targetCompatibility = 1.8
    }
      dependencies{
         // Room components
    implementation "androidx.room:room-runtime:$rootProject.roomVersion"
    annotationProcessor "androidx.room:room-compiler:$rootProject.roomVersion"
    androidTestImplementation "androidx.room:room-testing:$rootProject.roomVersion"

// Lifecycle components
    implementation "androidx.lifecycle:lifecycle-extensions:$rootProject.archLifecycleVersion"
    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$rootProject.archLifecycleVersion"
    implementation 'androidx.recyclerview:recyclerview:1.2.0-alpha04'
      }
}

```

**at build.gradle(project level)
```
ext {
    roomVersion = '2.2.1'
    archLifecycleVersion = '2.2.0'
    coreTestingVersion = '2.1.0'
    materialVersion = '1.0.0'
}

```