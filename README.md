# Faker
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Faker-green.svg?style=flat)](https://android-arsenal.com/details/1/2039)

Faker provides fake data to your Android apps. Now it's very handy to make screenshots of your apps without worrying with Google Play copyright infringments, e.g [this app](https://play.google.com/store/apps/details?id=io.kimo.tmdb). Faker helps you to populate your views with random data quickly and painlessly.

##Screenshots

![](https://raw.githubusercontent.com/thiagokimo/Faker/master/screenshots/random-data.png)
![](https://raw.githubusercontent.com/thiagokimo/Faker/master/screenshots/profile-sample-screenshot.png)


##Demo
The sample application (the source is in the **app** folder) has been published on Google Play to facilitate the access:

[![Get it on Google Play](http://www.android.com/images/brand/get_it_on_play_logo_small.png)](https://play.google.com/store/apps/details?id=io.kimo.faker)

The demo app has a very clean MVP architecture based in the idea of [this post](http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/). Feel free to give me suggestions.

##Setup

Gradle:

``` groovy
dependencies {
    compile 'com.github.thiagokimo:faker:1.1.0'
}
```

Maven:

``` xml
<dependency>
    <groupId>com.github.thiagokimo</groupId>
    <artifactId>faker</artifactId>
    <version>1.1.0</version>
</dependency>
```

##Usage

###The "lazy" way

``` java
Faker.with(context)
      .fill(rootView);
```

Faker will figure out all views inside the one you passed to it and fill it with proper data. Just like that!

By default faker will fill **TextViews** with lorem ipsum, **ImageViews** with a random color, **CompoundButtons** with a random state (check or uncheck) and **ProgressBars** with a random progress value.

###The specific way

``` java
Faker.with(context)
      .NameOfTheComponent
      .componentMethod();
```

Check out all examples [here](https://github.com/thiagokimo/Faker/tree/master/app/src/main/java/io/kimo/faker/mvp/presenter).

##Components

Faker is organized in components that provides you specific types of data. Here is a list of the current components:

* [Lorem]() - The old good lorem ispum words, sentences and paragraphs.
* [Name]() - Firsts, lasts, full and complete names and profession/titles.
* [Number]() - It gives you numbers ¬¬
* [Phone]() - Phone masks \o/
* [Internet]() - It provides you random emails and domains.
* [Url]() - Gives you (valid) urls that you might use somewhere.
* [Color]() - Generates attractive colors thanks to [lzyzsd](https://github.com/lzyzsd/AndroidRandomColor)!

##Contribuiting

1. Fork it
2. Create your feature/bug-fix branch(`git checkout -b my-new-feature-or-fix`)
3. Commit your changes (`git commit -am 'Add some feature/fix'`)
4. Do your pull-request

Make sure you write tests for your code. Only code with passing tests will be accepted.

###Components

You can add more components or improve the existing ones. For new components, make sure you also add an example in the demo app.

###Localization
You can help providing localized data to Faker components.

##License
    
    Copyright 2011, 2012 Thiago Rocha

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
