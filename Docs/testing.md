# Testing

### Unit and Mock Testing

We are using Maven to run our unit tests.  The Mockito framework will be used for mock testing of the 
Free Admin software.  A mock object of the Facebook API will be created to show that the software is
working correctly internally.

### Manual Testing

Manual testing will need to be done for interacting with Facebook.  There are three different types of files
a client can use to post to Facebook; text files, image files, and video files.  Each of these file types 
will be manually tested to make sure the posts display on the user's Facebook page correctly.

Manual testing will also be completed on the GUI by following the steps below:

1. Run the FreeAdmin software
    * When the Free Admin software window appears, there should be 3 drop down menus along the top labelled "File", "View", and "Help".  There should be 3 text input boxes in the window; "Enter Access Token", "Every how many hours?", and "Every how many minutes".  There should also be 6 buttons in the window; "Select Pictures", "Select Videos (.mp4)", "Select Text File", "Post Pictures", "Post Videos", and "Post Status".
2. Perform GUI tests:
    * Drop down menu
        * File
            * Click on "Exit" and FreeAdmin software should terminate.
        * View
            * Click on "Show Queue" and a new window should appear showing a table with 3 columns; Position, Content, and Delay (Minutes)
            * Click the "X" in the upper right hand corner of this window, and the "Show Queue" window should close.
        * Help
            * Click on "About" and a new window should appear showing the software name "Free Admin", a link to the software development site on github.com, the authors of the software, and a link to the MIT license.
            * The "About" window should close by clicking the "OK" button located in the center of the bottom of this window or the "X" in the upper right hand corner of this window.
    * The 3 input text boxes should all be able to accept text characters.
    * The 3 buttons "Select Pictures", "Select Videos (.mp4)", and "Select Text File" should all open a "Open" window where one or more files can be selected.
    * The 3 buttons "Post Pictures", "Post Videos", and "Post Status" should all add one or more entries to the "Show Queue" window.
        * The "Show Queue" entry will have the following data:
            * Position: The position number in the queue.
            * Content: The text being sent if it's a "Post Status" submission, "Photo" if it's a "Post Photo" submission, or "Video" if it's a "Post Video" submission.
            * Delay(Minutes): The time in hours and minutes of the delay before the entry will post.
        * The entry in position 1 should disappear when it is posted with all of the remaining entries in the queue bumped up one position in the queue.