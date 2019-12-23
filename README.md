# FragmentBundle  

Bundle is used to pass data between `activities` or `fragments`. The values that are to be passed are mapped to String keys which are later used in the next activity/fragment to retrieve the values.

A Bundle is passed in the following way.
```java
Intent intent = new Intent(this,SecondActivity.class);
Bundle bundle = new Bundle();
bundle.putString("key_1", "MainActivity greeted you with a HI");
bundle.putBoolean("key_2", true);
intent.putExtras(bundle);
startActivity(intent);
```
Data from a Bundle is retrieved in the SecondActivity.java in the following manner.
```java
Bundle bundle = getIntent().getExtras();
String title = bundle.getString("key_1");
boolean b = bundle.getBoolean("key_2");
startActivity(intent);
```
To remove a value from the bundle the remove() method is passed with the relevant key as shown below.
```java
bundle.remove("key_2");
```
To remove all data from the Bundle, the method `clear()` is called on the Bundle instance.
