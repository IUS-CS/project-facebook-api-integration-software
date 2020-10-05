<p align="center">	
<b>Software Architecture Document</b> <br>
</p>

# (1) Introduction

"Free Admin" works by scheduling multiple posts to be published on a certain page.
It will connect to the Facebook platform server and automatically publish the desired posts or files.


## (1.2) Purpose

The goal of this product is to allow users schedule multiple posts to advertise and manage 
social media pages with the tools that the software introduce.


## (1.3) Scope

The document is influenced by the process of building the software in which features are connected with one another.
This can lead the project to implement new attributes as well as improve design patterns.


## (1.4) Definitions, Acronyms and Abbreviations

Access tokens: Access token contains the security credentials for a login session and identifies the user, the user's groups, the user's privileges, and, in some cases, a particular application.
Threads: A thread of execution is the smallest sequence of programmed instructions that can be managed independently by a scheduler, which is typically a part of the operating system.
Binary Attachment: A computer file that is not a text file. Examples of binary files: SAS and SPSS system files, spreadsheets, compressed files, and graphic (image) files.

  
## (1.5) Overview

The illustrate of how components of the product work with Facebook server and the client to deliver its functionality by multi-threading output.


# (2) Architectural Representation

1. Main frame
2. Buttons
3. Labels
4. Fields
5. Facebook database

# (4) Logical View

A permission is granted to application for Pages, Groups, and business assets they manage at the individual level. Permissions are strings that are passed along with a login request or an API call.
Components of graphical interface display on the screen to allow users manage the software.
Each feature will perform an action that will interact with the server.


# (5) Process View

* When someone connects with an app using Facebook Login and approves the request for permissions, the app obtains an access token that provides temporary, secure access to Facebook APIs. Access tokens are obtained via a number of methods.
* Methods programmed to work based on the user selection.
* Methods include: Select text file, Select image files, two post buttons, and a text input from user to schedule time.


# (6) Implementation View

![](images/diagram.png)



# (7) Quality

The sofware perform safe connection with the server to perform the tasks.
App Access token should never be included in any code that could be accessed by anyone other than a developer of the app.
