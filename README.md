# MiniWeather

<!--- Replace <OWNER> with your Github Username and <REPOSITORY> with the name of your repository. -->
<!--- You can find both of these in the url bar when you open your repository in github. -->
![Workflow result](https://github.com/vsay01/android-dev-challenge-compose-weather/workflows/Check/badge.svg)


## :scroll: Description
MiniWeather is a week 4 challenge project that asked to create a one screen weather app. In this project, I use fake data.

## :bulb: Motivation and Context
In this challenge, it focus on:
- Visual beauty
- Novelty of idea
- Code quality
- Overall execution (including accessibility)
![More detail about the challenge.](https://android-developers.googleblog.com/2021/03/android-dev-challenge-4.html)

The main challenge that I faced is write unit test. There are not many resources available. 

## :camera_flash: Screenshots
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_4.png" width="260">


Here is demo video:
![demo_video](https://user-images.githubusercontent.com/6526127/112253343-8b647b80-8c2c-11eb-9d3c-35c876d410b2.mp4)


## :wheelchair: Accessibility
For accessibility, I tested with google accessibility scanner to make sure no suggestions found.

<img src="/results/screenshot_3.png" width="260">

To make it easier for user to use talkback, I merged the contents wherever possible and provide custom content description.


![accessibility video](https://user-images.githubusercontent.com/6526127/112253453-bea70a80-8c2c-11eb-8665-e90686dda15e.mp4)

## Testing Compose layout

I wrote two basic compose layout test, CurrentWeatherCardTest and FiveDayListTest under androidTest package.

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
