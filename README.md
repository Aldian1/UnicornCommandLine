# UnicornCommandLine
A command line app to manipulate text files. Using Junit for testing and gradle as the build system.

Commands:
new <filename> - Creates a new text file with that name.
open <filename> - Opens that specific file in a JFrame. If you close the window it will auto-save your content.
remove <filename> - Removes specified file.
copy <filename> <filename> - Copys specified file to new path.

Run the JAR:

Simply supply this command when either CD'd in the same directory as the JAR or set it a path in your .bash profile.
Terminal Command: java -jar UnicornGradle.jar

Things learnt from this project:

- Importance of architecture
- Interfaces and why they should be used
- Setting up a gradle project
- Setting up JUnit and writing unit tests
- How writing brittle code can affect the tests that you write

