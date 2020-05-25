## Tab Navigation


* Here we will see how to use another of the design library components, the TabLayout, which can be combined with the ViewPager class to create a tab based interface within an Android activity.
#### An Introduction to the ViewPager
* Although not part of the design support library, the ViewPager is a useful companion class when used in conjunction with the TabLayout component to implement a tabbed user interface. The primary role of the ViewPager is to allow the user to flip through different pages of information where each page is most typically represented by a layout fragment. The fragments that are associated with the ViewPager are managed by an instance of the FragmentPagerAdapter class.

* At a minimum the pager adapter assigned to a ViewPager must implement two methods. The first, named getCount(), must return the total number of page fragments available to be displayed to the user. The second method, getItem(), is passed a page number and must return the corresponding fragment object ready to be presented to the user.