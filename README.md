examples send email:   
    
    -using 1 email:

    #file accounts.json:
    [
        {
            "username": "this is gmail name",
            "password": "this is gmail APP_PASSWORD"
        }
    ]
    
**using N email (1 <= N <= +oo):**
    
    #file accounts.json:
    [
        {
            "username": "this is gmail name01",
            "password": "this is gmail APP_PASSWORD01"
        },
        {
            "username": "this is gmail name02",
            "password": "this is gmail APP_PASSWORD02"
        },
        ...more account here...
        {
            "username": "this is gmail name0N",
            "password": "this is gmail APP_PASSWORD0N"
        }
    ]

# how to config gmail to using this bot:
- goto https://support.google.com/accounts/answer/185833 to know how to create APP_PASSWORD

# using this tool
GOTO out/artifacts/SpamEmail_jar

1. create APP_PASSWORD
2. using gmail to pass field "username", APP_PASSWORD to pass field password
3. write your subject email to file subject.txt
4. write your content email to file content.txt
5. write (many) dest email to file destEmails.txt
6. rename file SpamEmail.any -> SpamEmail.jar
7. run file run.bat/run.sh
