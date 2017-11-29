<!--Project3CreateDatabase.php-->
<xml version = "1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
	<title>Daniel Sepe</title>
	<h3>Project 3</h3>
</head>
<body>

<?php

// $lnk = mysqli_connect("localhost", "Daniel", "password");
// if (!$lnk) {
// 	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
// }

// if (mysqli_query($lnk,"CREATE DATABASE Project3Base")) {
// 	echo "Database created successfully!" . '<br />';
// } else echo "Error: " . mysqli_error($lnk) . '<br />';

// mysqli_select_db($lnk,"Project3Base");

$lnk = mysqli_connect("localhost", "dsepe1", "dsepe1","dsepe1");
if (!$lnk) {
	die("Not Connected: " . mysqli_connect_error($lnk)) . '<br /';
}

mysqli_select_db($lnk,"dsepe1");

$sql = "CREATE TABLE newCarsTable (
  newCarsMake CHAR(15), -- first column for this table
  newCarsYear INT(4),
  newCarsQty INT(5) NOT NULL
  -- PRIMARY KEY ()
)";

if (mysqli_query($lnk,$sql)) {
	echo "newCarsTable created succesfully!" . '<br />';
} 
// else echo "Error: " . mysqli_error($lnk) . '<br />';

if (mysqli_error($lnk)) echo "Error: newCarsTable has already been made." . '<br />';
else {
	$info = "INSERT INTO newCarsTable (newCarsMake, newCarsYear, newCarsQty)
				VALUES ('newHonda', 2017, 60),
						('newToyota', 2017, 50),
						('newFord', 2017, 40),
						('newChevy', 2017, 30),
						('newTesla', 2017, 20),
						('newBMW', 2017, 10)
			";
};

if (mysqli_query($lnk,$info)) {
	echo "newCarsTable info added successfully!" . '<br />';
}

$sql2 = "CREATE TABLE usedCarsTable (
  usedCarsMake CHAR(15),
  usedCarsYear INT(4),
  usedCarsQty INT(5) NOT NULL
  -- PRIMARY KEY ()
)";

if (mysqli_query($lnk,$sql2)) {
	echo "usedCarsTable created succesfully!" . '<br />';
}
// else echo "Error: " . mysqli_error($lnk,$sql2) . '<br />';

if (mysqli_error($lnk)) echo "Error: usedCarsTable has already been made." . '<br />';
else {
	$info2 = "INSERT INTO usedCarsTable (usedCarsMake, usedCarsYear, usedCarsQty)
				VALUES ('usedHonda', 2001, 1),
						('usedToyota', 2002, 2),
						('usedFord', 2003, 3),
						('usedChevy', 2004, 4),
						('usedTesla', 2005, 5),
						('usedBMW', 2006, 6)
			";
}

if (mysqli_query($lnk,$info2)) {
	echo "usedCarsTable info added successfully!" . '<br />';
}

$sql3 = "CREATE TABLE registeredUsersTable (
  username CHAR(25),
  password CHAR(25)
  -- PRIMARY KEY ()
)";

if (mysqli_query($lnk,$sql3)) {
	echo "registeredUsersTable created succesfully!" . '<br />';
}
// else echo "Error: " . mysqli_error($lnk,$sql3) . '<br />';

if (mysqli_error($lnk)) echo "Error: registeredUsersTable has already been made." . '<br />';
else {
	$info3 = "INSERT INTO registeredUsersTable (username, password)
				VALUES ('usernameInput goes here', 'passwordInput goes here')
			";
}

if (mysqli_query($lnk,$info3)) {
	echo "registeredUsersTable info added successfully!" . '<br />';
}


$sql4 = "CREATE TABLE activeCartTable (
  addedCar CHAR(25),
  addedCarQTY INT(3)
)";

if (mysqli_query($lnk,$sql4)) {
	echo "activeCartTable created succesfully!" . '<br />';
}
// else echo "Error: " . mysqli_error($lnk,$sql4) . '<br />';

if (mysqli_error($lnk)) echo "Error: activeCartTable has already been made." . '<br />';
else {
	$info4 = "INSERT INTO activeCartTable (addedCar, addedCarQTY)
				VALUES ('newHonda for example', 1)
			";
}

if (mysqli_query($lnk,$info4)) {
	echo "activeCartTable info added successfully!" . '<br />';
}

mysqli_close($lnk);

?>

<br />

<a href="http://codd.cs.gsu.edu/~dsepe1/">
	Click here to return to dsepe1's homepage.
</a>

</body>
</html>