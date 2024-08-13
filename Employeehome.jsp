<html>
<head>
    <title>Employee Home Page</title>
    <style>
        body 
        {
            background-color: rgb(195, 253, 219);
        }
        * 
        {
            box-sizing: border-box;
        }
        .container
        {
            border-radius: 25px;
            margin: auto;
            width: 55%;
            padding: 25px;
            background-color: white;
            box-shadow: 20px 20px 20px 0px rgba(0, 0, 0, 0.7);
        }

        label {
            display: inline-block;
            width: 110px;
        }
    </style>
</head>
<body>
    <center>
        <font size="4">
            <br><br>
            <div class="container">
                <h1 style="color:rgb(0, 134, 134);">Welcome ${name}</h1><br>
                <h2 style="color:rgba(153, 0, 255, 0.911);">Profile Details:</h2><br>
                <table align="center" width="50%" cellspacing="10">
                    <tr><td><ul><li>Employee name - ${name}</li></ul></td></tr>
                    <tr><td><ul><li>Employee id - ${id}</li></ul></td></tr>
                    <tr><td><ul><li>Gender - ${gender}</li></ul></td></tr>
                    <tr><td><ul><li>Designation -${Des}</li></ul></td></tr>
                    <tr><td><ul><li>Date of Join - ${Doj}</li></ul></td></tr>
                    <tr><td><ul><li>Department - ${Dept}</li></ul></td></tr>
                    <tr><td><ul><li>Employee City- ${Empcity}</li></ul></td></tr>
                    <tr><td><ul><li>Employee Salary- ${Empsal}</li></ul></td></tr>
                </table>
                <h2 style="color:rgba(0, 114, 44, 0.911);">Contact Details:</h2><br>
                <table align="center" width="50%" cellspacing="10">
                    <tr><td><ul><li>Email Address- ${email}</li></ul></td></tr>
                    <tr><td><ul><li>Mobile number- ${mobile}</li></ul></td></tr>
                </table>
                <h1><a style="color:rgb(255, 137, 2);text-decoration:none;" href="index.html">Go to Home page</a><h1>
            </div>
        </font>
    </center>
</body>
</html>
