Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=0
or
ant -buildfile src/build.xml run -Darg0=1
or
ant -buildfile src/build.xml run -Darg0=2
or
ant -buildfile src/build.xml run

-----------------------------------------------------------------------

## To create tarball for submission
tar -cvf sujoy_das_chaitanya_khoje.tar sujoy_das_chaitanya_khoje/
gzip sujoy_das_chaitanya_khoje.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

[Date: 04/24/2018]

-----------------------------------------------------------------------
Note:
username for git
Sujoy Das: Codejoy92

Assumptions:
Debug value from command line will be and integer
Debug levels:
ERROR/NO-OP :-0,
MATCH_FOUND :-1,
CONSTRUCTOR :-2
