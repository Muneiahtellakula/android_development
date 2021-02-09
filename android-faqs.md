* How to pass data from one fragment to another
    
``` java
 FragmentC fragment = new  FragmentC();
    final Bundle bundle = new Bundle();
    bundle.putString("position", "http://www.facebook.com");            
    fragment.setArguments(bundle);}
});
```
