# EnumRessources [![Build Status](https://travis-ci.org/martyglaubitz/EnumResources.svg)](https://travis-ci.org/martyglaubitz/EnumResources)
I often found myself to have an enum for my apps UI state.
For example you might a have a drop down which value controls
the behaviour of the fragment/activity and also it's look (toolbar color for example).

You could store this meta-data in the enum values themselfes,
but by doing so they can quickly become cluttered wioth all sorts
of fields and methods. Also: enum constructors with 12 params don't look that nice.

```java

enum FeedContentMode {
  GLOBAL,
  LOCAL,
  FRIENDS
}

final EnumResources enumResources = new EnumResources();

enumResources.get(FeedContentMode.GLOBAL)
  .assocColor(R.color.blue)
  .assocString(R.string.ttl_global);
  
enumResources.get(FeedContentMode.LOCAL)
  .assocColor(R.color.red)
  .assocString(R.string.ttl_local);
  
enumResources.get(FeedContentMode.FRIENDS)
  .assocColor(R.color.yellow)
  .assocString(R.string.ttl_friends);
  
void onFilterChanged(final FeedContentMode feedContentMode) {
  toolbar.setBackgroundDrawable(new ColorDrawable(enumResource.get(feedContentMode).getColor(getResources())));
  setTitle(enumResource.get(feedContentMode).getStringRes());
}

```

#Usage
    repositories {
        jcenter()
    }
    
    compile 'de.mglaubitz:EnumResources:1.0.1'
