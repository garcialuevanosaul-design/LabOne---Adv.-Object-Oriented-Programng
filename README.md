# 1. Download the existing repository to your computer
git clone https://github.com/garcialuevanosaul-design/LabOne---Adv.-Object-Oriented-Programng.git

# 2. Move your terminal into the project folder
cd Lab1_Chess_Validator

# Identify yourself so Git knows who edited the file (If you're using VS Code -> Go to terminal -> Create new -> Select + bottom left -> Select Git Bash )
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# [STEP 1]: Open, edit, and save your files normally in your code editor.

# 2. Get the latest updates from your teammates (do this before pushing!)
git pull origin main

# 3. Tell Git to prepare your changed files
git add .

# 4. Save your changes with a short message
git commit -m "Fixed lab assignment step 3"

# 5. Upload your saved changes online
git push origin main

# !!WARNING !!
Create a -gitignore file and put on it " *.class "(this for to not upload the compiled Java bytecode):
