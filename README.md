# f20-project-facebook-api-integration-software

Version 0.4

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
* Microsoft Windows 8.1 or newer
* A working Facebook developer account
* A working JDK installation either:
    * Oracle JDK8u162 x86/x64 and above or
    * AdoptOpenJDK14u2 x86/x64
* IntelliJ IDEA 2017.3.7 or later of either Community Edition or Ultimate Edition

### 2) macOS

### 3) GNU/Linux


## 3. Getting Started

* Please refer to the guide in /Docs/Howto-FB App and Access Token.md for Facebook app creation and access token generation 

## 4. Merge Requests and Builds

Merge requests should be opened against the `master` branch with a proper description of changes. The naming convention will be: name-feature. At least one peer review is required before changes can be merged to the master branch.

## 5. Application and File Structure

* This section will update when more information is available.

## 6. Testing Setup

1. This section will update when more information is available.


## 7. Build Notes

* Although FreeAdmin will build on Microsoft Windows 7 with SP1, this environment is not supported.
* FreeAdmin will build and run with Oracle JDK8u162 on x86 platform. Since Oracle JDK9 and above are only available on x64 platform, please use appropriate OS and JDK combination.
* Alternatively, AdoptOpenJDK offers x86 builds for OpenJDK8-OpenJDK14. AdoptOpenJDK should build without issues, however, this build environment has not been tested. 

## 8. Design Patterns

* The FreeAdmin project implemented the Singleton and Adapter patterns.
* Please reference /Docs/Design patterns.md for more information.

## 9. Publishing

The source code and binary releases will be hosted on the IUS Computer Science Github group site
- **Project URL:** https://github.com/IUS-CS/project-facebook-api-integration-software

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
| 11/19/2020  | 0.4  | Revised sections and updated TOC  | Lu  |
|   |   |   |   |
|   |   |   |   |
|   |   |   |   |
|   |   |   |   |
