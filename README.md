Chavez's 3rd hour APCS 
======================
Download Git
------------

- http://www.git-scm.com/downloads

#### Storing credential using the command line
If you are being ask for your username and password everytime 
you push and pull, use the following command to stop this.

_git config --global credential.helper wincred_

##Git Cheat Sheets 
- https://training.github.com/kit/downloads/github-git-cheat-sheet.pdf
- http://www.cheat-sheets.org/saved-copy/git-cheat-sheet.pdf

##Vi Cheat Sheet
- http://www.atmos.albany.edu/daes/atmclasses/atm350/vi_cheat_sheet.pdf
 -  Esc - Exits current mode (needed to change mode)
 -  i - Enters insert mode where you can edit text
 -  :w - Saves, but does not exit vi
 -  :q - Exits vi 
 -  :wq - Saves and exits vi
 
##Git Bash Commands
If you are using git bash, you are going to be using a unix style command line.
This means the commands used are not window commands, but OSX\Linux commands.
Heres a list of simple commands to get around git bash. List is catorgize as first
listing the command and then the options being listed below. Also, use tab to autocomplete commands and names
of folders.

-  cd [option] - Used to change directories
 - .. - Takes you back a directory (Goes back one)
 - _name_ - The name of the directoy you want to switch to. Put the name in 
 double quotes if it has a space (Ex. The Game -> "The Game").
- ls [option] - Lists contents of directory
 - -l - Lists everything in the directoy
- mkdir _name_ - Creates a folder
- mv _name_ _NewLocation_- Moves file to a new place
 - Can also be used to rename files by simple moving it with a new name 