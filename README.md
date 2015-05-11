Chavez's 3rd hour APCS 
======================
Download Git
------------

- http://www.git-scm.com/downloads      **(Command Line)**
- https://windows.github.com/index.html **(GUI)**

#### Storing credential using the command line
If you are being ask for your username and password everytime 
you push and pull, use the following command to stop this.

`git config --global credential.helper wincred`

##Git Cheat Sheets 
- https://training.github.com/kit/downloads/github-git-cheat-sheet.pdf
- http://www.cheat-sheets.org/saved-copy/git-cheat-sheet.pdf

##Vi Cheat Sheet
Vi is a really confusing text editor if you have never used it before. Git uses it by default,
but you can change it to notepad by pasting the following command in git bash.

`git config --global core.editor "notepad"`

Otherwise, just use the cheat sheet or the commands listed below.
- http://www.atmos.albany.edu/daes/atmclasses/atm350/vi_cheat_sheet.pdf
 -  `Esc` - Exits current mode (needed to change mode)
 -  `i` - Enters insert mode where you can edit text
 -  `:w` - Saves, but does not exit vi
 -  `:q` - Exits vi 
 -  `:wq` - Saves and exits vi
 
##Git Bash Commands
If you are using git bash, you are going to be using a unix style command line.
This means the commands used are not window commands, but OSX\Linux commands.
Heres a list of simple commands to get around git bash. List is catorgize as first
listing the command and then the options being listed below. Also, use tab to autocomplete commands and names
of folders.

-  `cd [option]` - Used to change directories
 - `..` - Takes you back a directory (Goes back one)
 - `name` - The name of the directoy you want to switch to. Put the name in 
 double quotes if it has a space (Ex. The Game -> "The Game")
- `ls [option]` - Lists contents of directory
 - `-l` - Lists everything in the directoy
- `mkdir name` - Creates a folder
- `mv name NewLocation` - Moves file to a new place
 - Can also be used to rename files by simple moving it with a new name 
- `clear` - Clears screen