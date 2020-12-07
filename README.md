# f20-project-facebook-api-integration-software

Version 0.5

  * [1. Introduction](#1-introduction)
  * [2. Prerequisites](#2-prerequisites)
  * [3. Getting Started](#3-getting-started)
  * [4. Merge Requests and Builds](#4-merge-requests-and-builds)
  * [5. Application and File Structure](#5-application-and-file-structure)
  * [6. Testing Setup](#6-testing-setup)
  * [7. Build Notes](#7-build-notes)
  * [8. Design Patterns](#8-design-patterns)
  * [9. Publishing](#9-publishing)
  * [10. Resources and Credits](#10-resources-and-credits)
  * [11. Revision History](#11-revision-history)

## 1. Introduction

The **Facebook-api-integration-software project** plans to produce a multi-platform software program named Free Admin. Free Admin will be developed in the Java SE programing language, and it will be an open source project with the MIT license. The intent is to develop the ability to schedule and publish multiple posts by integrating the Facebook platform API. Because Facebook does not provide a multiple-post scheduler currently, the idea is to use the Facebook platform access tokens to schedule posts or files to be published. This program has real-world application value since many organizations hire employees just to advertise their products on social media pages.

Free Admin works by scheduling multiple posts to be published on a certain page.
It will connect to the Facebook platform server and automatically publish the desired posts or files. The required platform access tokens and the required resource are available on the Facebook developer portal site. 

## 2. Prerequisites

### 1) Microsoft Windows Environment
* Any x86 or x64 Intel-compatiable PC supporting Microsoft Windows 8.1 or newer; ARM port is not supported  
* A working Facebook developer account
* A working JDK SE installation:
    * Oracle JDK8u162 x86 or newer for x86 based OS
    * Oracle JDK8u162 x64 or newer for x64 based OS, JDK 11.0.9(LTS) recommended
* IDE: IntelliJ IDEA 2017.3.7 or later recommended but not required

### 2) macOS
* Any x64 Intel-based Apple Macintosh supporting OSX El Capitan (10.11) or later
* A working Facebook developer account
* A working JDK installation of Oracle JDK8u162 or newer x64, JDK 11.0.9(LTS) recommended
* IDE: IntelliJ IDEA 2017.3.7 or later recommended but not required

### 3) GNU/Linux
* Any x64 Intel-compatiable PC supporting a recent version of major GNU/Linux distrubutions (Debian, Ubuntu, Fedora, Redhat, and etc)  
* Only X.org mode is supported; Wayland mode is unsupported
* A working Facebook developer account
* A working JDK installation of Oracle JDK8u162 or newer x64, JDK 11.0.9(LTS) recommended
* IDE: IntelliJ IDEA 2017.3.7 or later recommended but not required

## 3. Getting Started

* Please reference the guide in /Docs/Howto-FB App and Access Token.md for Facebook app creation and access token generation. 

## 4. Build Notes

* Although FreeAdmin will build on Microsoft Windows 7 with SP1, this environment is not supported.
* FreeAdmin will build and run with Oracle JDK8u162 on x86 platform. Because Oracle JDK9 and above are only available on x64 platform, please use the appropriate OS and JDK combination.
* Alternatively, AdoptOpenJDK offers x86 builds for OpenJDK8-OpenJDK14. AdoptOpenJDK should build without issues, however, this build environment has not been tested. 

## 5. How to use the Application 

* Please reference the user guide in /Docs/Howto-use.md for more information. 

## 6. Design Patterns

* The FreeAdmin project implemented the Singleton and Adapter patterns.
* Please reference /Docs/Design patterns.md for more information.

## 7. Testing Setup

* Maven is used to run unit tests. The Mockito framework will be used for mock testing. A mock object of the Facebook API will be created to show that the software is
working correctly internally.

* Manual testing will need to be done for interacting with Facebook. There are three different types of files a client can use to post to Facebook: text files, image files, and video files. Each of these file types will be manually tested to make sure the posts display on the user's Facebook page correctly.

## 8. Publishing

The source code and binary releases will be hosted on the IUS Computer Science Github group site
- **Project URL:** https://github.com/IUS-CS/project-facebook-api-integration-software

## 9. Merge Requests and Builds

Merge requests should be opened against the `master` branch with a proper description of changes. The naming convention will be: lastname-feature. At least one peer review is required before changes can be merged to the master branch.

## 10. Resources and Credits

- GitHub Wiki TOC generator: easily create and update TOC in md syntax ** https://ecotrust-canada.github.io/markdown-toc/
- Open source online Markdown editor by Pandao: ** https://pandao.github.io/editor.md/en.html
- RestFB, a simple and flexible Facebook Graph API client, ** https://restfb.com/
- Apache Maven, a software project management and comprehension tool ** https://maven.apache.org/


## 11. Revision History
| Date  | Version  | Description  | Author  |
| ------------ | ------------ | ------------ | ------------ |
| 09/15/2020  | 0.1  | Initial draft  | Lu  |
| 10/02/2020  | 0.2  | Maven integration and branch naming convention  | John Combs  |
| 10/05/2020  | 0.3  | New markdown layout  | Lu  |
| 11/19/2020  | 0.4  | Revised the sections and updated TOC  | Lu  |
| 12/06/2020  | 0.5  | Updated and reorgnized the sections  | Lu  |
|   |   |   |   |
|   |   |   |   |
|   |   |   |   |
